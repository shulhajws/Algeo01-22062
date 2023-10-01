package mylib;;

public class SPL {

// METODE PENYELESAIAN SPL

// 1. Metode Eliminasi Gauss
    /* Prosedur untuk mengubah matriks yang diberikan hingga terbentuk matriks Gauss (eselon baris) */
    public void toGauss(Matriks m){
        Operations o = new Operations();
        int r = 0; int c = 0;
        if (m.Matriks[r][c] == 0){
            if (o.allZeroUnder(m, r, c)){
                c++;
            } else {
                int row = o.firstNoZeroCol(m, c);
                o.swapRow(m, r, row);
            }
        }
        if (o.allColZero(m, c)){
            c++;
        }
        while (c < m.nCols && r < m.nRows && !o.isEselonBaris(m)){
            if (o.allRowZero(m, r)){
                o.swapRow(m, r, m.nRows - 1);
                m.displayMatriks();
            }
            if (o.allZeroUnder(m, r, c)){
                c++;
            }
            if (r < m.nRows && c < m.nCols){
                if (m.Matriks[r][c] != 0){
                    double x = m.Matriks[r][c];
                    o.convertOne(x, r, c, m);
                } else {
                    c = o.firstNoZeroRow(m, r);
                    double x = m.Matriks[r][c];
                    if (x != 0){
                        o.convertOne(x, r, c, m);
                    }
                }
            }
            int b = r + 1;
            if (b < m.nRows && c < m.nCols){
                if (m.Matriks[b][c] == 0){
                    if (o.allZeroUnder(m, b, c)){
                        c++;
                    } else if (o.allRowZero(m, b)){
                        o.swapRow(m, b, m.nRows - 1);
                    } 
                    else {
                        b++;
                    }
                }if (b < m.nRows && c < m.nCols){
                    int r1 = o.leadingOne(m, c);
                    if (b == r1 && m.Matriks[b][c] == 1 && !o.allRowZero(m, b)){
                        b++;
                    }
                }
                
                if (b == m.nRows - 1){
                    if (o.allRowZero(m, r)){
                        break;
                    }
                }
                if (c == m.nCols - 1){
                    c = m.nCols - 1;
                    r = m.nRows;
                } else {
                    if (o.allRowZero(m, b)){
                        c = o.firstNoZeroRow(m, b-1);
                    } else {
                        c = o.firstNoZeroRow(m, b);
                    }
                }
                int r1 = o.leadingOne(m, c);
                if (r1 != -1){
                    if (!o.indented(m, b, c)){
                        while (b < m.nRows){
                            if (m.Matriks[b][c] == 0){
                                b++;
                            } else {
                                double x = m.Matriks[b][c];
                                o.convertZero(x, r1, b, m);
                                b++;
                            }
                        }
                    } 
                } else {
                    if (b < m.nRows && c < m.nCols){
                        if (m.Matriks[b][c] != 0){
                            double x = m.Matriks[b][c];
                            o.convertOne(x, b, c, m);
                        }
                    }
                }
            }
            if (c < m.nCols){
                r = o.leadingOne(m, c) + 1;
                c++;
            } else {
                r = m.nRows;
                c = m.nCols;
            }
        }
    }

    /*Memberikan solusi dalam string dari SPL */
    public String[] solveByGauss(Matriks m){
        Operations o = new Operations();
        boolean no, many, one = false;
        int b = m.nRows - 1;

        toGauss(m);

        if (o.allZeroBefore(m, b)){
            no = true; many = false; one = false;
        } else if (o.oneSolution(m)){
            one = true; many = false; no = false;
        } else if (o.allRowZero(m, b)){
            many = true;no = false; one = false;
        } else {
            many = true; no = false; one = false;
        }

        double[] x; x = new double[999999];
        String[] j; j = new String[999999];
        
        if (one){
            int assign = 0;
            for(int i = m.nRows - 1; i >= 0; i--){
                double elmt = m.Matriks[i][m.nCols - 1];
                int idx = m.nRows - 2 - i;
                for(int k = i + 1; k < m.nRows; k++){
                    elmt -= m.Matriks[i][k] * x[idx];
                    idx -= 1;
                }
                x[assign] = elmt;
                assign += 1;
            }
            for(int r = 0; r < m.nCols - 1; r++){
                j[r] = "x" + Integer.toString(r+1) + " = " + Double.toString(x[r]) + "\n";
            }
        } else if (many){
            j = o.manySolution(m, j);

        } else if (no){
            j = null;


            System.out.println("Tidak ada solusi.\n");
        }
        return j;
    }

