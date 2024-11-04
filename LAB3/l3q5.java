import java.io.*;
import java.util.StringTokenizer;

public class l3q5 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int nums= in.nextInt();
        Node[] sto = new Node[nums];
        Node[] sortedSto = new Node[nums];
        for (int i = 0; i < nums; i++) {
            int temp= in.nextInt();
            sto[i] = new Node(temp);
            sortedSto[i] = sto[i];
        }
        MergeSort.sort(sortedSto);
        Node head = new Node(2147483647);
        Node tail = new Node(-2147483648);
        head.next=sortedSto[0];
        sortedSto[0].prev=head;
        sortedSto[0].next=sortedSto[1];
        for (int i = 1; i < nums-1; i++) {
            sortedSto[i].prev=sortedSto[i-1];
            sortedSto[i].next=sortedSto[i+1];
        }
        sortedSto[nums-1].prev=sortedSto[nums-2];
        sortedSto[nums-1].next=tail;
        for (int i = 0; i < nums-1; i++) {
            int maxdi=Math.min(Math.abs(sto[i].data-sto[i].prev.data),Math.abs(sto[i].data-sto[i].next.data));
            out.print(maxdi+" ");
            sto[i].prev.next=sto[i].next;
            sto[i].next.prev=sto[i].prev;
        }
        out.close();
    }
    static class Node {
        public int data;
        Node prev;
        Node next;
        public Node(int coef) {
            //aX^n data1=a,data2=n
            data = coef;
            next = null;
            prev = null;
        }
    }
    static class MergeSort {
        private static Node[] assist;
        public static void sort(Node[] a){
            assist = new Node[a.length];
            int lo = 0;
            int hi = a.length - 1;
            sort(a,lo,hi);
        }
        private static void sort(Node[] a, int lo, int hi){
            if (hi<=lo) return;
            int mid = (lo + hi) >> 1;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }
        private static void merge (Node[] a, int lo, int mi, int hi){
            int i = lo;
            int j = mi + 1;
            int k = 0;
            while (i <=mi && j<= hi){
                if (a[i].data < a[j].data){
                    assist[k++] = a[i++];
                }else {
                    assist[k++] = a[j++];
                }
            }
            while (i <=mi){
                assist[k++] = a[i++];
            }
            while (j <= hi){
                assist[k++] = a[j++];
            }
            if (hi - lo + 1 >= 0) System.arraycopy(assist, 0, a, lo, hi - lo + 1);
        }
    }
    static QReader in= new QReader();
    static QWriter out= new QWriter();
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

    static class QWriter implements Closeable {
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
}
