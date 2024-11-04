import java.io.*;
import java.util.StringTokenizer;

public class qu5 {
    public static void main(String[] args) {
        int arrl=in.nextInt();
        long[] a=new long[arrl];
        long[] help=new long[arrl];

        for (int i = 0; i < arrl; i++) {
            a[i]=in.nextLong();
            help[i]=a[i];
        }
        MergeSort.sort(help);
        System.out.println(cost);
    }
    static long cost=0;
    static class MergeSort {
        private static long[] assist;
        public static void sort(long[] a){
            assist = new long[a.length];
            int lo = 0;
            int hi = a.length - 1;
            sort(a,lo,hi);
        }
        private static void sort(long[] a, int lo, int hi){
            if (hi<=lo) return;
            int mid = (lo + hi) >> 1;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }
        private static void merge (long[] a,int lo,int mi,int hi){
            int i = lo;
            int j = mi + 1;
            int k = 0;
            while (i <=mi && j<= hi){
                if (a[j]<a[i]){
                    cost+=(a[j])*(mi-i+1);
                    assist[k++] = a[j++];
                }else {
                    assist[k++] = a[i++];
                }
            }
            while (i <=mi){
                assist[k++] = a[i++];
            }
            while (j <= hi){
                if (a[j]<a[i]) {
                    cost+=a[j];
                }
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
