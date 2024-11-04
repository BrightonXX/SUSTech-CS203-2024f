import java.util.Scanner;

public class qu4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        boolean win=false;

        if (n==0){
            System.out.println(1%m);
        }else if (n==1) {
            System.out.println(1%m);
        }else if (n==2){
            System.out.println(2%m);
        }else if (n==3){
            long result=1;
            for (int i = 1; i <= 720; i++) {
                result = (result*i)%m;
            }
            System.out.println(result);
        }else System.out.println(0);

    }
}
