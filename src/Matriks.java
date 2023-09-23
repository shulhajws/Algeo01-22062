import java.util.Scanner;

public class Matriks {
    //Atribut
    int[][] Matriks = new int[1000][1000];
    int nRows;
    int nCols;

    //Methods
    //Konstruktor
    public Matriks(int nRows, int nCols){
        Matriks = new int[nRows][nCols];
        this.nRows = nRows;
        this.nCols = nCols;
    }

    //Baca Matriks
    public void readMatriks(int nRows, int nCols){
        Scanner in = new Scanner(System.in);

        int i,j;
        for(i=0;i<nRows;i++){
            for(j=0;j<nCols;j++){
                this.Matriks[i][j]=in.nextInt();
            }
        }
    }

    //Tulis Matriks
    public void displayMatriks(int nRows, int nCols){
        int i,j;
        for(i=0;i<nRows;i++){
            for(j=0;j<nCols;j++){
                System.out.print(this.Matriks[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isMatrixIdxValid(int i, int j){
        return (i>=0 && i<1000 && j>=0 && j<1000);
    } 

    public boolean isMatrixIdxEff(int i, int j){
        return (i>=0 && i<this.nRows && j>=0 && j<this.nCols);
    }

    public int getLastIdxRow(){
        return this.nRows-1;
    }

    public int getLastIdxCol(){
        return this.nCols-1;
    }

    public int getElmtDiagonal(int i){
        return this.Matriks[i][i];
    }

    public void copyMatriks(){
        Matriks MCopy = new Matriks(this.nRows, this.nCols);
        int i,j;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                MCopy.Matriks[i][j] = this.Matriks[i][j];
            }
        }
    }

    public Matriks addMatriks(Matriks M2){
        Matriks MCopy = new Matriks(this.nRows, this.nCols);
        int i,j;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                MCopy.Matriks[i][j] = MCopy.Matriks[i][j] + M2.Matriks[i][j];
            }
        }
        return MCopy;
    }

    public Matriks subMatriks(Matriks M2){
        Matriks MCopy = new Matriks(this.nRows, this.nCols);
        int i,j;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                MCopy.Matriks[i][j] = MCopy.Matriks[i][j] - M2.Matriks[i][j];
            }
        }
        return MCopy;
    }

    public Matriks multiplyMatriks(Matriks M2){
        Matriks MCopy = new Matriks(this.nRows, M2.nCols);
        int i,j,k;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<M2.nCols;j++){
                MCopy.Matriks[i][j] = 0;
                for(k=0;k<this.nCols;k++){
                    MCopy.Matriks[i][j] +=  this.Matriks[i][k] * M2.Matriks[k][j];
                }
            }
        }
        return MCopy;
    }

    public Matriks multiplyMatriksWithMod(Matriks M2, int mod){
        Matriks MCopy = new Matriks(this.nRows, M2.nCols);
        int i,j,k;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                MCopy.Matriks[i][j] = 0;
                for(k=0;k<this.nCols;k++){
                    MCopy.Matriks[i][j] +=  this.Matriks[i][k] * this.Matriks[k][j];
                }
                MCopy.Matriks[i][j]%=mod;
            }
        }
        return MCopy;
    }

    public Matriks multiplyByConst(int k){
        Matriks MCopy = new Matriks(this.nRows, this.nCols);
        int i,j;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                MCopy.Matriks[i][j] = this.Matriks[i][j] * k;
            }
        }
        return MCopy;
    }

    public boolean isMatrixSizeEqual(Matriks M2){
        return (this.nRows == M2.nRows && this.nCols == M2.nCols);
    }

    public boolean isMatrixEqual(Matriks M2){
        if(this.isMatrixSizeEqual(M2)){
            int i,j;
            for(i=0;i<this.nRows;i++){
                for(j=0;j<this.nCols;j++){
                    if(this.Matriks[i][j] != M2.Matriks[i][j]){
                        return false;
                    }
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isMatrixSquare(){
        return (this.nRows == this.nCols);
    }

    public int countElmt(Matriks M){
        return (M.nRows * M.nCols);
    }

    public boolean isSymmetric(){
        if(this.isMatrixSquare()){
            int i,j;
            for(i=0;i<this.nRows;i++){
                for(j=0;j<this.nCols;j++){
                    if(this.Matriks[i][j] != this.Matriks[j][i]){
                        return false;
                    }
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isIdentity(){
        if(this.isMatrixSquare()){
            int i,j;
            for(i=0;i<this.nRows;i++){
                for(j=0;j<this.nCols;j++){
                    if(i==j && this.Matriks[i][j] != 1){
                        return false;
                    }
                    else if(i!=j && this.Matriks[i][j] != 0){
                        return false;
                    }    
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public Matriks transpose(){
        Matriks MCopy = new Matriks(this.nRows, this.nCols);
        int i,j;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                MCopy.Matriks[i][j] = this.Matriks[j][i];
            }
        }
        return MCopy;
    }
}
