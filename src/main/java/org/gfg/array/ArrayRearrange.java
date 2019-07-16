package org.gfg.array;

import java.util.Arrays;
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

    public static void rearrangeArrayInIncreasingDecreasingOrderUsingSorting(int[] array) {
        int[] temp = new int[array.length];
        int oddPos = array.length / 2;
        int evenPos = array.length - oddPos;

        System.arraycopy(array, 0, temp, 0, array.length);
        Arrays.sort(temp);
        //copying even part in order will also work instead of reverse order
        for (int i = 0; i < evenPos; i++) {
            array[2 * i] = temp[evenPos - 1 - i];
        }

        for (int i = 0; i < oddPos; i++) {
            array[2 * i + 1] = temp[i + evenPos];
        }
    }

    public static void rearrangeArrayInIncreasingDecreasingOrderBySwappingAdjacentElement(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (i % 2 == 0) { //even position, next element should increase
                if (array[i] > array[i + 1]) {
                    swapWithNext(array, i);
                }
            } else {
                if (array[i] < array[i + 1]) {
                    swapWithNext(array, i);
                }
            }
        }
    }

    public static void swapIndex(int[] array, int src, int dest) {
        int temp = array[src];
        array[src] = array[dest];
        array[dest] = temp;
    }

    public static void swapWithNext(int[] array, int src) {
        swapIndex(array, src, src + 1);
    }

    public static void rearrangeAlternatePositiveNegative(int[] array) {
        //segregate negative at start using QuickSort partition 
        int negativesUptoIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                swapIndex(array, i, ++negativesUptoIndex);
            }
        }
        //swap alternate negatives with positives
        int pos = negativesUptoIndex + 1;
        int neg = 0;
        while (neg < pos && pos < array.length && array[neg] < 0) {
            swapIndex(array, neg, pos);
            neg += 2;
            pos++;
        }
    }

    public static void rearrangeAlternateNegativePositiveUsingSubarrayRightRotate(int[] array) {
        int outOfOrder = -1;
        for (int index = 0; index < array.length; index++) {
            if (outOfOrder >= 0) {
                if ((array[index] >= 0 && array[outOfOrder] < 0) || array[index] < 0 && array[outOfOrder] >= 0) {
                    rotateRight(array, outOfOrder, index);
                    if (index - outOfOrder > 2) {
                        outOfOrder += 2;
                    } else {
                        outOfOrder = -1;
                    }
                }
            }
            if (outOfOrder == -1) {
                if ((array[index] >= 0 && index % 2 == 0) || (array[index] < 0 && index % 2 == 1)) {
                    outOfOrder = index;
                }
            }
        }
    }

    private static void rotateRight(int[] array, int start, int end) {
        int temp = array[end];
        for (int i = end; i > start; i--) {
            array[i] = array[i - 1];
        }
        array[start] = temp;
    }
}
