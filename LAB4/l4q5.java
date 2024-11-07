import java.io.*;
import java.util.StringTokenizer;

public class l4q5 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int testcases = in.nextInt();
        for (int ts = 0; ts < testcases; ts++) {
            int arrle = in.nextInt();
            int[] arr = new int[arrle];
            int[] leftAnswer = new int[arrle];
            int[] rightAnswer = new int[arrle];
            leftAnswer[0]=-1; rightAnswer[0]=-1;
            for (int i = 0; i < arrle; i++) {
                arr[i] = in.nextInt();
            }
            Node incrHead = new Node(new DataWithIndex(2147483647,2147483646));
            Node incrTail = new Node(new DataWithIndex(2147483647,2147483647));
            Node ELIMINATED = new Node(new DataWithIndex(114514,1919810));
            incrHead.next=incrTail; incrTail.prev=incrHead;
            Node temp = new Node(new DataWithIndex(arr[0],0));
            // pop the first element into stack
            incrTail.prev.next=temp;
            temp.prev=incrTail.prev;
            temp.next=incrTail;
            incrTail.prev=temp;
            int index = 0;
            while (true){
                index++;
                if (index == arrle) break;
                if (incrTail.prev.packagedData.numb > arr[index]){
                    // the very left person is already higher, step down.
                    leftAnswer[index] = -1;
                    Node templeft = new Node(new DataWithIndex(arr[index],index));
                    incrTail.prev.next=templeft;
                    templeft.prev=incrTail.prev;
                    templeft.next=incrTail;
                    incrTail.prev=templeft;
                }else {
                    while (incrTail.prev.packagedData.numb < arr[index]){
                        temp = incrTail.prev;
                        if (temp == incrHead) {
                            temp = incrHead.next;
                            break;
                        }
                        incrTail.prev = temp.prev;
                        temp.prev.next = incrTail;
                        temp.next=ELIMINATED;
                        temp.prev=ELIMINATED;
                    }
                    leftAnswer[index] = temp.packagedData.index;
                    Node templeft = new Node(new DataWithIndex(arr[index],index));
                    incrTail.prev.next=templeft;
                    templeft.prev=incrTail.prev;
                    templeft.next=incrTail;
                    incrTail.prev=templeft;
                }
            }
            index = arrle;
            while (true){
                index--;
                if (index == -1) break;
                if (incrTail.prev.packagedData.numb > arr[index]){
                    // the very left person is already higher, step down.
                    rightAnswer[index] = -1;
                    Node templeft = new Node(new DataWithIndex(arr[index],index));
                    incrTail.prev.next=templeft;
                    templeft.prev=incrTail.prev;
                    templeft.next=incrTail;
                    incrTail.prev=templeft;
                }else {
                    while (incrTail.prev.packagedData.numb < arr[index]){
                        temp = incrTail.prev;
                        if (temp == incrHead) {
                            temp = incrHead.next;
                            break;
                        }
                        incrTail.prev = temp.prev;
                        temp.prev.next = incrTail;
                        temp.next=ELIMINATED;
                        temp.prev=ELIMINATED;
                    }
                    rightAnswer[index] = temp.packagedData.index;
                    Node templeft = new Node(new DataWithIndex(arr[index],index));
                    incrTail.prev.next=templeft;
                    templeft.prev=incrTail.prev;
                    templeft.next=incrTail;
                    incrTail.prev=templeft;
                }
            }
            rightAnswer[arrle-1] = -1;
            for (int i = 0; i < arrle; i++) {
                leftAnswer[i]++; rightAnswer[i]++;
            }
            out.println("Case "+(ts+1)+":");
            for (int i = 0; i < arrle; i++) {
                out.println(leftAnswer[i]+" "+rightAnswer[i]);
            }
        }
        out.close();
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
