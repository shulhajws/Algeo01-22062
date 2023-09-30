package mylib;

// import Matriks.*;

public class Gauss {
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
<<<<<<< Updated upstream
}

=======

    public int leadingOne(Matriks m, int c){
        int row1 = 0;
        if (c == -1){
            row1 = m.nRows;
        }
        
        for(int i = 0; i < m.nRows; i++){
            if (m.Matriks[i][c] == 1 &&  c == firstNoZeroRow(m, i)){
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
            col = -1;
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
>>>>>>> Stashed changes
