package mylib;

import java.util.Scanner;

public class Regresi {
    Scanner input = new Scanner(System.in);
    public Matriks multipleLinearRegression () {
        SPL spl = new SPL();

        System.out.print("Masukkan jumlah peubah x: ");
        int numOfVariable = input.nextInt();

        System.out.print("Masukkan jumlah data: ");
        int numOfData = input.nextInt();

        Matriks regressionMatrix = new Matriks(numOfVariable+1, numOfVariable+2);
        Matriks dataMatrix = new Matriks(numOfData, numOfVariable+1);

        int i;
        System.out.print("y");
        for (i = 0; i < numOfVariable; i++) {
            System.out.print("|x" + (i+1));
        }
        System.out.print("\n");

        dataMatrix.readMatriks(numOfData, numOfVariable+1);

        int j, k;
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

        return spl.solveByGaussRegresi(regressionMatrix);
    }

    public void mlrEquation(Matriks solution) {
        System.out.println("Persamaan regresi linear berganda berdasarkan data tersebut adalah sebagai berikut:");
        System.out.print("Y = ");

        int i, x = 0;
        for (i = solution.getLastIdxCol(); i >= 0; i--) {
            if (i == solution.getLastIdxCol()) {
                System.out.print(solution.Matriks[0][i]);
            } else {
                if (solution.Matriks[0][i] >= 0) {
                    System.out.print(" + " + solution.Matriks[0][i] + " X" + x);
                } else {
                    System.out.print(" - " + (solution.Matriks[0][i]*(-1)) + " X" + x);
                }
            }
            x++;
        }
        System.out.println();
    }

    public void mlrEstimation(Matriks solution) {
        Double y = solution.Matriks[0][solution.getLastIdxCol()];

        int i, p = 1;
        for (i = solution.getLastIdxCol()-1; i >= 0; i--) {
            System.out.print("Masukkan nilai variabel peubah " + p + ": ");
            Double x = input.nextDouble();
            y += x*(solution.Matriks[0][i]);
            p++;
        }
        System.out.println("Estimasi nilai variabel terikat berdasarkan regresu linear berganda adalah: ");
        System.err.println(y);
    }
}