import java.util.List;

public class Day01Part2 {
    public static void main(String[] args) {
        List<String> lines = FileReader.readLines("inputData/day01input.txt");

        int currentValue = 50;
        int zeroCount = 0;

        for (String line : lines) {
            int clicks = Integer.parseInt(line.substring(1));

            zeroCount += clicks / 100; // every 100 clicks is a full rotation, aka one pass through 0, count those
            clicks %= 100;  // remaining clicks after all full rotations

            if (line.charAt(0) == 'L') {
                currentValue -= clicks;
            } else {
                currentValue += clicks;
            }

            // if remaining clicks are equal to the absolute current value (eg -40/40 -> 40), that means we started this
            // operation at 0. Do not count that pass, we already counted that on the previous instruction.
            if (Math.abs(currentValue) != clicks && (currentValue >= 100 || currentValue <= 0)) {
                zeroCount++;
            }

            // reset current value to be within the range 0-99 inclusive
            if (currentValue < 0) currentValue += 100;
            currentValue %= 100;
        }

        System.out.println(zeroCount);
    }
}
