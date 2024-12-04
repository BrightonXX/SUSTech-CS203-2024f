import java.util.Scanner;
public class l5q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testc=sc.nextInt();
        for (int i = 0; i < testc; i++) {
            int temp = sc.next().length();
            System.out.println(temp*(temp+1)/2);
        }
    }
}
