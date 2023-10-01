package mylib;

public class Citra {

    /*Membuat Matriks 16x16 D */
    public Matriks makeMatriksD(){
        Matriks D = new Matriks(16,16);
        int i,j,c=0, r=0;
        double x,y;
        for(y=0;y<=1;y++){
            for(x=0;x<=1;x++){
                c=0;
                for(j=-1;j<3;j++){
                    for(i=-1;i<3;i++){
                        if(x==i && y==j){D.Matriks[r][c]=1;}
                        else{ D.Matriks[r][c]=0; }
                        c++;
                    }
                }
                r++;
            }
        }
        x=0; y=0;
        for(y=0;y<=1;y++){
            for(x=0;x<=1;x++){
                c=0;
                for(j=-1;j<3;j++){
                    for(i=-1;i<3;i++){
                        if(x==i+1 && y==j){D.Matriks[r][c]=1/2;}
                        if(x==i-1 && y==j){D.Matriks[r][c]=-1/2;}
                        else{ D.Matriks[r][c]=0; }
                        c++;
                    }
                }
                r++;
            }
        }
        x=0; y=0;
        for(y=0;y<=1;y++){
            for(x=0;x<=1;x++){
                c=0;
                for(j=-1;j<3;j++){
                    for(i=-1;i<3;i++){
                        if(x==i && y==j+1){D.Matriks[r][c]=1/2;}
                        if(x==i && y==j-1){D.Matriks[r][c]=-1/2;}
                        else{ D.Matriks[r][c]=0; }
                        c++;
                    }
                }
                r++;
            }
        }
        x=0; y=0;
        for(y=0;y<=1;y++){
            for(x=0;x<=1;x++){
                c=0;
                for(j=-1;j<3;j++){
                    for(i=-1;i<3;i++){
                        if(x==i+1 && y==j+1){D.Matriks[r][c]=1/4;}
                        if(x==i-1 && y==j){D.Matriks[r][c]=-1/4;}
                        if(x==i && y==j-1){D.Matriks[r][c]=-1/4;}
                        if(x==i && y==j){D.Matriks[r][c]=-1/4;}
                        else{ D.Matriks[r][c]=0; }
                        c++;
                    }
                }
                r++;
            }
        }
        return D;

        // Matriks D = new Matriks(16,16);
        // int i,j,c=0, r=0;
        // double x,y;
        // for(y=0;y<=1;y++){
        //     for(x=0;x<=1;x++){
        //         c=0;
        //         for(j=0;j<4;j++){
        //             for(i=0;i<4;i++){
        //                 if(x==i-1 && y==j-1){D.Matriks[r][c]=I.Matriks[i][j];}
        //                 else{ D.Matriks[r][c]=0; }
        //                 c++;
        //             }
        //         }
        //         r++;
        //     }
        // }
        // x=0; y=0;
        // for(y=0;y<=1;y++){
        //     for(x=0;x<=1;x++){
        //         c=0;
        //         for(j=0;j<4;j++){
        //             for(i=0;i<4;i++){
        //                 if(x==i-1 && y==j-1){D.Matriks[r][c]=(I.Matriks[i+1][j]-I.Matriks[i-1][j])/2;}
        //                 else{ D.Matriks[r][c]=0; }
        //                 c++;
        //             }
        //         }
        //         r++;
        //     }
        // }
        // x=0; y=0;
        // for(y=0;y<=1;y++){
        //     for(x=0;x<=1;x++){
        //         c=0;
        //         for(j=0;j<4;j++){
        //             for(i=0;i<4;i++){
        //                 if(x==i-1 && y==j-1){D.Matriks[r][c]=(I.Matriks[i][j+1]-I.Matriks[i][j-1])/2;}
        //                 else{ D.Matriks[r][c]=0; }
        //                 c++;
        //             }
        //         }
        //         r++;
        //     }
        // }
        // x=0; y=0;
        // for(y=0;y<=1;y++){
        //     for(x=0;x<=1;x++){
        //         c=0;
        //         for(j=0;j<4;j++){
        //             for(i=0;i<4;i++){
        //                 if(x==i-1 && y==j-1){D.Matriks[r][c]=1/4;}
        //                 else{ D.Matriks[r][c]=0; }
        //                 c++;
        //             }
        //         }
        //         r++;
        //     }
        // }
        // return D;
    }
}
