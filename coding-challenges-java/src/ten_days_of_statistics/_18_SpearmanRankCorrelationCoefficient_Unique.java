package ten_days_of_statistics;

import java.util.*;
import java.util.stream.Collectors;

/*
Rank - the relative position label of the observations within the variable
The Spearman correlation between two variables is equal to the Pearson correlation between the rank values of those two variables

Rs = COV(Rx, Ry) / STDRy * STDRy

Input:
10
10 9.8 8 7.8 7.7 1.7 6 5 1.4 2
200 44 32 24 22 17 15 12 8 4
Output:
0.903

 */

public class _18_SpearmanRankCorrelationCoefficient_Unique {

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

        System.out.format("%.3f%n", calculateSpearmanRankCorrelationCoefficient(n, listX, listY));

        scanner.close();

    }

    private static List<Integer> produceRanks(List<Double> numbers) {

        Map<Double, Integer> numberRanks = new LinkedHashMap<>();
        List<Double> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        int rank = 1;
        for (Double number : sortedNumbers) {
            if (!numberRanks.containsKey(number)) {
                numberRanks.put(number, rank++);
            }
        }

        List<Integer> ranks = new ArrayList<>();
        for (Double number : numbers) {
            ranks.add(numberRanks.get(number));
        }

        return ranks;
    }

    private static double calculateSumRankPairDifferences(double n, List<Integer> ranksX, List<Integer> ranksY) {
        double sumDeviations = 0.0;
        for (int i = 0; i < n; i++) {
            sumDeviations = sumDeviations + Math.pow((ranksX.get(i) - ranksY.get(i)), 2);
        }
        return sumDeviations;
    }

    private static double calculateSpearmanRankCorrelationCoefficient(double n, List<Double> listX, List<Double> listY) {
        return
                1 -
                (6 * calculateSumRankPairDifferences(n, produceRanks(listX), produceRanks(listY))) /
                (n * (Math.pow(n, 2) - 1));
    }

}