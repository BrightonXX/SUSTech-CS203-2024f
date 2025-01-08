import java.io.*;
import java.util.StringTokenizer;

public class l7q1 {
    public static void main(String[] args) {
        int num = in.nextInt();
        int[] nodes =new int[num];
        boolean max = true;
        boolean min = true;
        for (int i = 0; i < num ; i++) {
            nodes[i] = in.nextInt();
        }
        for (int i = 1; i < num; i++) {
            //System.out.println("compare:" + i +",and:"+ (i-1)/2);
            if (nodes[i] > nodes[(i-1)/2]){
                max = false;
            }else min = false;
        }
        if (max) {
            out.println("Max");
        }else if (min) {
            out.println("Min");
        }else out.println("Neither");
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
