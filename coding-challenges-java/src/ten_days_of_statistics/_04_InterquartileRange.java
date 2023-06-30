package ten_days_of_statistics;

import java.util.*;

/*
Input 1: an array of values
Input 2: an array of frequencies
Output: the difference between the first and third quartiles of the newly formed list

- given:
6 12 8 10 20 16
5 4 3 2 1 5
(a list of [6, 6, 6, 6, 6, 8, 8, 8, 10, 10 12, 12, 12, 12, 16, 16, 16, 16, 16, 20] is formed)
- the function should return:
9.0

- given:
1 2 3
3 2 1
(a list of [1, 1, 1, 2, 2, 3] is formed)
- the function should return:
1.0

- given:
10 40 30 50 20
1 2 3 4 5
(a list of [10, 40, 40, 30, 30, 30, 50, 50, 50, 50, 20, 20, 20, 20, 20] is formed)
- the function should return:
30.0

 */

public class _04_InterquartileRange {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        List<Integer> values = Arrays.stream(s1.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        String s2 = scanner.nextLine();
        List<Integer> frequencies = Arrays.stream(s2.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        System.out.println(interQuartile(values, frequencies));

        scanner.close();
    }

    public static double interQuartile(List<Integer> values, List<Integer> frequencies) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < frequencies.get(i); j++) {
                list.add(values.get(i));
            }
        }
        list.sort(Comparator.naturalOrder());

        return calculateMedian(list.subList(list.size() / 2 + ((list.size() % 2 != 0) ? 1 : 0), list.size()))-
                calculateMedian(list.subList(0, list.size() / 2 - ((list.size() % 2 != 0) ? 1 : 0)));

    }

    private static double calculateMedian(List<Integer> list) {
        if (list.size() % 2 == 0) return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        else return list.get(list.size() / 2);
    }

}