package mathematics;

import java.util.Scanner;

public class _01_Factorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(calculateFactorial(n));

    }

    private static long calculateFactorial(int n) {
        long factorial = n;
        for (int i = 1; i < n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

}
