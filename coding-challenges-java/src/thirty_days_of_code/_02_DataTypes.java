package thirty_days_of_code;

import java.util.Scanner;

/*
The manager of an industrial plant is planning to buy a machine of either type A or type B. For each day’s operation:
 - The number of repairs, X, that machine A needs is a Poisson random variable with mean 0,88.
   The daily cost of operating it is CA = 160 + 40X²
 - The number of repairs, Y, that machine B needs is a Poisson random variable with mean 1,55.
   The daily cost of operating it is CB = 128 + 40Y²
Assume that the repairs take a negligible amount of time and the machines are maintained nightly to ensure that they
operate like new at the start of each day. Find and print the expected daily cost for each machine.

Input:
12
4.0
is the best place to learn and practice coding!
Output:
16
8.0
HackerRank is the best place to learn and practice coding!

 */

public class _02_DataTypes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int var1 = Integer.parseInt(scanner.nextLine());
        double var2 = Double.parseDouble(scanner.nextLine());
        String var3 = scanner.nextLine();

        System.out.println(var1 + 4);
        System.out.println(var2 + 4.0);
        System.out.println("HackerRank " + var3);

        scanner.close();

    }

}
