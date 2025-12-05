import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day05Part2 {
    public static void main(String[] args) {
        List<String> inputLines = FileReader.readLines("day05input.txt");

        List<long[]> overLappingRanges = new ArrayList<>();
        for (String line : inputLines) {
            if (line.isEmpty()) break;
            String[] startAndEnd = line.split("-");
            overLappingRanges.add(new long[]{Long.parseLong(startAndEnd[0]), Long.parseLong(startAndEnd[1])});
        }

        overLappingRanges.sort(Comparator.comparingLong(a -> a[0]));

        List<long[]> ranges = new ArrayList<>();
        ranges.add(overLappingRanges.get(0));

        for (long[] currRange : overLappingRanges) {
            long[] prevRange = ranges.get(ranges.size()-1);
            if (currRange[0] >= prevRange[0] && currRange[0] <= prevRange[1]) {
                prevRange[1] = Math.max(prevRange[1], currRange[1]);
            } else {
                ranges.add(currRange);
            }
        }

        long output = 0L;

        for (long[] range : ranges) {
            output += range[1] - range[0] + 1;
        }

        System.out.println("Output is: " + output);
    }
}
