package ten_days_of_statistics;

import java.util.Scanner;

/*
The final grades for a Physics exam taken by a large group of students has a mean of 70 and a standard deviation of 10.
If we can approximate the distribution of these grades by a normal distribution, what percentage of the students:
 - scored higher than 80 (grade > 80)
 - passed the test (grade >= 60)
 - failed the test (grade < 60)

Input:
70 10
80
60
Output:
15,87
84,13
15,87

 */

public class _13_NormalDistributionII {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double mean = scanner.nextDouble();
        double std = scanner.nextDouble();
        double grade1 = scanner.nextDouble();
        double grade2 = scanner.nextDouble();

        System.out.format("%.2f%n", 100 * (1 - calculateCumulativeNormalDistribution(mean, std, grade1)));
        System.out.format("%.2f%n", 100 * (1 - calculateCumulativeNormalDistribution(mean, std, grade2)));
        System.out.format("%.2f%n", 100 * calculateCumulativeNormalDistribution(mean, std, grade2));

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
