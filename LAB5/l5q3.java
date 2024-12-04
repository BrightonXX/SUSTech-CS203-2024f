import java.io.*;
import java.util.Scanner;
public class l5q3 {
    static class QWriter implements Closeable {
        private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        public void print(Object object) {
            try {
                writer.write(object.toString());
            } catch (IOException e) {
                return;
            }
        }

        public void println(Object object) {
            try {
                writer.write(object.toString());
                writer.write("\n");
            } catch (IOException e) {
                return;
            }
        }

        @Override
        public void close() {
            try {
                writer.close();
            } catch (IOException e) {
                return;
            }
        }
    }
    public static void main(String[] args) {
        QWriter out = new QWriter();
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        int[][] transition= new int[st.length()][26];
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
        for (int i = 0; i < 26; i++) {
            if ((st.charAt(0)-19) % 26 == i){
                out.print(1+" ");
                transition[0][i]=1;
            }else {
                out.print(0+" ");
                transition[0][i]=0;
            }
        }
        for (int i = 1; i < st.length(); i++) {
            out.println("");
            for (int j = 0; j < 26; j++) {
                if ((st.charAt(i)-19) % 26 == j){
                    transition[i][j]=i+1;
                    out.print(i+1+" ");
                }else {
                    transition[i][j] = transition[next[i-1]][j];
                    out.print(transition[i][j]+" ");
                }
            }
        }
        out.close();
    }
}
