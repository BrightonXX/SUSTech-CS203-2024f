import java.io.*;
import java.util.StringTokenizer;

public class l3q3 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int testcases=in.nextInt();
        for (int its = 0; its < testcases; its++) {
            int ms=in.nextInt();
            int switchtimes=in.nextInt();
            Node head=new Node(2147483647);
            Node tail=new Node(-2147483648);
            Node[] nInO=new Node[ms];
            for (int i = 0; i < ms; i++) {
                nInO[i] = new Node(i);
            }
            //start first order
            int temp=in.nextInt();
            head.next=nInO[temp];
            nInO[temp].prev=head;
            int prevTemp=temp;
            for (int i = 0; i < ms-2; i++) {
                temp=in.nextInt();
                nInO[prevTemp].next=nInO[temp];
                nInO[temp].prev=nInO[prevTemp];
                prevTemp=temp;
            }
            temp=in.nextInt();
            nInO[prevTemp].next=nInO[temp];
            nInO[temp].prev=nInO[prevTemp];
            nInO[temp].next=tail;
            for (int sswwii = 0; sswwii < switchtimes; sswwii++) {
                int[] tf=new int[4];
                for (int i = 0; i < 4; i++) {
                    tf[i] = in.nextInt();
                }
                Node ntemp=nInO[tf[0]].prev;
                nInO[tf[0]].prev=nInO[tf[2]].prev;
                nInO[tf[2]].prev.next=nInO[tf[0]];
                nInO[tf[2]].prev=ntemp;
                ntemp.next=nInO[tf[2]];
                ntemp=nInO[tf[1]].next;
                nInO[tf[1]].next=nInO[tf[3]].next;
                nInO[tf[3]].next.prev=nInO[tf[1]];
                nInO[tf[3]].next=ntemp;
                ntemp.prev=nInO[tf[3]];
            }
            Node ntemp = head;
            while (ntemp.next!=tail){
                ntemp=ntemp.next;
                out.print(ntemp.data+" ");
            }
            out.println("");
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
class Node {
    public int data;
    Node prev;
    Node next;
    public Node(int coef) {
        //aX^n data1=a,data2=n
        data = coef;
        next = null;
        prev = null;
    }
}