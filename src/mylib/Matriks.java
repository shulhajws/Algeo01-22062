package mylib;
import java.util.Scanner;
// import mylib.AljabarLinear;

public class Matriks {
    //Atribut
    public double[][] Matriks = new double[1000][1000];
    public int nRows;
    public int nCols;

    //Methods
    //Konstruktor
    public Matriks(int nRows, int nCols){
        Matriks = new double[nRows][nCols];
        this.nRows = nRows;
        this.nCols = nCols;
    }

    //Baca Matriks
    /**
     * Membaca matriks dari input user
     * @param nRows
     * @param nCols
     */
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
    /**
     * Menampilkan matriks ke layar
     */
    public void displayMatriks(){
        int i,j;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                System.out.print(this.Matriks[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Mengembalikan true jika indeks matriks valid (kurang dari kapasitas maksimum matriks 1000)
     * @param i
     * @param j
     * @return
     */
    public boolean isMatrixIdxValid(int i, int j){
        return (i>=0 && i<1000 && j>=0 && j<1000);
    } 

    /**
     * Mengembalikan true jika indeks matriks efektif (kurang dari ukuran matriks)
     */
    public boolean isMatrixIdxEff(int i, int j){
        return (i>=0 && i<this.nRows && j>=0 && j<this.nCols);
    }

    //Getter
    /**
     * Mengembalikan indeks baris terakhir matriks
     * @return
     */
    public int getLastIdxRow(){
        return this.nRows-1;
    }

    /**
     * Mengembalikan indeks kolom terakhir matriks
     * @return
     */
    public int getLastIdxCol(){
        return this.nCols-1;
    }

    /**
     * Mengembalikan nilai dari indeks matriks yang diagonal
     * @return
     */
    public double getElmtDiagonal(int i){
        return this.Matriks[i][i];
    }

    /**
     * Membuat salinan dari matriks
     * Pada pemanggilan, MCopy harus dideclare terlebih dahulu
     */
    public void copyMatriks(Matriks MCopy){
        // Matriks MCopy = new Matriks(this.nRows, this.nCols);
        int i,j;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                MCopy.Matriks[i][j] = this.Matriks[i][j];
            }
        }
    }

    //Operasi Matriks
    /**
     * Mengembalikan matriks hasil penjumlahan matriks dengan matriks M2
     * @param M2
     * @return
     */
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

    /**
     * Mengembalikan matriks hasil pengurangan matriks dengan matriks M2
     * @param M2
     * @return
     */
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

    /*
     * Mengembalikan matriks hasil perkalian matriks dengan matriks M2
     */
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

    /*
     * Mengembalikan matriks hasil perkalian matriks dengan matriks M2 yang kemudian dimodulo kan
     */
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

    /*
     * Mengembalikan matriks hasil perkalian matriks dengan konstanta k
     */
    public Matriks multiplyByConst(double k){
        Matriks MCopy = new Matriks(this.nRows, this.nCols);
        int i,j;
        for(i=0;i<this.nRows;i++){
            for(j=0;j<this.nCols;j++){
                MCopy.Matriks[i][j] = this.Matriks[i][j] * k;
            }
        }
        return MCopy;
    }

    //Cek Matriks
    /**
     * Mengembalikan true jika ukuran matriks sama
     * @param M2
     * @return
     */
    public boolean isMatrixSizeEqual(Matriks M2){
        return (this.nRows == M2.nRows && this.nCols == M2.nCols);
    }

    /**
     * Mengembalikan true jika isi matriks sama
     * @param M2
     * @return
     */
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

    /**
     * Mengembalikan true jika matriks merupakan matriks persegi
     * @return
     */
    public boolean isMatrixSquare(){
        return (this.nRows == this.nCols);
    }

    /**
     * Mengembalikan jumlah elemen matriks
     * @param M
     * @return
     */
    public int countElmt(){
        return (this.nRows * this.nCols);
    }

    /**
     * Mengembalikan true jika matriks merupakan matriks simetris
     * yaitu jika matriks[i][j] == matriks[j][i]
     * @return
     */
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

    /**
     * Mengembalikan true jika matriks merupakan matriks identitas (diagonal nya berisi 1, sisanya 0)
     * @return
     */
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

    //Operasi Lainnya
    /**
     * Mengembalikan matriks hasil transpose matriks
     * @return
     */
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

    public double determinant(){
        if (this.isMatrixSquare()){
            AljabarLinear AL = new AljabarLinear();
            return AL.determinantByCofactor(this);
        } else {
            System.out.println("Matriks tidak persegi");
            return 0;
        }
    }

    public Matriks invers(){
        if (this.isMatrixSquare()){
            AljabarLinear AL = new AljabarLinear();
            return AL.inversMatriks(this);
        } else {
            System.out.println("Matriks tidak persegi");
            return null;
        }
    }

    public Matriks kofaktor(){
        Invers I = new Invers();
        return I.matriksKofaktor(this);
    }

    public Matriks adjoin(){
        Invers I = new Invers();
        return I.matriksAdjoin(this);
    }

    public void splCramer(){
        SPL S = new SPL();
        S.Cramer(this);
    }

    // public Matriks eselonBaris(){
    //     Matriks MCopy = new Matriks(this.nRows, this.nCols);
    //     this.copyMatriks(MCopy);
    //     AljabarLinear G = new AljabarLinear();
    //     G.Gauss(MCopy);

    //     return MCopy;
    // }
}
