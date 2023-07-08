package mathematics;

import java.util.Arrays;
import java.util.Scanner;

/*
The average of a set of values calculated using the product of the values rather than their sum.

given:
10 20 30 40 50 60
output:
29.93795165523908

 */

public class _05_GeometricMean {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(calculateMean(numbers.length, numbers));

        scanner.close();

    }

    private static double calculateMean(double n, int[] numbers) {
        double sum = 1.0;
        for (int number : numbers) {
            sum *= number;
        }
        return Math.pow(sum, 1.0 / n);
    }

}
