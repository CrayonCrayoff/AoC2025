import java.util.List;

public class Day01Part1 {

    public static void main(String[] args) {
        List<String> lines = FileReader.readLines("day01input.txt");

        int currentValue = 50;
        int zeroCounter = 0;

        for (String line : lines) {
            int clicks = Integer.parseInt(line.substring(1));

            if (line.charAt(0) == 'L') {
                currentValue -= clicks;
            } else {
                currentValue += clicks;
            }

            // reset currentValue to be in the range of 0-99
            if (currentValue < 0) currentValue += 1000;  // += 1000 because clicks can be up to 999
            currentValue %= 100;

            if (currentValue == 0) zeroCounter++;

        }

        System.out.println(zeroCounter);
    }
}
