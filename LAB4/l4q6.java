import java.io.*;
import java.util.StringTokenizer;
public class l4q6 {
    public static void main(String[] args) {
        QReader in = new QReader();
        int maximum = in.nextInt();
        int arrle = in.nextInt()+1;
        int[] intdata = new int[arrle+1];
        Node incrHead = new Node(new DataWithIndex(-2147483648,2147483646));
        Node incrTail = new Node(new DataWithIndex(-2147483648,2147483647));
        incrHead.next=incrTail; incrTail.prev=incrHead;
        Node decrHead = new Node(new DataWithIndex(2147483647,2147483646));
        Node decrTail = new Node(new DataWithIndex(2147483647,2147483647));
        decrHead.next=decrTail; decrTail.prev=decrHead;
        Node ELIMINATED = new Node(new DataWithIndex(2147483647,-114514));
        for (int i = 0; i < arrle-1; i++) {
            intdata[i] = in.nextInt();
        }
        intdata[arrle-1] = 2147483647;
        int indexleft=0;
        int indexright=0;
        int answer=-1;
        Node templeft = new Node(new DataWithIndex(intdata[indexleft],indexleft));
        Node tempright = new Node(new DataWithIndex(intdata[indexright],indexright));
        //left index into stack
        incrTail.prev.next=templeft;
        templeft.prev=incrTail.prev;
        templeft.next=incrTail;
        incrTail.prev=templeft;
        //right index into stack
        decrTail.prev.next=tempright;
        tempright.prev=decrTail.prev;
        tempright.next=decrTail;
        decrTail.prev=tempright;
        while (true){
            if ((incrHead.next.packagedData.numb - decrHead.next.packagedData.numb) <= maximum){
                indexright++;
                if (indexright == arrle) break;
                answer = Math.max(answer,indexright-indexleft);
                templeft = new Node(new DataWithIndex(intdata[indexright],indexright));
                tempright = new Node(new DataWithIndex(intdata[indexright],indexright));
                while (!(templeft.packagedData.numb <= incrTail.prev.packagedData.numb)) {
                    // delete all the data less than concurrent data
                    Node temp = incrTail.prev;
                    if (temp == incrHead) break;
                    incrTail.prev = temp.prev;
                    temp.prev.next = incrTail;
                    temp.next=ELIMINATED;
                    temp.prev=ELIMINATED;
                }
                incrTail.prev.next=templeft;
                templeft.prev=incrTail.prev;
                templeft.next=incrTail;
                incrTail.prev=templeft;
                while (!(tempright.packagedData.numb >= decrTail.prev.packagedData.numb)){
                    Node temp = decrTail.prev;
                    if (temp == decrHead) break;
                    decrTail.prev = temp.prev;
                    temp.prev.next = decrTail;
                    temp.prev = ELIMINATED;
                    temp.next = ELIMINATED;
                }
                decrTail.prev.next=tempright;
                tempright.prev=decrTail.prev;
                tempright.next=decrTail;
                decrTail.prev=tempright;
            }else {
                indexleft++;
                if (incrHead.next.packagedData.index < indexleft){
                    Node temp = incrHead.next;
                    incrHead.next = temp.next;
                    temp.next.prev = incrHead;
                    temp.prev=ELIMINATED;
                    temp.next=ELIMINATED;
                }
                if (decrHead.next.packagedData.index < indexleft){
                    Node temp = decrHead.next;
                    decrHead.next = temp.next;
                    temp.next.prev = decrHead;
                    temp.prev=ELIMINATED;
                    temp.next=ELIMINATED;
                }
            }
        }
        System.out.println(answer);
    }
    static class DataWithIndex{
        int numb;
        int index;
        DataWithIndex(int data,int index){
            this.numb =data;
            this.index=index;
        }
    }
    static class Node {
        public DataWithIndex packagedData;
        Node next;
        Node prev;
        public Node(DataWithIndex d) {
            packagedData = d;
            next = null;
            prev = null;
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
