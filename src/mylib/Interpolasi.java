package mylib;

public class Interpolasi {
    public void solveByInterpolasi(double[] x, double[] y, double I, int nt){
        SPL spl = new SPL();
    
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

        Matriks mj = spl.solveByGaussResult(m);

        System.out.println("Persamaan polinom interpolasi berdasarkan data tersebut adalah sebagai berikut:");
        System.out.print("f(X) = ");

        int i, a = 0;
        for (i = mj.getLastIdxCol(); i >= 0; i--) {
            if (i == mj.getLastIdxCol()) {
                System.out.print(String.format("%.3f", mj.Matriks[0][i]));
            } else {
                if (mj.Matriks[0][i] >= 0) {
                    System.out.print(" + " + String.format("%.3f", mj.Matriks[0][i]) + " X^" + a);
                } else {
                    System.out.print(" - " + String.format("%.3f", (mj.Matriks[0][i]*(-1))) + " X^" + a);
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
        System.out.printf("Hasil: " + String.format("%.3f", hasil));
    }
}
