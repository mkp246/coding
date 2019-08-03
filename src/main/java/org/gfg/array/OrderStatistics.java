package org.gfg.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class OrderStatistics {
    public static int getKthSmallestNumberUsingSorting(int[] array, int k) {
        Arrays.sort(array);
        return array[k - 1];
    }

    public static int getKthSmallestNumberUsingPartition(int[] array, int start, int end, int k) {
        if (end - start + 1 >= k) {
            int pos = partition(array, start, end);
            if (pos - start == k - 1) {
                return array[pos];
            } else if (pos - start > k - 1) {
                return getKthSmallestNumberUsingPartition(array, start, pos - 1, k);
            } else {
                return getKthSmallestNumberUsingPartition(array, pos + 1, end, k - pos + start - 1);
            }
        }
        return 0;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                ArrayRearrange.swapIndex(array, i, start++);
            }
        }
        ArrayRearrange.swapIndex(array, start, end);
        return start;
    }

    public static int findLargestElement(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static int[] findThreeLargestElement(int[] array) {
        int first, second, third;
        first = second = third = array[0];
        for (int element : array) {
            if (element > first) {
                third = second;
                second = first;
                first = element;
            } else if (element > second) {
                third = second;
                second = element;
            } else if (element > third) {
                third = element;
            }
        }
        return new int[]{first, second, third};
    }

    public static int[] findElementHavingAtLeastTwoGreaterBySorting(int[] array) {
        Arrays.sort(array);
        int[] result = new int[array.length - 2];
        System.arraycopy(array, 0, result, 0, result.length);
        return result;
    }

    public static int[] findElementHavingAtLeastTwoGreaterByFindingSecondMaximum(int[] array) {
        int first, second;
        first = second = array[0];

        for (int element : array) {
            if (element > first) {
                second = first;
                first = element;
            } else if (element > second) {
                second = element;
            }
        }

        int[] result = new int[array.length - 2];
        int resultPos = 0;
        for (int element : array) {
            if (element < second) {
                result[resultPos++] = element;
            }
        }
        return result;
    }

    public static double[] getMeanAndMedian(int[] array) {
        Arrays.sort(array);
        double sum = 0;
        for (int element : array) {
            sum += element;
        }
        double mean = sum / array.length;
        double median;
        if (array.length % 2 == 0) {
            median = (array[array.length / 2] + array[array.length / 2 - 1]) / (double) 2;
        } else {
            median = array[array.length / 2];
        }
        return new double[]{mean, median};
    }

    public static int getMinProductOfKInteger(int[] array, int k) {
        Arrays.sort(array);
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= array[i];
        }
        return result;
    }

    public static int getKthLargestSumContinuousSubarray(int[] array, int k) {
        //convert to cumulative sum
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        PriorityQueue<Integer> sums = new PriorityQueue<>();
        int tmpSum = 0;
        // for seq starting at 0 exclusive, we need arr[-1]=0
        for (int i = 0; i < array.length; i++) {
            tmpSum = array[i];
            if (sums.size() < k) {
                sums.add(tmpSum);
            } else if (sums.peek() < tmpSum) {
                sums.poll();
                sums.add(tmpSum);
            }
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                tmpSum = array[j] - array[i - 1];
                if (sums.size() < k) {
                    sums.add(tmpSum);
                } else if (sums.peek() < tmpSum) {
                    sums.poll();
                    sums.add(tmpSum);
                }
            }
        }
        return sums.peek();
    }

    public static int[] getKMaxSumCombinationTwoArrays(int[] array1, int[] array2, int k) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> maxHeap = new PriorityQueue<>(Comparator.comparing(Pair::getKey, Comparator.reverseOrder()));
        HashSet<Pair<Integer, Integer>> pairs = new HashSet<>();

        maxHeap.add(new Pair<>(array1[array1.length - 1] + array2[array2.length - 1], new Pair<>(array1.length - 1, array2.length - 1)));
        pairs.add(new Pair<>(array1.length - 1, array2.length - 1));

        int[] result = new int[k];
        int resultPos = 0;
        Pair<Integer, Integer> tmpPair;
        for (int i = 0; i < k; i++) {
            Pair<Integer, Pair<Integer, Integer>> poll = maxHeap.poll();
            result[resultPos++] = poll.getKey();

            if (poll.getValue().getKey() > 0) {
                tmpPair = new Pair<>(poll.getValue().getKey() - 1, poll.getValue().getValue());
                if (!pairs.contains(tmpPair)) {
                    maxHeap.add(new Pair<>(array1[tmpPair.getKey()] + array2[tmpPair.getValue()], tmpPair));
                    pairs.add(tmpPair);
                }
            }

            if (poll.getValue().getValue() > 0) {
                tmpPair = new Pair<>(poll.getValue().getKey(), poll.getValue().getValue() - 1);
                if (!pairs.contains(tmpPair)) {
                    maxHeap.add(new Pair<>(array1[tmpPair.getKey()] + array2[tmpPair.getValue()], tmpPair));
                    pairs.add(tmpPair);
                }
            }
        }
        return result;
    }

    public static int maxSubArraySumUsingPrefixSum(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        int minPrefixSum = 0;
        int maxSubArraySum = Integer.MIN_VALUE;
        int tmp;
        for (int i = 0; i < array.length; i++) {
            tmp = array[i] - minPrefixSum;
            if (tmp > maxSubArraySum) {
                maxSubArraySum = tmp;
            }
            if (array[i] < minPrefixSum) {
                minPrefixSum = array[i];
            }
        }
        return maxSubArraySum;
    }

    public static int[] kMaxSubArraySumUsingPrefixSum(int[] array, int k) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        PriorityQueue<Integer> maxI = new PriorityQueue<>();
        int[] minI = new int[k];

        minI[0] = 0;
        int minIPos = 0;// max filled index in minI < k

        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= minIPos; j++) {
                tmp = array[i] - minI[j];
                if (maxI.size() < k) {
                    maxI.add(tmp);
                } else if (maxI.peek() < tmp) {
                    maxI.poll();
                    maxI.add(tmp);
                } else {
                    continue; // all subsequent diffs will be lower only
                }
            }
            if (minIPos < k - 1 || array[i] < minI[minIPos]) {
                int j = 0;
                while (array[i] > minI[j] && j <= minIPos) {
                    j++;
                }

                for (int l = k - 1; l > j; l--) {
                    minI[l] = minI[l - 1];
                }
                minI[j] = array[i];
                if (minIPos < k - 1) {
                    minIPos++;
                }
            }
        }

        int[] result = new int[k];
        int resultPos = k - 1;
        while (!maxI.isEmpty()) {
            result[resultPos--] = maxI.poll();//min heap, smallest first
        }
        return result;
    }

    public static int[][] kMaxSubArraySumNonOverlappingUsingKadane(int[] array, int k) {
        int[][] result = new int[k][];
        int resultPos = 0;
        int[] kadaneResult;
        for (int i = 0; i < k; i++) {
            kadaneResult = ArrayRearrange.findLargestSumContinuousSubarray(array);
            result[resultPos++] = kadaneResult;
            for (int j = kadaneResult[0]; j <= kadaneResult[1]; j++) {
                array[j] = Integer.MIN_VALUE;
            }
        }
        return result;
    }

    public static int[] getNSmallestNumberUsingSortingAndExtraSpaceInGivenOrder(int[] array, int n) {
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        Arrays.sort(arrayCopy);
        int largestElement = arrayCopy[n - 1];

        int[] result = new int[n];
        int resultPos = 0;
        for (int i = 0; resultPos < n && i < array.length; i++) {
            if (array[i] <= largestElement) {
                result[resultPos++] = array[i];
            }
        }
        return result;
    }

    public static int[] getNSmallestNumberUsingWithoutExtraSpaceInGivenOrder(int[] array, int n) {
        int maxIndexInFirstN = 0;
        boolean maxIndexInFirstNDirty = true;
        for (int i = n; i < array.length; i++) {
            if (maxIndexInFirstNDirty) {
                maxIndexInFirstN = 0;
                for (int j = 1; j < n; j++) {
                    if (array[maxIndexInFirstN] < array[j]) {
                        maxIndexInFirstN = j;
                    }
                }
                maxIndexInFirstNDirty = false;
            }
            if (array[maxIndexInFirstN] > array[i]) {
                shiftLeftByOne(array, maxIndexInFirstN, n - 1);
                array[n - 1] = array[i];
                maxIndexInFirstNDirty = true;
            }
        }
        int[] result = new int[n];
        System.arraycopy(array, 0, result, 0, n);
        return result;
    }

    private static void shiftLeftByOne(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            array[i] = array[i + 1];
        }
    }

    public static int[][] getKMinSumCombinationTwoArrays(int[] array1, int[] array2, int k) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        //pair(sum, pair(array1Idx, array2Idx)) // max heap
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> minHeap = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        HashSet<Pair<Integer, Integer>> pairs = new HashSet<>();

        minHeap.add(new Pair<>(array1[0] + array2[0], new Pair<>(0, 0)));
        pairs.add(new Pair<>(0, 0));

        int[][] result = new int[k][2];
        int resultPos = 0;

        Pair<Integer, Integer> tmpPair;
        for (int i = 0; i < k; i++) {
            Pair<Integer, Pair<Integer, Integer>> poll = minHeap.poll();
            result[resultPos++] = new int[]{array1[poll.getValue().getKey()], array2[poll.getValue().getValue()]};

            if (poll.getValue().getKey() < array1.length - 1) {
                tmpPair = new Pair<>(poll.getValue().getKey() + 1, poll.getValue().getValue());
                if (!pairs.contains(tmpPair)) {
                    minHeap.add(new Pair<>(array1[tmpPair.getKey()] + array2[tmpPair.getValue()], tmpPair));
                    pairs.add(tmpPair);
                }
            }
            if (poll.getValue().getValue() < array2.length - 1) {
                tmpPair = new Pair<>(poll.getValue().getKey(), poll.getValue().getValue() + 1);
                if (!pairs.contains(tmpPair)) {
                    minHeap.add(new Pair<>(array1[tmpPair.getKey()] + array2[tmpPair.getValue()], tmpPair));
                    pairs.add(tmpPair);
                }
            }
        }
        return result;
    }

    public static int getKthSmallestAbsoluteDifference(int[] array, int k) {
        Arrays.sort(array);
        int low = array[1] - array[0];
        for (int i = 1; i < array.length - 1; i++) {
            low = Math.min(low, array[i + 1] - array[i]);
        }
        int high = array[array.length - 1] - array[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(array, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * return pair count with diff less of equal to mid using binary search of array[i] + mid
     *
     * @param array
     * @param mid
     * @return
     */
    private static int countPairs(int[] array, int mid) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += upperBound(array, i, array.length - 1, mid) - (i + 1);
        }
        return result;
    }

    /**
     * returns position of next higher element than array[start] + mid
     * TODO
     *
     * @param array
     * @param start inclusive
     * @param end   inclusive
     * @param mid
     * @return
     */
    private static int upperBound(int[] array, int start, int end, int mid) {
        return start;
    }

    public static int getSecondLargestElement(int[] array) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int element : array) {
            if (element > first) {
                second = first;
                first = element;
            } else if (element > second && element != first) {
                second = element;
            }
        }
        return second;
    }

    public static int[] findKNumbersWithMostOccurrences(int[] array, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : array) {
            map.put(element, 1 + map.getOrDefault(element, 0));
        }
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> element : map.entrySet()) {
            list.add(new Pair<>(element.getKey(), element.getValue()));
        }
        Collections.sort(list, (p2, p1) -> p1.getValue().equals(p2.getValue()) ? p1.getKey() - p2.getKey() : p1.getValue() - p2.getValue());

        int[] result = new int[k];
        int resultPos = 0;
        for (int i = 0; i < k; i++) {
            result[resultPos++] = list.get(i).getKey();
        }
        return result;
    }

    public static int[] getSmallestAndSecondSmallest(int[] array) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int element : array) {
            if (element < smallest) {
                secondSmallest = smallest;
                smallest = element;
            } else if (element < secondSmallest && element != smallest) {
                secondSmallest = element;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static int[] getSmallestAndSecondSmallestUsingTournamentTree(int[] array) {
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < array.length; i += 2) {
            Node node1 = new Node(array[i]);
            if (i + 1 < array.length) {
                Node node2 = new Node(array[i + 1]);
                Node parent = new Node(Math.min(node1.data, node2.data), node1, node2);
                list.add(parent);
            } else {
                list.add(node1);
            }
        }
        //find minimum
        while (list.size() != 1) {
            int size = list.size();
            for (int i = 0; i < size / 2; i++) {
                Node left = list.remove(0);
                Node right = list.remove(0);
                list.add(new Node(Math.min(left.data, right.data), left, right));
            }
            //odd
            if ((size & 1) == 1) {
                list.add(list.remove(0));
            }
        }
        int smallest = list.get(0).data;
        int secondSmallest = traverseHeightForSecondMax(list.get(0), list.get(0).data, Integer.MAX_VALUE);
        return new int[]{smallest, secondSmallest};
    }

    private static int traverseHeightForSecondMax(Node node, int smallest, int secondSmallest) {
        if (node != null && node.left != null && node.right != null) {
            if (node.left.data > smallest) {
                secondSmallest = Math.min(node.left.data, secondSmallest);
            } else {
                secondSmallest = traverseHeightForSecondMax(node.left, smallest, secondSmallest);
            }
            if (node.right.data > smallest) {
                secondSmallest = Math.min(node.right.data, secondSmallest);
            } else {
                secondSmallest = traverseHeightForSecondMax(node.right, smallest, secondSmallest);
            }
        }
        return secondSmallest;
    }

    public static int findFirstMissingNumberSortedArrayByDiffChecking(int[] array) {
        if (array[0] != 0) {
            return 0;
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] - array[i] != 1) {
                    return array[i] + 1;
                }
            }
        }
        return array.length; // all element present
    }

    public static int findFirstMissingNumberSortedArrayByFindFirstDeviationInIndexAndValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i) {
                return i;
            }
        }
        return array.length; //all element from 0 n-1 present
    }

    public static int findFirstMissingNumberSortedArrayByModifiedBinarySearch(int[] array, int start, int end) {
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (array[mid] > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return array[end] != end ? end : end + 1; // inc case it point to end element
    }

    public static int getMaxSubSequenceSumWithNoAdjacentElement(int[] array) {
        int maxIncluding = array[0];
        int maxExcluding = 0;
        int maxIncludingNew;
        for (int i = 1; i < array.length; i++) {
            maxIncludingNew = maxExcluding + array[i];
            maxExcluding = Math.max(maxIncluding, maxExcluding);
            maxIncluding = maxIncludingNew;
        }
        return Math.max(maxIncluding, maxExcluding);
    }

    public static int[] getMaximumAndMinimumUsingMinimumComparison(int[] array) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int i = 0;
        if (array.length % 2 == 1) {
            max = min = array[0];
            i = 1;
        }
        int pairMax, pairMin;
        for (; i < array.length; i += 2) {
            if (array[i + 1] > array[i]) {
                pairMax = array[i + 1];
                pairMin = array[i];
            } else {
                pairMax = array[i];
                pairMin = array[i + 1];
            }
            if (pairMax > max) {
                max = pairMax;
            }
            if (pairMin < min) {
                min = pairMin;
            }
        }
        return new int[]{max, min};
    }

    public static int getMaximumDiffLargerElementAfterSmaller(int[] array) {
        int maxDiff = Integer.MIN_VALUE;
        int minElement = array[0];
        int tempDiff;
        for (int i = 1; i < array.length; i++) {
            tempDiff = array[i] - minElement;
            if (tempDiff > maxDiff) {
                maxDiff = tempDiff;
            }
            if (minElement > array[i]) {
                minElement = array[i];
            }
        }
        return maxDiff;
    }

    /**
     * map - track indexes of elements, list to keep track of multiple occurance of an element
     *
     * @param array
     * @return
     */
    public static int findMaximumIJDifferenceSuchThatElementAtJIsHigher(int[] array) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.putIfAbsent(array[i], new ArrayList<>());
            map.get(array[i]).add(i);
        }
        Arrays.sort(array);
        int minIndex = array.length;
        int maxDiff = -1;
        for (int element : array) {
            List<Integer> occurances = map.get(element);
            if (occurances.get(0) < minIndex) {
                minIndex = occurances.get(0);
            }
            Integer lastOccurance = occurances.get(occurances.size() - 1);
            maxDiff = Math.max(maxDiff, lastOccurance - minIndex);
        }
        return maxDiff == 0 ? -1 : maxDiff;
    }

    public static int findMaximumIJDifferenceSuchThatElementAtJIsHigherByTrackingOfSmallestToLeftAndHighestToRight(int[] array) {
        int[] leftMin = new int[array.length];
        int[] rightMax = new int[array.length];

        leftMin[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], array[i]);
        }

        rightMax[array.length - 1] = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], array[i]);
        }
        int i = 0, j = 0, maxDiff = -1;
        while (i < array.length && j < array.length) {
            if (leftMin[i] > rightMax[j]) {
                i++;
            } else {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            }
        }
        return maxDiff == 0 ? -1 : maxDiff; //can't be zero
    }

    public static int[] testFindSlidingWindowMaximumOfAllSubarrayOfKLength(int[] array, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[array.length - k + 1];
        int resultPos = 0;

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result[resultPos++] = array[deque.peekFirst()];

        for (int i = k; i < array.length; i++) {
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            result[resultPos++] = array[deque.peekFirst()];
        }
        return result;
    }

    public static int findMinimumDistanceBetweenTwoNumber(int[] array, int x, int y) {
        int minDistance = array.length;
        int lastIdx = -1;
        int i = 0;
        for (; i < array.length; i++) {
            if (array[i] == x || array[i] == y) {
                lastIdx = i;
                break;
            }
        }
        for (; i < array.length; i++) {
            if (array[i] == x || array[i] == y) {
                if (array[i] != array[lastIdx]) {
                    minDistance = Math.min(minDistance, i - lastIdx);
                }
                lastIdx = i;
            }
        }
        return minDistance;
    }

    public static int findMaxElementInFirstIncreasingThenDecreasingArray(int[] array) {
        int max = 0;
        boolean maxFound = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                max = array[i];
                maxFound = true;
                break;
            }
        }

        // means all increasing order only
        if (!maxFound) {
            max = array[array.length - 1];
        }
        return max;
    }

    public static int findSmallestPositiveElementMissingInUnsortedArray(int[] array) {
        int negPos = -1; //will point to last index where element <= 0
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                ArrayRearrange.swapIndex(array, i, ++negPos);
            }
        }
        for (int i = 0; i <= negPos; i++) {
            array[i] *= -1;
        }
        for (int i = negPos + 1; i < array.length; i++) {
            int element = Math.abs(array[i]);
            if (element < array.length && array[element] > 0) {
                array[element] *= -1;
            }
        }
        int smallestMissing = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > 0) {
                smallestMissing = i;
                break;
            }
        }
        return smallestMissing;
    }

    public static int findMaximumRepeatingNumberInPositiveArray(int[] array, int allLestThan) {
        for (int i = 0; i < array.length; i++) {
            array[array[i] % allLestThan] += allLestThan;
        }

        int maxIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[maxIdx]) {
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    public static int[] findElementsWithMoreFrequencyMoreThanNByK(int[] array, int k) {
        Pair<Integer, Integer>[] pairs = new Pair[k - 1]; //can' be more than k-1 element, pair in (ele,count)
        for (int i = 0; i < array.length; i++) {
            boolean found = false;
            for (int j = 0; j < k - 1; j++) {
                if (pairs[j] != null && pairs[j].getKey() == array[i]) {
                    pairs[j].setValue(pairs[j].getValue() + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int j = 0; j < k - 1; j++) {
                    if (pairs[j] == null) {
                        pairs[j] = new Pair<>(array[i], 1);
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                for (int j = 0; j < k - 1; j++) {
                    if (pairs[j] != null) {
                        if (pairs[j].getValue() == 1) {
                            pairs[j] = null;
                        } else {
                            pairs[j].setValue(pairs[j].getValue() - 1);
                        }
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int countShouldBeGreaterThan = array.length / k;
        for (Pair<Integer, Integer> pair : pairs) {
            if (pair != null) {
                int count = 0;
                for (int element : array) {
                    if (element == pair.getKey()) {
                        count++;
                    }
                }
                if (count > countShouldBeGreaterThan) {
                    result.add(pair.getKey());
                }
            }
        }
        return Occurance.intListToArray(result);
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public static int findMaxSumPathAcrossTwoArrays(int[] array1, int[] array2) {
        int pos1 = 0, pos2 = 0, sum1 = 0, sum2 = 0, pathSum = 0;
        while (pos1 < array1.length && pos2 < array2.length) {
            if (array1[pos1] == array2[pos2]) {
                pathSum += Math.max(sum1, sum2) + array1[pos1];
                sum1 = sum2 = 0;
                pos1++;
                pos2++;
            } else if (array1[pos1] > array2[pos2]) {
                sum2 += array2[pos2++];
            } else {
                sum1 += array1[pos1++];
            }
        }
        for (int i = pos1; i < array1.length; i++) {
            sum1 += array1[i];
        }
        for (int i = pos2; i < array2.length; i++) {
            sum2 += array2[i];
        }

        pathSum += Math.max(sum1, sum2);

        return pathSum;
    }
}
