import java.io.*;
import java.util.StringTokenizer;

public class l7q4{
    public static void main(String[] args) {
        int runtime = in.nextInt();
        int heapcap = in.nextInt();
        long last_ans = in.nextInt();
        MaxHeap heap = new MaxHeap(heapcap);
        for (int i = 1; i < runtime+1; i++) {
            String str = String.valueOf((last_ans+i));
            int tempa = 0;
            for (int j = 0; j < str.length(); j++) {
                tempa += str.charAt(j)-48;
            }
            long temp = last_ans + i + tempa;
            if (heap.size < heapcap) {
                heap.insert(temp);
            }else if (temp > heap.getMin()){
                heap.removeMax();
                heap.insert(temp);
            }
           // System.out.println(Arrays.toString(heap.heap));
            if ((i)%100 == 0) {
                last_ans = heap.getMin();
                System.out.print(heap.getMin()+" ");
            }
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
    static class MaxHeap {
        long[] heap;
        private int size;
        private int capacity;
        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            heap = new long[capacity];
        }

        public void insert(long element) {
            if (size == capacity) {
                throw new IllegalStateException("Heap is full");
            }
            // Add the new element at the end
            heap[size] = element;
            size++;
            // Fix the heap property
            heapifyUp(size - 1);
        }

        // Method to remove the maximum element (root) from the heap
        public long removeMax() {
            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }

            long max = heap[0]; // The maximum element
            heap[0] = heap[size - 1]; // Move the last element to the root
            size--;
            // Fix the heap property
            heapifyDown(0);
            return max;
        }
        public long getMin(){
            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }
            return heap[0];
        }

        // Method to maintain the max heap property after an insertion
        private void heapifyUp(int index) {
            int parentIndex = (index - 1) / 2;
            if (index > 0 && heap[parentIndex] > heap[index]) {
                // Swap if the parent is less than the current element
                swap(parentIndex, index);
                // Continue heapifying up the tree
                heapifyUp(parentIndex);
            }
        }

        // Method to maintain the max heap property after removal of the maximum element
        private void heapifyDown(int index) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;

            // Find the largest among the node and its children
            if (leftChildIndex < size && heap[leftChildIndex] < heap[largest]) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex] < heap[largest]) {
                largest = rightChildIndex;
            }
            // If the largest is not the root
            if (largest != index) {
                swap(index, largest);
                // Recursively heapify the affected sub-tree
                heapifyDown(largest);
            }
        }

        // Method to swap two elements in the heap
        private void swap(int index1, int index2) {
            long temp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = temp;
        }

        // Method to get the current size of the heap
        public int size() {
            return size;
        }
    }
}
