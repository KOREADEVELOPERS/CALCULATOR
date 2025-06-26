import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class READFILE {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Replace with your file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("Contents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print each line
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
