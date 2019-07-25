package org.gfg.array;

import java.util.Arrays;

public class OrderStatistics {
    public static int getKthSmallestNumberUsingSorting(int[] array, int k) {
        Arrays.sort(array);
        return array[k - 1];
    }

    public static int getKthSmallestNumberUsingPartition(int[] array, int start, int end, int k) {
        if (end - start + 1 >= k) {
            int pos = partition(array, start, end);
            if (pos - start == k - 1) {
                return array[pos];
            } else if (pos - start > k - 1) {
                return getKthSmallestNumberUsingPartition(array, start, pos - 1, k);
            } else {
                return getKthSmallestNumberUsingPartition(array, pos + 1, end, k - pos + start - 1);
            }
        }
        return 0;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                ArrayRearrange.swapIndex(array, i, start++);
            }
        }
        ArrayRearrange.swapIndex(array, start, end);
        return start;
    }

    public static int findLargestElement(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static int[] findThreeLargestElement(int[] array) {
        int first, second, third;
        first = second = third = array[0];
        for (int element : array) {
            if (element > first) {
                third = second;
                second = first;
                first = element;
            } else if (element > second) {
                third = second;
                second = element;
            } else if (element > third) {
                third = element;
            }
        }
        return new int[]{first, second, third};
    }
}
