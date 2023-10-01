package mylib;

import java.util.Scanner;

public class Regresi {

    public Matriks multipleLinearRegression () {
        Scanner input = new Scanner(System.in);
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
        input.close();

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

        regressionMatrix.displayMatriks();
        return spl.solveByGaussRegresi(regressionMatrix);
        // regressionMatrix.displayMatriks();
        // double[] solution = spl.solveByGaussDouble(regressionMatrix);

        // for (i = 0; i < numOfVariable; i++) {
        //     System.out.println("solusi " + (i+1) + ": " + solution[i]);
        // }
    }

    public void mlrEquation() {
        Matriks solution = multipleLinearRegression();

        System.out.println("Persamaan regresi linear berganda berdasarkan data tersebut adalah sebagai berikut:");
        System.out.print("Y = ");

        int i;
        for (i = 0; i <= solution.getLastIdxCol(); i++) {
            if (i == 0) {
                System.out.print(solution.Matriks[0][i]);
            } else {
                if (solution.Matriks[0][i] >= 0) {
                    System.out.print(" + " + solution.Matriks[0][i] + "X" + i);
                } else {
                    System.out.print(" - " + (solution.Matriks[0][i]*(-1)) + "X" + i);
                }
            }
        }
        System.out.println();
    }

    public void mlrEstimation() {
        Matriks solution = multipleLinearRegression();
        Scanner input = new Scanner(System.in);
        Double y = solution.Matriks[0][0];

        int i;
        for (i = 1; i <= solution.getLastIdxCol(); i++) {
            System.out.print("Masukkan nilai variabel peubah " + i + ": ");
            Double x = input.nextDouble();
            y += x*(solution.Matriks[0][i]);
        }

        input.close();

        System.out.println("Estimasi nilai variabel terikat berdasarkan regresu linear berganda adalah: ");
        System.err.println(y);
    }
}
