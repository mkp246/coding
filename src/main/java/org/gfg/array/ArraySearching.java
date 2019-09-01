package org.gfg.array;

public class ArraySearching {

    public static int searchInUnsortedArray(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1; // key not found in array 
    }

    public static void insertInEndOfArray(int[] array, int key, int total, int capacity) {
        if (total >= capacity) {
            throw new UnsupportedOperationException();
        }
        array[total] = key;
    }

    public static int deleteElementOfArray(int[] array, int key, int length) {
        boolean found = false;
        for (int i = 0; i < length; i++) {
            if (!found) {
                if (array[i] == key) {
                    found = true;
                }
            } else {
                array[i - 1] = array[i];
            }
        }
        return found ? length - 1 : length;
    }

    public static int binarySearchInSortedArray(int[] array, int start, int end, int key) {
        if (start <= end) {
            int mid = Util.getMid(start, end);
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                return binarySearchInSortedArray(array, start, mid - 1, key);
            } else {
                return binarySearchInSortedArray(array, mid + 1, end, key);
            }
        } else {
            return -1;
        }
    }
}
