import java.util.Arrays;
import java.util.Scanner;

public class l3q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ts = sc.nextInt();
        for (int wwwww = 0; wwwww < ts; wwwww++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            boolean[] e = new boolean[n];
            int count = 0;
            int index = -1;
            for (int i = 0; i < e.length; i++) {
                e[i] = true;
            }
            while (count != n) {
                int tempk = 0;
                while (tempk < k) {
                 // System.out.println(count+","+index);
                    if (index <= n - 2) {
                        index++;
                    } else {
                        index = 0;
                    }
                    if (e[index]) {
                        tempk++;
                    }
                }
                count++;
                e[index] = false;

                System.out.print((index +1)+ " ");
            }
            System.out.println();
        }
    }
}
