package ten_days_of_statistics;

import java.util.Scanner;

/*
A large elevator can transport a maximum of 9800 pounds. Suppose a load of cargo containing 49 boxes must be transported
via the elevator. The box weight of this type of cargo follows a distribution with a mean of 205 pounds and a standard
deviation of 15 pounds. Based on this information, what is the probability that all 49 boxes can be safely loaded into
the freight elevator and transported?

Input:
9800
49
205
15
Output:
0,0098

 */

public class _14_TheCentralLimitTheoremI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double maxWeight = scanner.nextDouble();
        double n = scanner.nextDouble();
        double mean = scanner.nextDouble();
        double std = scanner.nextDouble();

        double sampleMean = n * mean;
        double sampleSTD  = Math.sqrt(n) * std;

        System.out.format("%.4f", calculateCumulativeNormalDistribution(sampleMean, sampleSTD, maxWeight));

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
