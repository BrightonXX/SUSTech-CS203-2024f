import java.io.*;
import java.util.StringTokenizer;

public class l4q1 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int times=in.nextInt();
        for (int i = 0; i < times; i++) {
            int lengt = in.nextInt();
            Stack sk = new Stack(lengt);
            String st = in.nextLine();
            boolean det = true;
            for (int i1 = 0; i1 < st.length(); i1++) {
                char temm = st.charAt(i1);
                if (temm == '(') sk.push('(');
                if (temm == '{') sk.push('{');
                if (temm == '[') sk.push('[');
                if (temm == ')') {
                    if (sk.pop() != '(') det = false;
                }
                if (temm == '}') {
                    if (sk.pop() != '{') det = false;
                }
                if (temm == ']') {
                    if (sk.pop() != '[') det = false;
                }
            }
            if (sk.getIndex()!=-1) det=false;
            if (det) {
                System.out.println("YES");
            } else System.out.println("NO");
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
class Stack {
    char[] storage;
    int index=-1;
    Stack(int size){
        storage=new char[size];
    }

    public void push(char a){
        if (index==storage.length-1){
            // System.out.println("full");
        }else {
            index++;
            storage[index]=a;
           // System.out.println("push:"+a);
        }
    }
    public char pop(){
        if (index==-1){
          //  System.out.println("empty");
            return '0';
        }else {
            index--;
           // System.out.println("pop:"+storage[index+1]);
            return storage[index+1];
        }
    }
    public int getIndex(){
        return index;
    }
}