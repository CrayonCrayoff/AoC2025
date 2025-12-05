import java.util.List;

public class Day03Part1 {
    public static void main(String[] args) {
        List<String> inputLines = FileReader.readLines("day03input.txt");

        long output = 0;

        for (String line : inputLines) {
            int tens = line.charAt(0) - '0';
            int tensIdx = 0;

            for (int i = 1; i < line.length() - 1; i++) {
                if (line.charAt(i) - '0' > tens) {
                    tens = line.charAt(i) - '0';
                    tensIdx = i;
                }
            }

            int singles = line.charAt(tensIdx+1) - '0';
            for (int i = tensIdx+2; i < line.length(); i++) {
                singles = Math.max(singles, line.charAt(i) - '0');
            }

            int joltage = (tens * 10) + singles;
            System.out.println("Joltage: " + joltage);

            output += (tens * 10L) + singles;
        }

        System.out.println(output);
    }
}
