import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<String> readLines(String fileName) {
        List<String> inputLines = new ArrayList<>();

        File inputFile = new File("inputData/" + fileName);

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                inputLines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Uh oh: " + e);
        }

        return inputLines;
    }
}
