package mathematics;

import java.util.Scanner;

public class _02_Permutations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        System.out.println(calculatePermutations(n, r));

    }

    private static long calculatePermutations(int n, int r) {
        return calculateFactorial(n) / calculateFactorial(n - r);
    }

    private static long calculateFactorial(int n) {
        long factorial = n;
        for (int i = 1; i < n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

}
