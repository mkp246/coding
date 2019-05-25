package org.gfg.array;

import java.util.Arrays;

public class DiffPair {
    private static final int MAX = 100000;

    public static int countDiffPairUsingSefBalancingBST(int[] array, int diff) {
        return 0;
    }

    /**
     * max element is supposed to 1e5;
     * use index based hashing to check if element is present or not
     */
    public static int countDiffPairUsingHashing(int[] array, int diff) {
        boolean[] map = new boolean[MAX];   //simple index based hashing
        int count = 0;
        for (int element : array) {
            if (!map[element]) {
                try {
                    if (map[element + diff]) count++;
                } catch (IndexOutOfBoundsException e) {
                    //
                }
                try {
                    if (map[element - diff]) count++;
                } catch (IndexOutOfBoundsException e) {
                    //
                }
                map[element] = true;
            }
        }
        return count;
    }

    public static int countDiffPairUsingSorting(int[] array, int diff) {
        Arrays.sort(array);
        int count = 0;
        int left = 0, right = 0;
        int tempDiff;
        while (right < array.length) {
            tempDiff = array[right] - array[left];
            if (tempDiff == diff) {
                count++;
                left++;
                right++;
            } else if (tempDiff < diff) {
                right++;
            } else {
                left++;
            }
        }
        return count;
    }
}
