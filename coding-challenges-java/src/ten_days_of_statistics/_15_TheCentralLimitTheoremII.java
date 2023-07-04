package ten_days_of_statistics;

import java.util.Scanner;

/*
The number of tickets purchased by each student for the University X vs. University Y football game follows a distribution
that has a mean of 2.4 and a standard deviation of 2.0. A few hours before the game starts, 100 eager students line up to
purchase last-minute tickets. If there are only tickets 250 left, what is the probability that all students will be able
to purchase tickets?

Input:
250
100
2,4
2,0
Output:
0,6915

 */

public class _15_TheCentralLimitTheoremII {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double ticketsLeft = scanner.nextDouble();
        double ticketsExpected = scanner.nextDouble();
        double mean = scanner.nextDouble();
        double std = scanner.nextDouble();

        double sampleMean = ticketsExpected * mean;
        double sampleSTD  = Math.sqrt(ticketsExpected) * std;

        System.out.format("%.4f", calculateCumulativeNormalDistribution(sampleMean, sampleSTD, ticketsLeft));

        scanner.close();
    }

    public static double calculateCumulativeNormalDistribution(double mean, double std, double x) {
        return 0.5 * (1.0 + erf((x - mean) / (std * Math.sqrt(2))));
    }

    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));
        double ans = 1 - t * Math.exp(-z * z - 1.26551223 +
                t * (1.00002368 +
                t * (0.37409196 +
                t * (0.09678418 +
                t * (-0.18628806 +
                t * (0.27886807 +
                t * (-1.13520398 +
                t * (1.48851587 +
                t * (-0.82215223 +
                t * (0.17087277))))))))));
        if (z >= 0) return ans;
        else return -ans;
    }

}
