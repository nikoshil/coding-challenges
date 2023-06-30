package ten_days_of_statistics;

import java.util.*;

/*
Input 1: number of elements in the array
Input 2: the array
Output 1: mean
Output 2: median
Output 3: mode (if more than one such value exists, print the numerically smallest one)

- given:
10
64630 11735 14216 99233 14470 4978 73429 38120 51135 67060
- the function should return:
43900.6
44627.5
4978
 */

public class _01_MeanMedianMode {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        String[] sArray = s.split(" ");

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(sArray[i]);
        }

        System.out.println(calculateMean(n, numbers));
        System.out.println(calculateMedian(n, numbers));
        System.out.println(calculateMode(n, numbers));

        scanner.close();
    }

    private static double calculateMean(int n, int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / n;
    }

    private static int calculateMode(int n, int[] numbers) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        int mode = 0;
        for (int number : numbers) {
            int frequency = frequencyMap.getOrDefault(number, 0) + 1;
            frequencyMap.put(number, frequency);
            mode = Math.max(mode, frequency);
        }

        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == mode) {
                modes.add(entry.getKey());
            }
        }

        Collections.sort(modes);
        return modes.get(0);

    }

    private static double calculateMedian(int n, int[] array) {

        List<Integer> numbers = Arrays.asList(
                Arrays.stream(array)
                .boxed()
                .toArray(Integer[]::new));
        numbers.sort(Comparator.naturalOrder());

        if (n % 2 != 0) return numbers.get(n / 2);
        else return (numbers.get(n / 2) + numbers.get(n / 2 - 1)) / 2.0;
    }

}
