import java.util.Scanner;

public class l5q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        int[] next = new int[st.length()];
        next[0] = 0;
        int lef = 0;
        int rig = 1;
        while (rig < st.length()){
            if (st.charAt(lef) == st.charAt(rig)){
                next[rig] = lef + 1;
                rig++;lef++;
            } else if (lef != 0){
                lef = next[lef - 1];
            } else {
                next[rig] = 0;
                rig++;
            }
        }
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
    }
}
