package mylib;

import java.util.Scanner;

public class Regresi {
    Scanner input = new Scanner(System.in);
    public Matriks multipleLinearRegression (int numOfVariable,int numOfData, Matriks dataMatrix ) {
        SPL spl = new SPL();

        Matriks regressionMatrix = new Matriks(numOfVariable+1, numOfVariable+2);

        int i, j, k;
        for (i = 0; i <= regressionMatrix.getLastIdxRow(); i++) {
            for (j = 0; j <= regressionMatrix.getLastIdxCol(); j++) {
                double sum = 0;
                if (i == 0 && j == 0) {
                    regressionMatrix.Matriks[i][j] = numOfData;
                }

                else if (i == 0 && j == regressionMatrix.getLastIdxCol()) {
                    for (k = 0; k < numOfData; k++) {
                        sum += dataMatrix.Matriks[k][0];
                    }
                    regressionMatrix.Matriks[0][regressionMatrix.getLastIdxCol()] = sum;
                }

                else if (i == 0 || j == 0) {
                    for (k = 0; k < numOfData; k++) {
                        sum += dataMatrix.Matriks[k][i+j];
                    
                    regressionMatrix.Matriks[i][j] = sum;
                    }
                }

                else if (i == j) {
                    for (k = 0; k < numOfData; k++) {
                        sum += (dataMatrix.Matriks[k][i]*dataMatrix.Matriks[k][i]);
                    }

                    regressionMatrix.Matriks[i][j] = sum;
                }

                else if (j == regressionMatrix.getLastIdxCol() && i > 0) {
                    for (k = 0; k < numOfData; k++) {
                        sum += (dataMatrix.Matriks[k][0]*dataMatrix.Matriks[k][i]);
                    }

                    regressionMatrix.Matriks[i][j] = sum;
                }

                else {
                    for (k = 0; k < numOfData; k++) {
                        sum += (dataMatrix.Matriks[k][j]*dataMatrix.Matriks[k][i]);
                    }

                    regressionMatrix.Matriks[i][j] = sum;
                }
            }
        }
        return spl.solveByGaussResult(regressionMatrix);
    }

    public void mlrEquation(Matriks solution) {
        System.out.println("Persamaan regresi linear berganda berdasarkan data tersebut adalah sebagai berikut:");
        System.out.print("f(X) = ");

        int i, x = 0;
        for (i = solution.getLastIdxCol(); i >= 0; i--) {
            if (i == solution.getLastIdxCol()) {
                System.out.print(String.format("%.3f", solution.Matriks[0][i]));
            } else {
                if (solution.Matriks[0][i] >= 0) {
                    System.out.print(" + " + String.format("%.3f", solution.Matriks[0][i]) + " X" + x);
                } else {
                    System.out.print(" - " + String.format("%.3f", solution.Matriks[0][i]*(-1)) + " X" + x);
                }
            }
            x++;
        }
        System.out.println();
    }

    public void mlrEstimation(Matriks solution, Matriks untukDitaksir) {
        Double y = solution.Matriks[0][solution.getLastIdxCol()];
        
        int j = 0;
        for (int i = solution.getLastIdxCol()-1; i >= 0; i--) {
            y += untukDitaksir.Matriks[0][j]*(solution.Matriks[0][i]);
            j++;
        }
        System.out.println("Estimasi nilai variabel terikat berdasarkan regresi linear berganda adalah: ");
        System.out.println(String.format("%.3f", y));
    }
}