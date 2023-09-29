package mylib;

// import Matriks.*;

public class Gauss {

    public boolean isEselonBaris(Matriks M){
        // jika 0 semua diterima
        // loop setiap baris hingga bukan 0 pertama, jika bukan 0 pertama, jika bukan 1 maka salah
        // jika 1, maka cek apakah 1 berada di kolom yang lebih kanan dari 1 pada baris sebelumnya
        // jika tidak lebih kanan maka salah

        int i,j, prevLeadingOne = -1;
        for(i=0;i<M.nRows;i++){
            for(j=0;j<M.nCols;j++){
                if(M.Matriks[i][j]!=0){
                    if(i!=0 && !allRowZero(M,i-1)){
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

    
    public void convertOne(double x, int r, int c, Matriks m){
        for(int k = c; k < m.nCols; k++){
            m.Matriks[r][k] = m.Matriks[r][k] / x;
        }
    }

    public void convertZero(double x, int rx, int ry, Matriks m){
        for(int c = 0; c < m.nCols; c++){
            m.Matriks[ry][c] = m.Matriks[ry][c] - (x * m.Matriks[rx][c]);
        }
    }

    public boolean allRowZero(Matriks m, int r){
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

    public boolean allColZero(Matriks m, int c){
        int count = 0; boolean yes = false;
        for(int r = 0; r < m.nRows; r++){
            if (m.Matriks[r][c] == 0){
                count++;
            }
        }
        if (count == m.nRows){
            yes = true;
        }
        return yes;
    }

    public boolean allZeroUnder(Matriks m, int r, int c){
        int count = 0; boolean yes = false;
        for(int row = r; row < m.nRows; row++){
            if (m.Matriks[row][c] == 0){
                count++;
            }
        }
        if (count == m.nRows - r){
            yes = true;
        }
        return yes;
    }

    public void swapRow(Matriks m, int r1, int r2){
        for(int c = 0; c < m.nCols; c++){
            double temp = m.Matriks[r1][c];
            m.Matriks[r1][c] = m.Matriks[r2][c];
            m.Matriks[r2][c] = temp;
        }
    }

    public int leadingOne(Matriks m, int c){
        int row1 = 0;
        for(int i = 0; i < m.nRows; i++){
            if (m.Matriks[i][c] == 1){
                row1 = i;
                break;
            } else {
                row1 = -1;
            }
        }
        return row1;
    }

    public int firstNoZeroRow(Matriks m, int r){
        int col = 0;
        if (r < m.nRows){
            for(int c = 0; c < m.nCols; c++){
                if (m.Matriks[r][c] != 0){
                    col = c;
                    break;
                } else {
                    col = m.nCols-1;
                }
            }
        } else {
            col = m.nCols -1;
        }
        
        return col;
    }

    public int firstNoZeroCol(Matriks m, int c){
        int row = 0;
        for(int r = 0; r < m.nRows; r++){
            if (m.Matriks[r][c] != 0){
                row = r;
                break;
            }
        }
        return row;
    }

    public boolean indented(Matriks m, int r, int c){
        return (c > firstNoZeroRow(m, r));
    }

}