    public Matriks solveByGaussRegresi(Matriks m){
        Operations o = new Operations();
        boolean no, many, one = false;
        int b = m.nRows - 1;

        toGauss(m);

        if (o.allZeroBefore(m, b)){
            no = true; many = false; one = false;
        } else if (o.oneSolution(m)){
            one = true; many = false; no = false;
        } else if (o.allRowZero(m, b)){
            many = true;no = false; one = false;
        } else {
            many = true; no = false; one = false;
        }

        String[] j; j = new String[999999];
        Matriks sol = new Matriks(1, m.nCols - 1);
        
        
        if (one){
            int assign = 0;
            for(int i = m.nRows - 1; i >= 0; i--){
                double x = m.Matriks[i][m.nCols - 1];
                int idx = m.nRows - 2 - i;
                for(int k = i + 1; k < m.nRows; k++){
                    x -= m.Matriks[i][k] * sol.Matriks[0][idx];
                    idx -= 1;
                }
                sol.Matriks[0][assign] = x;
                assign += 1;
            }
            
            for(int r = 0; r < m.nCols - 1; r++){
                j[r] = "x" + Integer.toString(r+1) + " = " + Double.toString(sol.Matriks[0][r]) + "\n";
            }
        } else if (many){
            j = o.manySolution(m, j);
        } else if (no){
            j = null;
            System.out.println("Tidak ada solusi.\n");
        }
        return sol;
    }


// 2. Metode Eliminasi Gauss-Jordan
    /* Prosedur untuk mengubah matriks yang diberikan hingga terbentuk matriks Gauss-Jordan (eselon baris tereduksi) */
    public void toGaussJordan(Matriks m){
        Operations o = new Operations();
        toGauss(m);
        int c = 0; int r = 0; int r1 = 0;

        if (o.allColZero(m, c)){
                c++;
            }
        if (o.leadingOne(m,c) == -1){
            c++;
        } 

        while (c < m.nCols-1){
            c = o.firstNoZeroRow(m, r);
            r1 = o.leadingOne(m, c);
                for (int b = r1 - 1; b >= 0; b--){
                    double x = m.Matriks[b][c];
                    o.convertZero(x, r1, b, m);
                }
            c++; r++;
        }
    }

    /*Memberikan solusi dari SPL */
    public Matriks solveByGaussJordanR(Matriks m){
        Operations o = new Operations();
        boolean no, many, one = false;
        int b = m.nRows - 1;

        toGaussJordan(m);

        // Mengecek kondisi matriks
        if (o.allZeroBefore(m, b)){
            no = true; many = false; one = false;
        } else if (o.oneSolution(m)){
            one = true; many = false; no = false;
        } else if (o.allRowZero(m, b)){
            many = true;no = false; one = false;
        } else {
            many = true; no = false; one = false;
        }

        // Inisialisasi solusi
        String[] j; j = new String[999999];
        
        Matriks x = new Matriks(1, m.nCols - 1);
        
        // Sesuai kondisi matriks
        if (one){
            for(int r = m.nCols - 2; r >= 0; r-- ){
                x.Matriks[0][r] = m.Matriks[r][m.nCols - 1];
            }
            for(int r = 0; r < m.nCols - 1; r++){
                j[r] = "x" + Integer.toString(r+1) + " = " + Double.toString(x.Matriks[0][r]) + "\n";
            }
        } else if (many){
            j = o.manySolution(m, j);

        } else if (no){
            j = null;
            System.out.println("Tidak ada solusi.\n");
        }
        return x;
    }

