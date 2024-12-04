import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class l6q5 {
    public static void main(String[] args) {
        int cities = in.nextInt();
        int maxlevel = 1;
        node[] city = new node[cities+1]; // city[0] null
        for (int i = 0; i < cities+1; i++) {
            city[i] = new node(i);
        }
        city[1].level = 1; // increasing from 1; since 0 is a default num;
        for (int i = 0; i < cities-1; i++) {
            int connection1 = in.nextInt();
            int connection2 = in.nextInt();
            city[connection1].relation.add(city[connection2]);
            city[connection2].relation.add(city[connection1]);
        }
        node[] queue = new node[cities + 1];
        int front = 0;
        int rear = 1;
        queue[0] = city[1];
        while (front < rear){
            node temp = queue[front];
            for (int i = 0; i < queue[front].relation.size(); i++) {
                temp.stacked = true;
                if (!queue[front].relation.get(i).stacked) {
                    temp.sons.add(queue[front].relation.get(i));
                    queue[front].relation.get(i).boss = temp;
                    queue[front].relation.get(i).level = temp.level+1;
                    queue[rear] = queue[front].relation.get(i);
                    rear++;
                }
            }
            front++;
        }
        int count = in.nextInt();
        for (int i = 0; i < count; i++) {
            int location = in.nextInt();
            city[location].occupied = true;
        }
        int answer = 0;
        for (int i = 0; i < city[1].sons.size(); i++) {
            Array.add(new ArrayList<>());
            dfs(city[1].sons.get(i),i);
        }
        for (int i = 0; i < city[1].sons.size(); i++) {
            int[] temparr= new int[Array.get(i).size()];
            for (int j = 0; j < temparr.length; j++) {
                temparr[j] = Array.get(i).get(j);
            }
            MergeSort.sort(temparr);
         //   System.out.println(Arrays.toString(temparr));
            if (temparr.length == 0)continue;
            int max = temparr[0];
            for (int j = 1; j < temparr.length; j++) {
                if (temparr[j] == temparr[j-1]){
                    max++;
                } else max = Math.max(max+1,temparr[j]);
            }
            answer = Math.max(answer,max);
            //  System.out.println("max:" + max);
        }
        System.out.println(answer-1);
    }
    static void dfs(node nd,int a) {
        if (nd == null) return;
        if (nd.occupied) Array.get(a).add(nd.level);
        for (int i = 0; i < nd.sons.size(); i++) {
            dfs(nd.sons.get(i),a);
        }
    }
    static ArrayList<ArrayList<Integer>> Array = new ArrayList<>();
    static class node{
        int level;
        int name;
        node boss;
        boolean occupied = false;
        ArrayList<node> sons = new ArrayList<>();
        ArrayList<node> relation = new ArrayList<>();
        boolean stacked = false;
        node(int name){
            this.name = name;
        }
    }

    static class MergeSort {
        private static int[] assist;
        public static void sort(int[] a){
            assist = new int[a.length];
            int lo = 0;
            int hi = a.length - 1;
            sort(a,lo,hi);
        }
        private static void sort(int[] a, int lo, int hi){
            if (hi<=lo) return;
            int mid = (lo + hi) >> 1;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }
        private static void merge (int[] a,int lo,int mi,int hi){
            int i = lo;
            int j = mi + 1;
            int k = 0;
            while (i <=mi && j<= hi){
                if (a[i] < a[j]){
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
    static QReader in = new QReader();
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
}

