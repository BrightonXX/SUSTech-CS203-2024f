import java.util.Scanner;

public class l4q2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String de= sc.next();
        long res=0;
        int leftl=0;
        for (int i = 0; i < de.length(); i++) {
            if (de.charAt(i)=='('){
                leftl++;
            }else if (de.charAt(i)==')'){
                leftl--;
                if (de.charAt(i-1)=='('){
                    long power=1;
                    for (int j = 0; j < leftl; j++) {
                        power=(power*2)%514329;
                    }
                    res+=power%514329;
                    res=res%514329;
                }
            }
        }
        System.out.println(res%514329);
    }
}
