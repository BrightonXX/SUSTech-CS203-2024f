package LAB0;

import java.util.Scanner;

public class qu5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeattimes = sc.nextInt();

        for (int i = 0; i < repeattimes; i++) {

            int length=sc.nextInt();
            int width=sc.nextInt();
            int height=sc.nextInt();


            int outPutLines=width*2+height*2+1;
            int outPutlength=length*2+width*2+1;

            char[][] output=new char[outPutLines][outPutlength];

            for (int j = 0; j < outPutLines; j++) {
                for (int k = 0; k < outPutlength; k++) {
                    output[j][k]='.';
                }
            }
            //top face
            for (int j = 0; j < width+1; j++) {
                for (int k = 0; k < 1; k++) {
                    output[j][k]='.';
                }
            }

            for (int j = 0; j < width+1; j++) {
                for (int k = 0; k < length+1; k++) {
                    output[j*2][width*2-2*j+2*k]='+';
                }
            }
            for (int j = 0; j < width+1; j++) {
                for (int k = 0; k < length; k++) {
                    output[j*2][width*2-2*j+2*k+1]='-';
                }
            }
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < length+1; k++) {
                    output[j*2+1][width*2-2*j+2*k-1]='/';
                }
            }
            for (int j = 0; j < height+1; j++) {
                for (int k = 0; k < length+1; k++) {
                    output[j*2+width*2][2*k]='+';
                }
            }
            for (int j = 0; j < height+1; j++) {
                for (int k = 0; k < length; k++) {
                    output[j*2+width*2][2*k+1]='-';
                }
            }
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < length+1; k++) {
                 output[j*2+width*2+1][2*k]='|';
                }
            }
            //side
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    output[1+2*k+2*j][outPutlength-2*j-1]='|';
                }
            }

            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height+1; k++) {
                    output[1+2*k+2*j-1][outPutlength-2*j-1]='+';
                }
            }
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height+1; k++) {
                    output[1+2*k+2*j][outPutlength-2*j-2]='/';
                }
            }
            //output
            for (int j = 0; j < outPutLines; j++) {
                for (int k = 0; k < outPutlength; k++) {
                    System.out.print(output[j][k]);
                }
                System.out.println();
            }
        }
    }
}
