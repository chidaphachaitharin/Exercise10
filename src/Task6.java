import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the first three digits of your bank account: ");
            String userInput = scanner.nextLine();

            String urlContent = loadUrlContent("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");

            String bankInfo = getBankInfo(userInput, urlContent);

            System.out.println(bankInfo);
        } catch (IOException e) {
            System.err.println("Error IO");
        }
    }

    private static String loadUrlContent(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }

    private static String getBankInfo(String userInput, String urlContent) {
        String[] lines = urlContent.split("\n");

        for (String line : lines) {
            String bankNumber = line.substring(0, 3);

            // Check if the user input matches the bank number
            if (bankNumber.startsWith(userInput)) {
                //  from character 5 to the end of the line
                String bankName = line.substring(5).trim();
                return "You have an account in: " + bankName;
            }
        }

        return "Bank information not found for the provided digits.";
    }
}
