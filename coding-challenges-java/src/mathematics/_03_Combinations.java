package mathematics;

import java.util.Scanner;

public class _03_Combinations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        System.out.println(calculateCombinations(n, r));

    }

    private static long calculateCombinations(int n, int r) {
        return calculateFactorial(n) / (calculateFactorial(r) * calculateFactorial(n - r));
    }

    private static long calculateFactorial(int n) {
        long factorial = n;
        for (int i = 1; i < n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }



}
