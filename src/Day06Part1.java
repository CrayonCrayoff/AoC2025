import java.util.ArrayList;
import java.util.List;

public class Day06Part1 {
    public static void main(String[] args) {
        List<String> inputLines = FileReader.readLines("day06input.txt");

        String[] operators = inputLines.get(inputLines.size()-1).strip().split("\s+");
        List<String[]> operands = new ArrayList<>();

        for (int i = 0; i < inputLines.size() - 1; i++) {
            operands.add(inputLines.get(i).strip().split("\s+"));
        }

        Long output = 0L;

        for (int col = 0; col < operands.get(0).length; col++) {
            String operator = operators[col];
            Long currTotal = 0L;

            for (int row = 0; row < operands.size(); row++) {
                int operand = Integer.parseInt(operands.get(row)[col]);
                switch (operator) {
                    case "+" -> currTotal += operand;
                    case "-" -> currTotal -= operand;
                    case "*" -> currTotal = (currTotal == 0) ? currTotal + operand : currTotal * operand;
                    case "/" -> currTotal = (currTotal == 0) ? currTotal + operand : currTotal / operand;
                }
            }
            output += currTotal;
        }
        System.out.println(output);
    }
}
