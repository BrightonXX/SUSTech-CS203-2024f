import java.io.*;
import java.util.StringTokenizer;
public class l3q6 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int ts = in.nextInt();
        for (int tss = 0; tss < ts; tss++) {
            int lth = in.nextInt();
            if (lth == 1) {
                out.println(in.nextInt());
            } else {
                int[] tempstor = new int[lth];
                boolean[] tempdel = new boolean[lth];
                for (int inp = 0; inp < lth; inp++) {
                    tempstor[inp] = in.nextInt();
                    tempdel[inp] = false;
                }
                for (int i = 0; i < lth - 1; i++) {
                    if (tempstor[i] > tempstor[i + 1]) {
                        tempdel[i] = true;
                        tempdel[i + 1] = true;
                    }
                }
                Node head = new Node(-2147483648);
                Node tail = new Node(2147483647);
                Node DEATH = new Node(114514);
                int i = 0;
                while (tempdel[i]) {
                    i++;
                }


                NodeNode nd = new NodeNode(head);//this is the checklist
                Node temp = new Node(tempstor[i++]);
                head.next = temp;
                temp.prev = head;
                NodeNode ndtemp = nd;
                ndtemp.next=new NodeNode(temp);
                ndtemp=ndtemp.next;//here is to add the first thing into checklist


                for (; i < lth - 1; i++) {
                    if (!tempdel[i]) {
                        temp.next = new Node(tempstor[i]);
                        temp.next.prev = temp;
                        temp = temp.next;
                        if (tempdel[i + 1]) {
                            ndtemp.next = new NodeNode(temp);
                            ndtemp = ndtemp.next;
                        }
                    }
                }
                if (!tempdel[lth - 1]) {
                    temp.next = new Node(tempstor[i]);
                    temp = temp.next;
                }
                temp.next = tail;
                tail.prev = temp;
                NodeNode tbcTemp = nd;
                /*
                System.out.print("first scan: ");
                temp=head;
                while (temp.next!=tail){
                    temp=temp.next;
                    System.out.print(temp.data+" ");
                }
                System.out.println();
                */

                while (true) {
                    NodeNode nextround = new NodeNode(head);
                    NodeNode nexttemp = nextround;
                    while (true) {
                        tbcTemp = tbcTemp.next;
                        temp = tbcTemp.data;
                        //System.out.println("processing:" +temp.data+",it's next is :"+temp.next.data);
                        while (temp.next != tail & temp.data > temp.next.data) {
                            temp = temp.next;
                        }
                        //System.out.println("after proc:"+temp.data);
                        if (tbcTemp.data != temp) {
                            nexttemp.next = new NodeNode(tbcTemp.data.prev);
                            nexttemp = nexttemp.next;
                            tbcTemp.data.prev.next = temp.next;
                            temp.next.prev = tbcTemp.data.prev;
                            // temp and tbctemp.data are sentenced to death;
                            temp.next=DEATH;
                            temp.prev=DEATH;
                            tbcTemp.data.prev=DEATH;
                            tbcTemp.data.next=DEATH;
                        }
                        if (tbcTemp.next==null){
                            break;
                        }
                    }
                    if (nextround.next == null) {
                        break;
                    }else {
                        tbcTemp=nextround;
                    }
                }
                temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                    out.print(temp.data + " ");
                }
                out.println("");
            }
        }
        out.close();
    }
    static class Node {
        public int data;
        Node next;
        Node prev;
        public Node(int coef) {
            data = coef;
            next = null;
            prev = null;
        }
    }
    static class NodeNode {
        public Node data;
        NodeNode next;
        NodeNode prev;
        public NodeNode(Node dat) {
            data = dat;
            next = null;
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
