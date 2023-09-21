public class Main {
    public static void main(String[] args) throws Exception {
        Matriks M1 = new Matriks(2,2);
        System.out.print("Selamat Datang di Program Matriks!\n");
        
        System.out.print("Isikan Matriks!\n");
        M1.ReadMatriks(2,2);
        M1.DisplayMatriks(2,2);
    }
}
