import java.util.Arrays;
import java.util.Scanner;

public class qu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tes=sc.nextInt();
        for (int i = 0; i < tes; i++) {
            int lon = sc.nextInt();
            int[] sccc = new int[lon];
            for (int j = 0; j < lon; j++) {
                sccc[j] = sc.nextInt();
            }
            for (int j = 0; j < lon; j++) {
                for (int k = 0; k < lon; k++) {
                    if (sccc[j] > sccc[k]) {
                        int temp = sccc[j];
                        sccc[j] = sccc[k];
                        sccc[k] = temp;
                    }
                }
            }
            if (lon == 3) {
                if (sccc[2] != sccc[1]) {
                    System.out.println(sccc[2]);
                } else System.out.println("wa");
            } else {
                if (sccc[2] != sccc[1] && sccc[2] != sccc[3]) {
                    System.out.println(sccc[2]);
                } else System.out.println("wa");
            }
        }
    }
}
