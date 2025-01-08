import java.io.*;
import java.util.StringTokenizer;

public class l8q5 {
    public static void main(String[] args) {
        int tc = in.nextInt();
        for (int ts = 0; ts < tc; ts++) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] store = new int[N][M];
            boolean[][] inVisited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    store[i][j] = in.nextInt();
                }
            }
            traverse(store,0,0,0);
            out.println(Maximum);
            Maximum = -2147483648;
        }
        out.close();
    }
    static int Maximum = -2147483648;
    static void traverse(int[][] a, int x, int y, int currentvalue){
        if (x <= -1 | y <= -1 | x >= a.length | y >= a[0].length) return; // out range point

         if (x + 1 <= a.length - 1) {
             traverse(a,x+1,y,currentvalue);
         } else traverse(a,0,y+1,currentvalue);

        if (a[x][y] == -1) {
            // this point cannot be visited;
            return;
        }else {
            currentvalue += a[x][y];
            //out.println("cs:"+currentvalue);
            Maximum = Math.max(Maximum,currentvalue);
            int[][] temp = new int[a.length][a[0].length];
            for (int i = 0; i < a.length; i++) {
                System.arraycopy(a[i], 0, temp[i], 0, a[0].length);
            }
            temp[x][y] = -1;
            try {temp[x+1][y] = -1;} catch (ArrayIndexOutOfBoundsException e){}
            try {temp[x][y+1] = -1;} catch (ArrayIndexOutOfBoundsException e){}
            try {temp[x+1][y+1] = -1;} catch (ArrayIndexOutOfBoundsException e){}
            try {temp[x-1][y] = -1;} catch (ArrayIndexOutOfBoundsException e){}
            try {temp[x][y-1] = -1;} catch (ArrayIndexOutOfBoundsException e){}
            try {temp[x-1][y-1] = -1;} catch (ArrayIndexOutOfBoundsException e){}
            try {temp[x-1][y+1] = -1;} catch (ArrayIndexOutOfBoundsException e){}
            try {temp[x+1][y-1] = -1;} catch (ArrayIndexOutOfBoundsException e){}
            if (x + 1 <= a.length - 1) {
                traverse(temp,x+1,y,currentvalue);
            } else traverse(temp,0,y+1,currentvalue);

        }
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
