package mylib;

public class Invers {

    Operations o = new Operations();
    SPL spl = new SPL();
    Determinant d = new Determinant();

    public Matriks matriksKofaktor(Matriks M){
        Determinant AL = new Determinant();
        Matriks MKof = new Matriks(M.nRows, M.nCols);
        int i,j;
        for(i=0;i<M.nRows;i++){
            for(j=0;j<M.nCols;j++){
                MKof.Matriks[i][j] = AL.cofactorAt(M,i,j);
            }
        }
        return MKof;
    }

    public Matriks matriksAdjoin(Matriks M){
        return matriksKofaktor(M).transpose();
    }

    public Matriks inversMatriks(Matriks M){
        Invers I = new Invers();
        double det = d.determinantByCofactor(M);
        if(det==0){
            System.out.println("Matriks tidak memiliki invers");
            return null;
        } else {
            return I.matriksAdjoin(M).multiplyByConst(1/det);
        }
    }

    public Matriks inversByGaussJordan(Matriks m){
        int rows1 = m.getLastIdxRow() + 1;
        int cols1 = m.getLastIdxCol() + 1;
        Matriks balikan = new Matriks(rows1, cols1);

        if (m.isMatrixSquare() && o.inversible(m)){
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
            spl.toGaussJordan(proses);

            
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
}
