import java.util.List;

public class Day02Part2 {
    public static void main(String[] args) {
        List<String> inputLine = FileReader.readLines("inputData/day02input.txt");

        String[] ranges = inputLine.get(0).split(",");
        long output = 0L;

        for (String range : ranges) {
            String[] rangeEndValues = range.split("-");
            long start = Long.parseLong(rangeEndValues[0]);
            long end = Long.parseLong(rangeEndValues[1]);

            for (long i = start; i <= end; i++) {
                if (i < 10) continue;

                String stringRep = Long.toString(i);

                for (int j = 2; j <= stringRep.length(); j++) {
                    if (stringRep.length() % j != 0) continue;
                    if (isInvalidID(stringRep, stringRep.length() / j)) {
                        output += i;
                        break;
                    }
                }
            }
        }
        System.out.println("Our output: " + output);
    }

    public static boolean isInvalidID(String stringRep, int step) {
        String sequence = stringRep.substring(0, step);

        for (int i = 0; i < stringRep.length(); i += step) {
            String part = stringRep.substring(i, i + step);
            if (!part.equals(sequence)) return false;
        }

        return true;
    }
}
