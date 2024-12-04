import java.util.Scanner;
public class l5q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int i = 0;
        int j = Math.min(str1.length(),str2.length());
        while (i<j) {
            int mid = (i+j+1)>>1;
           // System.out.println("check "+mid+check(mid,str1,str2));
            if (check(mid,str1,str2)){
                i = mid;
            }else j = mid - 1;
        }
        System.out.println(i);
    }
    public static boolean check(int n,String a,String b){
        if (n == 0) return true;
        if (n > a.length() | n > b.length()) return false;
        long[] hash = new long[a.length() - n + 1];
        for (int i = 0; i < n; i++) {
            hash[0] += (long)a.charAt(n-i-1)*power(i);
        }
        long pow = power(n-1);
        for (int i = 1; i < hash.length; i++) {
            hash[i] = (hash[i-1] - (long)a.charAt(i-1) * pow) * 139 + a.charAt(i+n-1);
        }
        MergeSort.sort(hash);
        long swaphash = 0;
        for (int i = 0; i < n; i++) {
            swaphash += (long)b.charAt(n-i-1)*power(i);
        }
        if (find(swaphash,hash)) return true;
        for (int i = 1; i < b.length()-n+1; i++) {
            swaphash = (swaphash - (long)b.charAt(i-1) * pow) * 139 + b.charAt(i+n-1);
            if (find(swaphash,hash)) return true;
        }
        return false;
    }
    public static long power(int n){
        long temp = 1;
        for (int i = 0; i < n; i++) {
            temp = temp * 139;
        }
        return temp;
    }
    public static boolean find (long a,long[] hash){
        int i = 0;
        int j = hash.length-1;
        while (i<j){
            int mid = (i+j)>>1;
            if (hash[mid] == a){
                 i = mid;break;
            }else if (hash[mid] > a){
                j = mid - 1;
            }else i = mid + 1;
        }
        return a==hash[i];
    }
    static class MergeSort {
        private static long[] assist;
        public static void sort(long[] a){
            assist = new long[a.length];
            int lo = 0;
            int hi = a.length - 1;
            sort(a,lo,hi);
        }
        private static void sort(long[] a, int lo, int hi){
            if (hi<=lo) return;
            int mid = (lo + hi) >> 1;
            sort(a,lo,mid);
            sort(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }
        private static void merge (long[] a,int lo,int mi,int hi){
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
}
