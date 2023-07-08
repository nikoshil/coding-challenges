package ten_days_of_statistics;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Pxy = COV(x, y) / STDy * STDy

Input:
10
10 9.8 8 7.8 7.7 7 6 5 4 2
200 44 32 24 22 17 15 12 8 4
Output:
0.612

Input:
10
10 9.8 8 7.8 7.7 7 6 15 4 2
200 414 32 24 212 17 15 12 8 4
Output:
0.299

Given:
10
10 9.8 8 7.8 7.7 7 16 115 4 2
200 414 32 24 212 17 15 12 8 4
Output:
-0.182

 */

public class _17_PearsonCorrelationCoefficient {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double n = Double.parseDouble(scanner.nextLine());
        String sX = scanner.nextLine();
        String sY = scanner.nextLine();
        List<Double> listX = Arrays.stream(sX.split(" "))
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
        List<Double> listY = Arrays.stream(sY.split(" "))
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());

        System.out.format("%.3f%n", calculateCorrelationCoefficient(
                n,
                calculateMean(n, listX),
                calculateMean(n, listY),
                listX,
                listY));

        scanner.close();

    }

    private static double calculateCorrelationCoefficient(double n, double meanX, double meanY, List<Double> listX, List<Double> listY) {
        return calculateCovariance(n, meanX, meanY, listX, listY) /
                (calculateStandardDeviation(n, listX) * calculateStandardDeviation(n, listY));
    }

    private static double calculateCovariance(double n, double meanX, double meanY, List<Double> listX, List<Double> listY) {
        double sumDeviations = 0.0;
        for (int i = 0; i < n; i++) {
            sumDeviations = sumDeviations + (listX.get(i) - meanX) * (listY.get(i) - meanY);
        }
        return sumDeviations / n;
    }

    public static double calculateStandardDeviation(double n, List<Double> list) {

        double mean = calculateMean(n, list);

        double variance = calculateVariance(n, mean, list);

        return Math.sqrt(variance);
    }

    private static double calculateVariance(double n, double mean, List<Double> list) {
        double sumDeviations = 0.0;
        for (double number : list) {
            sumDeviations = sumDeviations + Math.pow(number - mean, 2);
        }
        return sumDeviations / n;
    }

    private static double calculateMean(double n, List<Double> list) {
        double sum = 0;
        for (double number : list) {
            sum += number;
        }
        return sum / n;
    }

}