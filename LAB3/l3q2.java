import java.io.*;
import java.util.StringTokenizer;

public class l3q2 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int ts=in.nextInt();
        for (int testcase = 0; testcase < ts; testcase++) {
            int first=in.nextInt();
            Node n1=new Node();
            for (int i = 0; i < first; i++) {
                n1.append(in.nextInt(), in.nextInt());
            }
            int sec=in.nextInt();
            Node n2=new Node();
            for (int i = 0; i < sec; i++) {
                n2.append(in.nextInt(),in.nextInt());
            }
            Node result=merge(n1,n2);
            int finT=in.nextInt();
            int[] coe = result.intCoe();
            int[] exp = result.intExp();
            int index2=0;
            for (int i = 0; i < finT; i++) {
                int temp=in.nextInt();
                while (exp[index2]<temp){
                    if (index2<=coe.length-2) {
                        index2++;
                    }else break;
                }
                if (exp[index2]==temp) {
                    out.print(coe[index2]+" ");
                }else out.print("0 ");
            }
            out.println("");
        }
        out.close();
    }

    public static Node merge(Node nn1,Node nn2){
        Node toRe=new Node();
        Node n1=nn1.head;
        Node n2=nn2.head;
        while (n1!=null & n2!=null){
            if (n1.data2==n2.data2){
                toRe.append((n1.data1+n2.data1),n1.data2);
                n1=n1.next;
                n2=n2.next;
            }else if (n1.data2<n2.data2){
                toRe.append(n1.data1,n1.data2);
                n1=n1.next;
            }else {
                toRe.append(n2.data1,n2.data2);
                n2=n2.next;
            }
        }
        while (n1!=null){
            toRe.append(n1.data1,n1.data2);
            n1=n1.next;
        }
        while (n2!=null){
            toRe.append(n2.data1,n2.data2);
            n2=n2.next;
        }
        return toRe;
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
    static class Node {
        public int data1;
        public int data2;
        Node next;
        Node head;

        Node(){}
        Node(int coef,int exponents) {
            //aX^n data1=a,data2=n
            data1 = coef;
            data2 = exponents;
            next = null;
        }

        public void append(int coef,int exponents) {
            Node newNode = new Node(coef,exponents);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
        public int[] intExp(){
            Node temp=head;
            int count=0;
            while (temp!=null) {
                count++;
                temp=temp.next;
            }
            int[] ret=new int[count];
            temp=head;
            count=0;
            while (temp!=null) {
                ret[count]=temp.data2;
                temp=temp.next;
                count++;
            }
            return ret;
        }
        public int[] intCoe(){
            Node temp=head;
            int count=0;
            while (temp!=null) {
                count++;
                temp=temp.next;
            }
            int[] ret=new int[count];
            temp=head;
            count=0;
            while (temp!=null) {
                ret[count]=temp.data1;
                temp=temp.next;
                count++;

            }
            return ret;
        }
    }
}
