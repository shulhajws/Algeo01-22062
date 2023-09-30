package mylib;

public class SPL {
    
    /* Melakukan SPL dengan kaidah cramer. 
     * khusus untuk SPL dengan n peubah dan n persamaan
     * Solusi Cramer pastilah unik.
    */
    public void Cramer(Matriks M){
        Determinant AL = new Determinant();
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
                MCramer=MOri.copyMatriks();
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

    public void toGauss(Matriks m){
        int r = 0; int c = 0;
        Operations g = new Operations();
        if (m.Matriks[r][c] == 0){
            if (g.allZeroUnder(m, r, c)){
                c++;
            } else {
                int row = g.firstNoZeroCol(m, c);
                g.swapRow(m, r, row);
            }
        }
        if (g.allColZero(m, c)){
            c++;
        }
        while (c < m.nCols - 1 && r < m.nRows && !g.isEselonBaris(m)){
            if (g.allRowZero(m, r)){
                g.swapRow(m, r, m.nRows - 1);
            }
            if (g.allZeroUnder(m, r, c)){
                c++;
            }
            if (r < m.nRows && c < m.nCols){
                if (m.Matriks[r][c] != 0){
                    double x = m.Matriks[r][c];
                    g.convertOne(x, r, c, m);
                }
            }
            int b = r + 1;
            if (b < m.nRows && c < m.nCols){
                if (b == m.nRows - 1){
                    if (g.allRowZero(m, r)){
                        break;
                    }
                } else if (m.Matriks[b][c] == 0){
                    if (g.allRowZero(m, r)){
                        c++;
                    } else if (g.allZeroUnder(m, b, c)){
                        c++;
                    } else {
                        b++;
                    }
                }
                if (c == m.nCols - 1){
                    c = m.nCols - 1;
                    r = m.nRows;
                } else {
                    if (g.allRowZero(m, b)){
                        c = g.firstNoZeroRow(m, b-1);
                    } else {
                        c = g.firstNoZeroRow(m, b);
                    }
                }
                int r1 = g.leadingOne(m, c);
                if (r1 != -1){
                    if (!g.indented(m, b, c)){
                        while (b < m.nRows){
                            if (m.Matriks[b][c] == 0){
                                b++;
                            } else {
                                double x = m.Matriks[b][c];
                                g.convertZero(x, r1, b, m);
                                b++;
                            }
                        }
                    }
                } else {
                    if (r < m.nRows && c < m.nCols){
                        if (m.Matriks[r][c] != 0){
                            double x = m.Matriks[r][c];
                            g.convertOne(x, r, c, m);
                        }
                    }
                }
            }
            if (c < m.nCols){
                r = g.leadingOne(m, c) + 1;
                c++;
            } else {
                r = m.nRows;
                c = m.nCols;
            }
        }
    }

    public void toGaussJordan(Matriks m){
        SPL spl = new SPL();
        Operations o = new Operations();
        spl.toGauss(m);
        System.out.println("Gauss:");
        m.displayMatriks();
        System.out.println("\n");

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

    
    
}
