package mylib;

public class Bicubic {
    /*Membuat Matrik 16x16 tanpa hard code */
    public Matriks makeMatriksX(){
        Matriks X = new Matriks(16,16);
        int i,j,c=0, r=0;
        double x,y;
        for(y=0;y<=1;y++){
            for(x=0;x<=1;x++){
                c=0;
                for(j=0;j<4;j++){
                    for(i=0;i<4;i++){
                        X.Matriks[r][c]=Math.pow(x,i)*Math.pow(y,j);
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
                for(j=0;j<4;j++){
                    for(i=0;i<4;i++){
                        if(x==0&&i-1==-1){X.Matriks[r][c]=0;}
                        else{X.Matriks[r][c]=i*Math.pow(x,i-1)*Math.pow(y,j);}
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
                for(j=0;j<4;j++){
                    for(i=0;i<4;i++){
                        if(y==0&&j-1==-1){X.Matriks[r][c]=0;}
                        else{X.Matriks[r][c]=j*Math.pow(x,i)*Math.pow(y,j-1);}
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
                for(j=0;j<4;j++){
                    for(i=0;i<4;i++){
                        if((x==0&&i-1==-1)|(y==0&&j-1==-1)){X.Matriks[r][c]=0;}
                        else{X.Matriks[r][c]=i*j*Math.pow(x,i-1)*Math.pow(y,j-1);}
                        c++;
                    }
                }
                r++;
            }
        }
        return X;
    }

    /*Mengubah input matriks 4x4 menjadi 16x1 */
    public Matriks convertMatriksBic(Matriks x4){
        Matriks MCopy = new Matriks(16,1);
        int i,j,k=0;
        for(i=0;i<x4.nRows;i++){
            for(j=0;j<x4.nCols;j++){
                MCopy.Matriks[k][0]=x4.Matriks[i][j];
                k++;
            }
        }
        return MCopy;
    }
    
    /*Menghitung hasil petaan titik (xt,yt) dengan bicubic spline */
    public double bicubicResult(Matriks f, double xt, double yt){
        Invers inv = new Invers();

        Matriks xInvers = inv.inversByGaussJordan(makeMatriksX());
        Matriks koef = xInvers.multiplyMatriks(convertMatriksBic(f));
        int i,j,k=0;
        double result=0;
        for(j=0;j<4;j++){
            for(i=0;i<4;i++){
                result += koef.Matriks[k][0]*Math.pow(xt,i)*Math.pow(yt,j);
                k++;
            }
        }
        return result;
    }
}
