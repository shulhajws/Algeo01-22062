package mylib;

public class SPL {
    /* Melakukan SPL dengan kaidah cramer. 
     * khusus untuk SPL dengan n peubah dan n persamaan
     * Solusi Cramer pastilah unik.
    */
    public void Cramer(Matriks M){
        AljabarLinear AL = new AljabarLinear();
        // Mendefinikasikan matriks A pada SPL Ax=b
        Matriks MOri = new Matriks(M.nRows,M.nCols-1);
        for(int i=0;i<M.nRows;i++){
            for(int j=0;j<M.nCols-1;j++){
                MOri.Matriks[i][j] = M.Matriks[i][j];
            }
        }
        // Mendefinikasikan matriks b pada SPL Ax=b
        Matriks b = new Matriks(M.nRows,1);
        for(int i=0;i<M.nRows;i++){
            b.Matriks[i][0] = M.Matriks[i][M.nCols-1];
        }
        //Menghitung determinan matriks A
        double detOri = AL.determinantByCofactor(MOri);

        int j;
        if(detOri==0){
            System.out.println("Matriks tidak memiliki solusi");
        } else {
            System.out.println("Solusi SPL:");
            for(j=0;j<MOri.nCols;j++){ //lakukan pengulangan pada setiap kolom
                //pendefinisian matriks cramer yang akan dioperasikan
                Matriks MCramer = new Matriks(MOri.nRows,MOri.nCols);
                MOri.copyMatriks(MCramer);
                changeColWithb(MCramer,j,b);

                //menghitung determinan matriks cramer
                double detCramer = AL.determinantByCofactor(MCramer);

                //menampilkan solusi SPL
                System.out.println("x"+(j+1)+" = "+detCramer/detOri);
            }
        }   
    }

    public void changeColWithb(Matriks M, int i, Matriks b){
        //Mengganti kolom ke-i dengan kolom b
        for(int j=0;j<M.nRows;j++){
            M.Matriks[j][i] = b.Matriks[j][0];
        }
    }
    
}
