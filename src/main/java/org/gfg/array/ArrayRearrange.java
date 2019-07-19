package org.gfg.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

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

    public static void moveAllNegativeToStartPositiveToEnd(int[] array) {
        int negPos = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                swapIndex(array, i, ++negPos);
            }
        }
    }

    public static void sortArrayInWaveForm(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i += 2) {
            swapIndex(array, i, i + 1);
        }
    }

    public static void rearrangePosAtEvenNegAtOdd(int[] array) {
        int evenPos = 0, oddPos = 1;
        while (evenPos < array.length && oddPos < array.length) {
            while (evenPos < array.length && array[evenPos] >= 0) {
                evenPos += 2;
            }
            if (evenPos < array.length) {
                while (oddPos < array.length && array[oddPos] < 0) {
                    oddPos += 2;
                }
                if (oddPos < array.length) {
                    swapIndex(array, evenPos, oddPos);
                    evenPos += 2;
                    oddPos += 2;
                }
            }
        }
    }

    public static void rearrangePosAtEvenNegAtOddUsingSwapWithNextDefective(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1 && array[i] >= 0) {
                for (int j = i + 1; j < array.length; j++) {
                    if (j % 2 == 0 && array[j] < 0) {
                        swapIndex(array, i, j);
                        break;
                    }
                }
            } else if (i % 2 == 0 && array[i] < 0) {
                for (int j = i + 1; j < array.length; j++) {
                    if (j % 2 == 1 && array[j] >= 0) {
                        swapIndex(array, i, j);
                        break;
                    }
                }
            }
        }
    }

    public static void replaceWithMultOfPreviousAndNext(int[] array) {
        int prev = array[0], temPrev;
        array[0] *= array[1];
        for (int i = 1; i < array.length - 1; i++) {
            temPrev = array[i];
            array[i] = prev * array[i + 1];
            prev = temPrev;
        }
        array[array.length - 1] *= prev;
    }

    public static void shuffleArrayUsingFisherYatesAlgorithm(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            swapIndex(array, i, random.nextInt(i + 1));
        }
    }

    public static void segregateEvenAndOdd(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 == 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 1) {
                right--;
            }
            if (left < right) {
                swapIndex(array, left, right);
                left++;
                right--;
            }
        }
    }

    public static void segregateEvenAndOddUsingTempArray(int[] array) {
        int[] temp = new int[array.length];
        int start = 0, end = array.length - 1;
        for (int element : array) {
            if (element % 2 == 0) {
                temp[start++] = element;
            } else {
                temp[end--] = element;
            }
        }
        System.arraycopy(temp, 0, array, 0, array.length);
    }

    public static void segregateZeroAndOneByCounting(int[] array) {
        int zeroCount = 0;
        for (int element : array) {
            if (element == 0) zeroCount++;
        }
        for (int i = 0; i < zeroCount; i++) {
            array[i] = 0;
        }
        for (int i = zeroCount; i < array.length; i++) {
            array[i] = 1;
        }
    }

    @SuppressWarnings("Duplicates")
    public static int longestBitonicSubsequence(int[] array) {
        int[] lis = new int[array.length];
        int[] lds = new int[array.length];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (int i = array.length - 2; i >= 0; i--) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[i] > array[j] && lds[j] + 1 > lds[i]) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int lbs = 0;
        for (int i = 0; i < array.length; i++) {
            if (lis[i] + lds[i] > lbs) lbs = lis[i] + lds[i];
        }
        return lbs - 1;
    }

    public static int[] find3Numbers(int[] array) {
        int[] smaller = new int[array.length];
        int[] larger = new int[array.length];

        int minIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[minIdx] >= array[i]) {
                smaller[i] = -1;
                minIdx = i;
            } else {
                smaller[i] = minIdx;
            }
        }

        int maxIdx = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] >= array[maxIdx]) {
                larger[i] = -1;
                maxIdx = i;
            } else {
                larger[i] = maxIdx;
            }
        }
        int[] result = null;
        for (int i = 0; i < array.length; i++) {
            if (smaller[i] != -1 && larger[i] != -1) {
                result = new int[3];
                result[0] = array[smaller[i]];
                result[1] = array[i];
                result[2] = array[larger[i]];
                break;
            }
        }
        return result;
    }

    public static int[] findLargestSubarrayWithEqualZeroAndOnes(int[] array) {
        array[0] = array[0] == 0 ? -1 : 1;
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + (array[i] == 0 ? -1 : 1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0, maxStart = 0, maxEnd = 0;

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                if (i - map.get(array[i]) > maxLength) {
                    maxStart = map.get(array[i]);
                    maxEnd = i;
                    maxLength = i - map.get(array[i]);
                }
            } else {
                map.put(array[i], i);
            }
        }
        int[] result = null;
        if (maxLength > 0) {
            result = new int[2];
            result[0] = maxStart + 1;
            result[1] = maxEnd;
        }
        return result;
    }

    /**
     * Kadane’s algorithm
     *
     * @param array
     * @return [startOfSubarray endOfSubarray, maxSum]
     */
    public static int[] findLargestSumContinuousSubarray(int[] array) {
        int maxSoFar = 0, maxEndingHere = 0;
        int start = 0, end = 0;
        for (int i = 0; i < array.length; i++) {
            maxEndingHere += array[i]; //in case of all negative(init mSF=mEH=a[0]) take max of maxEndingHere, maxEndingHere+array[i]
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                start = i + 1;
            } else if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }
        return new int[]{start, end, maxSoFar};
    }

    public static int findLargestProductContinuousSubarray(int[] array) {
        int maxEndingHere = 1, minEndingHere = 1, maxSoFar = 1;
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                maxEndingHere *= array[i];
                minEndingHere = Math.min(minEndingHere * array[i], 1);// update only if negative
                flag = 1;
            } else if (array[i] == 0) {
                maxEndingHere = 1;
                minEndingHere = 1;
            } else {
                int temp = maxEndingHere;
                maxEndingHere = Math.max(minEndingHere * array[i], 1);
                minEndingHere = temp * array[i];
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }
        if (flag == 0 && maxSoFar == 1) {
            return 0;
        } else {
            return maxSoFar;
        }
    }
}
