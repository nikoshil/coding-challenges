package java_fundamentals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
Given a string, S, and an integer, N, complete the function so that it finds the lexicographically smallest and largest
substrings of N length .

- given:
welcometojava
3
- the function should return:
ava
wel

 */

public class _09_SubstringComparisons {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length() - 2; i++) {
            list.add(s.substring(i, 3 + i));
        }

        list.sort(Comparator.naturalOrder());

        System.out.println(list.get(0));
        System.out.println(list.get(list.size() - 1));

        scanner.close();
    }

}
