import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task4 {
    public static void main(String[] args) {
        String inputFile = "studentsEN.txt";
        String outputFile = "studentsGrade5.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts (tab)
                String[] parts = line.split("\t");

                if (parts.length >= 2 && "5".equals(parts[2].trim())) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Filtering complete. Students with grade 5 written to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error IO");
        }
    }
}
