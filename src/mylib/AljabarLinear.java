package mylib;

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

    public void toGauss(Matriks m){
        int r = 0; int c = 0;
        Gauss g = new Gauss();
        if (m.Matriks[r][c] == 0){
            if (g.allZeroUnder(m, r, c)){
                c++;
            } else {
                int row = g.firstNoZeroCol(m, c);
                g.swapRow(m, r, row);
            }
        }
        if (g.allColZero(m, c)){
            c++;
        }
        while (c < m.nCols - 1 && r < m.nRows && !g.isEselonBaris(m)){
            if (g.allRowZero(m, r)){
                g.swapRow(m, r, m.nRows - 1);
            }
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
        System.out.println("Gauss:");
        m.displayMatriks();
        System.out.println("\n");

        int c = 0; int r = 0; int r1 = 0;
        if (g.allColZero(m, c)){
                c++;
            }
        if (g.leadingOne(m,c) == -1){
            c++;
        } 

        while (c < m.nCols-1){
            c = g.firstNoZeroRow(m, r);
            r1 = g.leadingOne(m, c);
                for (int b = r1 - 1; b >= 0; b--){
                    double x = m.Matriks[b][c];
                    g.convertZero(x, r1, b, m);
                }
            c++; r++;
        }
    }

    public Matriks inversByGaussJordan(Matriks m){
        double det = determinantByCofactor(m);
        int rows1 = m.getLastIdxRow() + 1;
        int cols1 = m.getLastIdxCol() + 1;
        Matriks balikan = new Matriks(rows1, cols1);

        if (det != 0 && m.isMatrixSquare()){
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
            System.out.println("Tidak bisa dipecahkan dengan metode matriks balikan!\n");
            balikan = m.copyMatriks();
        }
        return balikan;
    }
}