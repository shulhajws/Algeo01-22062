package mylib;
// import mylib.Matriks;

public class AljabarLinear {
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

    public Matriks inversMatriks(Matriks M){
        Invers I = new Invers();
        double det = determinantByCofactor(M);
        if(det==0){
            System.out.println("Matriks tidak memiliki invers");
            return null;
        } else {
            return I.matriksAdjoin(M).multiplyByConst(1/det);
        }
    }

    // public static void Gauss(Matriks m){
    //     Gauss n = new Gauss();
    //     int r = 0; int c = 0;
    //     while (!n.isGauss() && c < m.nCols){
    //         if (m.Matriks[r][c] != 1){
    //             double x = m.Matriks[r][c];
    //             n.convertOne(x, r, m); 
    //         } else {
    //             continue;
    //         }
    //         for(int i = r + 1; r < m.nRows; r++){
    //             double x = m.Matriks[r][c];
    //             int rx = n.findFirstOne(m, c);
    //             n.convertZero(x, rx, i, m);
    //         }
    //         r = n.findFirstOne(m, c);
    //         c++; r++;
    //     }
    // }
}  
    // public void Gauss(Matriks m){
    //     Gauss n = new Gauss();
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

