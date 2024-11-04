import java.io.*;
import java.util.StringTokenizer;

public class qu4 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int times= in.nextInt();
        for (int repeat = 0; repeat < times; repeat++) {
            int aSize= in.nextInt();
            int max=-2147482638;
            int beforeMax=-2147482638;
            int[] store=new int[aSize];
            for (int i1 = 0; i1 < aSize; i1++) {
                store[i1]=in.nextInt();
            }
            for (int i = 1; i < store.length; i++) {
               beforeMax=Math.max(store[i-1],beforeMax);
               max=Math.max(max,beforeMax-store[i]);
            }
            System.out.println(max);
        }
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
