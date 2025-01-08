import java.io.*;
import java.util.StringTokenizer;

public class l8q1 {
    public static void main(String[] args) {
        int testcases = in.nextInt();
        for (int ts = 0; ts < testcases; ts++) {
            int itemnum = in.nextInt();
            int[][] matrix = new int[itemnum][itemnum];
            int relations = in.nextInt();
            for (int i = 0; i < relations; i++) {
              matrix[in.nextInt()-1][in.nextInt()-1] = 1;
            }
            for (int i = 0; i < itemnum; i++) {
                for (int j = 0; j < itemnum; j++) {
                    out.print(matrix[i][j]+" ");
                }
                out.println("");
            }
        }
        out.close();
    }
    static QReader in = new QReader();
    static QWriter out = new QWriter();
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
