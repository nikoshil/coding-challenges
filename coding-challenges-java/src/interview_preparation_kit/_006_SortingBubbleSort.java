package interview_preparation_kit;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm.
Once sorted, print the following three lines:
 - 'Array is sorted in N swaps'.
 - 'First Element: L'
 - 'Last Element: M'

- given:
3 2 1
- the function should return:
Array is sorted in 3 swaps'
First Element: 1
Last Element: 2

 */

public class _006_SortingBubbleSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a list to sort!");
        String inputClouds = scanner.nextLine();

        List<Integer> list= Arrays.stream(inputClouds.split(" "))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        countSwaps(list);

        scanner.close();

    }

    public static void countSwaps(List<Integer> list) {
        int swaps = 0;
        boolean swapped;

        for (int i = 0; i < list.size(); i++) {
            swapped = false;
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                    swaps++;
                }
            }

            if (!swapped) {
                break;
            }
        }

        System.out.format("Array is sorted in %s swaps.\n", swaps);
        System.out.format("First Element: %s\n", list.get(0));
        System.out.format("Last Element: %s\n", list.get(list.size() - 1));

    }

}
