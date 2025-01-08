import java.io.*;
import java.util.StringTokenizer;

public class bonusCP {
    public static void main(String[] args) {
        int querynum = in.nextInt();
        int cachesize = in.nextInt();
        matrixNode head = new matrixNode();
        matrixNode tail = new matrixNode();
        head.next = tail;
        tail.prev = head;
        int detectNum = 0;
        for (int ts = 0; ts < querynum; ts++) {
            int[][] matrixInput = new int[16][16];
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    matrixInput[i][j] = in.nextInt();
                }
            }
            matrixNode temp = new matrixNode(matrixInput);
            matrixNode trav = head.next;
            boolean isUpdated = false;
            while (trav.store != null) {
                if (trav.compare(temp.store)) { //in-it-update
                    trav.prev.next = trav.next;
                    trav.next.prev = trav.prev;//delete-the-formal
                    isUpdated = true;
                    break;
                } else trav = trav.next;
            }
            temp.prev = head;
            temp.next = head.next;
            head.next.prev = temp;
            head.next = temp;
            if (isUpdated){
                System.out.println("hit");
            }else {
                System.out.println("miss");
                if (detectNum < cachesize){// notfull
                    detectNum++;
                } else { //full-delete-last
                    tail.prev = tail.prev.prev;
                    tail.prev.next = tail;
                }
            }
        }
        out.close();
    }
    static class matrixNode{
        int[][] store;
        matrixNode next;
        matrixNode prev;
        matrixNode(int[][] temp){
            store = temp;
        }
        matrixNode(){}
        boolean compare(int[][] temp){
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (temp[i][j]!=store[i][j]) {
                        return false;
                    }
                }
            }
            return true;
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
