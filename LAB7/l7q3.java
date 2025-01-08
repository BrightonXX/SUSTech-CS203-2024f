import java.io.*;
import java.util.StringTokenizer;

public class l7q3 {
    public static void main(String[] args) {
        QReader in = new QReader();
        int testcase = in.nextInt();
        for (int ts = 0; ts < testcase; ts++) {
            int nodes = in.nextInt();
            int[] shili = new int[nodes];
            int[] baozhiqi = new int[nodes];
            node[] store = new node[nodes];
            for (int i = 0; i < nodes; i++) {
                shili[i] = in.nextInt();
            }
            for (int i = 0; i < nodes; i++) {
                baozhiqi[i] = in.nextInt();
            }
            for (int i = 0; i < nodes; i++) {
                store[i] = new node(shili[i], baozhiqi[i]);
            }
            MergeSort.sort(store);
            int day = store[nodes - 1].baozhiqi;
            int answer = 0;
            MaxHeap heap = new MaxHeap(nodes);
            int pointer = nodes - 1;
            int treenodes = 0;
            while (day != 0) {
                while (store[pointer].baozhiqi >= day) {
                    heap.insert(store[pointer]);
                    if (pointer == 0) {
                        break;
                    } else pointer--;
                }
                if (heap.size() != 0) {
                    answer += heap.removeMax();
                }
                day--;
            }
            System.out.println(answer);
        }
    }

    static class node {
        int shili;
        int baozhiqi;

        public node(int sl, int bzq) {
            shili = sl;
            baozhiqi = bzq;
        }
    }

    static class MergeSort {
        private static node[] assist;

        public static void sort(node[] a) {
            assist = new node[a.length];
            int lo = 0;
            int hi = a.length - 1;
            sort(a, lo, hi);
        }

        private static void sort(node[] a, int lo, int hi) {
            if (hi <= lo) return;
            int mid = (lo + hi) >> 1;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        private static void merge(node[] a, int lo, int mi, int hi) {
            int i = lo;
            int j = mi + 1;
            int k = 0;
            while (i <= mi && j <= hi) {
                if (a[i].baozhiqi < a[j].baozhiqi) {
                    assist[k++] = a[i++];
                } else {
                    assist[k++] = a[j++];
                }
            }
            while (i <= mi) {
                assist[k++] = a[i++];
            }
            while (j <= hi) {
                assist[k++] = a[j++];
            }
            if (hi - lo + 1 >= 0) System.arraycopy(assist, 0, a, lo, hi - lo + 1);
        }
    }

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

    class QWriter implements Closeable {
        private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        public void print(Object object) {
            try {
                writer.write(object.toString());
            } catch (IOException e) {
                return;
            }
        }

        public void println(Object object) {
            try {
                writer.write(object.toString());
                writer.write("\n");
            } catch (IOException e) {
                return;
            }
        }

        @Override
        public void close() {
            try {
                writer.close();
            } catch (IOException e) {
                return;
            }
        }
    }

    static class MaxHeap {
        private node[] heap;
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
