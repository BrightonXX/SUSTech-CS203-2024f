import java.io.*;
import java.util.StringTokenizer;

public class l6q1 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int ts = in.nextInt();
        for (int tss = 0; tss < ts; tss++) {
            long nodes = in.nextInt();
            long k = in.nextInt();
            long subnodes = 0;
            long temp = 1;
            while (subnodes + temp < nodes){
                subnodes += temp;
                temp *= k;
            }
            temp = temp/k;
            long wfs = nodes - subnodes;
            long par = wfs/k;
            if (par * k !=wfs) par++;
            out.println(temp - par + wfs);
        }
        out.close();
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
