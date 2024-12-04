import java.io.*;
import java.util.StringTokenizer;

public class l5q4 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int ts = in.nextInt();
        for (int i = 0; i < ts; i++) {
            String st = in.next();
            int[] next = new int[st.length()];
            next[0] = 0;
            int lef = 0;
            int rig = 1;
            while (rig < st.length()){
                if (st.charAt(lef) == st.charAt(rig)){
                    next[rig] = lef + 1;
                    rig++;lef++;
                } else if (lef != 0){
                    lef = next[lef - 1];
                } else {
                    next[rig] = 0;
                    rig++;
                }
            }
            if (next[st.length()-1] == 0) {
                out.println(st.length());
            } else {
                int temp = st.length()/(st.length() - next[st.length()-1]);
                if ((st.length() - temp*(st.length()-next[st.length()-1]))==0){
                    out.println(0);
                }else {
                    out.println((st.length()-next[st.length()-1]) - (st.length() - temp*(st.length()-next[st.length()-1])));
                }

            }
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
