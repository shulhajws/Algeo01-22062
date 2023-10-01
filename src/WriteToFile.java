import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class WriteToFile {
    Scanner input = new Scanner(System.in);

    public void writeUsingOutputStream(String data) {
        OutputStream os = null;

        try {
            System.out.print("Masukkan nama file .txt: ");
            String fileName = input.nextLine();

            os = new FileOutputStream(new File("../lib/" + fileName));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
