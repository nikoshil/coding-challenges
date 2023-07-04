package ten_days_of_statistics;

import java.util.Scanner;

/*
You have a sample of 100 values from a population with mean 500 and with standard deviation 80. Compute the interval
that covers the middle 95% of the distribution of the sample mean; in other words, compute A and B such that
P(A < x < B) = 0,95. Use a z-score of 1,96.

Input:
100  - sample size
500  - sample mean
80   - sample std
0,95 - distribution percentage
1,96 - z-score
Output:
484,32
515,68

 */

public class _16_TheCentralLimitTheoremIII {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double sampleSize = scanner.nextDouble();
        double sampleMean = scanner.nextDouble();
        double sampleSTD = scanner.nextDouble();
        double confidenceInterval = scanner.nextDouble();
        double zScore = scanner.nextDouble();

        double marginOfError = zScore * sampleSTD / Math.sqrt(sampleSize);

        System.out.format("%.2f%n", sampleMean - marginOfError);
        System.out.format("%.2f%n", sampleMean + marginOfError);
    }

}
