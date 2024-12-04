import java.io.*;
import java.util.StringTokenizer;

public class l5q6 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        char[] eyco=new char[26];
        for (int i = 0; i < 26; i++) {
            eyco[i] = in.next().charAt(0);
        }
        String text = in.next();
        char[] doubleText = new char[text.length()*2+1];
        for (int i = 0; i < text.length(); i++) {
            doubleText[i] = text.charAt(i);
        }
        for (int i = text.length()+1; i < text.length()*2+1; i++) {
            doubleText[i] = eyco[(text.charAt(i-text.length()-1)-19) % 26];
        }
        int[] next = new int[doubleText.length];
        next[0] = 0;
        int lef = 0;
        int rig = 1;
        while (rig < doubleText.length){
            if (doubleText[lef] == doubleText[rig]){
                next[rig] = lef + 1;
                rig++;lef++;
            } else if (lef != 0){
                lef = next[lef - 1];
            } else {
                next[rig] = 0;
                rig++;
            }
        }
        int ans = next[next.length-1];
        while (ans > text.length()/2){
            ans = next[ans-1];
        }
        out.println(text.length() - ans);
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
