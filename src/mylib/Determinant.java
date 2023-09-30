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
}
