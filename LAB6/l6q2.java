import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class l6q2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int ts = in.nextInt();
        for (int tss = 0; tss < ts; tss++) {
            int N = in.nextInt();
            node[] nodes= new node[N];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new node(i+1);
            }
            for (int i = 1; i < N; i++) {
                int temp = in.nextInt();
                nodes[temp-1].children.add(nodes[i]);
            }
            node[] queue = new node[N];
            int front = 0;
            int rear = 1;
            queue[0] = nodes[0];
            while (front < rear){
                out.print(queue[front].val+" ");
                for (int i = 0; i < queue[front].children.size(); i++) {
                    queue[rear] = queue[front].children.get(i);
                    rear++;
                }
                front++;
            }
            out.println("");
        }
        out.close();
    }
    static class node{
        ArrayList<node> children = new ArrayList<>();
        int val;
        public node (int val){
            this.val=val;
        }
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
