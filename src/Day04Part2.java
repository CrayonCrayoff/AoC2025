import java.util.List;

public class Day04Part2 {
    public static void main(String[] args) {
        List<String> inputLines = FileReader.readLines("inputData/day04input.txt");

        char[][] grid = new char[inputLines.size()][inputLines.get(0).length()];
        for (int i = 0; i < inputLines.size(); i++) {
            grid[i] = inputLines.get(i).toCharArray();
        }

        int output = 0;
        boolean rollsRemoved = false;

        do {
            rollsRemoved = false;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == '@' && isAccessible(grid, row, col)) {
                        output++;
                        rollsRemoved = true;
                        grid[row][col] = '.';
                    }
                }
            }
        } while (rollsRemoved);

        System.out.println(output);
    }

    public static boolean isAccessible(char[][] grid, int row, int col) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int y = row + i;
                int x = col + j;

                if ((y == row && x == col) || (y < 0 || y >= numRows) || (x < 0 || x >= numCols)) {
                    continue;
                }

                if (grid[y][x] == '@') count++;
            }
        }
        return count <= 3;
    }
}
