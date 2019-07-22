package org.gfg.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Stack;

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

    public static void replaceWithLargestOnRight(int[] array) {
        int max = array[array.length - 1];
        int tmpMax;
        array[array.length - 1] = -1;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] >= max) {
                tmpMax = max;
                max = array[i];
                array[i] = tmpMax;
            } else {
                array[i] = max;
            }
        }
    }

    public static int maxCircularSum(int[] array) {
        int kadane = findLargestSumContinuousSubarray(array)[2];
        int arraySum = 0;
        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];
            array[i] *= -1;
        }
        int wrapKadane = arraySum + findLargestSumContinuousSubarray(array)[2];

        return Math.max(kadane, wrapKadane);
    }

    @SuppressWarnings("Duplicates")
    public static int LISByDPTabulation(int[] array) {
        int[] lis = new int[array.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int result = 0;
        for (int element : lis) {
            if (element > result) {
                result = element;
            }
        }
        return result;
    }

    public static int LISInNLogN(int[] array) {
        int[] tailTable = new int[array.length];
        int len; //points to empty slot

        tailTable[0] = array[0];
        len = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < tailTable[0]) { //smallest, create new entry
                tailTable[0] = array[i];
            } else if (array[i] > tailTable[len - 1]) {
                tailTable[len++] = array[i];
            } else {
                tailTable[ceilIndex(tailTable, -1, len - 1, array[i])] = array[i];
            }
        }
        return len;
    }

    private static int ceilIndex(int[] array, int left, int right, int key) {
        int middle;
        while (left + 1 < right) {
            middle = left + (right - left) / 2;
            if (array[middle] >= key) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    /**
     * same as above but gives sub sequence instead of length
     *
     * @param array
     * @return
     */
    public static int[] LISInNLogNSequence(int[] array) {
        int[] tailIndicies = new int[array.length];
        int[] prevIndicies = new int[array.length];

        int len; //points to empty slot
        Arrays.fill(tailIndicies, 0);
        Arrays.fill(prevIndicies, -1);

        len = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[tailIndicies[0]]) { //smallest, create new entry
                tailIndicies[0] = i;
            } else if (array[i] > array[tailIndicies[len - 1]]) {
                prevIndicies[i] = tailIndicies[len - 1];
                tailIndicies[len++] = i;
            } else {
                int pos = ceilIndex(array, tailIndicies, -1, len - 1, array[i]);
                prevIndicies[i] = tailIndicies[pos - 1];
                tailIndicies[pos] = i;
            }
        }
        int[] result = new int[len];
        int resultPos = len - 1;
        for (int i = tailIndicies[len - 1]; i >= 0; i = prevIndicies[i]) {
            result[resultPos--] = array[i];
        }
        return result;
    }

    private static int ceilIndex(int[] array, int[] tailIndicies, int left, int right, int key) {
        int middle;
        while (left + 1 < right) {
            middle = left + (right - left) / 2;
            if (array[tailIndicies[middle]] >= key) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    public static int maxSumConsecutiveDifferenceCircularArray(int[] array) {
        Arrays.sort(array);
        int halfLen = array.length / 2;
        int sum = 0;
        for (int i = 0; i < halfLen; i++) { //in case of odd length, middle element is added and removed once 
            sum -= 2 * array[i];
            sum += 2 * array[array.length - 1 - i];
        }
        return sum;
    }

    public static void sortAccordingToOrderDefined(int[] array, int[] order) {
        int[] temp = new int[array.length];
        boolean[] visited = new boolean[array.length];

        System.arraycopy(array, 0, temp, 0, array.length);
        Arrays.fill(visited, false);
        Arrays.sort(temp);

        int first, arrayIndex = 0, firstValue;

        for (int i = 0; i < order.length; i++) {
            first = getFirst(temp, order[i]);
            if (first != -1) {
                firstValue = temp[first];
                while (first < temp.length && temp[first] == firstValue) {
                    array[arrayIndex++] = firstValue;
                    visited[first] = true;
                    first++;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                array[arrayIndex++] = temp[i];
            }
        }
    }

    public static int getFirst(int[] array, int key) {
        int low = 0, high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (array[mid] == key && (mid == 0 || array[mid - 1] < array[mid])) {
                return mid;
            } else if (array[mid] >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * longest ones subarray after replacing single zero with one
     *
     * @param array
     * @return [index, length of longest ones after replacing 0 at index]
     */
    public static int[] longestContinuousOnesAfterReplacingSingleZeroInBinaryString(int[] array) {
        int prevZero = -1, prevPrevZero = -1, maxSoFarPrev = -1;
        int maxSoFar = 0, tempLength;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                tempLength = i - prevPrevZero - 1;
                if (tempLength > maxSoFar) {
                    maxSoFar = tempLength;
                    maxSoFarPrev = prevZero;
                }
                prevPrevZero = prevZero;
                prevZero = i;
            }
        }
        tempLength = array.length - prevPrevZero - 1;
        if (tempLength > maxSoFar) {
            maxSoFar = tempLength;
            maxSoFarPrev = prevZero;
        }
        return new int[]{maxSoFarPrev, maxSoFar};
    }

    public static void threeWayPartitionAroundRange(int[] array, int low, int high) {
        int start = 0, end = array.length - 1;
        for (int i = 0; i <= end; ) {
            if (array[i] < low) {
                swapIndex(array, i, start++);
                i++;
            } else if (array[i] > high) {
                swapIndex(array, i, end--);
            } else {
                i++;
            }
        }
    }

    public static List<int[]> generateAllPossibleSortedArrayFromAlternateElement(int[] a, int[] b) {
        List<int[]> result = new ArrayList<>();
        int[] c = new int[a.length + b.length];
        int aPos = 0, bPos = 0, cPos = 0;
        generateAllPossibleSortedArrayFromAlternateElementUntil(a, aPos, b, bPos, c, cPos, true, result);
        return result;
    }

    private static void generateAllPossibleSortedArrayFromAlternateElementUntil(int[] a, int aPos, int[] b, int bPos, int[] c, int cPos, boolean takeFromA, List<int[]> result) {
        if (takeFromA) {
            if (cPos != 0) {//append to result, current c till cPos 
                int[] temp = new int[cPos];
                System.arraycopy(c, 0, temp, 0, temp.length);
                result.add(temp);
            }
            for (int i = aPos; i < a.length; i++) {
                if (cPos == 0 || c[cPos - 1] < a[i]) {
                    c[cPos] = a[i];
                    generateAllPossibleSortedArrayFromAlternateElementUntil(a, i + 1, b, bPos, c, cPos + 1, false, result);
                }
            }
        } else {
            for (int i = bPos; i < b.length; i++) {
                if (c[cPos - 1] < b[i]) {
                    c[cPos] = b[i];
                    generateAllPossibleSortedArrayFromAlternateElementUntil(a, aPos, b, i + 1, c, cPos + 1, true, result);
                }
            }
        }
    }

    public static int fromMinimumNumberFromDISequenceUsingStack(String sequence) {
        Stack<Integer> stack = new Stack<>();
        String result = "";
        for (int i = 0; i <= sequence.length(); i++) {
            stack.push(i + 1);
            if (i == sequence.length() || sequence.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result += stack.pop();
                }
            }
        }
        return Integer.parseInt(result);
    }
}
