import java.util.List;

public class Day03Part2 {
    public static void main(String[] args) {
        List<String> inputLines = FileReader.readLines("day03input.txt");

        long output = 0;

        for (String line : inputLines) {
            int startIdx = 0;
            int endIdx = line.length() - 11;

            long currNum = 0L;

            for (int i = 0; i < 12; i++) {
                int currDigit = -1;
                for (int j = startIdx; j < endIdx; j++) {
                    if (line.charAt(j) - '0' > currDigit) {
                        currDigit = line.charAt(j) - '0';
                        startIdx = j + 1;
                    }
                }
                currNum = (currNum * 10) + currDigit;
                endIdx++;

            }

            output += currNum;
        }

        System.out.println(output);
    }
}
