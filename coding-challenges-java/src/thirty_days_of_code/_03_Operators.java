package thirty_days_of_code;

import java.util.Scanner;

/*
Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip), and tax
percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost.
Round the result to the nearest integer.

Input:
12,00
20
8
Output:
15

 */

public class _03_Operators {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double mealCost = scanner.nextDouble();
        int tipPercent = scanner.nextInt();
        int taxPercent = scanner.nextInt();

        solve(mealCost, tipPercent, taxPercent);

        scanner.close();

    }

    public static void solve(double mealCost, int tipPercent, int taxPercent) {
        System.out.format("%.0f%n", mealCost * (1 + (double) tipPercent / 100) + mealCost * taxPercent / 100);
    }

}
