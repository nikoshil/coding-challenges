package ten_days_of_statistics;

import java.util.Scanner;

/*
The ratio of boys to girls for babies born in Russia is 1.09 to 1. If there is 1 child born per birth, what proportion
of Russian families with exactly 6 children will have at 3 least boys?

Output:
0,696

 */

public class _06_BinomialDistributionI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 1.09
        double boysBirthRate = Double.parseDouble(scanner.nextLine());
        // 1
        double girlsBirthRate = Double.parseDouble(scanner.nextLine());

        // children in family: 6
        int n = 6;
        // at least boys: 3
        int r = 3;

        double cumulativeProbability = 0.0;

        for (int i = r; i <= n; i++) {
            cumulativeProbability = cumulativeProbability +
                    calculateCombinations(n, i) *
                            Math.pow(boysBirthRate / (boysBirthRate + girlsBirthRate), i) *
                            Math.pow(girlsBirthRate / (boysBirthRate + girlsBirthRate), n - i);
        }

        System.out.printf("%.3f", cumulativeProbability);

    }

    private static long calculateCombinations(int n, int r) {
        if (n == r) return 1;
        else return calculateFactorial(n) / (calculateFactorial(r) * calculateFactorial(n - r));
    }

    private static long calculateFactorial(int n) {
        long factorial = n;
        for (int i = 1; i < n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

}
