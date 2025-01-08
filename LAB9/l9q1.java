import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class l9q1 {
    public static void main(String[] args) {
        int citynum = in.nextInt();
        int roads = in.nextInt();
        node[] store = new node[citynum];  // index in [index-1];
        for (int i = 0; i < citynum; i++) {
            store[i] = new node(i+1,infinity);
        }
        for (int i = 0; i < roads; i++) {
            int c1 = in.nextInt();
            int c2 = in.nextInt();
            int cs = in.nextInt();
            store[c1-1].roadsto.add(store[c2-1]);
            store[c1-1].roadscost.add(cs);
        }
        store[0].distance = 0;
        store[0].isOptimal = true;
        node aTrueGhost = new node(-1,infinity);
        aTrueGhost.dead = true;
        MinHeap heap = new MinHeap(roads+1);
        for (int i = 0; i < store[0].roadsto.size(); i++) {
            if (store[0].roadsto.get(i).distance > store[0].distance+store[0].roadscost.get(i)){
                store[0].roadsto.get(i).distance = store[0].distance+store[0].roadscost.get(i);
                heap.insert(store[0].roadsto.get(i));
            }
        }
        for (int sb = 0; sb < citynum - 2; sb++) {
            node focus = heap.removeM();
            focus.isOptimal = true;
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
            }
        }
        if (store[citynum-1].distance != infinity) {
            System.out.println(store[citynum-1].distance);
        }else System.out.println(-1);
    }
    static long infinity = Long.MAX_VALUE;
    static class node {
        int index;
        long distance;
        boolean isOptimal = false;
        boolean dead = false;
        ArrayList<node> roadsto;
        ArrayList<Integer> roadscost;
        public node(int hlb, long dis) {
            index = hlb;
            distance = dis;
            roadsto = new ArrayList<>();
            roadscost = new ArrayList<>();
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
}
