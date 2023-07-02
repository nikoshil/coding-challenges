package ten_days_of_statistics;

/*
A manufacturer of metal pistons finds that, on average, 12% of the pistons they manufacture are rejected because they are
incorrectly sized. What is the probability that a batch of 10 pistons will contain:
 - No more than 2 rejects?
 - At least 2 rejects?

Input:
12 (%)
10
Output:
0,891
0,342

 */

import java.util.Scanner;

public class _07_BinomialDistributionII {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double faultRate = Double.parseDouble(scanner.nextLine()) / 100;
        int batchSize = scanner.nextInt();

        // no more than two rejects: 8
        int r1 = 8;
        // at least two rejects: 2
        int r2 = 2;


        System.out.format("%.3f%n", calculateCumulativeProbability(batchSize, r1, faultRate));
        System.out.format("%.3f%n", calculateCumulativeProbability(batchSize, r2, 1 - faultRate));

        scanner.close();
    }

    private static double calculateCumulativeProbability(int n, int sample, double rate) {
        double cumulativeProbability = 0.0;

        for (int i = sample; i <= n; i++) {
            cumulativeProbability = cumulativeProbability +
                    calculateCombinations(n, i) *
                            Math.pow(1 - rate, i) *
                            Math.pow(rate, n - i);
        }

        return cumulativeProbability;
    }

    private static long calculateCombinations(int n, int r) {
        if (n == r) return 1;
        else return calculateFactorial(n) / (calculateFactorial(r) * calculateFactorial(n - r));
    }

    private static long calculateFactorial(int n) {
        long factorial = n;
        for (int i = 1; i < n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

}
