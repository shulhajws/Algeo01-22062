package mylib;


public class Determinant {
    public double cofactorAt(Matriks M, int r, int k){
        Matriks MKof = new Matriks(M.nRows-1, M.nCols-1);
        int i,j,ikof=0, jkof=0;
        for(i=0;i<M.nRows;i++){
            if(i!=r){
                jkof=0;
                for(j=0;j<M.nCols;j++){
                    if(j!=k){
                        MKof.Matriks[ikof][jkof] = M.Matriks[i][j];
                        jkof++;
                    }
                }
                ikof++;
            }
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
                det += M.Matriks[0][i] * cofactorAt(M,0,i);
            }
            return det;
        }
    }

    public double determinantByRowReduction (Matriks m) {
        Operations op = new Operations();

        if (!op.isProcessed(m)) {
            return 0;

        } else {
            if (op.isLowerTriangular(m) || op.isUpperTriangular(m)) {
                double determinant = 1; int i;

                for (i = 0; i <= m.getLastIdxRow(); i++) {
                    determinant *= m.Matriks[i][i];
                }

                return determinant;
            } else {
                int i, j, swapCount = 0;

                while (!op.noZeroInDiagonal(m)) {
                    for (j = 0; j <= m.getLastIdxCol(); j++) {
                        if (m.Matriks[j][j] == 0) {
                            i = j;

                            while (i <= m.getLastIdxRow() && m.Matriks[i][j] == 0) {
                                i++;
                            }

                            if (i > m.getLastIdxRow()) {
                                return 0;
                            }
                            
                            op.swapRow(m, j, i);
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
}
