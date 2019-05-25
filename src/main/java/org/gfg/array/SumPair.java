package org.gfg.array;

import java.util.Arrays;
import java.util.HashSet;

public class SumPair {
    public static boolean hasUnsortedArrayTwoCandidatesUsingSorting(int[] array, int sum) {
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        int tempSum;
        while (left < right) {
            tempSum = array[left] + array[right];
            if (tempSum == sum) {
                return true;
            } else if (tempSum < sum) {
                left++;
            } else {
                right--;
            }
        }
        return false; // No pair found
    }

    public static int[] getUnsortedArraySumPairUsingHashing(int[] array, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : array) {
            if (set.contains(sum - element)) {
                return new int[]{sum - element, element};
            } else {
                set.add(element);
            }
        }
        return null;
    }

    public static boolean hasSortedAndRotatedArrayTwoCandidates(int[] array, int sum) {
        int pivot = ArraySearch.findPivot(array, 0, array.length - 1);
        int lower = pivot;
        int higher = pivot - 1;
        int tempSum;
        while (lower != higher) {
            tempSum = array[lower] + array[higher];
            if (tempSum == sum) {
                return true;
            } else if (tempSum < sum) {
                lower = (lower + 1) % array.length;
            } else {
                higher = (higher - 1 + array.length) % array.length;
            }
        }
        return false;
    }
}
