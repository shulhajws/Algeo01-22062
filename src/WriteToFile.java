import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
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

    public void writeFromConsole (String fileName) {
        try {
            //create a buffered reader that connects to the console, we use it so we can read lines
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            //read a line from the console
            String lineFromInput = in.readLine();

            //create an print writer for writing to a file
            PrintStream out = new PrintStream(new FileOutputStream("../lib/" + fileName));
            System.setOut(out);

            //output to the file a line
            out.println(lineFromInput);

            //close the file (VERY IMPORTANT!)
            out.close();
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
            e1.printStackTrace();
        }
    }
}
