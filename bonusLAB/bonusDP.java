import java.io.*;
import java.util.StringTokenizer;

public class bonusDP {
    public static void main(String[] args) {
        int test = in.nextInt();
        for (int ts = 0; ts < test; ts++) {
            int days = in.nextInt();
            int[] pan = new int[days];
            int[] ans = new int[days];
            for (int i = 0; i < days; i++) {
                pan[i] = in.nextInt();
            }
            int query = in.nextInt();
            int[] tofindindex =new int[query];
            for (int i = 0; i < query; i++) {
                tofindindex[i] = in.nextInt() -1 ;
            }
            Stack sk = new Stack(query);
            sk.push(new node(0,pan[0]));
            for (int i = 1; i < days; i++) {
                while (true){
                    if (sk.getIndex() == -1) break;
                    if (sk.getTop().value >= pan[i]) break;
                    node temp = sk.pop();
                    ans[temp.day] = i - temp.day;
                }
                sk.push(new node(i,pan[i]));
            }
            for (int i = 0; i < query; i++) {
                if (ans[tofindindex[i]]==0){
                    out.println("-1");
                }else out.println(ans[tofindindex[i]]);
            }
        }
        out.close();
    }

    static class node {
        int day;
        int value;
        public node(int d,int v) {
            day = d;
            value = v;
        }
    }

    static class Stack {
        node[] storage;
        int index=-1;
        Stack(int size){
            storage=new node[size];
        }

        public void push(node a){
            if (index==storage.length-1){
                 System.out.println("full");
            }else {
                index++;
                storage[index]=a;
            }
        }
        public node pop(){
            if (index==-1){
                System.out.println("empty");
                return null;
            }else {
                index--;
                // System.out.println("pop:"+storage[index+1]);
                return storage[index+1];
            }
        }
        public int getIndex(){
            return index;
        }
        public node getTop(){
            return storage[index];
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
