import java.util.ArrayList;
import java.util.List;

public class Day05Part1 {
    public static void main(String[] args) {
        List<String> inputLines = FileReader.readLines("day05input.txt");

        boolean emptyLineFound = false;
        List<Long[]> ranges = new ArrayList<>();
        List<Long> ingredients = new ArrayList<>();

        long freshCount = 0L;

        for (String line : inputLines) {
            if (line.isEmpty()) {
                emptyLineFound = true;
                continue;
            }
            if (emptyLineFound) ingredients.add(Long.parseLong(line));
            else {
                String[] startAndEnd = line.split("-");
                long start = Long.parseLong(startAndEnd[0]);
                long end = Long.parseLong(startAndEnd[1]);
                ranges.add(new Long[] {start, end});
            }
        }

        for (Long ingredient : ingredients) {
            for (Long[] range : ranges) {
                Long start = range[0];
                Long end = range[1];

                if (ingredient >= start && ingredient <= end) {
                    freshCount++;
                    break;
                }
            }
        }

        System.out.println(freshCount);
    }
}
