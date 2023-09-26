package mylib;

public class Invers {
    public Matriks matriksKofaktor(Matriks M){
        AljabarLinear AL = new AljabarLinear();
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
}
