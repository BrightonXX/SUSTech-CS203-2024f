import java.io.*;

import java.util.StringTokenizer;

public class bonusIP {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int testcases=in.nextInt();
        for (int ts = 0; ts < testcases; ts++) {
            int zn = in.nextInt();
            list[] listlist = new list[zn];
            for (int i = 0; i < zn; i++) {
                listlist[i] = new list(in.nextInt(), in.nextInt());
            }
            int Bb = 0;
            for (int i = 0; i < zn; i++) {
                if (listlist[i].b >= listlist[i].r) Bb += 1;
            }
            int Rb = zn - Bb;
            list[] listBb = new list[Bb];
            list[] listRb = new list[Rb];
            Bb = 0;
            Rb = 0;
            for (int i = 0; i < zn; i++) {
                if (listlist[i].b >= listlist[i].r) {
                    listBb[Bb] = listlist[i];
                    Bb++;
                } else {
                    listRb[Rb] = listlist[i];
                    Rb++;
                }
            }
            MergeSortR.sort(listBb);
            MergeSortB.sort(listRb);
            listlist = new list[zn];
            for (int i = 0; i < listRb.length; i++) {
                listlist[i] = listRb[i];
            }
            for (int i = listRb.length; i < zn; i++) {
                listlist[i] = listBb[listBb.length - 1 - i + listRb.length];
            }
            if (listlist.length==1){
                out.println(listlist[0].b+listlist[0].r);
            }else {
                int index = 0;
                int BlueBox1 = listlist[index].b;
                int RedBox1 = listlist[index].r;
                int BlueBox2 = listlist[index + 1].b;
                int RedBox2 = listlist[index + 1].r;
                while (true) {
                    if (RedBox1 >= BlueBox2) {
                        RedBox1 = RedBox1 - BlueBox2 + RedBox2;
                        index++;
                        if (index == listlist.length - 1) break;
                        BlueBox2 = listlist[index + 1].b;
                        RedBox2 = listlist[index + 1].r;
                    } else {
                        BlueBox1 = BlueBox2 - RedBox1 + BlueBox1;
                        RedBox1 = RedBox2;
                        index++;
                        if (index == listlist.length - 1) break;
                        BlueBox2 = listlist[index + 1].b;
                        RedBox2 = listlist[index + 1].r;
                    }
                } out.println(RedBox1+BlueBox1);
            }
        }
        out.close();
    }
    static class list{
        int b;
        int r;
        list(int b,int r){
            this.b=b;
            this.r=r;
        }
    }
    static class MergeSortB {
        private static list[] assist;
        public static void sort(list[] a){
            assist = new list[a.length];
            int lo = 0;
            int hi = a.length - 1;
            sort(a,lo,hi);
        }
        private static void sort(list[] a, int lo, int hi){
            if (hi<=lo) return;
            int mid = (lo + hi) >> 1;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }
        private static void merge (list[] a,int lo,int mi,int hi){
            int i = lo;
            int j = mi + 1;
            int k = 0;
            while (i <=mi && j<= hi){
                if (a[i].b < a[j].b){
                    assist[k++] = a[i++];
                }else {
                    assist[k++] = a[j++];
                }
            }
            while (i <=mi){
                assist[k++] = a[i++];
            }
            while (j <= hi){
                assist[k++] = a[j++];
            }
            if (hi - lo + 1 >= 0) System.arraycopy(assist, 0, a, lo, hi - lo + 1);
        }
    }
    static class MergeSortR {
        private static list[] assist;
        public static void sort(list[] a){
            assist = new list[a.length];
            int lo = 0;
            int hi = a.length - 1;
            sort(a,lo,hi);
        }
        private static void sort(list[] a, int lo, int hi){
            if (hi<=lo) return;
            int mid = (lo + hi) >> 1;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }
        private static void merge (list[] a,int lo,int mi,int hi){
            int i = lo;
            int j = mi + 1;
            int k = 0;
            while (i <=mi && j<= hi){
                if (a[i].r < a[j].r){
                    assist[k++] = a[i++];
                }else {
                    assist[k++] = a[j++];
                }
            }
            while (i <=mi){
                assist[k++] = a[i++];
            }
            while (j <= hi){
                assist[k++] = a[j++];
            }
            if (hi - lo + 1 >= 0) System.arraycopy(assist, 0, a, lo, hi - lo + 1);
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
