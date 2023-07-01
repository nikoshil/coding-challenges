package hackerrank;

import java.util.Scanner;

/*

An avid hiker keeps meticulous records of their hikes. For every step he notes U if it was uphill, or D if it was downhill.
Hikes always start and end at sea level, and each step up or down represents a unit change in altitude.

 - A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with
 a step-down to sea level.
 - A valley is a sequence of consecutive steps below sea level, starting with a step-down from sea level and ending with
 a step-up to sea level.

Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.

- given:
22
UDDDUDUUDUDUDUUUDDDUDU
- the function should return:
6

 */

public class _004_CountingValleys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many steps?");
        String inputNumberOfSteps = scanner.nextLine();
        int numberOfSteps = Integer.parseInt(inputNumberOfSteps);
        System.out.println("What is the sequence?");
        String inputSequence = scanner.nextLine();

        System.out.println(countingValleys(numberOfSteps, inputSequence));

        scanner.close();
    }

    public static int countingValleys(int steps, String path) {

        int valleysCount = 0;
        int level = 0;

        for (int i = 0; i < steps; i++) {

            if (level == 0 & path.charAt(i) == 'D') {
                valleysCount++;
            }

            if (path.charAt(i) == 'U') level++;
            else if (path.charAt(i) == 'D') level--;

        }

        return valleysCount;

    }

}
