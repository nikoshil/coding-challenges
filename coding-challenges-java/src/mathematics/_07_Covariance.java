package mathematics;

/*
Covariance is a measure of the joint variability of two random variables.

given:
10 20 30 40 50 60
12 26 34 52 68 94
6
output:
461.6666666666667

 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _07_Covariance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String sX = scanner.nextLine();
        String sY = scanner.nextLine();
        int n = scanner.nextInt();
        List<Integer> listX = Arrays.stream(sX.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .toList();
        List<Integer> listY = Arrays.stream(sY.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .toList();

        System.out.println(calculateCovariance(
                n,
                calculateMean(n, listX),
                calculateMean(n, listY),
                listX,
                listY));

        scanner.close();

    }

    private static double calculateCovariance(int n, double meanX, double meanY, List<Integer> listX, List<Integer> listY) {
        double sumDeviations = 0.0;
        for (int i = 0; i < n; i++) {
            sumDeviations = sumDeviations + (listX.get(i) - meanX) * (listY.get(i) - meanY);
        }
        return sumDeviations / n;
    }


    private static double calculateMean(int n, List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return (double) sum / n;
    }

}