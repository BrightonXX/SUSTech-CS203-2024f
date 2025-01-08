import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class l8q4 {
    public static void main(String[] args) {
        int tc = in.nextInt();
        for (int ts = 0; ts < tc; ts++) {
            int nodes = in.nextInt();
            int query = in.nextInt();
            node[] store = new node[nodes];
            for (int i = 0; i < store.length; i++) {
                store[i] = new node(i+1);
            } // store[0] stores node with index 1; if given index 'son' , stored in [son-1]
            for (int i = 0; i < nodes-1; i++) {
                int son = in.nextInt();
                int fat = in.nextInt();
                store[son-1].isSoned = true;
                store[fat-1].myDearSons.add(store[son-1]);
            }
            //find the root.
            node root = null;
            for (int i = 0; i < nodes; i++) {
                if (!store[i].isSoned) {
                    root = store[i];
                    break;
                }
            }
            if (root != null) {
                dfs(root);
            }
            for (int i = 0; i < query; i++) {
                int isSon = in.nextInt();
                int isFather = in.nextInt();
                if (store[isFather-1].entryTime <= store[isSon-1].entryTime & store[isFather-1].kickOutTime >= store[isSon-1].kickOutTime){
                    out.println("Yes");
                }else out.println("No");
            }
        }
        out.close();
    }
    static int theSystemTime = 0;
    static void dfs(node a){
        a.entryTime = theSystemTime;
        theSystemTime++;
        for (int i = 0; i < a.myDearSons.size(); i++) {
            dfs(a.myDearSons.get(i));
        }
        a.kickOutTime = theSystemTime;
        theSystemTime++;
    }
    static class node{
        int indexs;
        boolean isSoned;
        int entryTime;
        int kickOutTime;
        ArrayList<node> myDearSons = new ArrayList<>();
        public node (int ind){
            indexs = ind;
            isSoned = false;
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
