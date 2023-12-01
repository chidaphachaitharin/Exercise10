import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class DataManagement {
    private static final String FILE_PATH = "userData.txt";

    public void readData() { // Get data from the user and write it to the file
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first and last name: ");
        String fullName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(fullName);
            writer.newLine();
            System.out.println("Data written to file successfully.");
        }
        catch (IOException e) {
            System.err.println("Error IO");
        }
    }


    public void readDataFromFile() {    // Read data from the file and display it
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("Data read from file:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error IO");
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        DataManagement dataManager = new DataManagement();
        dataManager.readData();
        dataManager.readDataFromFile();
    }
}
