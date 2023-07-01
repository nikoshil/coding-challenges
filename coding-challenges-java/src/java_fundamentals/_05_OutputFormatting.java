package java_fundamentals;

import java.util.Scanner;

/*
Each String is left-justified with trailing whitespace through the first 15 characters.
The leading digit of the integer is the 16th character, and each integer that was less than 3 digits now has leading zeroes.


- given:
java 100
cpp 65
python 50
- the function should return:
================================
java           100
cpp            065
python         050
================================

 */
public class _05_OutputFormatting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s = scanner.next();
            int x = scanner.nextInt();
            System.out.printf("%-15s%03d%n", s, x);

        }
        System.out.println("================================");

        scanner.close();

    }

}
