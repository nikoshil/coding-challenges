package misc.sorting;

/*
Selection Sort is a simple comparison-based sorting algorithm. It divides the input list into a sorted and an unsorted
region. It repeatedly finds the minimum element from the unsorted region and swaps it with the leftmost unsorted element.
Time Complexity: O(n^2) in all cases, as it always requires scanning the entire unsorted region.
 */

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {5, 63, 4, 2, 99, 75, 34, 12, 9, 55, 54, 53, 52, 1, 6, 50, 77, 12, 92, 33};
        selectionSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

}
