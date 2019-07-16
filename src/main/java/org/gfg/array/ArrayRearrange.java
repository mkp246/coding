package org.gfg.array;

import java.util.HashSet;

public class ArrayRearrange {

    /**
     * rearrange such that arr[i] = i, if element not present then -1
     *
     * @param array
     */
    public static void rearrangeAiIsI(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //if A[i] = -1 or i do nothing
            if (array[i] != -1 && array[i] != i) {
                int x = array[i];
                while (array[x] != -1 && array[x] != x) {
                    int y = array[x];
                    array[x] = x;
                    x = y;
                }
                array[x] = x;
                if (array[i] != i) {
                    array[i] = -1;
                }
            }
        }
    }

    public static void rearrangeAiIsIUsingHashSet(int[] array) {
        HashSet<Integer> integers = new HashSet<>();
        for (int element : array) {
            integers.add(element);
        }
        for (int i = 0; i < array.length; i++) {
            if (integers.contains(i)) {
                array[i] = i;
            } else {
                array[i] = -1;
            }
        }
    }

    public static void rearrangeAiIsIUsingSwap(int[] array) {
        for (int i = 0; i < array.length; ) {
            if (array[i] != -1 && array[i] != i) {
                array[array[i]] = array[array[i]] + array[i] - (array[i] = array[array[i]]);
            } else {
                i++;
            }
        }
    }

    public static void reverseArray(int[] array, int start, int end) {
        int temp;
        while (start < end) {
            temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
    }
}
