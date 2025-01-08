import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class l9q6 {
    public static void main(String[] args) {
        int citynum = in.nextInt();
        int roads = in.nextInt();
        int portals = in.nextInt();
        int trials = in.nextInt();
        node[][] store = new node[citynum][trials+1];
        for (int i = 0; i < citynum; i++) {
            for (int f = 0; f < trials+1; f++) {
                store[i][f] = new node(i+1,infinity,f);
            }
        }
        for (int i = 0; i < roads; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            for (int j = 0; j < trials+1; j++) {
                store[a-1][j].roadsto.add(store[b-1][j]);
                store[a-1][j].roadscost.add(c);
            }
        }
        for (int i = 0; i < portals; i++) {
            //add portal roads
            int a = in.nextInt();
            int b = in.nextInt();
            for (int j = 0; j < trials; j++) {
                store[a-1][j].portalsto.add(store[b-1][j+1]);
            }
        }
        int start = in.nextInt();
        int destination = in.nextInt();
        store[start-1][0].distance = 0;
        node aTrueGhost = new node(-1,infinity,-1);
        aTrueGhost.dead = true;
        MinHeap heap = new MinHeap((portals+roads+2)*(trials+2));
        for (int i = 0; i < store[start-1][0].roadsto.size(); i++) {
            store[start-1][0].roadsto.get(i).distance = store[start-1][0].distance+store[start-1][0].roadscost.get(i);
            heap.insert(store[start-1][0].roadsto.get(i));
        }
        for (int i = 0; i < store[start-1][0].portalsto.size(); i++) {
            store[start-1][0].portalsto.get(i).distance = 0;
            heap.insert(store[start-1][0].portalsto.get(i));
        }
        node focus;
        while (true){
            focus = heap.removeM();
            //System.out.println("focus index:"+focus.index+", layer:"+focus.layer+", distance:"+focus.distance);
            focus.isOptimal = true;
            if (focus.index == destination) break;
            for (int i = 0; i < focus.roadsto.size(); i++) {
                if (focus.roadsto.get(i).distance > focus.distance+focus.roadscost.get(i)){
                    focus.roadsto.get(i).distance = focus.distance+focus.roadscost.get(i);
                    for (int i1 = 0; i1 < heap.heap.length; i1++) {
                        if (heap.heap[i1] == focus.roadsto.get(i)){
                            heap.heap[i1] = aTrueGhost;
                            break;
                        }
                    }
                    heap.insert(focus.roadsto.get(i));
                }
                for (int f = 0; f < focus.portalsto.size(); f++) {
                    focus.portalsto.get(f).distance = focus.distance;
                    heap.insert(focus.portalsto.get(f));
                }
            }
        }
        System.out.println(focus.distance);
    }
    static QReader in = new QReader();
    static class QReader {
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String nextLine = innerNextLine();
                if (nextLine == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(nextLine);
            }
            return true;
        }

        public String nextLine() {
            tokenizer = new StringTokenizer("");
            return innerNextLine();
        }

        public String next() {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    static long infinity = Long.MAX_VALUE;
    static class node {
        int index;
        int layer;
        long distance;
        boolean isOptimal = false;
        boolean dead = false;
        ArrayList<node> roadsto;
        ArrayList<node> portalsto;
        ArrayList<Integer> roadscost;
        public node(int ind,long distance,int layer) {
            index = ind;
            this.distance = distance;
            this.layer = layer;
            roadsto = new ArrayList<>();
            roadscost = new ArrayList<>();
            portalsto = new ArrayList<>();
        }
    }
    static class MinHeap {
        node[] heap;
        private int size;
        private int capacity;
        public MinHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            heap = new node[capacity];
        }

        public void insert(node element) {
            if (size == capacity) {
                throw new IllegalStateException("Heap is full");
            }
            heap[size] = element;
            size++;
            heapifyUp(size - 1);
        }
        public node removeM() {
            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }
            node max = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapifyDown(0);
            if (max.dead){
                // SiLe,RenDiao.
                return removeM();
            }else return max;
        }
        private void heapifyUp(int index) {
            int parentIndex = (index - 1) / 2;
            if (index > 0 && heap[parentIndex].distance > heap[index].distance) {
                swap(parentIndex, index);
                heapifyUp(parentIndex);
            }
        }
        private void heapifyDown(int index) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;
            if (leftChildIndex < size && heap[leftChildIndex].distance < heap[largest].distance) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex].distance < heap[largest].distance) {
                largest = rightChildIndex;
            }
            if (largest != index) {
                swap(index, largest);
                heapifyDown(largest);
            }
        }
        private void swap(int index1, int index2) {
            node temp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = temp;
        }
        public int size() {
            return size;
        }
    }
}
