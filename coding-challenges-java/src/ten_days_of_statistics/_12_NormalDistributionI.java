package ten_days_of_statistics;

import java.util.Scanner;

/*
In a certain plant, the time taken to assemble a car is a random variable, X, having a normal distribution with a mean
of 20 hours and a standard deviation of 2 hours. What is the probability that a car can be assembled at this plant in:
- Less than 19,5 hours?
- Between 20 and 22 hours?

Input:
20 2
19,5
20 22
Output:
0,401
0,341

 */

public class _12_NormalDistributionI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double mean = scanner.nextDouble();
        double std = scanner.nextDouble();
        double h1 = scanner.nextDouble();
        double h2 = scanner.nextDouble();
        double h3 = scanner.nextDouble();

        System.out.format("%.3f%n", calculateCumulativeNormalDistribution(mean, std, h1));
        System.out.format("%.3f%n", calculateCumulativeNormalDistribution(mean, std, h3) - calculateCumulativeNormalDistribution(mean, std, h2));

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
