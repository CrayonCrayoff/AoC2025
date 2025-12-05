import java.util.List;

public class Day02Part1 {
    public static void main(String[] args) {
        List<String> inputLine = FileReader.readLines("day02input.txt");

        String[] ranges = inputLine.get(0).split(",");
        long output = 0L;

        for (String range : ranges) {
            String[] rangeEndValues = range.split("-");
            long start = Long.parseLong(rangeEndValues[0]);
            long end = Long.parseLong(rangeEndValues[1]);

            for (long i = start; i <= end; i++) {
                String stringRep = Long.toString(i);
                if (stringRep.length() % 2 != 0) continue;

                int half = stringRep.length() / 2;
                if (stringRep.substring(0, half).equals(stringRep.substring(half))) output += i;
            }
        }

        System.out.println(output);
    }
}
