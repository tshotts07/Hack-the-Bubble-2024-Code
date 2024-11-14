import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {

    public static ArrayList<Issue> loadIssues(String filePath) {
        ArrayList<Issue> issues = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Skip header line if any

            while ((line = br.readLine()) != null) {
                // Ensure that the description, which can be multiline, is handled correctly
                String[] data = parseCSVLine(line);

                if (data.length == 2) {
                    String issueName = data[0].trim().replace("\"", "");  // Remove quotes around the name
                    String description = data[1].trim().replace("\"", "");  // Remove quotes around the description
                    issues.add(new Issue(issueName, description));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return issues;
    }

    // Helper function to handle CSV line parsing, especially for multiline descriptions
    private static String[] parseCSVLine(String line) {
        // Handle quoted strings and split by the first comma only
        int firstCommaIndex = line.indexOf("\",\"");
        if (firstCommaIndex != -1) {
            return new String[] {
                line.substring(0, firstCommaIndex + 1), 
                line.substring(firstCommaIndex + 2) // Removing the second quote after the comma
            };
        }
        return line.split(",", 2);
    }
}
