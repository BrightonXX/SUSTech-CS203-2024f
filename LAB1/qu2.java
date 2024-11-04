package LAB1;

import java.util.Scanner;

public class qu2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int times=sc.nextInt();
        for (int i = 0; i < times; i++) {
            long temp=sc.nextLong();
            long temp2=((temp*(temp+1))/2)%1000000007;
            temp2 =temp2*temp2%1000000007;
            System.out.println(temp2);
        }
    }
}
