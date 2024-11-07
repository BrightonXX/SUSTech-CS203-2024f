import java.io.*;
import java.util.StringTokenizer;

public class l4q3 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        while (in.hasNext()){
            int deques=in.nextInt();
            Node[] tNHead=new Node[deques];
            Node[] tNTail=new Node[deques];
            Node ELIMINATED = new Node(2147483647);
            for (int i = 0; i < deques; i++) {
                tNHead[i] = new Node(2147483647);
                tNTail[i] = new Node(-2147483648);
                tNHead[i].next=tNTail[i];
                tNTail[i].prev=tNHead[i];
            }
            int opti=in.nextInt();
            for (int i = 0; i < opti; i++) {
                int opMode=in.nextInt();
                int index= in.nextInt() - 1;
                if (opMode==1){ //insertion mode
                    int w = in.nextInt();
                    Node temp = new Node(in.nextInt());
                    if (w==0) { // insert in the front;
                        tNHead[index].next.prev=temp;
                        temp.prev=tNHead[index];
                        temp.next=tNHead[index].next;
                        tNHead[index].next=temp;
                    }else {//insert to the rear
                        tNTail[index].prev.next=temp;
                        temp.prev=tNTail[index].prev;
                        temp.next=tNTail[index];
                        tNTail[index].prev=temp;
                    }
                }else if (opMode==2){ //pop the element
                    int w = in.nextInt();
                    if (w==0){ // pop front;
                        if (tNHead[index].next==tNTail[index]){
                            System.out.println("-1");
                        }else {
                        Node temp = tNHead[index].next;
                        tNHead[index].next = temp.next;
                        temp.next.prev = tNHead[index];
                        temp.next=ELIMINATED;
                        temp.prev=ELIMINATED;
                        System.out.println(temp.data);
                        }
                    }else {  // pop rear
                        if (tNHead[index].next==tNTail[index]){
                            System.out.println("-1");
                        }else {
                        Node temp = tNTail[index].prev;
                        tNTail[index].prev = temp.prev;
                        temp.prev.next = tNTail[index];
                        temp.next=ELIMINATED;
                        temp.prev=ELIMINATED;
                        System.out.println(temp.data);
                        }
                    }
                } else {// connection
                    int diIndex=in.nextInt() - 1;
                    int inverse=in.nextInt();
                    if (inverse == 0) {//directly
                        tNTail[index].prev.next = tNHead[diIndex].next;
                        tNHead[diIndex].next.prev = tNTail[index].prev;
                        tNTail[diIndex].prev.next = tNTail[index];
                        tNTail[index].prev = tNTail[diIndex].prev;
                    }else {// reversely problem.
                        Node temp2 = tNTail[diIndex];
                        while (true){
                            temp2 = temp2.prev;
                            if (temp2 == tNHead[diIndex]) break;
                            Node temp = new Node(temp2.data);
                            tNTail[index].prev.next=temp;
                            temp.prev=tNTail[index].prev;
                            temp.next=tNTail[index];
                            tNTail[index].prev=temp;
                        }
                    }
                    tNHead[diIndex].next=tNTail[diIndex];
                    tNTail[diIndex].prev=tNHead[diIndex];
                }
            }
        }
        out.close();
    }
    static class Node {
        public int data;
        Node next;
        Node prev;
        public Node(int dat) {
            data = dat;
            next = null;
            prev = null;
        }
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
