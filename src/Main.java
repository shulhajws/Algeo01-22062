import mylib.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean programOn = true;
        int choice;
        Scanner in = new Scanner(System.in);
        while(programOn){
            Util u = new Util();
            u.displayMenu();
            System.out.print("Operasi apa yang ingin kamu lakukan? (Masukkan pilihan menu dalam angka): ");
            choice = in.nextInt();

            switch(choice){
                case 1: //SPL
                    u.displayMenuSPL();
                    System.out.print("Operasi apa yang ingin kamu lakukan? (Masukkan pilihan menu dalam angka): ");
                    int choiceSPL = in.nextInt();
                    switch(choiceSPL){
                        case 1:
                            System.out.println("Program ini masih dalam tahap pengembangan");
                            break;
                        case 2:
                            System.out.println("Program ini masih dalam tahap pengembangan");
                            break;
                        case 3:
                            System.out.println("Program ini masih dalam tahap pengembangan");
                            break;
                        case 4: //Kaidah Cramer
                            System.out.println("Perlu diingat bahsa kaidah Cramer khusus untuk SPL dengan n peubah dan n persamaan");
                            System.out.println("Masukkan SPL dalam bentuk matriks augmented");
                            System.out.print("Masukkan jumlah baris matriks augmented: ");
                            int nRows = in.nextInt();
                            System.out.print("Masukkan jumlah kolom matriks augmented: ");
                            int nCols = in.nextInt();
                            Matriks M = new Matriks(nRows,nCols);

                            if(M.nCols!=M.nRows+1){
                                System.out.println("Tidak dapat diselesaikan dengan Kaidah Cramer");
                            } else{
                                System.out.println("Masukkan nilai untuk matriks augmented: ");
                                M.readMatriks(M.nRows,M.nCols);
                                System.out.println("SPL anda dalam bentuk matriks: ");
                                M.displayMatriks();
                                M.splCramer();
                            }
                            break;
                    }
                    break;
                case 2: //Determinan
                    // System.out.print("Masukkan jumlah baris matriks: ");
                    // int nRows = in2.nextInt();
                    // System.out.print("Masukkan jumlah kolom matriks: ");
                    // int nCols = in2.nextInt();
                    // Matriks M = new Matriks(nRows,nCols);
                    // System.out.println("Masukkan nilai matriks: ");
                    // M.readMatriks(nRows,nCols);
                    // ----------------------
                    u.displayMenuDet();
                    System.out.print("Operasi apa yang ingin kamu lakukan? (Masukkan pilihan menu dalam angka): ");
                    int choiceDet = in.nextInt();
                    switch(choiceDet){
                        case 1: //Reduksi Baris
                            System.out.println("Program ini masih dalam tahap pengembangan");
                            break;
                        case 2: //Ekspansi Kofaktor
                            System.out.print("Masukkan jumlah baris matriks: ");
                            int nRows2 = in.nextInt();
                            System.out.print("Masukkan jumlah kolom matriks: ");
                            int nCols2 = in.nextInt();
                            Matriks M2 = new Matriks(nRows2,nCols2);
                            System.out.println("Masukkan nilai matriks: ");
                            M2.readMatriks(nRows2,nCols2);
                            // ----------------------
                            System.out.println("Determinan matriks anda adalah: ");
                            System.out.println(M2.determinantCofactor());
                            break;
                    }
                    break;
                case 3: //Invers
                    // System.out.print("Masukkan jumlah baris matriks: ");
                    // int nRows3 = in.nextInt();
                    // System.out.print("Masukkan jumlah kolom matriks: ");
                    // int nCols3 = in.nextInt();
                    // Matriks M3 = new Matriks(nRows3,nCols3);
                    // System.out.println("Masukkan nilai matriks: ");
                    // M3.readMatriks(nRows3,nCols3);
                    // ----------------------
                    u.displayMenuInvers();
                    System.out.print("Operasi apa yang ingin kamu lakukan? (Masukkan pilihan menu dalam angka): ");
                    int choiceInvers = in.nextInt();
                    switch(choiceInvers){
                        case 1: //Matriks Balikan
                            break;
                        case 2: //Adjoin
                            System.out.print("Masukkan jumlah baris matriks: ");
                            int nRows3 = in.nextInt();
                            System.out.print("Masukkan jumlah kolom matriks: ");
                            int nCols3 = in.nextInt();
                            Matriks M3 = new Matriks(nRows3,nCols3);
                            System.out.println("Masukkan nilai matriks: ");
                            M3.readMatriks(nRows3,nCols3);
                            M3.inversAdjoin().displayMatriks();
                            break;
                    }
                    break;
                case 4: //Interpolasi Polinom
                    System.out.println("Program ini masih dalam tahap pengembangan");
                    break;
                case 5: //Interpolasi Bicubic Spline
                    System.out.println("Program ini masih dalam tahap pengembangan");
                    break;
                case 6: //Regresi Linear Berganda
                    System.out.println("Program ini masih dalam tahap pengembangan");
                    break;
                case 7: //Perbesaran Citra
                    System.out.println("Program ini masih dalam tahap pengembangan");
                    break;
                case 8:
                    programOn = false;
                    break;
            }
        }
        in.close();
    }
}
