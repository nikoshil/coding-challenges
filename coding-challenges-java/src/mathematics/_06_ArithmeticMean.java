package mathematics;

import java.util.Arrays;
import java.util.Scanner;

/*
given:
10 20 30 40 50 60
output:
35

 */

public class _06_ArithmeticMean {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(calculateMean(numbers.length, numbers));

        scanner.close();

    }

    private static double calculateMean(int n, int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / n;
    }

}
