package java_fundamentals;

import java.time.LocalDate;
import java.util.Scanner;

/*
You are given a date. You just need to write the method, getDay(), which returns the day on that date. To simplify your task,
we have provided a portion of the code in the editor.

- given:
08
05
2015
- the function should return:
WEDNESDAY

 */

public class _12_DateAndTime {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int month = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println(findDay(month, day, year));

    }

    public static String findDay(int month, int day, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.getDayOfWeek().toString();
    }

}
