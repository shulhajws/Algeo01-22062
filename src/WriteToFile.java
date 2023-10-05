import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class WriteToFile {
    Scanner input = new Scanner(System.in);
    PrintStream printToConsole = System.out;

    public PrintStream startWritingToFile (String fileName) throws FileAlreadyExistsException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("../lib/outputfile/" + fileName));
            System.setOut(out);
            return out;
        } catch (IOException e) {
            System.out.println("Error during reading/writing");
            e.printStackTrace();
            return null;
        }
    }

    public void stopWritingToFile (String fileName, PrintStream out) {
        out.close();
        System.setOut(printToConsole);
    }
}
