import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class l9q5 {
    public static void main(String[] args) {
        int nodes = in.nextInt();
        int edges = in.nextInt();
        int target = in.nextInt();
        node[] store = new node[nodes];
        edge[] stedg = new edge[edges];
        for (int i = 0; i < nodes; i++) {
            store[i] = new node(i+1);
            store[i].inverse.add(store[i]);
            store[i].straightforward.add(store[i]);
        }
        for (int i = 0; i < edges; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            stedg[i] = new edge(store[a-1],store[b-1]);
            store[a-1].straightforward.add(store[b-1]);
            store[b-1].inverse.add(store[a-1]);
        }
        for (int i = 0; i < nodes; i++) {
            if (!store[i].dfsed){
                dfs(store[i]);
            }
        }
        int groups = 0;
        for (int i = 0; i < nodes; i++) {
            if (!inverseDFS.get(nodes-1-i).dfs2ed){
                dfs2(inverseDFS.get(nodes-1-i),groups);
                groups++;
            }
        }
        int[] SCCs = new int[groups];
        for (int i = 0; i < edges; i++) {
            if(stedg[i].leftcon.group!=stedg[i].rightcon.group){
                SCCs[stedg[i].rightcon.group]++;
            }
        }
        int answer = 0;
        for (int i = 0; i < groups; i++) {
            if (SCCs[i] == 0) answer++;
        }
        if (SCCs[store[target-1].group] == 0) answer--;
        System.out.println(answer);
    }
    static ArrayList<node> inverseDFS = new ArrayList<>();
    static void dfs(node a){
        a.dfsyellow = true;
        for (int i = 0; i < a.inverse.size(); i++) {
            if (!a.inverse.get(i).dfsyellow) {
                dfs(a.inverse.get(i));
            }
        }
        inverseDFS.add(a);
        a.dfsed = true;
    }
    static void dfs2(node a,int group){
        a.group = group;
        a.dfs2yellow = true;
        for (int i = 0; i < a.straightforward.size(); i++) {
            if (!a.straightforward.get(i).dfs2yellow) {
                dfs2(a.straightforward.get(i),group);
            }
        }
        a.dfs2ed = true;
    }
    static class node {
        int index;
        int group;
        boolean dfsed = false;
        boolean dfsyellow = false;
        boolean dfs2ed = false;
        boolean dfs2yellow = false;
        ArrayList<node> straightforward;
        ArrayList<node> inverse;

        public node(int hlb) {
            index = hlb;
            straightforward = new ArrayList<>();
            inverse = new ArrayList<>();
        }
    }
    static class edge {
        node leftcon;
        node rightcon;
        public edge(node a, node b) {
            leftcon = a;
            rightcon = b;
        }
    }
    static QReader in = new QReader();
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
}
