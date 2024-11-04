package LAB0;
import java.util.Scanner;

public class qu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nsize= sc.nextInt();
        int[] aArray=new int[nsize];
        for (int i = 0; i < nsize; i++){
            aArray[i]=sc.nextInt();
        }
        int bsize=sc.nextInt();
        for (int i = 0; i < bsize; i++){
           int temp= sc.nextInt();
           boolean index=false;
           for (int i1 = 0; i1 < nsize; i1++){
                if (aArray[i1]==temp){
                    index=true;
                    break;
                }
            }
           if (index) {
               System.out.println("yes");
           } else System.out.println("no");
        }
    }
}
