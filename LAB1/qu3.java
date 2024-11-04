import java.io.*;
import java.util.StringTokenizer;

public class qu3 {
    public static void main(String[] args) {
        int arrl=in.nextInt();
        int[] arr=new int[arrl];
        int tc=in.nextInt();
        for (int i = 0; i < arrl; i++) {
            arr[i]=in.nextInt();
        }
        for (int i = 0; i < tc; i++) {
            int left=in.nextInt();
            int right=in.nextInt();

            boolean find=false;
            int index1=0;
            int index2=arrl;
            while (index1< index2){
                int tem = (index1 + ((index2 - index1 + 1) >> 1));
                if (arr[tem - 1] < right & arr[tem - 1] > left ){
                    find=true;
                    break;
                }else if (arr[tem - 1] > left ){
                    index2 = tem - 1;
                }else {
                    index1 = tem;
                }
            }

           if (find) {
               System.out.print("YES ");
               int ldx=0;
               int rdx=0;
               index1=0;
               index2=arrl;
               while (index1< index2){
                   int tem = (index1 + ((index2 - index1 + 1) >> 1));
                 //   System.out.println("finding l:" + tem + ", "+index1+" ,"+index2 );
                   if (tem == 0 | tem == 1 | tem == 2){
                       if (arr[0]>left) {
                           ldx=0;
                           break;
                       }
                       if (arr[1]>left){
                            ldx=1;
                            break;
                       }
                       if (arr[2]>left) {
                           ldx = 2;
                           break;
                       }
                       index1+=1;
                   }else {
                       if (arr[tem - 1] > left & arr[tem - 2] <= left) {
                           ldx = tem - 1;
                           break;
                       } else if (arr[tem - 1] > left) {
                           index2 = tem - 1;
                       } else {
                           index1 = tem;
                       }
                   }
               }

               index1=0;
               index2=arrl;
               while (index1< index2){
                   int tem = (index1 + ((index2 - index1 + 1) >> 1));
                 // System.out.println("finding r:" + tem + ", "+index1+" ,"+index2 );
                   if (tem == arrl-1 | tem == arrl-2 | tem == arrl - 3){
                       if (arr[arrl-1]<right) {
                           rdx=arrl-1;
                           break;
                       }
                       if (arr[arrl-2]<right) {
                           rdx=arrl-2;
                           break;
                       }
                       if (arr[arrl-3]<right) {
                           rdx=arrl-3;
                           break;
                       }
                       index1-=1;
                   }else {
                       if (arr[tem] < right & arr[tem + 1] >= right) {
                           rdx = tem;
                           break;
                       } else if (arr[tem] < right) {
                           index1 = tem;
                       } else {
                           index2 = tem - 1;
                       }
                   }
               }
               System.out.println(rdx-ldx+1);
           }else {
               System.out.println("NO");
           }
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
