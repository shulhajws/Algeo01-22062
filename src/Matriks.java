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
    public void ReadMatriks(int nRows, int nCols){
        Scanner in = new Scanner(System.in);

        int i,j;
        for(i=0;i<nRows;i++){
            for(j=0;j<nCols;j++){
                this.Matriks[i][j]=in.nextInt();
            }
        }
    }

    //Tulis Matriks
    public void DisplayMatriks(int nRows, int nCols){
        int i,j;
        for(i=0;i<nRows;i++){
            for(j=0;j<nCols;j++){
                System.out.print(this.Matriks[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean IsMatrixIdxValid(int i, int j){
        return (i>=0 && i<1000 && j>=0 && j<1000);
    } 

    public boolean IsMatrixIdxEff(int i, int j){
        return (i>=0 && i<this.nRows && j>=0 && j<this.nCols);
    }

    public int GetLastIdxRow(){
        return this.nRows-1;
    }

    public int GetLastIdxCol(){
        return this.nCols-1;
    }

    public int GetElmtDiagonal(int i){
        return this.Matriks[i][i];
    }

    public void CopyMatriks(){
        Matriks MCopy = new Matriks(this.nRows, this.nCols);
        int i,j;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                MCopy.Matriks[i][j] = this.Matriks[i][j];
            }
        }
    }

    public Matriks addMatriks(Matriks M1, Matriks M2){
        Matriks MCopy = new Matriks(M1.nRows, M1.nCols);
        int i,j;
        for(i=0;i<M1.nRows;i++){
            for(j=0;j<M1.nCols;j++){
                MCopy.Matriks[i][j] = MCopy.Matriks[i][j] + M2.Matriks[i][j];
            }
        }
        return MCopy;
    }

    public Matriks subMatriks(Matriks M1, Matriks M2){
        Matriks MCopy = new Matriks(M1.nRows, M1.nCols);
        int i,j;
        for(i=0;i<M1.nRows;i++){
            for(j=0;j<M1.nCols;j++){
                MCopy.Matriks[i][j] = MCopy.Matriks[i][j] - M2.Matriks[i][j];
            }
        }
        return MCopy;
    }

    public Matriks multiplyMatriks(Matriks M1, Matriks M2){
        Matriks MCopy = new Matriks(M1.nRows, M2.nCols);
        int i,j,k;
        for(i=0;i<M1.nRows;i++){
            for(j=0;j<M2.nCols;j++){
                MCopy.Matriks[i][j] = 0;
                for(k=0;k<M1.nCols;k++){
                    MCopy.Matriks[i][j] +=  M1.Matriks[i][k] * M2.Matriks[k][j];
                }
            }
        }

        return MCopy;
    }
}
