import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {

        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try (
                FileInputStream fis = new FileInputStream(inputFileName);
                FileOutputStream fos = new FileOutputStream(outputFileName)
        ) {
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                // Replace space with dash ('-');
                if (byteRead == ' ') {
                    byteRead = '-';
                }
                fos.write(byteRead);
            }
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("Error IO");
        }
    }
}
