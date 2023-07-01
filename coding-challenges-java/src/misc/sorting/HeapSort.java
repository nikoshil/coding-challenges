package misc.sorting;

import java.util.Arrays;

/*
Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure. It builds a max heap from the
input list, repeatedly extracts the maximum element from the heap and places it in the sorted region.
Time Complexity: O(n log n) in all cases. It has a guaranteed worst-case performance and is an in-place algorithm.

 */
public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {5, 63, 4, 2, 99, 75, 34, 12, 9, 55, 54, 53, 52, 1, 6, 50, 77, 12, 92, 33};
        heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

}
