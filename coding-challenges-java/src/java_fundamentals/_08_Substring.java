package java_fundamentals;

import java.util.Scanner;

public class _08_Substring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        System.out.println(s.substring(start, end));

        scanner.close();
    }

}
