package mathematics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
Variance is a measure of dispersion, meaning it is a measure of how far a set of numbers is spread out from their average value.

given:
10 20 30 40 50 60
output:
Population variance:
291.6666666666667
Sample variance:
350.0

 */

public class _04_Variance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Integer> list = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .toList();
        int n = list.size();

        System.out.println("Population variance:");
        System.out.println(calculatePopulationVariance(n, calculateMean(n, list), list));
        System.out.println("Sample variance:");
        System.out.println(calculateSampleVariance(n, calculateMean(n, list), list));

        scanner.close();

    }

    private static double calculatePopulationVariance(int n, double mean, List<Integer> list) {
        double sumDeviations = 0.0;
        for (int number : list) {
            sumDeviations = sumDeviations + Math.pow(number - mean, 2);
        }
        return sumDeviations / n;
    }

    private static double calculateSampleVariance(int n, double mean, List<Integer> list) {
        double sumDeviations = 0.0;
        for (int number : list) {
            sumDeviations = sumDeviations + Math.pow(number - mean, 2);
        }
        // Bessel's correction:
        return sumDeviations / (n - 1);
    }

    private static double calculateMean(int n, List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return (double) sum / n;
    }

}
