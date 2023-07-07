package thirty_days_of_code;

import java.util.Scanner;

public class _01_HelloWorld {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, World.");
        System.out.println(scanner.nextLine());

        scanner.close();

    }

}
