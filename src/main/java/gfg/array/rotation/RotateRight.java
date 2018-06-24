package gfg.array.rotation;

import gfg.array.Search;

/**
 * https://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/
 */

public class RotateRight {
    public static void rotate(int[] array) {
        int lastIndex = array.length - 1;
        int temp = array[lastIndex];
        while (lastIndex > 0) {
            array[lastIndex] = array[lastIndex - 1];
            lastIndex--;
        }
        array[0] = temp;
    }

    public static int pivotedBinarySearch(int[] array, int key) {
        int pivot = Search.findPivot(array, 0, array.length - 1);
        if (pivot == -1) return Search.binarySearch(array, 0, array.length - 1, key);
        if (array[pivot] == key) {
            return pivot;
        }
        if (key >= array[0]) {
            return Search.binarySearch(array, 0, pivot - 1, key);
        } else {
            return Search.binarySearch(array, pivot + 1, array.length - 1, key);
        }
    }

    public static boolean pairInSortedRotated(int[] array, int sum) {
        int pivot = Search.findPivot(array, 0, array.length - 1);
        int maxIndex;
        int minIndex;
        if (pivot != -1) {
            maxIndex = pivot;
            minIndex = (maxIndex + 1) % array.length;
        } else {
            maxIndex = pivot;
            minIndex = (maxIndex + 1) % array.length;
        }
        int currentSum;
        while (maxIndex != minIndex) {
            currentSum = array[minIndex] + array[maxIndex];
            if (currentSum == sum) return true;
            else if (currentSum > sum) {
                maxIndex = (maxIndex - 1 + array.length) % array.length;
            } else {
                minIndex = (minIndex + 1) % array.length;
            }
        }
        return false;
    }
}
