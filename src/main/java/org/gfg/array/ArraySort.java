package org.gfg.array;

import org.gfg.array.OrderStatistics.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.gfg.array.Occurance.intListToArray;

public class ArraySort {

    public static void sortKSortedArrayUsingInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void sortKSortedArrayUsingMinHeap(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //insert first k+1 element
        for (int i = 0; i <= k; i++) {
            minHeap.add(array[i]);
        }
        int resultPos = 0;
        //remove min, put it in the result, add new element from remaining
        for (int i = k + 1; i < array.length; i++) {
            array[resultPos++] = minHeap.poll();
            minHeap.add(array[i]);
        }
        while (!minHeap.isEmpty()) {
            array[resultPos++] = minHeap.poll();
        }
    }

    public static void sortArrayAccordingToAbsoluteDiffWithGivenValueUsingSelfBalancingBST(int[] array, int x) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(); // key = abs diff with x, value=list of elements
        for (int i = 0; i < array.length; i++) {
            int diff = Math.abs(array[i] - x);
            if (!map.containsKey(diff)) {
                map.put(diff, new ArrayList<>());
            }
            map.get(diff).add(array[i]);
        }
        int resultPos = 0;
        for (List<Integer> list : map.values()) {
            for (Integer element : list) {
                array[resultPos++] = element;
            }
        }
    }

    /**
     * merges both in mNArray, first array only has m valid element
     * used -1 to indicate invalid element
     *
     * @param mNArray
     * @param nArray
     */
    public static void mergeNArrayIntoMPlusNArraySorted(int[] mNArray, int[] nArray) {
        int pos = mNArray.length - 1;
        // move all -1 to start, so we can reuse same array for output
        for (int i = mNArray.length - 1; i >= 0; i--) {
            if (mNArray[i] != -1) {
                ArrayRearrange.swapIndex(mNArray, i, pos--);
            }
        }
        int mNPos = nArray.length;
        int mNLength = mNArray.length;
        int nPos = 0;
        int nLength = nArray.length;
        int resultPos = 0;
        while (mNPos < mNLength || nPos < nLength) {
            if (nPos == nLength || (mNPos != mNLength && mNArray[mNPos] < nArray[nPos])) {
                mNArray[resultPos++] = mNArray[mNPos++];
            } else {
                mNArray[resultPos++] = nArray[nPos++];
            }
        }
    }

    public static void segregateZerosOnLeft(int[] array) {
        int pos = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                ArrayRearrange.swapIndex(array, pos++, i);
            }
        }
    }

    public static int[] findTwoElementsWithSumClosestToZeroUsingSorting(int[] array) {
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        int leftValue = 0;
        int rightValue = 0;
        int minAbsSum = Integer.MAX_VALUE;
        while (left < right) {
            int sum = array[left] + array[right];
            if (Math.abs(sum) < minAbsSum) {
                leftValue = array[left];
                rightValue = array[right];
                minAbsSum = Math.abs(sum);
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{leftValue, rightValue};
    }

    public static int[] findTwoElementsWithSumClosestToZeroUsingSortingUsingAbsoluteSoring(Integer[] array) {
        Arrays.sort(array, Comparator.comparing(Math::abs));
        int minIdx = 0;
        int minAbsValue = Integer.MAX_VALUE;

        for (int i = 0; i < array.length - 1; i++) {
            int sum = Math.abs(array[i] + array[i + 1]);
            if (minAbsValue > sum) {
                minAbsValue = sum;
                minIdx = i;
            }
        }
        return new int[]{array[minIdx], array[minIdx + 1]};
    }

    public static int shortestUnorderedSubarrayLength(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if ((array[i - 1] < array[i] && array[i] > array[i + 1]) || (array[i - 1] > array[i] && array[i] < array[i + 1])) {
                return 3;
            }
        }
        return 0;
    }

    public static int minSwapsRequiredToSortArray(int[] array) {
        Pair<Integer, Integer>[] pairs = new Pair[array.length];
        for (int i = 0; i < array.length; i++) {
            pairs[i] = new Pair<>(array[i], i);
        }
        Arrays.sort(pairs, Comparator.comparing(Pair::getKey));

        int minSwaps = 0;
        boolean[] visited = new boolean[array.length];
        for (int i = 0; i < pairs.length; i++) {
            if (visited[i] || pairs[i].getValue() == i) {
                continue;
            }
            int cycleCount = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j].getValue();
                cycleCount++;
            }
            minSwaps += (cycleCount - 1);
        }
        return minSwaps;
    }

    public static int[][] unionAndIntersectionOfTwoSortedArray(int[] array1, int[] array2) {
        int pos1 = 0, pos2 = 0;
        int len1 = array1.length, len2 = array2.length;

        ArrayList<Integer> union = new ArrayList<>();
        ArrayList<Integer> common = new ArrayList<>();

        while (pos1 < len1 && pos2 < len2) {
            if (array1[pos1] == array2[pos2]) {
                // handling duplicates
                if (union.size() == 0 || union.get(union.size() - 1) != array1[pos1]) {
                    union.add(array1[pos1]); // or array2[pos2]
                    common.add(array1[pos1]);
                }
                pos1++;
                pos2++;
            } else if (array1[pos1] < array2[pos2]) {
                if (union.size() == 0 || union.get(union.size() - 1) != array1[pos1]) {
                    union.add(array1[pos1]);
                }
                pos1++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != array2[pos2]) {
                    union.add(array2[pos2]);
                }
                pos2++;
            }
        }
        //put remaining from un exhausted array to union
        if (pos1 < len1) {
            for (int i = pos1; i < len1; i++) {
                if (union.size() == 0 || union.get(union.size() - 1) != array1[i]) {
                    union.add(array1[i]);
                }
            }
        } else if (pos2 < len2) {
            for (int i = pos2; i < len2; i++) {
                if (union.size() == 0 || union.get(union.size() - 1) != array2[i]) {
                    union.add(array2[i]);
                }
            }
        }
        return new int[][]{intListToArray(union), intListToArray(common)};
    }

    public static void sortArrayOfZerosOnesAndTwos(int[] array) {
        int lPos = 0, rPos = array.length - 1;
        int mid = 0;
        while (mid <= rPos) {
            switch (array[mid]) {
                case 0: {
                    ArrayRearrange.swapIndex(array, mid++, lPos++);
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    ArrayRearrange.swapIndex(array, mid, rPos--);
                    break;
                }
            }
        }
    }

    public static int[] minLengthUnsortedSubarraySortingWhichMakesArraySorted(int[] array) {
        int start = 0, end = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                start = i;
                break;
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i - 1] > array[i]) {
                end = i;
                break;
            }
        }
        int min = array[start], max = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        for (int i = 0; i < start; i++) {
            if (array[i] > min) {
                start = i;
                break;
            }
        }
        for (int i = array.length - 1; i > end; i--) {
            if (array[i] < max) {
                end = i;
                break;
            }
        }
        return new int[]{start, end};
    }

    public static int countNumberOfTrianglePossibleUsingThreeNestedLoop(int[] array) {
        Arrays.sort(array);
        int count = 0;
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = array[i] + array[j];
                for (int k = j + 1; k < length; k++) {
                    if (sum > array[k]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static int countNumberOfTrianglePossibleUsingTwoPointerMethod(int[] array) {
        Arrays.sort(array);
        int count = 0;
        int left, right;

        for (int i = array.length - 1; i >= 2; i--) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (array[left] + array[right] > array[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public static int countXYPairsSuchThatXpowerYGreterThanYpowerX(int[] array1, int[] array2) {
        Arrays.sort(array2);
        int[] noOfY = new int[5];
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] < 5) {
                noOfY[array2[i]]++;
            }
        }
        int result = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                result += 0;
            } else if (array1[i] == 1) {
                result += noOfY[0];
            } else if (array1[i] == 2) {
                int pos = Arrays.binarySearch(array2, 5);
                if (pos < 0) {
                    pos = Math.abs(pos) - 1;
                }
                result += (noOfY[0] + noOfY[1] + array2.length - pos);
            } else if (array1[i] == 3) {
                result += (array2.length - noOfY[3]);
            } else if (array1[i] >= 4) {
                int pos = Arrays.binarySearch(array2, 1 + array1[i]);
                if (pos < 0) {
                    pos = Math.abs(pos) - 1;
                }
                result += (noOfY[0] + noOfY[1] + array2.length - pos);
            }
        }
        return result;
    }

    public static int[] printDistinctElementsUsingHashing(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList();

        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
                result.add(array[i]);
            }
        }
        return intListToArray(result);
    }

    public static int[] constructArrayFromItsPairSumArray(int[] pairSum, int length) {
        int[] array = new int[length]; // pair sum length = n(n-1)/2 where n = array.length
        // a[0]  =  a[0]+a[1]  + a[0]+a[2]  - (a[1]+a[2])          = 2 a[0]
        array[0] = (pairSum[0] + pairSum[1] - pairSum[length - 1]) / 2;
        for (int i = 1; i < length; i++) {
            array[i] = pairSum[i - 1] - array[0];
        }
        return array;
    }

    public static void mergeTwoSortedArrayWithConstantExtraSpace(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;

        for (int i = len2 - 1; i >= 0; i--) {
            int j = len1 - 1;
            int last = array1[j];
            if (last < array2[i]) {
                continue; // already sorted
            }

            while (j >= 1 && array1[j - 1] > array2[i]) {
                array1[j] = array1[j - 1];
                j--;
            }
            array1[j] = array2[i];
            array2[i] = last;
        }
    }

    public static int findProductOfMaxOfFirstAndMinOfSecondArray(int[] array1, int[] array2) {
        int max = array1[0];
        int min = array2[0];
        for (int i = 1; i < array1.length; i++) {
            if (array1[i] > max) {
                max = array1[i];
            }
        }

        for (int i = 1; i < array2.length; i++) {
            if (array2[i] < min) {
                min = array2[i];
            }
        }
        return min * max;
    }

    public static double probabilityOfRandomPairBeingMaximumWeightedTwoArray(int[] array1, int[] array2) {
        int count1 = findMaxCount(array1);
        int count2 = findMaxCount(array2);
        return (count1 * count2) / (double) (array1.length * array2.length);
    }

    private static int findMaxCount(int[] array) {
        int max = array[0], maxCount = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                maxCount++;
            } else if (array[i] > max) {
                max = array[i];
                maxCount = 1;
            }
        }
        return maxCount;
    }

    public static int minimumDearragementPresentInAPArray(int[] array) {
        int[] copy = new int[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        Arrays.sort(copy);

        int mismatchCount1 = 0;
        for (int i = 0; i < copy.length; i++) {
            if (array[i] != copy[i]) {
                mismatchCount1++;
            }
        }

        ArrayRotation.reverseArray(copy, 0, copy.length - 1);
        int mismatchCount2 = 0;
        for (int i = 0; i < copy.length; i++) {
            if (array[i] != copy[i]) {
                mismatchCount2++;
            }
        }
        return Math.min(mismatchCount1, mismatchCount2);
    }

    public static int dearragementForMinProductSumTwoArray(int[] array1, int[] array2) {
        int[] a1Copy = new int[array1.length];
        int[] a2Copy = new int[array2.length];
        System.arraycopy(array1, 0, a1Copy, 0, array1.length);
        System.arraycopy(array2, 0, a2Copy, 0, array2.length);

        Arrays.sort(a1Copy);
        Arrays.sort(a2Copy);
        ArrayRearrange.reverseArray(a2Copy, 0, a2Copy.length - 1);

        int result = 0;
        for (int i = 0; i < array1.length; i++) {
            int index = Arrays.binarySearch(a1Copy, array1[i]);
            if (array2[i] != a2Copy[index]) {
                result++;
            }
        }
        return result;
    }

    public static int maximumOfKSegmentsMinimumInArray(int[] array, int k) {
        int result = 0;
        if (k == 1) {
            result = array[0];
            for (int i = 1; i < array.length; i++) {
                if (result > array[i]) {
                    result = array[i];
                }
            }
        } else if (k == 2) {
            result = Math.max(array[0], array[array.length - 1]);
        } else {
            result = array[0];
            for (int i = 1; i < array.length; i++) {
                if (result < array[i]) {
                    result = array[i];
                }
            }
        }
        return result;
    }

    public static int countWaysToFormMinProductTriplets(int[] array) {
        Arrays.sort(array);
        int count = 0;
        if (array[2] == array[0]) {
            // all three element same
            int freq = 3; // freq of min element
            for (int i = 3; i < array.length; i++) {
                if (array[i] == array[2]) {
                    freq++;
                } else {
                    break;
                }
            }
            count = freq * (freq - 1) * (freq - 2) / 6; // nC3
        } else if (array[2] == array[1]) {
            // last 2 element same
            int freq = 2; //freq of 2nd element
            for (int i = 3; i < array.length; i++) {
                if (array[i] == array[2]) {
                    freq++;
                } else {
                    break;
                }
            }
            count = freq * (freq - 1) / 2; // nC2
        } else {
            // all element different or first 2 element same and 2nd different
            int freq = 1; //freq of 3rd in element
            for (int i = 3; i < array.length; i++) {
                if (array[i] == array[2]) {
                    freq++;
                } else {
                    break;
                }
            }
            count = freq; // nC1=n
        }
        return count;
    }

    public static int makingTwoArraySameWithMinimumIncrementDecrement(int[] array1, int[] array2) {
        Arrays.sort(array1);
        Arrays.sort(array2);
        int result = 0;
        for (int i = 0; i < array1.length; i++) {
            result += Math.abs(array1[i] - array2[i]);
        }
        return result;
    }

    public static boolean checkIfIntervalsCompletelyOverlaps(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        boolean result = false;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][1]) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void sortingElementExceptInSubarray(int[] array, int start, int end) {
        int[] toSort = new int[array.length - (end - start + 1)];
        System.arraycopy(array, 0, toSort, 0, start);
        System.arraycopy(array, end + 1, toSort, start, array.length - 1 - end);
        Arrays.sort(toSort);

        System.arraycopy(toSort, 0, array, 0, start);
        System.arraycopy(toSort, start, array, end + 1, array.length - 1 - end);
    }

    public static void sortingElementExceptOne(int[] array, int k) {
        ArrayRearrange.swapIndex(array, k, array.length - 1);
        Arrays.sort(array, 0, array.length - 1);

        int last = array[array.length - 1];
        int i;
        for (i = array.length - 1; i > k; i--) {
            array[i] = array[i - 1];

        }
        array[i] = last;
    }

    public static int minAdjacentSwapsRequiredToSortBinaryArray(int[] array) {
        int[] zerosOnRight = new int[array.length];
        zerosOnRight[array.length - 1] = (array[array.length - 1] == 0 ? 1 : 0);
        int swapsRequired = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            zerosOnRight[i] = zerosOnRight[i + 1];
            if (array[i] == 0) {
                zerosOnRight[i]++;
            } else {
                swapsRequired += zerosOnRight[i];
            }
        }
        return swapsRequired;
    }

    public static void sortArrayInOrderOfElementInOtherArray(Integer[] array, int[] order) {
        final Map<Integer, Integer> valueToIndexMap = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            valueToIndexMap.put(order[i], i);
        }

        Arrays.sort(array, Comparator.comparing(valueToIndexMap::get));
    }

    public static int[] printSortedDistinctElement(int[] array) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        int[] result = new int[set.size()];
        int resultPos = 0;
        for (int element : set) {
            result[resultPos++] = element;
        }
        return result;
    }
}
