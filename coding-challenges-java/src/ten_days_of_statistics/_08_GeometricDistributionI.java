package ten_days_of_statistics;

/*
The probability that a machine produces a defective product is 1 / 3.
What is the probability that the 1st defect occurs the 5th item produced?

The first line contains the respective space-separated numerator and denominator for the probability of a defect, and
the second line contains the inspection we want the probability of being the first defect for:

Input:
1 3
5
Output:
0,066

 */

import java.util.Scanner;

public class _08_GeometricDistributionI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double faultRate = scanner.nextDouble() / scanner.nextDouble();
        int batchSize = scanner.nextInt();

        System.out.format("%.3f%n", calculateGeometricProbability(faultRate, batchSize));

        scanner.close();
    }

    private static double calculateGeometricProbability(double rate, int sample) {
        return Math.pow(1 - rate, sample - 1) * rate;
    }

}
