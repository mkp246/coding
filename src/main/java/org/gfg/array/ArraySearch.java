package org.gfg.array;

public class ArraySearch {
    public static int binarySearch(int[] array, int startIndex, int endIndex, int key) {
        if (startIndex > endIndex) return -1;
        int midIndex = (startIndex + endIndex) / 2;
        if (array[midIndex] == key) {
            return midIndex;
        } else if (array[midIndex] > key) {
            return binarySearch(array, startIndex, midIndex - 1, key);
        } else {
            return binarySearch(array, midIndex + 1, endIndex, key);
        }
    }

    /**
     * finds index of smallest number in sorted and rotated array
     *
     * @param array      array
     * @param startIndex start from what index inclusive
     * @param endIndex   till what index in array to look inclusive
     * @return index of pivot
     */
    public static int findPivot(int[] array, int startIndex, int endIndex) {
        if (startIndex > endIndex) return -1;
        int midIndex = (startIndex + endIndex) / 2;
        if (midIndex == 0) return -1; //pivot can't be at zero, means no rotation
        if (array[midIndex] < array[midIndex - 1]) {
            return midIndex;
        } else if (array[midIndex] < array[endIndex]) {
            return findPivot(array, startIndex, midIndex - 1);
        } else {
            return findPivot(array, midIndex + 1, endIndex);
        }
    }

    public static int findInSortedAndRotatedArray(int[] array, int key) {
        int pivot = findPivot(array, 0, array.length - 1);
        if (pivot == -1) return binarySearch(array, 0, array.length - 1, key); //no rotation
        if (key < array[0]) {
            return binarySearch(array, pivot, array.length - 1, key);
        } else {
            return binarySearch(array, 0, pivot - 1, key);
        }
    }
}
