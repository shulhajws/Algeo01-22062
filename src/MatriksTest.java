import java.util.Scanner;
import mylib.Matriks;

public class MatriksTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of rows for Matrix1: ");
        int rows1 = in.nextInt();
        System.out.print("Enter the number of columns for Matrix1: ");
        int cols1 = in.nextInt();

        Matriks matrix1 = new Matriks(rows1, cols1);
        System.out.println("Enter values for Matrix1:");
        matrix1.readMatriks(rows1, cols1);

        // System.out.print("Enter the number of rows for Matrix2: ");
        // int rows2 = in.nextInt();
        // System.out.print("Enter the number of columns for Matrix2: ");
        // int cols2 = in.nextInt();

        // Matriks matrix2 = new Matriks(rows2, cols2);
        // System.out.println("Enter values for Matrix2:");
        // matrix2.readMatriks(rows2,cols2);

        // // Test displayMatriks
        // System.out.println("Matrix1:");
        // matrix1.displayMatriks();

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
        // System.out.println("Kofaktor of Matrix1: \n");
        // matrix1.kofaktor().displayMatriks();
        // System.out.println("Adjoin of Matrix1: \n");
        // matrix1.adjoin().displayMatriks();
        // System.out.println("Invers of Matrix1: \n");
        // matrix1.invers().displayMatriks();


        //test gauss
        // Matriks Eselon = matrix1.eselonBaris();
        // System.out.println("Matriks eselon barisnya: ");
        // Eselon.displayMatriks();
        // Matriks Eselon = new Matriks(rows1, cols1);

        // Test SPL Matriks
        matrix1.splCramer();
        

        // Matriks Eselon = matrix1.eselonBaris();
        // Eselon.displayMatriks();
        in.close();
    }
}
