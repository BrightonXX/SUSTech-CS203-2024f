import java.io.*;
import java.util.StringTokenizer;

public class qu6 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int arrlen=in.nextInt();
        int[]a =new int[arrlen];
        int[]b= new int[arrlen];
        int times=in.nextInt();
        for (int i = 0; i < arrlen; i++) {
            a[i]= in.nextInt();
        }
        for (int i = 0; i < arrlen; i++) {
            b[i]= in.nextInt();
        }
        for (int i = 0; i < times; i++) {
            int fir = in.nextInt();
            int sec = in.nextInt();
            int lengtttth=sec - fir + 1;

            int index1 = fir-1;
            int index2 = lengtttth+fir-1;

            while (index1< index2){
                int tem = (index1 + ((index2 - index1 + 1) >> 1));
                // actually occ : tem-fir+1;
                int jb = (fir-1)+ (lengtttth - tem + fir - 1 );
                if (a[tem - 1] > b[jb]) {
                    index2 = tem - 1;
                } else {
                    index1 = tem;
                }
            }
            int jb = (fir-1)+ (lengtttth - (index1 + ((index2 - index1 + 1) >> 1)) + fir - 1 );
            if (jb == (fir-1)) {
                out.println(a[index1 - 1]);
            } else if (index1 == (fir-1)) {
                out.println(b[jb - 1]);
            } else {
                out.println((a[index1 - 1] >=b[jb - 1]) ? a[index1 - 1] :b[jb - 1]);
            }
        }
        out.close();
    }
}
class QReader {
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

class QWriter implements Closeable {
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

