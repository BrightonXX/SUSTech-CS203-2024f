import java.io.*;
import java.util.StringTokenizer;

public class l6q4 {
    public static void main(String[] args) {
        int ts = in.nextInt();
        for (int tss = 0; tss < ts; tss++) {
            int nums = in.nextInt();
            int[] t = new int[nums];
            boolean[] index = new boolean[nums];
            for (int i = 0; i < nums; i++) {
                t[i] = in.nextInt();
                index[i] = true;
            }
            int answer = 0;
            for (int i = 0; i < nums-1; i++) {
                int min = 2147483647;
                int indexsave = 0;
                for (int j = 0; j < nums; j++) {
                     if (index[j]) min = Math.min(t[j],min);
                }
                for (int j = 0; j < nums; j++) {
                    if (t[j] == min & index[j]) {
                        index[j] = false;
                        indexsave = j;
                        break;
                    }
                }
                int min2 = 2147483647;
                for (int j = 0; j < nums; j++) {
                    if (index[j]) min2 = Math.min(t[j],min2);
                }
                for (int j = 0; j < nums; j++) {
                    if (t[j] == min2 & index[j]) {
                        index[j] = false;
                        break;
                    }
                }
                answer += min + min2;
                t[indexsave] = min + min2;
                index[indexsave] = true;
                /*for (int j = 0; j < nums; j++) {
                    if (index[j]) System.out.print(t[j]+" ");
                }
                System.out.println(min + min2);*/
            }
            System.out.println(answer);
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
