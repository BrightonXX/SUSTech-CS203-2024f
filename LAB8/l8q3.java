import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class l8q3 {
    public static void main(String[] args) {
        int testcases = in.nextInt();
        for (int ts = 0; ts < testcases; ts++) {
            int cities = in.nextInt();
            int roads = in.nextInt();
            node[] store = new node[cities+1]; // store is stored as index. left 0 as null;

            for (int i = 1; i < store.length; i++) {
                store[i] = new node(i);
            }

            for (int i = 0; i < roads; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                store[a].partner.add(store[b]);
                store[b].partner.add(store[a]);
            }
            node[] queue = new node[cities + 2];
            int front = 0;
            int rear = 1;
            queue[0] = store[1];
            queue[0].isstacked = true;
            ArrayList<node> star = new ArrayList<>();
            ArrayList<node> moon = new ArrayList<>();
            star.add(store[1]);
            while (front < rear){
                for (int i = 0; i < queue[front].partner.size(); i++) {
                    if (!queue[front].partner.get(i).isstacked){
                        queue[rear++] = queue[front].partner.get(i);
                        queue[front].partner.get(i).distance = queue[front].distance+1;
                        queue[front].partner.get(i).isstacked = true;
                        if (queue[front].partner.get(i).distance % 2 == 1) {
                            moon.add(queue[front].partner.get(i));
                        } else star.add(queue[front].partner.get(i));
                    }
                }
                front++;
            }
            if (star.size() <= moon.size()){
                out.println(star.size());
                for (int i = 0; i < star.size(); i++) {
                    out.print(star.get(i).indexs+" ");
                }
            }else {
                out.println(moon.size());
                for (int i = 0; i < moon.size(); i++) {
                    out.print(moon.get(i).indexs+" ");
                }
            }
            out.println("");
        }
        out.close();
    }
    static class node{
        int distance;
        int indexs;
        boolean isstacked = false;
        ArrayList<node> partner = new ArrayList<>();
        public node (int ind){
            indexs = ind;
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
