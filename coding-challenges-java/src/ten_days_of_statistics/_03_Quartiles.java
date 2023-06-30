package ten_days_of_statistics;

import java.util.*;
import java.util.stream.Collectors;

/*
Input 1: the number of elements in the array
Input 2: the array
Output:
 - The first quartile is the middle number between the smallest number in a data set and its median.
 - The second quartile is the median of the data set.
 - The third quartile is the middle number between a data set's median and its largest number.

- given:
9
3 7 8 5 12 14 21 13 18
- the function should return:
6
12
16

- given:
10
1 3 5 7 9 2 4 6 8 10
- the function should return:
3
5
8

- given:
12
4 17 7 14 18 12 3 16 10 4 4 12
- the function should return:
4
11
15

- given:
10
3 7 8 5 12 14 21 15 18 14
- the function should return:
7
13
15

 */

public class _03_Quartiles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        List<Integer> list = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println(calculate(n, list));

        scanner.close();
    }

    public static List<Integer> calculate(int n, List<Integer> list) {

        List<Integer> output = new ArrayList<>();

        if (n % 2 == 0) {
            if ((n / 2) % 2 == 0) {
                output.add((list.get(n / 4) + list.get(n / 4 - 1)) / 2);
                output.add((list.get(n / 2) + list.get(n / 2 - 1)) / 2);
                output.add((list.get((n / 4) * 3) + list.get(n / 4 * 3 - 1)) / 2);
            } else {
                output.add(list.get(n / 4));
                output.add((list.get(n / 2) + list.get(n / 2 - 1)) / 2);
                output.add(list.get((n / 4) * 3) + 1);
            }
        }

        if (n % 2 != 0) {
            if ((n / 2) % 2 == 0) {
                output.add((list.get(n / 4) + list.get(n / 4 - 1)) / 2);
                output.add(list.get(n / 2));
                output.add((list.get((n / 4) * 3 + 1) + list.get((n / 4) * 3)) / 2);
            } else {
                output.add((list.get(n / 4) + list.get(n / 4 - 1)) / 2);
                output.add(list.get(n / 2));
                output.add((list.get((n / 4) * 3) + list.get((n / 4) * 3 - 1)) / 2);
            }
        }

        return output;

    }


}
