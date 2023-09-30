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

    public double determinantByRowReduction (Matriks m) {
        Gauss n = new Gauss();

        if (!n.isProcessed(m)) {
            return 0;

        } else {
            if (n.isLowerTriangular(m) || n.isUpperTriangular(m)) {
                double determinant = 1; int i;

                for (i = 0; i <= m.getLastIdxRow(); i++) {
                    determinant *= m.Matriks[i][i];
                }

                return determinant;
            } else {
                int i, j, swapCount = 0;

                while (!n.noZeroInDiagonal(m)) {
                    for (j = 0; j <= m.getLastIdxCol(); j++) {
                        if (m.Matriks[j][j] == 0) {
                            i = j;

                            while (i <= m.getLastIdxRow() && m.Matriks[i][j] == 0) {
                                i++;
                            }

                            if (i > m.getLastIdxRow()) {
                                return 0;
                            }
                            
                            n.swapRow(m, j, i);
                            swapCount++;
                        }
                    }
                }
                int k; double reductor;

                for (j = 0; j <= m.getLastIdxCol(); j++) {
                    for (i = j+1; i <= m.getLastIdxRow(); i++) {
                        if (m.Matriks[i][j] != 0) {
                            reductor = m.Matriks[i][j]/m.Matriks[j][j];
                            for (k = 0; k <= m.getLastIdxCol(); k++) {
                                m.Matriks[i][k] -= m.Matriks[j][k]*reductor;
                            }
                        }
                    }
                }

                double determinant = 1;

                for (i = 0; i <= m.getLastIdxRow(); i++) {
                    determinant *= m.Matriks[i][i];
                }

                int powerOfSwap = 1;

                for (i = 0; i < swapCount; i++) {
                    powerOfSwap *= -1;
                }
                
                return determinant*powerOfSwap;
            }
        }
    }

    // public static void Gauss(Matriks m){
    //     int r = 0; int c = 0;
    //     while (!gauss && c < m.nCols){
    //         if (m.Matriks[r][c] != 1){
    //             double x = m.Matriks[r][c];
    //             convertOne(x, r, m); 
    //         } else {
    //             continue;
    //         }
    //         for(int i = r + 1; r < m.nRows; r++){
    //             double x = m.Matriks[r][c];
    //             int rx = findFirstOne(m, c);
    //             convertZero(x, rx, i);
    //         }
    //         r = findFirstOne(m, c);
    //         c++; r++;
    //     }
    // }


}
