import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class l6q3 {
    public static void main(String[] args) {
        int N = in.nextInt();
        int num = in.nextInt();
        node[] nodes = new node[N+1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] =new node();
        }
        for (int i = 2; i < N+1; i++) {
            int relation = in.nextInt();
            int re2 = in.nextInt();
            int distance = in.nextInt();
            nodes[re2].children.add(nodes[relation]);
            nodes[relation].children.add(nodes[re2]);
            nodes[re2].distances.add(distance);
            nodes[relation].distances.add(distance);
        }
        node[] queue = new node[N+1];
        int front = 0;
        int rear = 1;
        queue[0] = nodes[1];
        nodes[1].path = 0;
        int ans = 0;
        while (front < rear){
            node temp = queue[front];
            boolean determineleaf = true;
            for (int i = 0; i < queue[front].children.size(); i++) {
                if (queue[front].children.get(i).flag) {
                    queue[front].children.get(i).flag = false;
                    determineleaf = false;
                    queue[rear] = queue[front].children.get(i);
                    temp.children.get(i).path = temp.path+temp.distances.get(i);
                    rear++;
                }
            }
            if (determineleaf) if (temp.path == num) ans++;
            front++;
        }
        out.print(ans);
        out.close();
    }
    static class node{
        ArrayList<node> children = new ArrayList<>();
        ArrayList<Integer> distances = new ArrayList<>();
        int path;
        boolean flag = true;
        public node (){}
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