    public String[] solveByGaussJordan(Matriks m){
        Operations o = new Operations();
        boolean no, many, one = false;
        int b = m.nRows - 1;

        toGaussJordan(m);

        // Mengecek kondisi matriks
        if (o.allZeroBefore(m, b)){
            no = true; many = false; one = false;
        } else if (o.oneSolution(m)){
            one = true; many = false; no = false;
        } else if (o.allRowZero(m, b)){
            many = true;no = false; one = false;
        } else {
            many = true; no = false; one = false;
        }

        // Inisialisasi solusi
        double[] x; x = new double[999999];
        String[] j; j = new String[999999];
        
        // Sesuai kondisi matriks
        if (one){
            for(int r = m.nCols - 2; r >= 0; r-- ){
                x[r] = m.Matriks[r][m.nCols - 1];
            }
            for(int r = 0; r < m.nCols - 1; r++){
                j[r] = "x" + Integer.toString(r+1) + " = " + Double.toString(x[r]) + "\n";
            }
        } else if (many){
            j = o.manySolution(m, j);

        } else if (no){
            j = null;
            System.out.println("Tidak ada solusi.\n");
        }
        return j;
    }

// 3. Metode Matriks Balikan
    /* Prosedur untuk mengubah matriks yang diberikan hingga terbentuk matriks Gauss-Jordan (eselon baris tereduksi) */
    public String[] solveByInverse(Matriks m){
        // Inisialisasi
        Operations o = new Operations();
        Invers invers = new Invers();
        int rows = m.getLastIdxRow();
        int cols = m.getLastIdxCol();
        double[] x; x = new double[999999];
        String[] j; j = new String[999999];

        if ((rows != cols - 1)){
            System.out.println("Tidak bisa dipecahkan dengan metode matriks balikan!\n");
        } else {
            Matriks A = new Matriks(rows + 1, rows + 1);
            Matriks B = new Matriks(rows + 1, 1);
            for(int b = 0; b < m.nRows; b++){
                for(int k = 0; k < cols; k++){
                    A.Matriks[b][k] = m.Matriks[b][k];
                }
            }
            for(int b = 0; b < m.nRows; b++){
                B.Matriks[b][0] = m.Matriks[b][cols];
            }
            if (!o.inversible(A)){
                System.out.println("Tidak bisa dipecahkan dengan metode matriks balikan!\n");
            } else {
                Matriks Ai;
                Ai = invers.inversByGaussJordan(A);
                Matriks hasil = new Matriks(rows + 1, 1);
                for(int b = 0; b < Ai.nRows; b++){
                    for(int k = 0; k < Ai.nCols; k++){
                        hasil.Matriks[b][0] = hasil.Matriks[b][0] + Ai.Matriks[b][k] * B.Matriks[k][0];
                    }
                }
                for(int i = 0; i < hasil.nRows; i++){
                    x[i] = hasil.Matriks[i][0];
                }
                for(int i = 0; i < hasil.nRows; i++){
                    j[i] = "x" + Integer.toString(i+1) + " = " + Double.toString(x[i]) + "\n";
                }
            }
        }
        return j;
    }


    

// 4. Metode Cramer
    /* Melakukan SPL dengan kaidah cramer. 
     * khusus untuk SPL dengan n peubah dan n persamaan
     * Solusi Cramer pastilah unik. */
    public String[] Cramer(Matriks M){
        // Inisialisasi tempat simpan jawaban
        Determinant d = new Determinant();
        String[] jaw; jaw = new String[999999];

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
        double detOri = d.determinantByCofactor(MOri);

        int j;
        if(detOri==0){
            System.out.println("Matriks tidak memiliki solusi");
        } else {
            System.out.println("Solusi SPL:");
            for(j=0;j<MOri.nCols;j++){ //lakukan pengulangan pada setiap kolom
                //pendefinisian matriks cramer yang akan dioperasikan
                Matriks MCramer = new Matriks(MOri.nRows,MOri.nCols);
                MCramer=MOri.copyMatriks();
                changeColWithb(MCramer,j,b);

                //menghitung determinan matriks cramer
                double detCramer = d.determinantByCofactor(MCramer);

                //menampilkan solusi SPL
                jaw[j] = "x"+ Integer.toString(j+1) +" = " + Double.toString(detCramer/detOri) + "\n";
            }
        }   
        return jaw;
    }

    public void changeColWithb(Matriks M, int i, Matriks b){
        //Mengganti kolom ke-i dengan kolom b
        for(int j=0;j<M.nRows;j++){
            M.Matriks[j][i] = b.Matriks[j][0];
        }
    }
}

