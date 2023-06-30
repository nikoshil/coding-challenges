package ten_days_of_statistics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
Input 1: the number of elements in the array
Input 2: the array
Output: the standard deviation rounded to a scale of 1 decimal place

- given:
5
10 40 30 50 20
- the function should return:
14.1
 */

public class _05_StandardDeviation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        List<Integer> list = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .toList();

        System.out.printf("%.1f%n", calculateStandardDeviation(n, list));

        scanner.close();
    }

    public static double calculateStandardDeviation(int n, List<Integer> list) {

        double mean = calculateMean(n, list);

        double variance = calculateVariance(n, mean, list);

        return Math.sqrt(variance);
    }

    private static double calculateVariance(int n, double mean, List<Integer> list) {
        double sumDeviations = 0.0;
        for (int number : list) {
            sumDeviations = sumDeviations + Math.pow(number - mean, 2);
        }
        return sumDeviations / n;
    }

    private static double calculateMean(int n, List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return (double) sum / n;
    }

}
