package misc.sorting;

/*
Bubble Sort is a simple comparison-based sorting algorithm. It repeatedly compares adjacent elements and swaps them if
they are in the wrong order until the entire list is sorted.
Time Complexity: O(n^2) in the worst and average case, and O(n) in the best case (when the input list is already sorted).
 */

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {5, 63, 4, 2, 99, 75, 34, 12, 9, 55, 54, 53, 52, 1, 6, 50, 77, 12, 92, 33};
        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
