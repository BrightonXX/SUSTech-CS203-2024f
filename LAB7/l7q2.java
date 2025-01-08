import java.io.*;
import java.util.StringTokenizer;

public class l7q2 {
    public static void main(String[] args) {
        int testcase = in.nextInt();
        for (int ts = 0; ts < testcase; ts++) {
            int nodes = in.nextInt();
            MaxHeap heap = new MaxHeap(nodes);
            for (int i = 1; i < nodes+1; i++) {
                heap.insert(new node(in.nextInt(),i));
            }
            int tofindindex = in.nextInt();
            int answer = 0;
            for (int i = 0; i < heap.heap.length; i++) {
                if (heap.heap[i].index == tofindindex) answer = i;
            }
            int power = 1;
            int height = 0;
            while (answer - power > 0){
                answer = answer - power;
                power = power*2;
                height++;
            }
            System.out.println((height+1)+" "+(answer+1));
        }
    }
    static class node {
        int shili;
        int index;
        public node(int sl, int bzq) {
            shili = sl;
            index = bzq;
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
        node[] heap;
        private int size;
        private int capacity;
        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            heap = new node[capacity];
        }

        // Method to insert a new element into the heap
        public void insert(node element) {
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
        public int removeMax() {
            if (size == 0) {
                throw new IllegalStateException("Heap is empty");
            }

            int max = heap[0].shili; // The maximum element
            heap[0] = heap[size - 1]; // Move the last element to the root
            size--;
            // Fix the heap property
            heapifyDown(0);
            return max;
        }

        // Method to maintain the max heap property after an insertion
        private void heapifyUp(int index) {
            int parentIndex = (index - 1) / 2;
            if (index > 0 && heap[parentIndex].shili < heap[index].shili) {
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
            if (leftChildIndex < size && heap[leftChildIndex].shili > heap[largest].shili) {
                largest = leftChildIndex;
            }
            if (rightChildIndex < size && heap[rightChildIndex].shili > heap[largest].shili) {
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
            node temp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = temp;
        }

        // Method to get the current size of the heap
        public int size() {
            return size;
        }
    }
}
