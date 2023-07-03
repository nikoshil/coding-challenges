package ten_days_of_statistics;

import java.util.Scanner;

/*
The manager of an industrial plant is planning to buy a machine of either type A or type B. For each day’s operation:
 - The number of repairs, X, that machine A needs is a Poisson random variable with mean 0,88.
   The daily cost of operating it is CA = 160 + 40X²
 - The number of repairs, Y, that machine B needs is a Poisson random variable with mean 1,55.
   The daily cost of operating it is CB = 128 + 40Y²
Assume that the repairs take a negligible amount of time and the machines are maintained nightly to ensure that they
operate like new at the start of each day. Find and print the expected daily cost for each machine.

Input: A single line comprised of 2 space-separated values denoting the respective means for A and B:
0,88 1,55
Output:
0,067
0,067

 */

public class _11_PoissonDistributionII {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double meanA = scanner.nextDouble();
        double meanB = scanner.nextDouble();

        System.out.format("%.3f%n", 160 + 40 * (meanA + Math.pow(meanA, 2)));
        System.out.format("%.3f%n", 128 + 40 * (meanB + Math.pow(meanB, 2)));

        scanner.close();
    }

}
