package ten_days_of_statistics;

import java.util.Scanner;

/*
A random variable, X, follows Poisson distribution with mean of 2.5. Find the probability with which the random variable is equal to 5.

Input:
2,5
5
Output:
0,067

 */
public class _10_PoissonDistributionI {

    private static final double EULERS_NUMBER = 2.71828;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double mean = scanner.nextDouble();
        double actual = scanner.nextDouble();

        System.out.format("%.3f%n", calculatePoisson(mean, actual));

        scanner.close();
    }

    private static double calculatePoisson(double mean, double actual) {
        return Math.pow(mean, actual) * Math.pow(EULERS_NUMBER, -mean) / calculateFactorial(actual);
    }

    private static double calculateFactorial(double n) {
        double factorial = n;
        for (int i = 1; i < n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

}
