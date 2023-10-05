package mylib;

public class Operations {

    Determinant d = new Determinant();

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

    public void convertOne(double x, int r, Matriks m){
        for(int k = 0; k < m.nCols; k++){
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

    public boolean allZeroBefore(Matriks m, int r){
        int count = 0; boolean yes = false;
        if (m.Matriks[r][m.nCols - 1] != 0){
            for(int col = 0; col < m.nCols - 1; col++){
                if (m.Matriks[r][col] == 0){
                    count++;
                }
            }
            if (count == m.nCols - 1){
                yes = true;
            }
        } else {
            yes = false;
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

    public int leadingOneRow(Matriks m, int c){
        int row1 = 0;
        if (c > 0){
            for(int i = 0; i < m.nRows; i++){
                if (m.Matriks[i][c] == 1 && m.Matriks[i][c-1] == 0){
                    row1 = i;
                    break;
                } else {
                    row1 = -1;
                }
            }
        } else {
            for(int i = 0; i < m.nRows; i++){
                if (m.Matriks[i][c] == 1){
                    row1 = i;
                    break;
                } else {
                    row1 = -1;
                }
            }
        }
        return row1;
    }

    public int leadingOneCol(Matriks m, int r){
        int col1 = 0;
        boolean found = false;
        while(col1 < m.nCols && !found){
            if (m.Matriks[r][col1] != 0){
                found = true;
            } else {
                col1++;
            }
        }
        
        return col1;
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

    public boolean inversible(Matriks m){
        boolean yes = true;
        double det = d.determinantByRowReduction(m);
        if (det == 0){
            System.out.println("Tidak memilikin matriks balikan!\n");
            yes = false;
        } else {
            yes = true;
        }
        return yes;
    }

    public boolean isLowerTriangular (Matriks m) {
        int i, j;

        for (i = 0; i <= m.getLastIdxRow(); i++) {
            for (j = i+1; j <= m.getLastIdxCol(); j++) {
                if (m.Matriks[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUpperTriangular (Matriks m) {
        int i, j;

        for (j = 0; j <= m.getLastIdxRow(); j++) {
            for (i = j+1; i <= m.getLastIdxCol(); i++) {
                if (m.Matriks[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean noZeroInDiagonal (Matriks m) {
        int i;

        for (i = 0; i <= m.getLastIdxRow(); i++) {
            if (m.Matriks[i][i] == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isProcessed (Matriks m) {
        int i, j, count;

        for (i = 0; i <= m.getLastIdxRow(); i++) {
            count = 0;
            for (j = 0; j <= m.getLastIdxCol(); j++) {
                if (m.Matriks[i][j] == 0) {
                    count++;
                }
            }
            if (count == m.nCols) {
                return false;
            }
        }

        for (j = 0; j <= m.getLastIdxCol(); j++) {
            count = 0;
            for (i = 0; i <= m.getLastIdxRow(); i++) {
                if (m.Matriks[i][j] == 0) {
                    count++;
                }
            }
            if (count == m.nRows) {
                return false;
            }
        }

        return true;
    }

    public boolean oneSolution(Matriks m){
        boolean yes = true;
        if (m.nRows < m.nCols - 1){
            yes = false;
        }
        if (yes){
            for (int i = 0; i < m.nCols - 1; i++){
                if (m.Matriks[i][i] != 1){
                    yes = false;
                } 
            }
        }
        return yes;
    }

    public String[] manySolution(Matriks m, String[] j){
        boolean[] proses = new boolean[m.nCols - 1];
        char[] variabel = new char[m.nCols - 1];
        int cur = 17;
        for(int i = 0; i < m.nCols - 1; i++){
            proses[i] = false;
        } 
        for(int a = 0; a < m.nRows; a++){
            for(int c = a; c < m.nCols - 1; c++){
                if(m.Matriks[a][c] == 1){
                    proses[c] = true;
                    String temp = "";
                    if(Math.abs(m.Matriks[a][m.nCols - 1]) > 1e-8){
                        temp += Double.toString(m.Matriks[a][m.nCols - 1]);
                    }
                    for(int k = c + 1; k < m.nCols - 1; k++){
                        if(Math.abs(m.Matriks[a][k]) > 1e-8){
                            if(!proses[k]){
                                proses[k] = true;
                                variabel[k] = (char)(97+cur);
                                j[k] = "x" + Integer.toString(k+1) + " = " + Character.toString(variabel[k]) + "\n";
                                cur = (cur+1)%26;
                            }
                            if(m.Matriks[a][k] > 0) {
                                temp += (temp.length() == 0 ? "" : " - ") + (Math.abs(m.Matriks[a][k]) != 1.0 ? Double.toString(Math.abs(m.Matriks[a][k])) : "") + Character.toString(variabel[k]);
                            } else {
                                temp += (temp.length() == 0 ? "" : " + ") + (Math.abs(m.Matriks[a][k]) != 1.0 ? Double.toString(Math.abs(m.Matriks[a][k])) : "") + Character.toString(variabel[k]);
                            }    
                        }
                    }
                    if (temp == ""){
                        j[c] = "x" + Integer.toString(c+1) + " = " + 0 + "\n";
                    } else {
                        j[c] = "x" + Integer.toString(c+1) + " = " + temp + "\n";
                    }
                    break;
                } else {
                    if(!proses[c]){
                        proses[c] = true;
                        variabel[c] = (char)(97+cur);
                        j[c] = "x" + Integer.toString(c+1) + " = " + Character.toString(variabel[c]) + "\n";
                        cur = (cur+1)%26;
                    }
                }
            }
        }
        return j;
    }

    public Matriks concatMatriksSPL(Matriks A, Matriks b){
        Matriks MCopy = new Matriks(A.nRows,A.nCols+1);
        for(int i=0;i<A.nRows;i++){
            for(int j=0;j<A.nCols;j++){
                MCopy.Matriks[i][j]=A.Matriks[i][j];
            }
        }
        for(int k=0;k<b.nRows;k++){
            MCopy.Matriks[k][MCopy.getLastIdxCol()]=b.Matriks[k][0];

        }
        return MCopy;
    }
    public void toSolve(Matriks m){
        Operations o = new Operations();
        for(int b = 1; b < m.nRows; b++){
            // mendapatkan kolom leading 1
            int c1 = o.leadingOneCol(m, b);
            if (c1 < m.nCols){
                // menjadikan elemen di atas leading 1 nol
                for(int row = b - 1; row >= 0; row--){
                    // menyimpan elemen untuk dikalikan dengan leading 1
                    double x = m.Matriks[row][c1];
                    for(int k = 0; k < m.nCols; k++){
                        m.Matriks[row][k] = m.Matriks[row][k] - (x * m.Matriks[b][k]);
                    }
                }
            }
        }
    }

}
