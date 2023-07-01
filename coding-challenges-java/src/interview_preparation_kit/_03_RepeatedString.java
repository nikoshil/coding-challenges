package interview_preparation_kit;

import java.util.Scanner;

/*
There is a string S of lowercase English letters that is repeated infinitely many times. Given an integer N find and print
the number of letter a's in the first N letters of the infinite string.

- given:
abcac
22
- the function should return:
9

The substring we consider is 'abcacabcacabcacabcaca', the first characters 22 of the infinite string. There are  9occurrences
of 'a' in the substring.  */

public class _03_RepeatedString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me the character sequence string!");
        String s = scanner.nextLine();
        System.out.println("How many repeats?");
        String inputN = scanner.nextLine();
        long n = Integer.parseInt(inputN);

        System.out.println(repeatedString(s, n));

        scanner.close();
    }

    public static long repeatedString(String s, long n) {

        long counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('a' == s.charAt(i)) counter++;
        }
        counter = counter * (n / s.length());

        long residualLength = n % s.length();
        for (int i = 0; i < residualLength; i++) {
            if ('a' == s.charAt(i)) counter++;
        }

        return counter;

    }

}
