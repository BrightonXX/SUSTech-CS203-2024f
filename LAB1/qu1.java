package LAB1;
import java.io.*;
import java.util.StringTokenizer;

public class qu1 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int arraylen= in.nextInt();
        int[] ar=new int[arraylen];
        for (int i = 0; i < arraylen; i++) {
            ar[i]=in.nextInt();
        }
        int times= in.nextInt();
        for (int i = 0; i < times; i++) {
            int left=0;
            int right=arraylen-1;
            int input=in.nextInt();
            boolean find=false;
            if (input==ar[0]|input==ar[right]){
                find=true;
            }else {
                while (left!=right) {
                if (input == ar[(left + right) >> 1]) {
                    find = true;
                    break;
                }else if (input > ar[(left + right) >> 1]){
                    if (left==(left+right)>>1){
                        left+=1;
                    } else left= (left+right)>>1;
                }else {
                    if (right ==(left+right)>>1){
                        right-=1;
                    }else right =(left+right)>>1;
                    }
                }
            }
            if (find) {
                out.println("YES");
            }else out.println("NO");
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
