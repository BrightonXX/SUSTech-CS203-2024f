import java.io.*;
import java.util.StringTokenizer;
public class qu2 {
    public static void main(String[] args) {
        int ttt=in.nextInt();
        for (int i = 0; i < ttt; i++) {
            int nlo=in.nextInt();
            int mlo=in.nextInt();
            int[] n=new int[nlo];
            int[] m=new int[mlo];
            for (int j = 0; j < nlo; j++) {
                n[j]=in.nextInt();
            }
            for (int j = 0; j < mlo; j++) {
                m[j]=in.nextInt();
            }
            int[] nm=new int[nlo+mlo];
            int indexall=0;
            int indexn=0;
            int indexm=0;
            while (indexall!=nlo+mlo){
                if (indexn==nlo){
                    nm[indexall]=m[indexm];
                    indexall++;
                    indexm++;
                }else if (indexm==mlo){
                    nm[indexall]=n[indexn];
                    indexall++;
                    indexn++;
                }else if (n[indexn]<=m[indexm]){
                    nm[indexall]=n[indexn];
                    indexall++;
                    indexn++;
                }else {
                    nm[indexall]=m[indexm];
                    indexall++;
                    indexm++;
                }
            }
            for (int j = 0; j < nm.length; j++) {
                out.print(nm[j]+" ");
            }
            out.println("");
        }
        out.close();
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
