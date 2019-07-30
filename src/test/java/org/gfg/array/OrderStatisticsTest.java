package org.gfg.array;

import com.mkp.ALT;
import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@GFG(date = "24-07-2019", topic = " array order statistics", url = "/array-data-structure/array-order-statistics/", impls = OrderStatistics.class)
public class OrderStatisticsTest {

    @Test
    @GFGMethod(date = "24-07-2019", algo = "(method 1)sort and get return array[k-1]", url = "kth-smallestlargest-element-unsorted-array/")
    public void testGetKthSmallestNumberUsingSorting() {
        int[] array = {7, 10, 4, 3, 20, 15};
        int result = OrderStatistics.getKthSmallestNumberUsingSorting(array, 3);
        assertEquals(7, result);

        result = OrderStatistics.getKthSmallestNumberUsingSorting(array, 4);
        assertEquals(10, result);
    }

    @Test
    @ALT(desc = "partition around median of median of 5 size blocks of n/5 at each step", url = "/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/")
    @ALT(desc = "partition around random element instead of last", url = "/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time-2/")
    @GFGMethod(date = "24-07-2019", algo = "(method 4)quick sort partition around last element", url = "/kth-smallestlargest-element-unsorted-array/", tComp = "avg O(n), worst O(n^2)")
    public void testGetKthSmallestNumberUsingPartition() {
        int[] array = {12, 3, 5, 7, 4, 19, 26};
        int result = OrderStatistics.getKthSmallestNumberUsingPartition(array, 0, array.length - 1, 3);
        assertEquals(5, result);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "assume largest @0, traverse update largest if greater found", url = "/c-program-find-largest-element-array/")
    public void testFindLargestElement() {
        int[] array = {10, 20, 4};
        int result = OrderStatistics.findLargestElement(array);
        assertEquals(20, result);

        array = new int[]{20, 10, 20, 4, 100};
        result = OrderStatistics.findLargestElement(array);
        assertEquals(100, result);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "keep track of 3 highest number", url = "/find-the-largest-three-elements-in-an-array/")
    public void testFindThreeLargestElement() {
        int[] array = {10, 4, 3, 50, 23, 90};
        int[] result = OrderStatistics.findThreeLargestElement(array);
        assertArrayEquals(new int[]{90, 50, 23}, result);

        array = new int[]{12, 13, 1, 10, 34, 1};
        result = OrderStatistics.findThreeLargestElement(array);
        assertArrayEquals(new int[]{34, 13, 12}, result);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "(method 2) sorting and print first n-2 elements", url = "/find-elements-array-least-two-greater-elements/")
    public void testFindElementHavingAtLeastTwoGreaterBySorting() {
        int[] array = {2, 8, 7, 1, 5};
        int[] result = OrderStatistics.findElementHavingAtLeastTwoGreaterBySorting(array);
        assertArrayEquals(new int[]{1, 2, 5}, result);

        array = new int[]{7, -2, 3, 4, 9, -1};
        result = OrderStatistics.findElementHavingAtLeastTwoGreaterBySorting(array);
        assertArrayEquals(new int[]{-2, -1, 3, 4}, result);

        array = new int[]{2, -6, 3, 5, 1};
        result = OrderStatistics.findElementHavingAtLeastTwoGreaterBySorting(array);
        assertArrayEquals(new int[]{-6, 1, 2}, result);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "(method 3)find 2nd largest and print less element than that", url = "/find-elements-array-least-two-greater-elements/")
    public void testFindElementHavingAtLeastTwoGreaterByFindingSecondMaximum() {
        int[] array = {2, 8, 7, 1, 5};
        int[] result = OrderStatistics.findElementHavingAtLeastTwoGreaterByFindingSecondMaximum(array);
        assertArrayEquals(new int[]{2, 1, 5}, result);

        array = new int[]{7, -2, 3, 4, 9, -1};
        result = OrderStatistics.findElementHavingAtLeastTwoGreaterByFindingSecondMaximum(array);
        assertArrayEquals(new int[]{-2, 3, 4, -1}, result);

        array = new int[]{2, -6, 3, 5, 1};
        result = OrderStatistics.findElementHavingAtLeastTwoGreaterByFindingSecondMaximum(array);
        assertArrayEquals(new int[]{2, -6, 1}, result);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "sorting", url = "/program-for-mean-and-median-of-an-unsorted-array/")
    public void testGetMeanAndMedian() {
        int[] array = {1, 3, 4, 2, 6, 5, 8, 7};
        double[] result = OrderStatistics.getMeanAndMedian(array);
        assertArrayEquals(new double[]{4.5, 4.5}, result, 0);

        array = new int[]{4, 4, 4, 4, 4};
        result = OrderStatistics.getMeanAndMedian(array);
        assertArrayEquals(new double[]{4, 4}, result, 0);

        array = new int[]{1, 3, 4, 2, 7, 5, 8, 6};
        result = OrderStatistics.getMeanAndMedian(array);
        assertArrayEquals(new double[]{4.5, 4.5}, result, 0);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "maintain 2 heap one has smaller(max heap), one has larger(min heap) than median",
            url = "/median-of-stream-of-running-integers-using-stl/", impls = RunningMedian.class)
    public void testGetMedianOfRunningStream() {
        int[] array = {5, 15, 10, 20, 3};
        RunningMedian runningMedian = new RunningMedian();
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = runningMedian.addAndGetMedian(array[i]);
        }
        assertArrayEquals(new double[]{5, 10, 10, 12.5, 10}, result, 0);

