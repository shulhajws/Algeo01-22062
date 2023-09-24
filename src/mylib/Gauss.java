package mylib;

// import Matriks.*;

public class Gauss {

    /** Cek apakah matriks merupakan matriks eselon baris */
    public boolean isEselonBaris(Matriks M){
        // jika 0 semua diterima
        // loop setiap baris hingga bukan 0 pertama, jika bukan 0 pertama, jika bukan 1 maka salah
        // jika 1, maka cek apakah 1 berada di kolom yang lebih kanan dari 1 pada baris sebelumnya
        // jika tidak lebih kanan maka salah

        int i,j, prevLeadingOne = -1;
        for(i=0;i<M.nRows;i++){
            for(j=0;j<M.nCols;j++){
                if(M.Matriks[i][j]!=0){
                    if(i!=0 && !isRowAllZero(M,i-1)){
                        return false;
                    }
                    if(M.Matriks[i][j]!=1){
                        return false;
                    } else {
                        if(j<=prevLeadingOne){
                            return false;
                        } else {
                            prevLeadingOne = j;
                        }
                    }
                    break;
                } else {
                    continue;
                }
            }
        }
        return true;       
    }

    
    public void convertOne(double x, int r, Matriks m){
        for(int c = 0; c < m.nCols; c++){
            m.Matriks[r][c] = m.Matriks[r][c] / x;
        }
    }

    public void convertZero(double x, int rx, int ry, Matriks m){
        for(int c = 0; c < m.nCols; c++){
            m.Matriks[ry][c] = m.Matriks[ry][c] - (x * m.Matriks[rx][c]);
        }
    }

    public int findFirstOne(Matriks m, int c){
        int row = 0;
        for(int r = 0; r < m.nRows; r++){
            if (m.Matriks[r][c] == 1){
                row = r;
                break;
            }
        }
        return row;
    }

    public boolean isRowAllZero(Matriks m, int r){
        int count = 0; boolean yes = false;
        for(int c = 0; c < m.nCols; c++){
            if (m.Matriks[r][c] == 0){
                count++;
            }
        }
        if (count == m.nCols){
            yes = true;
        }
        return yes;
    }

    public void swapRow(Matriks m, int r1, int r2){
        double temp = 0;
        for(int c = 0; c < m.nCols; c++){
            temp = m.Matriks[r1][c];
            m.Matriks[r1][c] = m.Matriks[r2][c];
            m.Matriks[r2][c] = m.Matriks[r1][c];
        }
    }
}

