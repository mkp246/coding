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

    public static int[] findElementHavingAtLeastTwoGreaterBySorting(int[] array) {
        Arrays.sort(array);
        int[] result = new int[array.length - 2];
        System.arraycopy(array, 0, result, 0, result.length);
        return result;
    }

    public static int[] findElementHavingAtLeastTwoGreaterByFindingSecondMaximum(int[] array) {
        int first, second;
        first = second = array[0];

        for (int element : array) {
            if (element > first) {
                second = first;
                first = element;
            } else if (element > second) {
                second = element;
            }
        }

        int[] result = new int[array.length - 2];
        int resultPos = 0;
        for (int element : array) {
            if (element < second) {
                result[resultPos++] = element;
            }
        }
        return result;
    }
}
