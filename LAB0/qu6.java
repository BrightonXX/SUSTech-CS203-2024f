package LAB0;

import java.util.Arrays;
import java.util.Scanner;

public class qu6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int times= sc.nextInt();
        for (int i = 0; i < times; i++) {
            //
            int[] majangStore=new int[9+9+9+7];
            for (int i1 = 0; i1 < majangStore.length; i1++) {
                majangStore[0]=0;
            }
            String thisGame= sc.next();
            String[] parts=new String[14];
            for (int split = 0; split < 28; split += 2) {
                parts[split / 2] = thisGame.substring(split, split + 2);
            }
            for (int j = 0; j < 14; j++) {
                switch (parts[j]){
                    case "1w": majangStore[0]+=1;break;
                    case "2w": majangStore[1]+=1;break;
                    case "3w": majangStore[2]+=1;break;
                    case "4w": majangStore[3]+=1;break;
                    case "5w": majangStore[4]+=1;break;
                    case "6w": majangStore[5]+=1;break;
                    case "7w": majangStore[6]+=1;break;
                    case "8w": majangStore[7]+=1;break;
                    case "9w": majangStore[8]+=1;break;

                    case "1b": majangStore[9]+=1;break;
                    case "2b": majangStore[10]+=1;break;
                    case "3b": majangStore[11]+=1;break;
                    case "4b": majangStore[12]+=1;break;
                    case "5b": majangStore[13]+=1;break;
                    case "6b": majangStore[14]+=1;break;
                    case "7b": majangStore[15]+=1;break;
                    case "8b": majangStore[16]+=1;break;
                    case "9b": majangStore[17]+=1;break;

                    case "1s": majangStore[18]+=1;break;
                    case "2s": majangStore[19]+=1;break;
                    case "3s": majangStore[20]+=1;break;
                    case "4s": majangStore[21]+=1;break;
                    case "5s": majangStore[22]+=1;break;
                    case "6s": majangStore[23]+=1;break;
                    case "7s": majangStore[24]+=1;break;
                    case "8s": majangStore[25]+=1;break;
                    case "9s": majangStore[26]+=1;break;

                    case "1z": majangStore[27]+=1;break;
                    case "2z": majangStore[28]+=1;break;
                    case "3z": majangStore[29]+=1;break;
                    case "4z": majangStore[30]+=1;break;
                    case "5z": majangStore[31]+=1;break;
                    case "6z": majangStore[32]+=1;break;
                    case "7z": majangStore[33]+=1;break;
                } 
            }
            System.out.println(Arrays.toString(majangStore));
            boolean win = false;
            for (int j = 0; j < 34; j++) {
                int[] shit=new int[34];
                System.arraycopy(majangStore, 0, shit, 0, 34);
                if (shit[j]>=2){
                    shit[j]-=2;
                }else {
                    continue;
                }
                if ((shit[0]+shit[1]+shit[2]+shit[3]+shit[4]+shit[5]+shit[6]+shit[7]+shit[8])%3!=0| (shit[9]+shit[10]+shit[11]+shit[12]+shit[13]+shit[14]+shit[15]+shit[16]+shit[17])%3!=0|(shit[18]+shit[19]+shit[20]+shit[21]+shit[22]+shit[23]+shit[24]+shit[25]+shit[26])%3!=0|(shit[27]+shit[28]+shit[29]+shit[30]+shit[31]+shit[32]+shit[33])%3!=0){
                    continue;
                }
                int maxAppear=0;
                int[] tempa=new int[9];
                System.arraycopy(shit, 0, tempa, 0, 9);
                if ( find(tempa) ){
                    maxAppear++;
                }
                System.arraycopy(shit, 9, tempa, 0, 9);
                if ( find(tempa) ){
                    maxAppear++;
                }
                System.arraycopy(shit, 18, tempa, 0, 9);
                if ( find(tempa) ){
                    maxAppear++;
                }
                System.arraycopy(shit, 27, tempa, 0, 7);
                boolean okey=true;
                for (int k = 0; k < 7; k++) {
                    if (tempa[k]%3!=0)okey=false;
                }
              if (okey) maxAppear++;
              if (maxAppear==4) win=true;
            }
            if (win) {
                System.out.print("1");
            }else {
                System.out.print("0");
            }
        }
    }

    public static boolean find(int[] shit){
        boolean winwin=false;
        if (shit[0]+shit[1]+shit[2]+shit[3]+shit[4]+shit[5]+shit[6]+shit[7]+shit[8]==0) {
            return true;
        }
        for (int k = 0; k < 7; k++) {
            if (shit[k] >= 1 & shit[k + 1] >= 1 & shit[k + 2] >= 1) {
                int[] tempa=new int[9];
                System.arraycopy(shit, 0, tempa, 0, 9);
                tempa[k] -= 1;
                tempa[k + 1] -= 1;
                tempa[k + 2] -= 1;
                if (find(tempa)) winwin=true;
            }
        }
        for (int kk = 0; kk < 9; kk++) {
            if (shit[kk]>=3){
                int[] tempa=new int[9];
                System.arraycopy(shit, 0, tempa, 0, 9);
                tempa[kk] -= 3;
                if (find(tempa)) winwin=true;
            }
        }
        if (shit[0]+shit[1]+shit[2]+shit[3]+shit[4]+shit[5]+shit[6]+shit[7]+shit[8]==0) {
            return true;
        }
        return winwin;
    }
}
