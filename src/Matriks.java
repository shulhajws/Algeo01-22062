import java.util.Scanner;

public class Matriks {
    //Atribut
    int[][] Matriks;

    //Method
    //Konstruktor
    public void CreateMatriks(int nRows, int nCols){
        Matriks = new int[nRows][nCols];
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
}
