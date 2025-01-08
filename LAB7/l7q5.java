import java.io.*;
import java.util.StringTokenizer;

public class l7q5 {
    public static void main(String[] args) {
        int hlbnum = in.nextInt();
        node fakeHead = new node(-111111111);
        node fakeTail = new node(-111111111);
        fakeHead.next = fakeTail;
        fakeTail.prev = fakeHead;
        MinHeap heap = new MinHeap(hlbnum);
        for (int i = 0; i < hlbnum; i++) {
            node temp = new node(in.nextInt());
            fakeTail.prev.next = temp;
            temp.prev = fakeTail.prev;
            temp.next = fakeTail;
            fakeTail.prev = temp;
            heap.insert(temp);
        }
        for (int i = 0; i < hlbnum-1; i++) {
            node temp = heap.removeM();
            if (temp.prev == fakeHead) {
                // associate with next one
                temp.HuLuoBo =  (temp.HuLuoBo^temp.next.HuLuoBo) + 1;
                temp.next.isGhost = true;
                temp.next.next.prev = temp;
                temp.next = temp.next.next;
            } else if (temp.next == fakeTail){
                // associate with prev one
                temp.HuLuoBo =  (temp.HuLuoBo^temp.prev.HuLuoBo) + 1;
                temp.prev.isGhost = true;
                temp.prev.prev.next = temp;
                temp.prev = temp.prev.prev;
            } else if ((temp.HuLuoBo^temp.prev.HuLuoBo) > (temp.HuLuoBo^temp.next.HuLuoBo)){
                // associate with prev one
                temp.HuLuoBo =  (temp.HuLuoBo^temp.prev.HuLuoBo) + 1;
                temp.prev.isGhost = true;
                temp.prev.prev.next = temp;
                temp.prev = temp.prev.prev;
            } else {
                // associate with next one
                temp.HuLuoBo =  (temp.HuLuoBo^temp.next.HuLuoBo) + 1;
                temp.next.isGhost = true;
                temp.next.next.prev = temp;
                temp.next = temp.next.next;
            }
            heap.insert(temp);
        }
        System.out.println(heap.removeM().HuLuoBo);
    }
    static class node {
        int HuLuoBo;

        boolean isGhost = false;
        node next;
        node prev;

        public node(int hlb) {
            HuLuoBo = hlb;
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
            if (max.isGhost) {
                return removeM();
            }else return max;
        }
        private void heapifyUp(int index) {
            int parentIndex = (index - 1) / 2;
            if (index > 0 && heap[parentIndex].HuLuoBo > heap[index].HuLuoBo) {
                swap(parentIndex, index);
                heapifyUp(parentIndex);
            }
        }
        private void heapifyDown(int index) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;
            if (leftChildIndex < size && heap[leftChildIndex].HuLuoBo < heap[largest].HuLuoBo) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex].HuLuoBo < heap[largest].HuLuoBo) {
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
