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
}