        array = new int[]{5, 10, 15};
        runningMedian = new RunningMedian();
        result = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = runningMedian.addAndGetMedian(array[i]);
        }
        assertArrayEquals(new double[]{5, 7.5, 10}, result, 0);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "sort and multiply smallest k integers", url = "/minimum-product-k-integers-array-positive-integers/")
    public void testGetMinProductOfKInteger() {
        int[] array = {198, 76, 544, 123, 154, 675};
        int result = OrderStatistics.getMinProductOfKInteger(array, 2);
        assertEquals(9348, result);

        array = new int[]{11, 8, 5, 7, 5, 100};
        result = OrderStatistics.getMinProductOfKInteger(array, 4);
        assertEquals(1400, result);
    }

    @Test
    @GFGMethod(date = "27-07-2019", algo = "cumulative sum diff will give range sum, calc all possible sums,put in mean heap only largest k element",
            url = "/k-th-largest-sum-contiguous-subarray/")
    public void testGetKthLargestSumContinuousSubarray() {
        int[] array = {20, -5, -1};
        int result = OrderStatistics.getKthLargestSumContinuousSubarray(array, 3);
        assertEquals(14, result);

        array = new int[]{10, -10, 20, -40};
        result = OrderStatistics.getKthLargestSumContinuousSubarray(array, 6);
        assertEquals(-10, result);
    }

    @Test
    @GFGMethod(date = "27-07-2019", algo = "sort both, insert i,j,sum in maxHeap if i,j not present, iterate for ij in heap with i-1,j and i,j-1, print K from heap",
            url = "/k-maximum-sum-combinations-two-arrays/")
    public void testGetKMaxSumCombinationTwoArrays() {
        int[] array1 = {3, 2};
        int[] array2 = {1, 4};
        int[] result = OrderStatistics.getKMaxSumCombinationTwoArrays(array1, array2, 2);
        assertArrayEquals(new int[]{7, 6}, result);

        array1 = new int[]{4, 2, 5, 1};
        array2 = new int[]{8, 0, 3, 5};
        result = OrderStatistics.getKMaxSumCombinationTwoArrays(array1, array2, 3);
        assertArrayEquals(new int[]{13, 12, 10}, result);
    }

    @Test
    @GFGMethod(date = "27-07-2019", algo = "alternate to kadane's algorithm,(keep track of min prefix sum till @i)",
            url = "/maximum-subarray-sum-using-prefix-sum/", tComp = "O(n)")
    public void testMaxSubArraySumUsingPrefixSum() {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        int result = OrderStatistics.maxSubArraySumUsingPrefixSum(array);
        assertEquals(7, result);

        array = new int[]{4, -8, 9, -4, 1, -8, -1, 6};
        result = OrderStatistics.maxSubArraySumUsingPrefixSum(array);
        assertEquals(9, result);
    }

    @Test
    @GFGMethod(date = "27-07-2019", algo = "Sung Eun Bae and Tadao Takaoka, tracking k min prefix sum",
            url = "/k-maximum-sum-overlapping-contiguous-sub-arrays/", tComp = "O(n*k)")
    public void testKMaxSubArraySumUsingPrefixSum() {
        int[] array = {4, -8, 9, -4, 1, -8, -1, 6};
        int[] result = OrderStatistics.kMaxSubArraySumUsingPrefixSum(array, 4);
        assertArrayEquals(new int[]{9, 6, 6, 5}, result);

        array = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        result = OrderStatistics.kMaxSubArraySumUsingPrefixSum(array, 3);
        assertArrayEquals(new int[]{7, 6, 5}, result);
    }

    @Ignore("TODO kadane for all negative number")
    @Test
    @GFGMethod(date = "27-07-2019", algo = "run kadane k times each time replace used with -INF",
            url = "/k-maximum-sums-non-overlapping-contiguous-sub-arrays/", tComp = "O(n*k)")
    public void testKMaxSubArraySumNonOverlappingUsingKadane() {
        int[] array = {5, 1, 2, -6, 2, -1, 3, 1};
        int[][] result = OrderStatistics.kMaxSubArraySumNonOverlappingUsingKadane(array, 2);
        assertArrayEquals(new int[][]{{0, 2, 8}, {4, 7, 5}}, result);

        array = new int[]{4, 1, 1, -1, -3, -5, 6, 2, -6, -2};
        result = OrderStatistics.kMaxSubArraySumNonOverlappingUsingKadane(array, 3);
        assertArrayEquals(new int[][]{{6, 7, 8}, {0, 2, 6}, {3, 3, 1}}, result);
    }

    @Test
    @GFGMethod(date = "27-07-2019", desc = "didn't use searching if element in original is present in copy after sort first n element",
            algo = "make copy, sort copy, find kth smallest number, print number less than or equal to that in original array",
            url = "/find-n-smallest-element-given-array-order-array/")
    public void testGetNSmallestNumberUsingSortingAndExtraSpaceInGivenOrder() {
        int[] array = {4, 2, 6, 1, 5};
        int[] result = OrderStatistics.getNSmallestNumberUsingSortingAndExtraSpaceInGivenOrder(array, 3);
        assertArrayEquals(new int[]{4, 2, 1}, result);

        array = new int[]{4, 12, 16, 21, 25};
        result = OrderStatistics.getNSmallestNumberUsingSortingAndExtraSpaceInGivenOrder(array, 3);
        assertArrayEquals(new int[]{4, 12, 16}, result);

        array = new int[]{1, 5, 8, 9, 6, 7, 3, 4, 2, 0};
        result = OrderStatistics.getNSmallestNumberUsingSortingAndExtraSpaceInGivenOrder(array, 5);
        assertArrayEquals(new int[]{1, 3, 4, 2, 0}, result);
    }

    @Test
    @GFGMethod(date = "27-07-2019", desc = "didn't use searching if element in original is present in copy after sort first n element",
            algo = "assume first n correct, starting n+1 to len if smaller than max in first n, starting max index shift all to left by 1, put element at n",
            url = "/k-smallest-elements-order-using-o1-extra-space/")
    public void testGetNSmallestNumberUsingWithoutExtraSpaceInGivenOrder() {
        int[] array = {4, 2, 6, 1, 5};
        int[] result = OrderStatistics.getNSmallestNumberUsingWithoutExtraSpaceInGivenOrder(array, 3);
        assertArrayEquals(new int[]{4, 2, 1}, result);

        array = new int[]{4, 12, 16, 21, 25};
        result = OrderStatistics.getNSmallestNumberUsingWithoutExtraSpaceInGivenOrder(array, 3);
        assertArrayEquals(new int[]{4, 12, 16}, result);

        array = new int[]{1, 5, 8, 9, 6, 7, 3, 4, 2, 0};
        result = OrderStatistics.getNSmallestNumberUsingWithoutExtraSpaceInGivenOrder(array, 5);
        assertArrayEquals(new int[]{1, 3, 4, 2, 0}, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "(method 3)sort both, insert 0,0,sum00 in minHeap, remove top from heap with idx ij, add to result, if not present in set add i+1,j and i,j+1, to heap, repeat k times",
            url = "/find-k-pairs-smallest-sums-two-arrays/")
    public void testGetKMinSumCombinationTwoArrays() {
        int[] array1 = {1, 7, 11};
        int[] array2 = {2, 4, 6};
        int[][] result = OrderStatistics.getKMinSumCombinationTwoArrays(array1, array2, 3);
        assertArrayEquals(new int[][]{{1, 2,}, {1, 4}, {1, 6}}, result);

        array1 = new int[]{1, 3, 11};
        array2 = new int[]{2, 4, 8};
        result = OrderStatistics.getKMinSumCombinationTwoArrays(array1, array2, 4);
        assertArrayEquals(new int[][]{{1, 2}, {3, 2}, {1, 4}, {3, 4}}, result);
    }

    @Ignore("TODO")
    @Test
    @GFGMethod(date = "28-07-2019",
            algo = "sort, find min and max diff, count diff pair(using binary search a[i]+mid from i to n) <=mid, if count >k then high=mid, else low = mid+1",
            url = "/k-th-smallest-absolute-difference-two-elements-array/")
    public void testGetKthSmallestAbsoluteDifference() {
        int[] array = {1, 2, 3, 4};
        int result = OrderStatistics.getKthSmallestAbsoluteDifference(array, 3);
        assertEquals(1, result);

        array = new int[]{10, 10};
        result = OrderStatistics.getKthSmallestAbsoluteDifference(array, 1);
        assertEquals(0, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "keep track of two largest", url = "/k-th-smallest-absolute-difference-two-elements-array/")
    public void testGetSecondLargestElement() {
        int[] array = {12, 35, 1, 10, 34, 1};
        int result = OrderStatistics.getSecondLargestElement(array);
        assertEquals(34, result);

        array = new int[]{10, 5, 10};
        result = OrderStatistics.getSecondLargestElement(array);
        assertEquals(5, result);

        array = new int[]{10, 10, 10};
        result = OrderStatistics.getSecondLargestElement(array);
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "(Method 1)count freq of each using map, put all map ele to list and sort by custom comparator",
            desc = "(method 2)alternate can use max heap(pq with custom comparator) to store k element",
            url = "/find-k-numbers-occurrences-given-array/")
    public void testFindKNumbersWithMostOccurrences() {
        int[] array = {3, 1, 4, 4, 5, 2, 6, 1};
        int[] result = OrderStatistics.findKNumbersWithMostOccurrences(array, 2);
        assertArrayEquals(new int[]{4, 1}, result);

        array = new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        result = OrderStatistics.findKNumbersWithMostOccurrences(array, 4);
        assertArrayEquals(new int[]{5, 11, 7, 10}, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "keep track of 2 smallest, and already used values",
            url = "/to-find-smallest-and-second-smallest-element-in-an-array/")
    public void testGetSmallestAndSecondSmallest() {
        int[] array = {12, 13, 1, 10, 34, 1};
        int[] result = OrderStatistics.getSmallestAndSecondSmallest(array);
        assertArrayEquals(new int[]{1, 10}, result);

        array = new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        result = OrderStatistics.getSmallestAndSecondSmallest(array);
        assertArrayEquals(new int[]{2, 5}, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "tournament tree", url = "/second-minimum-element-using-minimum-comparisons/", tComp = "O(n+log(n))")
    public void testGetSmallestAndSecondSmallestUsingTournamentTree() {
        int[] array = {12, 13, 1, 10, 34, 1};
        int[] result = OrderStatistics.getSmallestAndSecondSmallestUsingTournamentTree(array);
        assertArrayEquals(new int[]{1, 10}, result);

        array = new int[]{61, 6, 100, 9, 10, 12, 17};
        result = OrderStatistics.getSmallestAndSecondSmallestUsingTournamentTree(array);
        assertArrayEquals(new int[]{6, 9}, result);

        array = new int[]{7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        result = OrderStatistics.getSmallestAndSecondSmallestUsingTournamentTree(array);
        assertArrayEquals(new int[]{2, 5}, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "(method 2) if diff greater than 1", url = "/find-the-first-missing-number/")
    public void testFindFirstMissingNumberSortedArrayByDiffChecking() {
        int[] array = {0, 1, 2, 6, 9};
        int result = OrderStatistics.findFirstMissingNumberSortedArrayByDiffChecking(array);
        assertEquals(3, result);

        array = new int[]{4, 5, 10, 11};
        result = OrderStatistics.findFirstMissingNumberSortedArrayByDiffChecking(array);
        assertEquals(0, result);

        array = new int[]{0, 1, 2, 3};
        result = OrderStatistics.findFirstMissingNumberSortedArrayByDiffChecking(array);
        assertEquals(4, result);

        array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10};
        result = OrderStatistics.findFirstMissingNumberSortedArrayByDiffChecking(array);
        assertEquals(8, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "first deviation in array index and value", url = "/find-the-first-missing-number/")
    public void testFindFirstMissingNumberSortedArrayByFindFirstDeviationInIndexAndValue() {
        int[] array = {0, 1, 2, 6, 9};
        int result = OrderStatistics.findFirstMissingNumberSortedArrayByFindFirstDeviationInIndexAndValue(array);
        assertEquals(3, result);

        array = new int[]{4, 5, 10, 11};
        result = OrderStatistics.findFirstMissingNumberSortedArrayByFindFirstDeviationInIndexAndValue(array);
        assertEquals(0, result);

        array = new int[]{0, 1, 2, 3};
        result = OrderStatistics.findFirstMissingNumberSortedArrayByFindFirstDeviationInIndexAndValue(array);
        assertEquals(4, result);

        array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10};
        result = OrderStatistics.findFirstMissingNumberSortedArrayByFindFirstDeviationInIndexAndValue(array);
        assertEquals(8, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "(method 3)bin search with condition arr[mid] <> mid", url = "/find-the-first-missing-number/")
    public void testFindFirstMissingNumberSortedArrayByModifiedBinarySearch() {
        int[] array = {0, 1, 2, 6, 9};
        int result = OrderStatistics.findFirstMissingNumberSortedArrayByModifiedBinarySearch(array, 0, array.length - 1);
        assertEquals(3, result);

        array = new int[]{4, 5, 10, 11};
        result = OrderStatistics.findFirstMissingNumberSortedArrayByModifiedBinarySearch(array, 0, array.length - 1);
        assertEquals(0, result);

        array = new int[]{0, 1, 2, 3};
        result = OrderStatistics.findFirstMissingNumberSortedArrayByModifiedBinarySearch(array, 0, array.length - 1);
        assertEquals(4, result);

        array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 10};
        result = OrderStatistics.findFirstMissingNumberSortedArrayByModifiedBinarySearch(array, 0, array.length - 1);
        assertEquals(8, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "DP tabulation, keep track of max incl and excl", url = "/maximum-sum-such-that-no-two-elements-are-adjacent/")
    public void testGetMaxSubSequenceSumWithNoAdjacentElement() {
        int[] array = {5, 5, 10, 100, 10, 5};
        int result = OrderStatistics.getMaxSubSequenceSumWithNoAdjacentElement(array);
        assertEquals(110, result);

        array = new int[]{1, 2, 3};
        result = OrderStatistics.getMaxSubSequenceSumWithNoAdjacentElement(array);
        assertEquals(4, result);

        array = new int[]{1, 20, 3};
        result = OrderStatistics.getMaxSubSequenceSumWithNoAdjacentElement(array);
        assertEquals(20, result);

        array = new int[]{5, 5, 10, 40, 50, 35};
        result = OrderStatistics.getMaxSubSequenceSumWithNoAdjacentElement(array);
        assertEquals(80, result);
    }

    @Test
    @GFGMethod(date = "28-07-2019", algo = "(method 3)compare in pair", url = "/maximum-and-minimum-in-an-array/", tComp = "O(1.5n)",
            desc = "(method 1) linear O(2n), (method 2) divide and conquer tournament algorithm O(>= 3n/2 -2)")
    public void testGetMaximumAndMinimumUsingMinimumComparison() {
        int[] array = {1000, 11, 445, 1, 330, 3000};
        int[] result = OrderStatistics.getMaximumAndMinimumUsingMinimumComparison(array);
        assertArrayEquals(new int[]{3000, 1}, result);

        array = new int[]{5, 5, 10, 100, 10, 5};
        result = OrderStatistics.getMaximumAndMinimumUsingMinimumComparison(array);
        assertArrayEquals(new int[]{100, 5}, result);

        array = new int[]{1, 2, 3};
        result = OrderStatistics.getMaximumAndMinimumUsingMinimumComparison(array);
        assertArrayEquals(new int[]{3, 1}, result);

        array = new int[]{1, 20, 3};
        result = OrderStatistics.getMaximumAndMinimumUsingMinimumComparison(array);
        assertArrayEquals(new int[]{20, 1}, result);

        array = new int[]{5, 5, 10, 40, 50, 35};
        result = OrderStatistics.getMaximumAndMinimumUsingMinimumComparison(array);
        assertArrayEquals(new int[]{50, 5}, result);
    }

    @Test
    @GFGMethod(date = "29-07-2019", algo = "(method 2)keep track of max diff, min element to left of current",
            desc = "(method 2 alt) can keep track of maximum to the right of element,(method 3) diff array between adjacent adn find max sum subarray of diff array",
            url = "/maximum-difference-between-two-elements/")
    public void testGetMaximumDiffLargerElementAfterSmaller() {
        int[] array = {2, 3, 10, 6, 4, 8, 1};
        int result = OrderStatistics.getMaximumDiffLargerElementAfterSmaller(array);
        assertEquals(8, result);

        array = new int[]{7, 9, 5, 6, 3, 2};
        result = OrderStatistics.getMaximumDiffLargerElementAfterSmaller(array);
        assertEquals(2, result);

        array = new int[]{1, 2, 90, 10, 110};
        result = OrderStatistics.getMaximumDiffLargerElementAfterSmaller(array);
        assertEquals(109, result);
    }

    @Test
    @GFGMethod(date = "29-07-2019", algo = "(method 2)sort array, max j-i is when any value's index in sorted array is compared with smallest index among all of lower element",
            url = "/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/")
    public void testFindMaximumIJDifferenceSuchThatElementAtJIsHigher() {
        int[] array = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int result = OrderStatistics.findMaximumIJDifferenceSuchThatElementAtJIsHigher(array);
        assertEquals(6, result);

        array = new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        result = OrderStatistics.findMaximumIJDifferenceSuchThatElementAtJIsHigher(array);
        assertEquals(8, result);

        array = new int[]{1, 2, 3, 4, 5, 6};
        result = OrderStatistics.findMaximumIJDifferenceSuchThatElementAtJIsHigher(array);
        assertEquals(5, result);

        array = new int[]{6, 5, 4, 3, 2, 1};
        result = OrderStatistics.findMaximumIJDifferenceSuchThatElementAtJIsHigher(array);
        assertEquals(-1, result);
    }

    @Test
    @GFGMethod(date = "29-07-2019", algo = "(method 3)tracking min to left and max to right(both incl), start traverse at i=0,j=0, if Lmin[i] is higher that Rmax[j] i++, else j++ and update max diff if less than j-i",
            url = "/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/")
    public void testFindMaximumIJDifferenceSuchThatElementAtJIsHigherByTrackingOfSmallestToLeftAndHighestToRight() {
        int[] array = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int result = OrderStatistics.findMaximumIJDifferenceSuchThatElementAtJIsHigherByTrackingOfSmallestToLeftAndHighestToRight(array);
        assertEquals(6, result);

        array = new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        result = OrderStatistics.findMaximumIJDifferenceSuchThatElementAtJIsHigherByTrackingOfSmallestToLeftAndHighestToRight(array);
        assertEquals(8, result);

        array = new int[]{1, 2, 3, 4, 5, 6};
        result = OrderStatistics.findMaximumIJDifferenceSuchThatElementAtJIsHigherByTrackingOfSmallestToLeftAndHighestToRight(array);
        assertEquals(5, result);

        array = new int[]{6, 5, 4, 3, 2, 1};
        result = OrderStatistics.findMaximumIJDifferenceSuchThatElementAtJIsHigherByTrackingOfSmallestToLeftAndHighestToRight(array);
        assertEquals(-1, result);
    }

    @Test
    @GFGMethod(date = "29-07-2019", algo = "(method 3)deque, and maintaining useful(greater than other to left in window) element of window in deque",
            url = "/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/")
    public void testFindSlidingWindowMaximumOfAllSubarrayOfKLength() {
        int[] array = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int[] result = OrderStatistics.testFindSlidingWindowMaximumOfAllSubarrayOfKLength(array, 3);
        assertArrayEquals(new int[]{3, 3, 4, 5, 5, 5, 6}, result);

        array = new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        result = OrderStatistics.testFindSlidingWindowMaximumOfAllSubarrayOfKLength(array, 4);
        assertArrayEquals(new int[]{10, 10, 10, 15, 15, 90, 90}, result);

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        result = OrderStatistics.testFindSlidingWindowMaximumOfAllSubarrayOfKLength(array, 3);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8, 9, 10}, result);

        array = new int[]{12, 1, 78, 90, 57, 89, 56};
        result = OrderStatistics.testFindSlidingWindowMaximumOfAllSubarrayOfKLength(array, 3);
        assertArrayEquals(new int[]{78, 90, 90, 90, 89}, result);
    }

    @Test
    @GFGMethod(date = "29-07-2019", algo = "(method 2) if any of x or y found update last idx, if next x/y and different than last, then update min dist if lower diff, update last idx",
            url = "/find-the-minimum-distance-between-two-numbers/")
    public void testFindMinimumDistanceBetweenTwoNumber() {
        int[] array = {1, 2};
        int result = OrderStatistics.findMinimumDistanceBetweenTwoNumber(array, 1, 2);
        assertEquals(1, result);

        array = new int[]{3, 4, 5};
        result = OrderStatistics.findMinimumDistanceBetweenTwoNumber(array, 3, 5);
        assertEquals(2, result);

        array = new int[]{3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        result = OrderStatistics.findMinimumDistanceBetweenTwoNumber(array, 3, 6);
        assertEquals(4, result);

        array = new int[]{2, 5, 3, 5, 4, 4, 2, 3};
        result = OrderStatistics.findMinimumDistanceBetweenTwoNumber(array, 3, 2);
        assertEquals(1, result);
    }

    @Test
    @GFGMethod(date = "30-07-2019", algo = "(method 1) linear search",
            url = "/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/")
    public void testFindMaxElementInFirstIncreasingThenDecreasingArray() {
        int[] array = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        int result = OrderStatistics.findMaxElementInFirstIncreasingThenDecreasingArray(array);
        assertEquals(500, result);

        array = new int[]{1, 3, 50, 10, 9, 7, 6};
        result = OrderStatistics.findMaxElementInFirstIncreasingThenDecreasingArray(array);
        assertEquals(50, result);

        array = new int[]{10, 20, 30, 40, 50};
        result = OrderStatistics.findMaxElementInFirstIncreasingThenDecreasingArray(array);
        assertEquals(50, result);

        array = new int[]{120, 100, 80, 20, 0};
        result = OrderStatistics.findMaxElementInFirstIncreasingThenDecreasingArray(array);
        assertEquals(120, result);
    }

    @Test
    @GFGMethod(date = "30-07-2019", algo = "segregate negative to end, mark presence of element by making it negative, return smallest index where ele is positive",
            url = "/find-the-smallest-positive-number-missing-from-an-unsorted-array/")
    public void testFindSmallestPositiveElementMissingInUnsortedArray() {
        int[] array = {2, 3, 7, 6, 8, -1, -10, 15};
        int result = OrderStatistics.findSmallestPositiveElementMissingInUnsortedArray(array);
        assertEquals(1, result);

        array = new int[]{2, 3, -7, 6, 8, 1, -10, 15};
        result = OrderStatistics.findSmallestPositiveElementMissingInUnsortedArray(array);
        assertEquals(4, result);

        array = new int[]{1, 1, 0, -1, -2};
        result = OrderStatistics.findSmallestPositiveElementMissingInUnsortedArray(array);
        assertEquals(2, result);

        array = new int[]{0, 10, 2, -10, -20};
        result = OrderStatistics.findSmallestPositiveElementMissingInUnsortedArray(array);
        assertEquals(1, result);
    }

    @Test
    @GFGMethod(date = "31-07-2019", algo = "use quotient to store freq @index=ele, and reminder to store previous",
            url = "/find-the-maximum-repeating-number-in-ok-time/")
    public void testFindMaximumRepeatingNumberInPositiveArray() {
        int[] array = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
        int result = OrderStatistics.findMaximumRepeatingNumberInPositiveArray(array, 10);
        assertEquals(2, result);

        array = new int[]{2, 3, 3, 5, 3, 4, 1, 7};
        result = OrderStatistics.findMaximumRepeatingNumberInPositiveArray(array, 8);
        assertEquals(3, result);
    }
}
