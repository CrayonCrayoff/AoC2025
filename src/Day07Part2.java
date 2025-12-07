import java.util.ArrayList;
import java.util.List;

public class Day07Part2 {
    static long[][] memo;

    public static void main(String[] args) {
        List<String> inputLines = FileReader.readLines("day07input.txt");
        List<char[]> grid = new ArrayList<>();
        for (String line : inputLines) grid.add(line.toCharArray());
        memo = new long[grid.size()][grid.get(0).length];

        int startColIdx = inputLines.get(0).indexOf('S');

        System.out.println(traverseAndCount(1, startColIdx, grid));
    }

    public static long traverseAndCount(int row, int col, List<char[]> grid) {
        if (row >= grid.size()) {
            return 1;
        }

        if (memo[row][col] != 0) return memo[row][col];

        if (grid.get(row)[col] == '.') {
            return traverseAndCount(row + 1, col, grid);
        }

        memo[row][col] = traverseAndCount(row, col + 1, grid) + traverseAndCount(row, col - 1, grid);
        return memo[row][col];
    }
}
