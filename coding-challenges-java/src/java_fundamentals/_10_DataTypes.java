package java_fundamentals;

import java.util.Scanner;

/*
Java has 8 primitive data types; char, boolean, byte, short, int, long, float, and double.
 - A byte is an 8-bit signed integer.
 - A short is a 16-bit signed integer.
 - An int is a 32-bit signed integer.
 - A long is a 64-bit signed integer.
Given an input integer, you must determine which primitive data types are capable of properly storing that input.

- given:
5
-150
150000
1500000000
213333333333333333333333333333333333
-100000000000000
- the function should return:
-150 can be fitted in:
* short
* int
* long
150000 can be fitted in:
* int
* long
1500000000 can be fitted in:
* int
* long
213333333333333333333333333333333333 can't be fitted anywhere.
-100000000000000 can be fitted in:
* long

 */

public class _10_DataTypes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            try {
                long x = scanner.nextLong();
                System.out.println(x + " can be fitted in:");
                if (x >= -128 && x <= 127) System.out.println("* byte \n* short \n* int \n* long");
                else if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) System.out.println("* short \n* int \n* long");
                else if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) System.out.println("* int \n* long");
                else System.out.println("* long");
            } catch (Exception e) {
                System.out.println(scanner.next() + " can't be fitted anywhere.");
            }
        }

        scanner.close();

    }

}