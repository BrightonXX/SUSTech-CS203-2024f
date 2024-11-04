import java.io.*;
import java.util.StringTokenizer;
public class qu3 {
    public static void main(String[] args) {
        int nums=in.nextInt();
        long m=in.nextLong();
        long[] s=new long[nums];
        for (int i = 0; i < nums; i++) {
            s[i] = in.nextLong();
        }
        long times=0;
        for (int j = 0; j < nums; j++) {
            for (int k = 0; k < nums; k++) {
                if (s[j] < s[k]) {
                    long temp = s[j];
                    s[j] = s[k];
                    s[k] = temp;
                }
            }
        }
        for (int i = 0; i < nums-2; i++) {
            for (int j = 1; j < nums-1; j++) {
                if (i>=j) continue;
                if (s[i]+s[j]<=m){
                    long target=m-s[i]-s[j];
                    boolean find=false;
                    int left = j+1, right = nums - 1;
                    while (left <= right) {
                        //System.out.println("1");
                        int mid = (right - left) / 2 + left;
                        long num = s[mid];
                        if (num == target) {
                            find=true;
                            break;
                        } else if (num > target) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                    //
                    if (find) {
                       int id1 = j+1;
                       int id2 = nums-1;
                       while(id1 <= id2) {
                           int mi = (id1 + id2) >> 1;
                        //   System.out.println("finding r+" +target+":"+mi+","+id1+","+id2);
                           if (s[mi] <= target) {
                               id1=mi+1;
                           }else id2=mi-1;
                       }
                       int findr = id1;
                       id1 = j+1;
                       id2 = nums-1;
                       while(id1 <= id2) {
                          int mi = (id1+id2)>>1;
                         //  System.out.println("finding l+" +target+":"+mi+","+id1+","+id2);
                          if (s[mi] <target) {
                              id1 = mi+1;
                          }else id2= mi - 1;
                        }
                        int findl = id2;
                        if (findl>=j & findr>=j){
                            System.out.println(findr-findl-1);
                            times+=findr-findl-1 >=0 ? findr-findl-1:-(findr-findl-1);
                        }
                    }
                }
            }
        }
        out.print(times);
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
