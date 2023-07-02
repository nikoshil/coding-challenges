package ten_days_of_statistics;

import java.util.Scanner;

/*
The probability that a machine produces a defective product is 1 / 3.
What is the probability that the 1st defect occurs WITHIN the first 5 items produced?

The first line contains the respective space-separated numerator and denominator for the probability of a defect, and
the second line contains the size of the production batch:

Input:
1 3
5
Output:
0,868

 */

public class _09_GeometricDistributionII {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double faultRate = scanner.nextDouble() / scanner.nextDouble();
        int batchSize = scanner.nextInt();

        double cumulativeGeometricProbability = 0.0;
        for (int i = 1; i <= batchSize; i++) {
            cumulativeGeometricProbability = cumulativeGeometricProbability + Math.pow(1 - faultRate, batchSize - i) * faultRate;
        }

        System.out.format("%.3f%n", cumulativeGeometricProbability);

        scanner.close();
    }

}
