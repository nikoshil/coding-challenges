package java_fundamentals;

import java.util.Scanner;

/*
The first line contains an integer, Q, denoting the number of queries.
Each line I of the Q subsequent lines contains three space-separated integers describing the respective Ai, Bi, and Ni values for that query.
For each query, print the corresponding series on a new line. Each series must be printed in order as a single line of N space-separated integers.

- given:
2
0 2 10
5 3 5
- the function should return:
2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98

 */

public class _07_LoopsII {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int m = scanner.nextInt();
            int res = 0;
            for (int j = 0; j < m; j++) {
                res = a += (int) Math.pow(2, j) * b;
                System.out.print(res + " ");
            }
        }

        scanner.close();

    }

}
