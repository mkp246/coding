package org.gfg.array;

import java.util.Arrays;

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
}
