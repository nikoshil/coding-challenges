package ten_days_of_statistics;

/*
Input 1: the number of elements in both arrays
Input 2: an array of values
Input 3: an array of weights
Output: (float) the weighted mean to one decimal place

- given:
5
10 40 30 50 20
1 2 3 4 5
- the function should return:
32.0

- given:
20
10 40 30 50 20 10 40 30 50 20 1 2 3 4 5 6 7 8 9 10
1 2 3 4 5 6 7 8 9 10 10 40 30 50 20 10 40 30 50 20
- the function should return:
9.6
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _02_WeightedMean {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String s1 = scanner.nextLine();
        List<Integer> values = Arrays.stream(s1.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        String s2 = scanner.nextLine();
        List<Integer> weights = Arrays.stream(s2.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        System.out.printf("%.1f%n", weightedMean(n, values, weights));

        scanner.close();
    }

    public static double weightedMean(int n, List<Integer> values, List<Integer> weights) {

        int weightedValues = 0;
        int weightsDivisor = 0;
        for (int i = 0; i < n; i++) {
            weightedValues = weightedValues + (values.get(i) * weights.get(i));
            weightsDivisor = weightsDivisor + weights.get(i);
        }

        return (double) weightedValues / weightsDivisor;

    }

}
