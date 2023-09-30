package mylib;
// import mylib.Matriks;

public class AljabarLinear {
    public double cofactor(Matriks M, int r, int k){
        Matriks MKof = new Matriks(M.nRows-1, M.nCols-1);
        int i,j,ikof=0, jkof;
        for(i=0;i<M.nRows;i++){
            jkof=0;
            for(j=0;j<M.nCols;j++){
                if(i!=r && j!=k){
                    MKof.Matriks[ikof][jkof] = M.Matriks[i][j];
                    jkof++;
                }
            }
            if(i!=r){ ikof++; }
        }
        if((k+r)%2==1){
            return (-1*determinantByCofactor(MKof));
        } else {
            return determinantByCofactor(MKof);
        }
    }

    public double determinantByCofactor(Matriks M){
        if(M.countElmt()==1){
            return M.Matriks[0][0];
        } else {
            float det = 0;
            int i;
            for(i=0;i<M.nCols;i++){
                det += M.Matriks[0][i] * cofactor(M,0,i);
            }
            return det;
        }
    }

    public static void Gauss(Matriks m){
        int r = 0; int c = 0;
        while (!gauss && c < m.nCols){
            if (m.Matriks[r][c] != 1){
                double x = m.Matriks[r][c];
                convertOne(x, r, m); 
            } else {
                continue;
            }
            for(int i = r + 1; r < m.nRows; r++){
                double x = m.Matriks[r][c];
                int rx = findFirstOne(m, c);
                convertZero(x, rx, i);
            }
<<<<<<< Updated upstream
            r = findFirstOne(m, c);
            c++; r++;
        }
    }
}
=======
            if (g.allZeroUnder(m, r, c)){
                c++;
            }
            if (r < m.nRows && c < m.nCols){
                if (m.Matriks[r][c] != 0){
                    double x = m.Matriks[r][c];
                    g.convertOne(x, r, c, m);
                }
            }
            int b = r + 1;
            if (b < m.nRows && c < m.nCols){
                if (b == m.nRows - 1){
                    if (g.allRowZero(m, r)){
                        break;
                    }
                } else if (m.Matriks[b][c] == 0){
                    if (g.allRowZero(m, r)){
                        c++;
                    } else if (g.allZeroUnder(m, b, c)){
                        c++;
                    } else {
                        b++;
                    }
                }
                if (c == m.nCols - 1){
                    c = m.nCols - 1;
                    r = m.nRows;
                } else {
                    if (g.allRowZero(m, b)){
                        c = g.firstNoZeroRow(m, b-1);
                    } else {
                        c = g.firstNoZeroRow(m, b);
                    }
                }
                int r1 = g.leadingOne(m, c);
                if (r1 != -1){
                    if (!g.indented(m, b, c)){
                        while (b < m.nRows){
                            if (m.Matriks[b][c] == 0){
                                b++;
                            } else {
                                double x = m.Matriks[b][c];
                                g.convertZero(x, r1, b, m);
                                b++;
                            }
                        }
                    }
                } else {
                    if (r < m.nRows && c < m.nCols){
                        if (m.Matriks[r][c] != 0){
                            double x = m.Matriks[r][c];
                            g.convertOne(x, r, c, m);
                        }
                    }
                }
            }
            if (c < m.nCols){
                r = g.leadingOne(m, c) + 1;
                c++;
            } else {
                r = m.nRows;
                c = m.nCols;
            }
        }
    }

    public void toGaussJordan(Matriks m){
        AljabarLinear spl = new AljabarLinear();
        Gauss g = new Gauss();
        spl.toGauss(m);

        int c = 0; int r = 0; int r1 = 0;
        if (g.allColZero(m, c)){
                c++;
            }
        if (g.leadingOne(m,c) == -1){
            c++;
        } 

        while (c < m.nCols-1 && r < m.nRows){
            c = g.firstNoZeroRow(m, r);
            r1 = g.leadingOne(m, c);
                for (int b = r1 - 1; b >= 0; b--){
                    double x = m.Matriks[b][c];
                    g.convertZero(x, r1, b, m);
                }
            c++; r++;
        }
    }
    public boolean inversible(Matriks m){
        boolean yes = true;
        double det = determinantByCofactor(m);
        if (det == 0){
            System.out.println("Tidak memilikin matriks balikan!\n");
            yes = false;
        } else {
            yes = true;
        }
        return yes;
    }

    public Matriks inversByGaussJordan(Matriks m){
        int rows1 = m.getLastIdxRow() + 1;
        int cols1 = m.getLastIdxCol() + 1;
        Matriks balikan = new Matriks(rows1, cols1);

        if (m.isMatrixSquare() && inversible(m)){
            Matriks proses = new Matriks(rows1, cols1*2);
            for(int b = 0; b < rows1; b++){
                for(int k = 0; k < cols1; k++){
                    proses.Matriks[b][k] = m.Matriks[b][k];
                }
            }
            for(int b = 0; b < rows1; b++){
                for(int k = cols1; k < cols1*2; k++){
                    if (k - b == rows1){
                        proses.Matriks[b][k] = 1;
                    } else {
                        proses.Matriks[b][k] = 0;
                    }
                }
            }
            toGaussJordan(proses);

            
            for(int b = 0; b < rows1; b++){
                for(int k = 0; k < cols1; k++){
                    balikan.Matriks[b][k] = proses.Matriks[b][k + rows1];
                }
            }
        } else {
            System.out.println("Tidak memilikin matriks balikan!\n");
            balikan = m.copyMatriks();
        }
        return balikan;
    }

    public void solveByInverse(Matriks m){
        double[] x;
        String[] ans;
        
        x = new double[100001];
        ans = new String[100001];
        
        int rows = m.getLastIdxRow();
        int cols = m.getLastIdxCol() ;

        if ((rows != cols - 1)){
            System.out.println("Tidak bisa dipecahkan dengan metode matriks balikan!\n");
        } else {
            Matriks A = new Matriks(rows + 1, rows + 1);
            Matriks B = new Matriks(rows + 1, 1);
            for(int b = 0; b < m.nRows; b++){
                for(int k = 0; k < cols; k++){
                    A.Matriks[b][k] = m.Matriks[b][k];
                }
            }
            for(int b = 0; b < m.nRows; b++){
                B.Matriks[b][0] = m.Matriks[b][cols];
            }
            if (!inversible(A)){
                System.out.println("Tidak bisa dipecahkan dengan metode matriks balikan!\n");
            } else {
                Matriks Ai;
                Ai = inversByGaussJordan(A);
                Ai.displayMatriks();
                Matriks hasil = new Matriks(rows + 1, 1);
                for(int b = 0; b < Ai.nRows; b++){
                    for(int k = 0; k < Ai.nCols; k++){
                        hasil.Matriks[b][0] = hasil.Matriks[b][0] + Ai.Matriks[b][k] * B.Matriks[k][0];
                    }
                }
                hasil.displayMatriks();
                for(int i = 0; i < hasil.nRows; i++){
                    x[i] = hasil.Matriks[i][0];
                }
                for(int i = 0; i < hasil.nRows; i++){
                    ans[i] = "X"+Integer.toString(i+1)+" = "+Double.toString(x[i])+"\n";
                    System.out.println(ans[i]);
                }
            }
        }
    }

    // public boolean singleSolution(){

    // }
}
>>>>>>> Stashed changes
