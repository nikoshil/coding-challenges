package ten_days_of_statistics;

import java.util.*;
import java.util.stream.Collectors;

/*
Rank - the relative position label of the observations within the variable
The Spearman correlation between two variables is equal to the Pearson correlation between the rank values of those two variables

For a sample of size N, the N raw scores Xi , Yi are converted to ranks R(Xi), R(Yi), and Rs is computed as
Rs = COV(Rx, Ry) / STDRx * STDRy

Input:
10
10 9.8 8 7.8 7.7 1.7 6 5 1.4 2
200 44 32 24 22 17 15 12 8 4
Output:
0.903

 */

public class _18_SpearmanRankCorrelationCoefficient_Duplicates {

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

        List<Double> ranksX = produceRanks(listX);
        List<Double> ranksY = produceRanks(listY);

        System.out.format("%.3f%n", calculateCorrelationCoefficient(
                n,
                calculateMean(n, ranksX),
                calculateMean(n, ranksY),
                ranksX,
                ranksY));

        scanner.close();

    }

    private static List<Double> produceRanks(List<Double> numbers) {

        Map<Double, Double> numberRanks = new LinkedHashMap<>();
        List<Double> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        double rank = 1.0;
        for (Double number : sortedNumbers) {
            if (!numberRanks.containsKey(number)) {
                numberRanks.put(number, rank++);
            }
        }

        List<Double> ranks = new ArrayList<>();
        for (Double number : numbers) {
            ranks.add(numberRanks.get(number));
        }

        return ranks;
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