package LAB0;

import java.util.Scanner;

public class qu3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int times= sc.nextInt();
        for (int i = 0; i < times; i++) {
            //
            int[] majangStore=new int[9+9+9+7];
            for (int i1 = 0; i1 < majangStore.length; i1++) {
                majangStore[0]=0;
            }
            for (int j = 0; j < 13; j++) {
                String temp= sc.next();
                switch (temp){
                    case "W1": majangStore[0]+=1;break;
                    case "W2": majangStore[1]+=1;break;
                    case "W3": majangStore[2]+=1;break;
                    case "W4": majangStore[3]+=1;break;
                    case "W5": majangStore[4]+=1;break;
                    case "W6": majangStore[5]+=1;break;
                    case "W7": majangStore[6]+=1;break;
                    case "W8": majangStore[7]+=1;break;
                    case "W9": majangStore[8]+=1;break;

                    case "T1": majangStore[9]+=1;break;
                    case "T2": majangStore[10]+=1;break;
                    case "T3": majangStore[11]+=1;break;
                    case "T4": majangStore[12]+=1;break;
                    case "T5": majangStore[13]+=1;break;
                    case "T6": majangStore[14]+=1;break;
                    case "T7": majangStore[15]+=1;break;
                    case "T8": majangStore[16]+=1;break;
                    case "T9": majangStore[17]+=1;break;

                    case "Y1": majangStore[18]+=1;break;
                    case "Y2": majangStore[19]+=1;break;
                    case "Y3": majangStore[20]+=1;break;
                    case "Y4": majangStore[21]+=1;break;
                    case "Y5": majangStore[22]+=1;break;
                    case "Y6": majangStore[23]+=1;break;
                    case "Y7": majangStore[24]+=1;break;
                    case "Y8": majangStore[25]+=1;break;
                    case "Y9": majangStore[26]+=1;break;

                    case "E": majangStore[27]+=1;break;
                    case "S": majangStore[28]+=1;break;
                    case "W": majangStore[29]+=1;break;
                    case "N": majangStore[30]+=1;break;
                    case "B": majangStore[31]+=1;break;
                    case "F": majangStore[32]+=1;break;
                    case "Z": majangStore[33]+=1;break;
                }
            }
            for (int j = 0; j < majangStore.length; j++) {
                if (majangStore[j]!=0){
                    for (int k = 0; k < majangStore[j]; k++) {
                        switch (j){
                            case 0:
                                System.out.print("W1 ");break;
                            case 1:
                                System.out.print("W2 ");break;
                            case 2:
                                System.out.print("W3 ");break;
                            case 3:
                                System.out.print("W4 ");break;
                            case 4:
                                System.out.print("W5 ");break;
                            case 5:
                                System.out.print("W6 ");break;
                            case 6:
                                System.out.print("W7 ");break;
                            case 7:
                                System.out.print("W8 ");break;
                            case 8:
                                System.out.print("W9 ");break;

                            case 9:
                                System.out.print("T1 ");break;
                            case 10:
                                System.out.print("T2 ");break;
                            case 11:
                                System.out.print("T3 ");break;
                            case 12:
                                System.out.print("T4 ");break;
                            case 13:
                                System.out.print("T5 ");break;
                            case 14:
                                System.out.print("T6 ");break;
                            case 15:
                                System.out.print("T7 ");break;
                            case 16:
                                System.out.print("T8 ");break;
                            case 17:
                                System.out.print("T9 ");break;

                            case 18:
                                System.out.print("Y1 ");break;
                            case 19:
                                System.out.print("Y2 ");break;
                            case 20:
                                System.out.print("Y3 ");break;
                            case 21:
                                System.out.print("Y4 ");break;
                            case 22:
                                System.out.print("Y5 ");break;
                            case 23:
                                System.out.print("Y6 ");break;
                            case 24:
                                System.out.print("Y7 ");break;
                            case 25:
                                System.out.print("Y8 ");break;
                            case 26:
                                System.out.print("Y9 ");break;

                            case 27:
                                System.out.print("E ");break;
                            case 28:
                                System.out.print("S ");break;
                            case 29:
                                System.out.print("W ");break;
                            case 30:
                                System.out.print("N ");break;
                            case 31:
                                System.out.print("B ");break;
                            case 32:
                                System.out.print("F ");break;
                            case 33:
                                System.out.print("Z ");break;
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
