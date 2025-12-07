import java.util.ArrayList;
import java.util.List;

public class Day06Part2 {
    public static void main(String[] args) {
        List<String> inputLines = FileReader.readLines("day06input.txt");
        int operatorIdx = inputLines.size()-1;
        inputLines.set(operatorIdx, inputLines.get(operatorIdx) + "  "); // add two spaces because IntelliJ is annoying

        long output = 0L;

        List<Integer> operands = new ArrayList<>();

        for (int col = inputLines.get(0).length()-1; col >= 0; col--) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < operatorIdx; row++) {
                char digit = inputLines.get(row).charAt(col);
                if (digit != ' ') sb.append(digit);
            }

            if (sb.isEmpty()) continue;

            int number = Integer.parseInt(sb.toString());
            operands.add(number);

            char operator = inputLines.get(operatorIdx).charAt(col);
            if (operator == ' ') continue;

            long currNum = 0;

            if (operator == '+') {
                for (int num : operands) currNum += num;
            } else {
                currNum = 1;
                for (int num : operands) currNum *= num;
            }

            output += currNum;
            operands.clear();
        }

        System.out.println(output);
    }
}
