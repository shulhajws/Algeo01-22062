import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import mylib.*;

public class ReadFile {

    public Matriks readMatriksFromFile(String filePath) throws FileNotFoundException{
        try {
            File text = new File(filePath);
            Scanner fReader = new Scanner(text);
            int nRows=0, nCols=0;
            while (fReader.hasNextLine()) {
              nRows++;
              Scanner colReader = new Scanner(fReader.nextLine());
              while (colReader.hasNextDouble()){
                  nCols++;
                  colReader.nextDouble();              
              }
            }
            nCols = nCols/nRows;
            Matriks M = new Matriks(nRows,nCols);
            fReader.close();

            fReader = new Scanner(text);
            int i,j;
            for(i=0;i<M.nRows;i++){
                for(j=0;j<M.nCols;j++){
                    if(fReader.hasNextDouble()){
                        M.Matriks[i][j] = fReader.nextDouble();
                    }
                }
            }
            fReader.close();
            // M.displayMatriks();
            return M;
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    public Matriks getMatriks(Matriks M){
        Matriks Mat = new Matriks(M.nRows-1,M.nCols);
        for(int i=0;i<Mat.nRows;i++){
            for(int j=0;j<Mat.nCols;j++){
                Mat.Matriks[i][j]=M.Matriks[i][j];
            }
        }
        return Mat;
    }

    public double getXUntukDitebak(Matriks M){
        return M.Matriks[M.getLastIdxRow()][0];
    }

    public Matriks getXYUntukDitebak(Matriks M){
        Matriks Mat = new Matriks(1,2);
        Mat.Matriks[0][0]=M.Matriks[M.getLastIdxRow()][0];
        Mat.Matriks[0][1]=M.Matriks[M.getLastIdxRow()][1];
        return Mat; 
    }

    public Matriks getLastLineMatriks(Matriks M){
        Matriks Mat = new Matriks(1,M.nCols-1);
        for(int j=0;j<Mat.nCols;j++){
            Mat.Matriks[0][j]=M.Matriks[M.getLastIdxRow()][j];
        }
        return Mat;
    }

    public Matriks getXforIpol(){
        
    }

    public Matriks getYforIpol(){

    }
}
