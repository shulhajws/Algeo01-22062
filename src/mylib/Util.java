package mylib;

public class Util {
    /* Prosedur untuk  */
    // public Matriks createMatriks(){
    //     Scanner inMat = new Scanner(System.in);
    //     System.out.print("Masukkan jumlah baris matriks: ");
    //     int nRows = inMat.nextInt();
    //     System.out.print("Masukkan jumlah kolom matriks: ");
    //     int nCols = inMat.nextInt();
    //     Matriks M = new Matriks(nRows,nCols);
    //     inMat.close();
    //     return M;
    // }
    public void welcome(){
        System.out.println("---------------------KALKULATOR MATRIKS-------------------");
    }
    public void bye(){
        System.out.println("---------------------TERIMA KASIH-------------------");
    }
    public void displayMenu(){
        System.out.println("Selamat datang di program pemanfaatan operasi matriks!");
        System.out.println("---------------------MENU-------------------");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Invers");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Interpolasi Bicubic Spline");
        System.out.println("6. Regresi Linear Berganda");
        System.out.println("7. Perbesaran Citra");
        System.out.println("8. Keluar");
    }

    public void displayMenuSPL(){
        System.out.println("---------------------MENU SPL-------------------");
        System.out.println("1. Metode Eliminasi Gauss");
        System.out.println("2. Metode Eliminasi Gauss-Jordan");
        System.out.println("3. Metode Matriks Balikan");
        System.out.println("4. Kaidah Cramer");
    }

    public void displayMenuDet(){
        System.out.println("---------------------MENU DETERMINAN-------------------");
        System.out.println("1. Metode Reduksi Baris");
        System.out.println("2. Metode Ekspansi Kofaktor");
    }

    public void displayMenuInvers(){
        System.out.println("---------------------MENU INVERS-------------------");
        System.out.println("1. Metode Matriks Balikan");
        System.out.println("2. Metode Adjoin");
    }

    public Matriks matriksHilbert(int n){
        Matriks h = new Matriks(n, n + 1);
        for (int b = 0 ; b < n ; b++){
            for (int k = 0 ; k < n ; k++){
                h.Matriks[b][k] = 1/ (b + k + 1);
            }
        }
        for (int b = 0 ; b < n ; b++){
            if (b == 0){
                h.Matriks[b][n] = 1;
            } else {
                h.Matriks[b][n] = 0;
            }
        }
        return h;
    }

    public void displayOurLove() {
        final int size = 8;  
        final String msg = " We love You ";  
          
        // nested for loop to print the upper part of Heart  
        for (int m = 0; m < size; m++) {  
            for (int n = 0; n <= 4 * size; n++) {  
                double pos1 = Math.sqrt(Math.pow(m - size, 2) + Math.pow(n - size, 2));  
                double pos2 = Math.sqrt(Math.pow(m - size, 2) + Math.pow(n - 3 * size, 2));  
   
                if (pos1 < size + 0.5 || pos2 < size + 0.5) {  
                    System.out.print('*');  
                } else {  
                    System.out.print(' ');  
                }  
            }  
            System.out.print(System.lineSeparator());  
        }  
          
        // for loop to print the lower part of Heart  
        for (int m = 1; m <= 2 * size; m++) {  
            for (int n = 0; n < m; n++) {  
                System.out.print(' ');  
            }  
   
            for (int n = 0; n < 4 * size + 1 - 2 * m; n++) {  
                if (m >= 2 && m <= 4) {  
                    int position = n - (4 * size - 2 * m - msg.length()) / 2;  
                    if (position < msg.length() && position >= 0) {  
                        if (m == 3) {  
                            System.out.print(msg.charAt(position));  
                        } else {  
                            System.out.print(' ');  
                        }  
                    }  
                    else {  
                        System.out.print('*');  
                    }  
                }  
                else {  
                    System.out.print('*');  
                }  
            }  
            System.out.print(System.lineSeparator());  
        }  
    }

}
