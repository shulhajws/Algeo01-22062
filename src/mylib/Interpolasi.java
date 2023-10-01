package mylib;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Interpolasi {
    public static void solveByInterpolasi(){
        Scanner in = new Scanner(System.in);
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        SPL spl = new SPL();
        double[] x = new double[999999];
        double[] y = new double[999999];
        double I = 0;
        int nt = 0;

        System.out.printf("Pilih format masukan:\n1. Keyboard\n2. File");
        int masukan = in.nextInt();
        while(masukan != 1 && masukan != 2){
            System.out.printf("Mohon ulangi masukan! Format masukan:\n1. Keyboard\n2. File");
            masukan = in.nextInt();
        }

        if (masukan == 1){
            System.out.printf("Jumlah titik yang akan dimasukkan: ");
            nt = in.nextInt();
            for (int i = 0; i < nt; i++){
                System.out.printf("Titik " + (i+1) + ":\n");
                System.out.printf("--> x" + (i+1) + ": ");
                x[i] = in.nextDouble();
                System.out.printf("--> y" + (i+1) + ": ");
                y[i] = in.nextDouble();
            }
            System.out.printf("Value x yang akan ditaksir: ");
            I = in.nextDouble();
    
            Matriks m = new Matriks(nt, nt + 1);
            // Matriks mj = new Matriks(1, nt + 1);
            for(int b = 0; b < nt; b++){
                for(int k = 0; k < nt + 1; k++){
                    if (k < nt){
                        m.Matriks[b][k] = Math.pow(x[b], k);
                    } else {
                        m.Matriks[b][k] = y[b];
                    }
                }
            }

            Matriks mj = spl.solveByGaussRegresi(m);

            System.out.println("Persamaan polinom interpolasi berdasarkan data tersebut adalah sebagai berikut:");
            System.out.print("f(X) = ");

            int i, a = 0;
            for (i = mj.getLastIdxCol(); i >= 0; i--) {
                if (i == mj.getLastIdxCol()) {
                    System.out.print(mj.Matriks[0][i]);
                } else {
                    if (mj.Matriks[0][i] >= 0) {
                        System.out.print(" + " + mj.Matriks[0][i] + " X" + a);
                    } else {
                        System.out.print(" - " + (mj.Matriks[0][i]*(-1)) + " X" + a);
                    }
                }
                a++;
            }
            System.out.println();
    
            int length = mj.nCols; 
            int p = 0;
            double hasil = 0;
            for(i = length - 1; i >= 0; i--){
                hasil += mj.Matriks[0][i] * Math.pow(I, p);
                p += 1;
            }
            System.out.printf("Hasil: " + hasil);
        }
        in.close();
    }
}
