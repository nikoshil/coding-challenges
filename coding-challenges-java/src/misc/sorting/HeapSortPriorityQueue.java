package misc.sorting;

import java.util.*;

/*
Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure. It builds a max heap from the
input list, repeatedly extracts the maximum element from the heap and places it in the sorted region.
Time Complexity: O(n log n) in all cases. It has a guaranteed worst-case performance and is an in-place algorithm.

 */

public class HeapSortPriorityQueue {

    public static void main(String[] args) {

        int[] arr = {5, 63, 4, 2, 99, 75, 34, 12, 9, 55, 54, 53, 52, 1, 6, 50, 77, 12, 92, 33};
        heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void heapSort(int[] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int j : arr) {
            maxHeap.offer(j);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.poll();
        }
    }

}