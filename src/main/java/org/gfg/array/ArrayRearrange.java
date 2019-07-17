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

    public static void moveAllZerosToEnd(int[] array) {
        int count = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                array[++count] = array[i];
            }
        }
        for (int i = count + 1; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public static int minSwapToBringTogether(int[] array, int lessThanOrEqual) {
        int count = 0;
        for (int element : array) {
            if (element <= lessThanOrEqual) count++;
        }
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (array[i] > lessThanOrEqual) bad++;
        }
        int minSwaps = bad;
        for (int start = 0, end = count; end < array.length; start++, end++) {
            if (array[start] > lessThanOrEqual) bad--;
            if (array[end] > lessThanOrEqual) bad++;

            if (bad < minSwaps) {
                minSwaps = bad;
            }
        }
        return minSwaps;
    }

    public static void rearrangeAlternatePositiveNegativeUsingInbuiltSort(Integer[] array) {
        Arrays.sort(array, (o1, o2) -> {
            if (o1 <= 0 && o2 > 0) {
                return -1;
            } else {
                return +1;
            }
        });
    }

    public static int[] rearrangeMinMax(int[] array) {
        Arrays.sort(array);
        int[] temp = new int[array.length];
        int i, j;
        for (i = 0, j = array.length - 1; i < j; i++, j--) {
            temp[2 * i] = array[i];
            temp[2 * i + 1] = array[j];
        }
        if (i == j) {
            temp[2 * i] = array[i];
        }
        return temp;
    }

    public static void doubleFirstElementAndPushZerosToEnd(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != 0 && (array[i] == array[i + 1])) {
                array[i] *= 2;
                array[i + 1] = 0;
                i++;// as next element is set to zero, no need to check again  
            }
        }
        moveAllZerosToEnd(array);
    }

    public static void reorderAccordingToGivenIndexUsingTempArray(int[] array, int[] index) {
        int[] temp = new int[array.length];
        for (int i = 0; i < index.length; i++) {
            temp[index[i]] = array[i];
        }
        System.arraycopy(temp, 0, array, 0, array.length);
    }

    public static void reorderAccordingToGivenIndexUsingSwapping(int[] array, int[] index) {
        for (int i = 0; i < index.length; ) {
            if (index[i] == i) {
                i++;
            } else {
                swapIndex(array, index[i], i);
                swapIndex(index, index[i], i);
            }
        }
    }

    public static void rearrangeArrIJBecomesArrJIUsingTempArray(int[] array) {
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            temp[array[i]] = i;
        }
        System.arraycopy(temp, 0, array, 0, array.length);
    }


    public static void rearrangeArrIJBecomesArrJIUsingSwapForSingleCycle(int[] array) {
        int index = 0, value = array[0];
        int tempValue;
        while (value != 0) {
            tempValue = array[value];
            array[value] = index;

            index = value;
            value = tempValue;
        }
        array[0] = index;
    }

    public static void rearrangeArrIJBecomesArrJIUsingSwapForMultiCycle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]++;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                int index = i, value = array[i] - 1;
                int tempValue;
                while (value != i) {
                    tempValue = array[value] - 1;
                    array[value] = -(index + 1);

                    index = value;
                    value = tempValue;
                }
                array[i] = -(index + 1);
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
            array[i]--;
        }
    }

    public static void rearrangeArrIJBecomesArrJIUsingQuotientAndReminder(int[] array) {
        int targetIndex;
        for (int i = 0; i < array.length; i++) {
            targetIndex = array[i] % array.length;
            array[targetIndex] += i * array.length;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] /= array.length;
        }
    }

    public static void rearrangeMaxMinUsingQuotientAndReminder(int[] array) {
        int maxElement = array[array.length - 1] + 1;
        int i, j;
        for (i = 0, j = array.length - 1; i < j; i++, j--) {
            array[2 * i] += (array[j] % maxElement) * maxElement;
            array[2 * i + 1] += (array[i] % maxElement) * maxElement;
        }
        if (i == j) {
            array[2 * i] += (array[j] % maxElement) * maxElement;
        }
        for (i = 0; i < array.length; i++) {
            array[i] /= maxElement;
        }
    }
}
