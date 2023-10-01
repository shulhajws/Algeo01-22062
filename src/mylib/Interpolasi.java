package mylib;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Interpolasi {
    public static void solveByInterpolasi(){
        Scanner in = new Scanner(System.in);
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("Pilih format masukan:\n1. Keyboard\n2. File");
        int masukan = in.nextInt();
        while(masukan != 1 && masukan != 2){
            System.out.printf("Mohon ulangi masukan! Format masukan:\n1. Keyboard\n2. File");
            masukan = in.nextInt();
        }

        if (masukan == 1){
            System.out.printf("Jumlah titik yang akan dimasukkan: ");
            int nt = in.nextInt();
            for (int i = 0; i < nt; i++){
                System.out.printf("Titik " + (i+1) + ": ");
                
            }
            
        }
        in.close();
    }
    

}
