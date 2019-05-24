package org.gfg.array;

public class ArraySearch {
    public void findInSortedAndRotatedArray(int[] array, int key) {

    }

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
}
