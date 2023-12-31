import mylib.*;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean programOn = true;
        int choice, choiceInput, choiceOutput;
        Scanner in = new Scanner(System.in);
        ReadFile rf = new ReadFile();
        SPL spl = new SPL();
        Determinant det = new Determinant();
        Operations o = new Operations();
        Invers inv = new Invers();
        Interpolasi ipol = new Interpolasi();
        Bicubic bic = new Bicubic();
        Regresi reg = new Regresi();
        Util u = new Util();
        WriteToFile wf = new WriteToFile();

        u.welcome();
        while(programOn){
            u.displayMenu();
            System.out.print("Operasi apa yang ingin kamu lakukan? (Masukkan pilihan menu dalam angka): ");
            choice = in.nextInt();
            if(choice==8){
                u.bye();
                programOn = false;
                break;
            }
            System.out.print("Pilih cara input? 1. Keyboard 2. File .txt: ");
            choiceInput = in.nextInt();
            System.out.print("Pilih cara output? 1. Console 2. File .txt: ");
            choiceOutput = in.nextInt();

            switch(choice){
                case 1: //SPL
                    u.displayMenuSPL();
                    System.out.print("Operasi apa yang ingin kamu lakukan? (Masukkan pilihan menu dalam angka): ");
                    int choiceSPL = in.nextInt();

                    Matriks M1;
                    if(choiceInput==1){ //Read from Keyboard
                        System.out.println("Masukkan SPL yang ingin kamu selesaikan dalam bentuk matriks A:");
                        System.out.print("Masukkan jumlah baris matriks: ");
                        int nRows = in.nextInt();
                        System.out.print("Masukkan jumlah kolom matriks: ");
                        int nCols = in.nextInt();
                        System.out.print("Masukkan nilai nilai matriks A: ");
                        Matriks A = new Matriks(nRows,nCols);
                        A.readMatriks(nRows, nCols);
                        System.out.print("Masukkan nilai nilai hasil dalam bentuk matriks b: ");
                        Matriks b = new Matriks(nRows,1);
                        b.readMatriks(nRows, 1);
                        M1 = o.concatMatriksSPL(A, b);
                        
                    } else { //Read from File
                        System.out.println("Masukkan SPL yang ingin kamu selesaikan dalam bentuk matriks augmented:");
                        System.out.print("Masukkan nama file input dengan format namafile.txt: ");
                        in.nextLine();
                        String fileNameString = in.nextLine();
                        String filePath = "../test/testfile/"+fileNameString;
                        M1 = rf.readMatriksFromFile(filePath);
                    }

                    switch(choiceSPL){
                        case 1: //Gauss
                            if(choiceOutput==1){ //Output to Keyboard
                                String[] answerSPLbyGauss = spl.solveByGauss(M1);
                                for(int i=0;i<M1.nCols-1;i++){
                                    if(answerSPLbyGauss[i]==null){break;}
                                    System.out.print(answerSPLbyGauss[i]);
                                }
                            } else { //Output to File
                                System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                            String fileOut = in.nextLine();
                            PrintStream ps = wf.startWritingToFile(fileOut);
                            String[] answerSPLbyGauss = spl.solveByGauss(M1);
                            for(int i=0;i<M1.nCols-1;i++){
                                if(answerSPLbyGauss[i]==null){break;}
                                System.out.print(answerSPLbyGauss[i]);
                            }
                            wf.stopWritingToFile(fileOut, ps);
                            System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");
                            }
                            break;
                        case 2: //Gauss-Jordan
                            if(choiceOutput==1){ //Output to Keyboard
                                String[] answerSPLbyGaussJordan = spl.solveByGaussJordan(M1);
                                for(int i=0;i<M1.nCols-1;i++){
                                    if(answerSPLbyGaussJordan[i]==null){break;}
                                    System.out.print(answerSPLbyGaussJordan[i]);
                                }
                            } else { //Output to File
                                System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                                String fileOut = in.nextLine();
                                PrintStream ps = wf.startWritingToFile(fileOut);
                                String[] answerSPLbyGaussJordan = spl.solveByGaussJordan(M1);
                                for(int i=0;i<M1.nCols-1;i++){
                                    if(answerSPLbyGaussJordan[i]==null){break;}
                                    System.out.print(answerSPLbyGaussJordan[i]);
                                }
                                wf.stopWritingToFile(fileOut, ps);
                                System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");
                            }
                            break;
                        case 3: //Invers
                            if(choiceOutput==1){ //Output to Keyboard
                                String[] answerSPLbyInvers = spl.solveByInverse(M1);
                                for(int i=0;i<M1.nCols-1;i++){
                                    if(answerSPLbyInvers[i]==null){break;}
                                    System.out.print(answerSPLbyInvers[i]);
                                }
                            } else { //Output to File
                                System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                                String fileOut = in.nextLine();
                                PrintStream ps = wf.startWritingToFile(fileOut);
                                String[] answerSPLbyInvers = spl.solveByInverse(M1);
                                for(int i=0;i<M1.nCols-1;i++){
                                    if(answerSPLbyInvers[i]==null){break;}
                                    System.out.print(answerSPLbyInvers[i]);
                                }
                                wf.stopWritingToFile(fileOut, ps);
                                System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");

                            }
                            break;
                        case 4: //Kaidah Cramer
                            System.out.println("Perlu diingat bahsa kaidah Cramer khusus untuk SPL dengan n peubah dan n persamaan!");
                            
                            if(M1.nCols!=M1.nRows+1){ //Jika tidak dapat cramer
                                if(choiceOutput==1){
                                    System.out.println("Tidak dapat diselesaikan dengan Kaidah Cramer");
                                } else {
                                    System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                                    String fileOut = in.nextLine();
                                    PrintStream ps = wf.startWritingToFile(fileOut);
                                    System.out.println("Tidak dapat diselesaikan dengan Kaidah Cramer");
                                    wf.stopWritingToFile(fileOut, ps);
                                    System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");
                                }
                            } else{
                                if(choiceOutput==1){ //Output to Keyboard
                                    String[] answerSPLbyCramer = spl.Cramer(M1);
                                    for(int i=0;i<M1.nCols-1;i++){
                                        if(answerSPLbyCramer[i]==null){break;}
                                        System.out.print(answerSPLbyCramer[i]);
                                    }
                                } else { //Output to File
                                    System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                                    String fileOut = in.nextLine();
                                    PrintStream ps = wf.startWritingToFile(fileOut);
                                    String[] answerSPLbyCramer = spl.Cramer(M1);
                                    for(int i=0;i<M1.nCols-1;i++){
                                        if(answerSPLbyCramer[i]==null){break;}
                                        System.out.print(answerSPLbyCramer[i]);
                                    }
                                    wf.stopWritingToFile(fileOut, ps);
                                    System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");

                                }
                            }
                            break;
                    }
                    break;
                case 2: //Determinan
                    u.displayMenuDet();
                    System.out.print("Operasi apa yang ingin kamu lakukan? (Masukkan pilihan menu dalam angka): ");
                    int choiceDet = in.nextInt();

                   Matriks M2;
                    if(choiceInput==1){ //Read from Keyboard
                        System.out.println("Masukkan Matriks yang ingin kamu cari determinannya:");
                        System.out.print("Masukkan nilai n (jumlah baris dan kolom harus sama agar memiliki determinan): ");
                        int nRows = in.nextInt();
                        int nCols = nRows;
                        System.out.print("Masukkan nilai nilai matriks: ");
                        M2 = new Matriks(nRows,nCols);
                        M2.readMatriks(nRows, nCols);
                    } else { //Read from File
                        System.out.println("Masukkan matriks yang kamu ingin cari determinannya");
                        System.out.print("Masukkan nama file input dengan format namafile.txt: ");
                        in.nextLine();
                        String fileNameString = in.nextLine();
                        String filePath = "../test/testfile/"+fileNameString;
                        M2 = rf.readMatriksFromFile(filePath);
                    };

                    if (!M2.isMatrixSquare()) {
                        System.out.println("Matriks bukan merupakan matriks persegi. Determinan tidak dapat dihitung.");
                        break;
                    } else {
                        switch(choiceDet){
                            case 1: //Reduksi Baris
                                if(choiceOutput==1){ //Output to Console
                                    System.out.println("Determinan matriks anda adalah: ");
                                    System.out.println(det.determinantByRowReduction(M2));
                                } else { //Output to File
                                    System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                                    String fileOut = in.nextLine();
                                    PrintStream ps = wf.startWritingToFile(fileOut);
                                    System.out.println("Determinan matriks anda adalah: ");
                                    System.out.println(det.determinantByRowReduction(M2));
                                    wf.stopWritingToFile(fileOut, ps);
                                    System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");
                                }
                                break;
                            case 2: //Ekspansi Kofaktor
                                // ----------------------
                                if(choiceOutput==1){ //Output to Console
                                    System.out.println("Determinan matriks anda adalah: ");
                                    System.out.println(det.determinantByCofactor(M2));
                                } else { //Output to File
                                    System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                                    String fileOut = in.nextLine();
                                    PrintStream ps = wf.startWritingToFile(fileOut);
                                    System.out.println("Determinan matriks anda adalah: ");
                                    System.out.println(det.determinantByCofactor(M2));
                                    wf.stopWritingToFile(fileOut, ps);
                                    System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");
                                }
                                break;
                        }
                        break;
                    }
                case 3: //Invers
                    u.displayMenuInvers();
                    System.out.print("Operasi apa yang ingin kamu lakukan? (Masukkan pilihan menu dalam angka): ");
                    int choiceInvers = in.nextInt();

                    Matriks M3;
                    if(choiceInput==1){ //Read from Keyboard
                        System.out.println("Masukkan Matriks yang ingin kamu cari inversnya:");
                        System.out.print("Masukkan nilai n (jumlah baris dan kolom harus sama agar memiliki invers): ");
                        int nRows = in.nextInt();
                        int nCols = nRows;
                        System.out.print("Masukkan nilai nilai matriks: ");
                        M3 = new Matriks(nRows,nCols);
                        M3.readMatriks(nRows, nCols);
                    } else { //Read from File
                        System.out.println("Masukkan matriks yang kamu ingin cari inversnya");
                        System.out.print("Masukkan nama file input dengan format namafile.txt: ");
                        in.nextLine();
                        String fileNameString = in.nextLine();
                        String filePath = "../test/testfile/"+fileNameString;
                        M3 = rf.readMatriksFromFile(filePath);
                    };

                    switch(choiceInvers){
                        case 1: //Matriks Balikan
                            if(choiceOutput==1){ //Output to Keyboard
                                System.out.println("Invers matriks anda adalah: ");
                                (inv.inversByGaussJordan(M3)).displayMatriks();
                            } else { //Output to File
                                System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                                String fileOut = in.nextLine();
                                PrintStream ps = wf.startWritingToFile(fileOut);
                                System.out.println("Invers matriks anda adalah: ");
                                (inv.inversByGaussJordan(M3)).displayMatriks();
                                wf.stopWritingToFile(fileOut, ps);
                                System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");
                            }
                            break;
                        case 2: //Adjoin
                            if(choiceOutput==1){ //Output to Keyboard
                                System.out.println("Invers matriks anda adalah: ");
                                (inv.inversMatriks(M3)).displayMatriks();
                            } else { //Output to File
                                System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                                String fileOut = in.nextLine();
                                PrintStream ps = wf.startWritingToFile(fileOut);
                                System.out.println("Invers matriks anda adalah: ");
                                (inv.inversMatriks(M3)).displayMatriks();
                                wf.stopWritingToFile(fileOut, ps);
                                System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");

                            };
                            break;
                    }
                    break;
                case 4: //Interpolasi Polinom
                    double[] x = new double[999999];
                    double[] y = new double[999999];
                    double I = 0; int nt = 0;
                    if(choiceInput==1){ //Read from Keyboard
                        System.out.printf("Jumlah titik yang akan dimasukkan: ");
                        nt = in.nextInt();
                        for (int i = 0; i < nt; i++){
                            System.out.printf("Titik " + (i+1) + ":\n");
                            System.out.printf("--> x" + (i+1) + ", y" + (i+1) +": ");
                            x[i] = in.nextDouble();
                            y[i] = in.nextDouble();
                        }
                        System.out.printf("Value x yang akan ditaksir: ");
                        I = in.nextDouble();
                    } else {//Read from File
                        System.out.println("Masukkan file text dengan format beberapa titik x y dan nilai yang akan ditaksir");
                        System.out.print("Masukkan nama file input dengan format namafile.txt: ");
                        in.nextLine();
                        String fileNameString = in.nextLine();
                        String filePath = "../test/testfile/"+ fileNameString;
                        Matriks M4 = rf.readMatriksFromFile(filePath);
                        nt=M4.nRows-1;
                        x = rf.getXforIpol(M4);
                        y = rf.getYforIpol(M4);
                        I = rf.getXUntukDitebak(M4);
                    }

                    if(choiceOutput==1){ //Output to Keyboard
                        ipol.solveByInterpolasi(x, y, I, nt);
                        System.out.println();
                    } else { //Output to File
                        System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                        String fileOut = in.nextLine();
                        PrintStream ps = wf.startWritingToFile(fileOut);
                        ipol.solveByInterpolasi(x, y, I, nt);
                        System.out.println();
                        wf.stopWritingToFile(fileOut, ps);
                        System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");
                    }
                    break;

                case 5: //Interpolasi Bicubic Spline
                    Matriks M5;
                    double xbic,ybic;
                    if(choiceInput==1){ //Read from Keyboard
                        System.out.println("Masukkan Matriks 4x4 sebagai titik dasar dan titik turunan yang diketahui:");
                        System.out.print("Masukkan nilai nilai matriks: ");
                        M5 = new Matriks(4,4);
                        M5.readMatriks(4, 4);
                        System.out.print("Masukkan absis titik yang ingin kita cari: ");
                        xbic = in.nextDouble();
                        System.out.print("Masukkan ordinat titik yang ingin kita cari: ");
                        ybic = in.nextDouble();
                    } else { //Read from File
                        System.out.println("Masukkan matriks 4x4 beserta titik yang kamu ingin cari nilainya");
                        System.out.print("Masukkan nama file input dengan format namafile.txt: ");
                        in.nextLine();
                        String fileNameString = in.nextLine();
                        String filePath = "../test/testfile/" + fileNameString;
                        Matriks M5fromFile = rf.readMatriksFromFile(filePath);
                        M5 = rf.getMatriks(M5fromFile);
                        Matriks M5Titik = rf.getXYUntukDitebak(M5fromFile);
                        xbic = M5Titik.Matriks[0][0];
                        ybic = M5Titik.Matriks[0][1];
                    };

                    if(choiceOutput==1){//Output to Keyboard
                        System.out.print("Hasil dari petaan bicubic spline nya adalah ");
                        double result = bic.bicubicResult(M5, xbic, ybic);
                        System.out.print(String.format("%.3f", result));
                        System.out.print("\n");
                    } else { //Output to File
                        System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                        String fileOut = in.nextLine();
                        PrintStream ps = wf.startWritingToFile(fileOut);
                        System.out.print("Hasil dari petaan bicubic spline nya adalah ");
                        double result = bic.bicubicResult(M5, xbic, ybic);
                        System.out.print(String.format("%.3f", result));
                        System.out.print("\n");
                        wf.stopWritingToFile(fileOut, ps);
                        System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");
                    }
                    break;

                case 6: //Regresi Linear Berganda
                    Matriks resultReg, dataMatrix, untukDitaksir; int numOfData, numOfVariable;
                    if(choiceInput==1){ //Input Keyboard
                        System.out.print("Masukkan jumlah peubah x: ");
                        numOfVariable = in.nextInt();
                        System.out.print("Masukkan jumlah data: ");
                        numOfData = in.nextInt();
                        dataMatrix = new Matriks(numOfData, numOfVariable+1);

                        int i;
                        System.out.print("y");
                        for (i = 0; i < numOfVariable; i++) {
                            System.out.print("|x" + (i+1));
                        }
                        System.out.print("\n");
                        dataMatrix.readMatriks(numOfData, numOfVariable+1);
                        
                        resultReg = reg.multipleLinearRegression(numOfVariable, numOfData, dataMatrix);

                        untukDitaksir = new Matriks(1, numOfVariable);
                        int p=1;
                        for(int j=0;j<untukDitaksir.nCols;j++){
                            System.out.print("Masukkan nilai variabel peubah " + p + ": ");
                            untukDitaksir.Matriks[0][j]=in.nextDouble();
                            p++;
                        }
                    } else { //Input File
                        System.out.println("Masukkan nilai nilai regresi linear dalam bentuk matriks dengan format kolom f(X)|X1|X2|...|Xn");
                        System.out.print("Masukkan nama file input dengan format namafile.txt: ");
                        in.nextLine();
                        String fileNameString = in.nextLine();
                        String filePath = "../test/testfile/" + fileNameString;
                        Matriks M6fromFile = rf.readMatriksFromFile(filePath);
                        numOfVariable=(M6fromFile.nCols)-1;
                        numOfData=(M6fromFile.nRows)-1;
                        dataMatrix = new Matriks(numOfData, numOfVariable+1);
                        dataMatrix = rf.getMatriks(M6fromFile);
                        resultReg = reg.multipleLinearRegression(numOfVariable, numOfData, dataMatrix);
                        untukDitaksir = rf.getLastLineMatriks(M6fromFile);
                    }

                    if(choiceOutput==1){
                        reg.mlrEquation(resultReg);
                        reg.mlrEstimation(resultReg,untukDitaksir);
                    } else {
                        System.out.print("Masukkan nama file output dengan format namafile.txt: ");
                        String fileOut = in.nextLine();
                        PrintStream ps = wf.startWritingToFile(fileOut);
                        reg.mlrEquation(resultReg);
                        reg.mlrEstimation(resultReg,untukDitaksir);
                        wf.stopWritingToFile(fileOut, ps);
                        System.out.println("Output telah berhasil disimpan dalam file " + fileOut + "!");
                    }
                    break;
                case 7: //Perbesaran Citra
                    System.out.println("Kak maaf kami gak selesai-selesai ngerjain perbesaran citranya :c");
                    System.out.println("Daripada kosong doang gitu mending kami gombalin kakak xixixi~");
                    System.out.println("Kak tau gak kesamaan cinta kami sama perbesaran citra tubes algeo??");
                    System.out.println("Sama-sama gak akan pernah selesai alias unendinggg *ba dum tsssss*");
                    u.displayOurLove();
                    System.out.println("P.S. Kak maaf banget tapi kita udah ada effort kok tolong at least cek citra.java ya plssss makasihh");
                    break;
            }
        }
        in.close();
    }
}
