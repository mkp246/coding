package org.gfg.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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

    public static int searchInArrayWhereAdjacentDifferenceIsOne(int[] array, int key) {
        int i = 0;
        while (i < array.length) {
            if (array[i] == key) {
                return i;
            } else {
                i += Math.abs(array[i] - key);
            }
        }
        return -1;
    }

    public static int searchInArrayWhereAdjacentDifferenceIsAtMostK(int[] array, int key, int maxDiff) {
        int i = 0;
        while (i < array.length) {
            if (array[i] == key) {
                return i;
            } else {
                i += Math.ceil(Math.abs(array[i] - key) / (double) maxDiff);
            }
        }
        return -1;
    }

    public static int[] findCommonInThreeSortedArray(int[] array1, int[] array2, int[] array3) {
        int len1 = array1.length;
        int len2 = array2.length;
        int len3 = array3.length;
        int pos1, pos2, pos3;
        pos1 = pos2 = pos3 = 0;
        List<Integer> result = new ArrayList<>();

        while (pos1 < len1 && pos2 < len2 && pos3 < len3) {
            if (array1[pos1] == array2[pos2]) {
                while (array3[pos3] < array1[pos1]) {
                    pos3++;
                }
                if (array3[pos3] == array1[pos1]) {
                    result.add(array1[pos1]);
                    pos3++;
                }
                pos1++;
                pos2++;
            } else if (array1[pos1] > array2[pos2]) {
                pos2++;
            } else {
                pos1++;
            }
        }
        return Occurance.intListToArray(result);
    }

    public static int findElementInInfiniteSortedArray(int[] array, int key) {
        int start = 0;
        int end = 1;
        while (end < array.length) {
            if (key <= array[end]) {
                return binarySearchInSortedArray(array, start, end, key);
            } else {
                start = end + 1;
                end *= 2;
                end = Math.min(end, array.length - 1);
            }
        }
        return -1;
    }

    public static int findOnlyRepetitiveElementInUnsortedArray1ToNMinus1UsingSumFormula(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int max = array.length - 1;
        int sum1ToNMinus1 = max * (max + 1) / 2;
        return sum - sum1ToNMinus1;
    }

    public static int findOnlyRepetitiveElementInUnsortedArray1ToNMinus1UsingHashing(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : array) {
            if (set.contains(element)) {
                return element;
            } else {
                set.add(element);
            }
        }
        return -1;
    }

    public static int testFindOnlyRepetitiveElementInUnsortedArray1ToNUsingXor(int[] array) {
        int xor = 0;
        for (int element : array) {
            xor ^= element;
        }
        int max = array.length - 1;
        int elementToXor = (max + 1) % 4;
        int xor1TONMinus1 = 0;
        for (int i = 0; i < elementToXor; i++) {
            xor1TONMinus1 ^= max--;
        }
        return xor ^ xor1TONMinus1;
    }

    public static int findElementAppearingOnceWhereOtherAppearTwiceUsingXor(int[] array) {
        int result = 0;
        for (int element : array) {
            result ^= element;
        }
        return result;
    }

    public static int maxSubarraySumExcludingCertainElement(int[] array, int[] exclude) {
        Arrays.sort(exclude);
        int maxSum = 0;
        int maxSumSoFar = 0;
        for (int i = 0; i < array.length; i++) {
            maxSumSoFar += array[i];
            if (binarySearchInSortedArray(exclude, 0, exclude.length - 1, array[i]) != -1) {
                maxSumSoFar = 0;
            } else if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
            } else if (maxSumSoFar > maxSum) {
                maxSum = maxSumSoFar;
            }
        }
        return maxSum;
    }
}
