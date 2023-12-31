// import java.util.Scanner;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

// import mylib.Operations;
// import mylib.SPL;
// import mylib.Invers;
// import mylib.Gauss;
import mylib.*;
public class MatriksTest {
    
    public static void main(String[] args) throws FileNotFoundException{
        ReadFile rf = new ReadFile();
        Scanner in = new Scanner(System.in);
        int lala = in.nextInt();
        System.out.println(lala);
        in.nextLine();
        String fileNameString = in.nextLine();
        String filePath = "../lib/testfile/"+fileNameString;
        Matriks M1 = rf.readMatriksFromFile(filePath);
        M1.displayMatriks();
        in.close();
        // Bicubic bic = new Bicubic();
        // Invers inv = new Invers();
        // Determinant det = new Determinant();
        // Matriks matrix1 = new Matriks(4, 4);
        // SPL spl = new SPL();
        
        // System.out.println("Enter values for Matrix1:");
        // matrix1.readMatriks(4, 4);
        // matrix1.displayMatriks();
        // System.out.println("----------------------------------");

        // (inv.inversByGaussJordan(matrix1)).displayMatriks();
        // Scanner in = new Scanner(System.in);
        // System.out.println("----------------------------------");
        // System.out.print("Enter the number of rows for Matrix1: ");
        // int rows1 = in.nextInt();
        // System.out.print("Enter the number of columns for Matrix1: ");
        // int cols1 = in.nextInt();
        // Matriks matrix1 = new Matriks(rows1, cols1);
        
        // System.out.println("Enter values for Matrix1:");
        // matrix1.readMatriks(rows1, cols1);

        // Matriks proses = new Matriks(rows1, cols1*2);
        //     for(int b = 0; b < rows1; b++){
        //         for(int k = 0; k < cols1; k++){
        //             proses.Matriks[b][k] = matrix1.Matriks[b][k];
        //         }
        //     }
        //     for(int b = 0; b < rows1; b++){
        //         for(int k = cols1; k < cols1*2; k++){
        //             if (k - b == rows1){
        //                 proses.Matriks[b][k] = 1;
        //             } else {
        //                 proses.Matriks[b][k] = 0;
        //             }
        //         }
        //     }
        // Matriks f = new Matriks(4,4);
        // System.out.println("Enter values for Matrix1:");
        // f.readMatriks(4, 4);
        // f.displayMatriks();
        // System.out.println("----------------------------------");

        // Matriks X = bic.makeMatriksX();
        // X.displayMatriks();
        // System.out.println("----------------------------------");
        // (inv.inversByGaussJordan(X)).displayMatriks();
        // double result=bic.bicubicResult(f, 0.3, 0.4);
        // System.out.println(result);
        // proses.displayMatriks();
        // System.out.println("\n");

        // System.out.println("----------------------------------");
        // spl.toGaussJordan(matrix1);
        // matrix1.displayMatriks();
        // System.out.println("Determinan:"+det.determinantByRowReduction(X));
        
        // Matriks xInvers = inv.inversByGaussJordan(X);
        // xInvers.displayMatriks();
        // Regresi reg = new Regresi();
        // Matriks apani = reg.multipleLinearRegression();
        // reg.mlrEquation(apani);
        // reg.mlrEstimation(apani);

        // Test readMatriksFromFile
        // Matriks matrix1 = new Matriks(0,0);
        // ReadFile file = new ReadFile();
        // matrix1 = file.readMatriksFromFile("lib/testfile/matriks 3x3.txt");
        // matrix1.displayMatriks();
        // Scanner in = new Scanner(System.in);
        // AljabarLinear spl = new AljabarLinear();

        

        // System.out.print("Enter the number of rows for Matrix2: ");
        // int rows2 = in.nextInt();
        // System.out.print("Enter the number of columns for Matrix2: ");
        // int cols2 = in.nextInt();

        // Matriks matrix2 = new Matriks(rows2, cols2);
        // System.out.println("Enter values for Matrix2:");
        // matrix2.readMatriks(rows2,cols2);

        //Test displayMatriks
        // System.out.println("Matrix1:");
        // matrix1.displayMatriks();
        // System.out.println("\n");
        
       
        // System.out.println("Matrix2:");
        // matrix2.displayMatriks();

        // // Test other functions
        // System.out.println("Last Index Row of Matrix1: " + matrix1.getLastIdxRow());
        // System.out.println("Last Index Col of Matrix1: " + matrix1.getLastIdxCol());

        // System.out.println("Is Matrix1 Square? " + matrix1.isMatrixSquare());
        // System.out.println("Is Matrix2 Symmetric? " + matrix2.isSymmetric());
        // System.out.println("Is Matrix2 Identity? " + matrix2.isIdentity());
        
        // // Test addMatriks, subMatriks, multiplyMatriks, multiplyMatriksWithMod
        // Matriks resultAdd = matrix1.addMatriks(matrix2);
        // System.out.println("Matrix1 + Matrix2:");
        // resultAdd.displayMatriks();

        // Matriks resultSub = matrix1.subMatriks(matrix2);
        // System.out.println("Matrix1 - Matrix2:");
        // resultSub.displayMatriks();

        // Matriks resultMultiply = matrix1.multiplyMatriks(matrix2);
        // System.out.println("Matrix1 * Matrix2:");
        // resultMultiply.displayMatriks();

        // int mod = 10; // You can change the value of 'mod' as needed
        // Matriks resultMultiplyWithMod = matrix1.multiplyMatriksWithMod(matrix2, mod);
        // System.out.println("Matrix1 * Matrix2 % " + mod + ":");
        // resultMultiplyWithMod.displayMatriks();

        // // Test multiplyByConst
        // int k = 3; // You can change the value of 'k' as needed
        // Matriks resultMultiplyByConst = matrix1.multiplyByConst(k);
        // System.out.println("Matrix1 * " + k + ":");
        // resultMultiplyByConst.displayMatriks();

        // // Test isMatrixSizeEqual and isMatrixEqual
        // System.out.println("Is Matrix1 and Matrix2 size equal? " + matrix1.isMatrixSizeEqual(matrix2));
        // System.out.println("Is Matrix1 and Matrix2 equal? " + matrix1.isMatrixEqual(matrix2));

        // // Test transpose
        // Matriks transposedMatrix1 = matrix1.transpose();
        // System.out.println("Transpose of Matrix1:");
        // transposedMatrix1.displayMatriks();

        // Matriks transposedMatrix2 = matrix2.transpose();
        // System.out.println("Transpose of Matrix2:");
        // transposedMatrix2.displayMatriks();

        // // Test determinant
        // System.out.println("Determinant of Matrix1: " + matrix1.determinant());

        // in.close();
    }
}

