package misc.sorting;

/*
Insertion Sort is a simple comparison-based sorting algorithm that builds the final sorted list one item at a time. It
iterates through the list, comparing each element with the previous elements and inserting it into the correct position.
Time Complexity: O(n^2) in the worst and average case, and O(n) in the best case (when the input list is already sorted).
 */

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {5, 63, 4, 2, 99, 75, 34, 12, 9, 55, 54, 53, 52, 1, 6, 50, 77, 12, 92, 33};
        insertionSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
