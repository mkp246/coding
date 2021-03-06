package org.gfg.array;

import com.mkp.ALT;
import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@GFG(date = "18-08-2019", topic = "array sorting", url = "/array-data-structure/array-sorting/", impls = ArraySort.class)
public class ArraySortTest {

    @Test
    @GFGMethod(date = "18-08-2019", algo = "insertion sort", url = "/nearly-sorted-algorithm/")
    public void testSortKSortedArrayUsingInsertionSort() {
        int[] array = {6, 5, 3, 2, 8, 10, 9};
        int[] result = {2, 3, 5, 6, 8, 9, 10};
        ArraySort.sortKSortedArrayUsingInsertionSort(array);
        assertArrayEquals(result, array);

        array = new int[]{10, 9, 8, 7, 4, 70, 60, 50};
        result = new int[]{4, 7, 8, 9, 10, 50, 60, 70};
        ArraySort.sortKSortedArrayUsingInsertionSort(array);
        assertArrayEquals(result, array);
    }

    @Test
    @GFGMethod(date = "18-08-2019", algo = "make heap of size k+1, insert first k, repeat(add one ele from remains, put min in result)",
            url = "/nearly-sorted-algorithm/")
    public void testSortKSortedArrayUsingMinHeap() {
        int[] array = {6, 5, 3, 2, 8, 10, 9};
        int[] result = {2, 3, 5, 6, 8, 9, 10};
        ArraySort.sortKSortedArrayUsingMinHeap(array, 3);
        assertArrayEquals(result, array);

        array = new int[]{10, 9, 8, 7, 4, 70, 60, 50};
        result = new int[]{4, 7, 8, 9, 10, 50, 60, 70};
        ArraySort.sortKSortedArrayUsingMinHeap(array, 4);
        assertArrayEquals(result, array);

        array = new int[]{2, 6, 3, 12, 56, 8};
        result = new int[]{2, 3, 6, 8, 12, 56};
        ArraySort.sortKSortedArrayUsingMinHeap(array, 3);
        assertArrayEquals(result, array);
    }

    @Test
    @GFGMethod(date = "18-08-2019", algo = "using self balancing BST eg. TreeMap<int,int[]> here, k=diff,v=ele with same",
            url = "/sort-an-array-according-to-absolute-difference-with-given-value/")
    public void testSortArrayAccordingToAbsoluteDiffWithGivenValueUsingSelfBalancingBST() {
        int[] array = {10, 5, 3, 9, 2};
        int[] result = {5, 9, 10, 3, 2};
        ArraySort.sortArrayAccordingToAbsoluteDiffWithGivenValueUsingSelfBalancingBST(array, 7);
        assertArrayEquals(result, array);

        array = new int[]{1, 2, 3, 4, 5};
        result = new int[]{5, 4, 3, 2, 1};
        ArraySort.sortArrayAccordingToAbsoluteDiffWithGivenValueUsingSelfBalancingBST(array, 6);
        assertArrayEquals(result, array);

        array = new int[]{2, 6, 8, 3};
        result = new int[]{6, 3, 2, 8};
        ArraySort.sortArrayAccordingToAbsoluteDiffWithGivenValueUsingSelfBalancingBST(array, 5);
        assertArrayEquals(result, array);
    }

    @Test
    @GFGMethod(date = "18-08-2019", algo = "move -1=n/a element in last of mnArray, keep to pointer one at n, other at 0, merge in mnArray",
            url = "/merge-one-array-of-size-n-into-another-one-of-size-mn/")
    public void testMergeNArrayIntoMPlusNArraySorted() {
        int[] mNArray = {2, -1, 7, -1, -1, 10, -1};
        int[] nArray = {5, 8, 12, 14};
        ArraySort.mergeNArrayIntoMPlusNArraySorted(mNArray, nArray);
        assertArrayEquals(new int[]{2, 5, 7, 8, 10, 12, 14}, mNArray);

        mNArray = new int[]{2, 8, -1, -1, -1, 13, -1, 15, 20};
        nArray = new int[]{5, 7, 9, 25};
        ArraySort.mergeNArrayIntoMPlusNArraySorted(mNArray, nArray);
        assertArrayEquals(new int[]{2, 5, 7, 8, 9, 13, 15, 20, 25}, mNArray);
    }

    @Test
    @GFGMethod(date = "19-08-2019", algo = "set pos=0,traverse from start to end, if 0 is found swap with current pos,increment pos",
            url = "/sort-array-containing-two-types-elements/")
    public void testSegregateZerosOnLeft() {
        int[] array = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        ArraySort.segregateZerosOnLeft(array);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, array);

        array = new int[]{1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1};
        ArraySort.segregateZerosOnLeft(array);
        assertArrayEquals(new int[]{0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, array);
    }

    @Test
    @GFGMethod(date = "19-08-2019", algo = "(method 2) by sorting, and traversing two pointer one @0, other @end, moving them closer by moving left if sum is -ve, else right one",
            url = "/two-elements-whose-sum-is-closest-to-zero/")
    public void testFindTwoElementsWithSumClosestToZeroUsingSoring() {
        int[] array = {1, 60, -10, 70, -80, 85};
        int[] result = ArraySort.findTwoElementsWithSumClosestToZeroUsingSorting(array);
        assertArrayEquals(new int[]{-80, 85}, result);
    }

    @Test
    @GFGMethod(date = "19-08-2019", algo = "(method 2) by sorting acc to abs value, and adding adjacent 2 and checking min abs",
            url = "/two-elements-whose-sum-is-closest-to-zero/")
    public void testFindTwoElementsWithSumClosestToZeroUsingAbsoluteSoring() {
        Integer[] array = {1, 60, -10, 70, -80, 85};
        int[] result = ArraySort.findTwoElementsWithSumClosestToZeroUsingSortingUsingAbsoluteSoring(array);
        assertArrayEquals(new int[]{-80, 85}, result);
    }

    @Test
    @GFGMethod(date = "19-08-2019", algo = "will be either 0(in case inc, or dec array) or 3",
            url = "/shortest-un-ordered-subarray/")
    public void testShortestUnorderedSubarrayLength() {
        int[] array = {7, 9, 10, 8, 11};
        int result = ArraySort.shortestUnorderedSubarrayLength(array);
        assertEquals(3, result);

        array = new int[]{1, 2, 3, 4, 5};
        result = ArraySort.shortestUnorderedSubarrayLength(array);
        assertEquals(0, result);
    }

    @Test
    @GFGMethod(date = "19-08-2019", algo = "make pair(val,idx) array, sort acc. to val,make bool visited array, sum cycleLength-1 for all cycle",
            url = "/minimum-number-swaps-required-sort-array/")
    public void testMinSwapsRequiredToSortArray() {
        int[] array = {4, 3, 2, 1};
        int result = ArraySort.minSwapsRequiredToSortArray(array);
        assertEquals(2, result);

        array = new int[]{1, 5, 4, 3, 2};
        result = ArraySort.minSwapsRequiredToSortArray(array);
        assertEquals(2, result);

        array = new int[]{14, 15, 12, 11, 15};
        result = ArraySort.minSwapsRequiredToSortArray(array);
        assertEquals(3, result);
    }

    @Test
    @GFGMethod(date = "19-08-2019", algo = "keep two pointer one on each,increment smaller element one and put in union if unequal, else put in union and common, increment both pointer",
            desc = "if length ratio is logarithmic order, then use binary search shorter arr ele in big one ",
            url = "/union-and-intersection-of-two-sorted-arrays-2/")
    public void testUnionAndIntersectionOfTwoSortedArray() {
        int[] array1 = {1, 3, 4, 5, 7};
        int[] array2 = {2, 3, 5, 6};
        int[][] result = ArraySort.unionAndIntersectionOfTwoSortedArray(array1, array2);
        assertArrayEquals(new int[][]{{1, 2, 3, 4, 5, 6, 7}, {3, 5}}, result);

        array1 = new int[]{2, 5, 6};
        array2 = new int[]{4, 6, 8, 10};
        result = ArraySort.unionAndIntersectionOfTwoSortedArray(array1, array2);
        assertArrayEquals(new int[][]{{2, 4, 5, 6, 8, 10}, {6}}, result);

        array1 = new int[]{1, 2, 4, 5, 6};
        array2 = new int[]{2, 3, 5, 7};
        result = ArraySort.unionAndIntersectionOfTwoSortedArray(array1, array2);
        assertArrayEquals(new int[][]{{1, 2, 3, 4, 5, 6, 7}, {2, 5}}, result);

        // with duplicates
        array1 = new int[]{1, 2, 2, 2, 3};
        array2 = new int[]{2, 3, 4, 5};
        result = ArraySort.unionAndIntersectionOfTwoSortedArray(array1, array2);
        assertArrayEquals(new int[][]{{1, 2, 3, 4, 5}, {2, 3}}, result);
    }

    @Test
    @GFGMethod(date = "20-08-2019", algo = "3 way partitioning", url = "/sort-an-array-of-0s-1s-and-2s/")
    public void testSortArrayOfZerosOnesAndTwos() {
        int[] array = {0, 1, 2, 0, 1, 2};
        int[] result = {0, 0, 1, 1, 2, 2};
        ArraySort.sortArrayOfZerosOnesAndTwos(array);
        assertArrayEquals(result, array);

        array = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        result = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2};
        ArraySort.sortArrayOfZerosOnesAndTwos(array);
        assertArrayEquals(result, array);
    }

    @Test
    @GFGMethod(date = "20-08-2019", algo = "find first dec as start, last dec+1 as end, find min/max between them," +
            " if higher/lower than min/max exist on left/right (first from start/end), make them start/end respectively, return start,end",
            url = "/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/")
    public void testMinLengthUnsortedSubarraySortingWhichMakesArraySorted() {
        int[] array = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int[] result = ArraySort.minLengthUnsortedSubarraySortingWhichMakesArraySorted(array);
        assertArrayEquals(new int[]{3, 8}, result);

        array = new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50};
        result = ArraySort.minLengthUnsortedSubarraySortingWhichMakesArraySorted(array);
        assertArrayEquals(new int[]{2, 5}, result);
    }

    @Test
    @GFGMethod(date = "20-08-2019", algo = "sort array, pick idx i<j,foreach pair i,k, count higher ele. than sum(i,j) in arr[j+1]...arr[n] and add to count",
            url = "/find-number-of-triangles-possible/", tComp = "O(n^2)")
    public void testCountNumberOfTrianglePossibleUsingThreeNestedLoop() {
        int[] array = {4, 6, 3, 7};
        int result = ArraySort.countNumberOfTrianglePossibleUsingThreeNestedLoop(array);
        assertEquals(3, result);

        array = new int[]{10, 21, 22, 100, 101, 200, 300};
        result = ArraySort.countNumberOfTrianglePossibleUsingThreeNestedLoop(array);
        assertEquals(6, result);

        array = new int[]{4, 3, 5, 7, 6};
        result = ArraySort.countNumberOfTrianglePossibleUsingThreeNestedLoop(array);
        assertEquals(9, result);
    }

    @Test
    @GFGMethod(date = "20-08-2019", algo = "for each triangle with highest as arr[i], keep to pointer l=0,r=i-1,if sum of l,r is higher inc count by r-l and r--, else l++ till l<r",
            url = "/find-number-of-triangles-possible/")
    public void testCountNumberOfTrianglePossibleUsingTwoPointerMethod() {
        int[] array = {4, 6, 3, 7};
        int result = ArraySort.countNumberOfTrianglePossibleUsingTwoPointerMethod(array);
        assertEquals(3, result);

        array = new int[]{10, 21, 22, 100, 101, 200, 300};
        result = ArraySort.countNumberOfTrianglePossibleUsingTwoPointerMethod(array);
        assertEquals(6, result);

        array = new int[]{4, 3, 5, 7, 6};
        result = ArraySort.countNumberOfTrianglePossibleUsingTwoPointerMethod(array);
        assertEquals(9, result);
    }

    @Test
    @GFGMethod(date = "21-08-2019", algo = "look at log(x)/x curve, has max at x=e, which decides condition of y for given x, use table lookup for deviations",
            url = "/find-number-pairs-xy-yx/")
    public void testCountXYPairsSuchThatXpowerYGreterThanYpowerX() {
        int[] array1 = {2, 1, 6};
        int[] array2 = {1, 5};
        int result = ArraySort.countXYPairsSuchThatXpowerYGreterThanYpowerX(array1, array2);
        assertEquals(3, result);

        array1 = new int[]{10, 19, 18};
        array2 = new int[]{11, 15, 9};
        result = ArraySort.countXYPairsSuchThatXpowerYGreterThanYpowerX(array1, array2);
        assertEquals(2, result);
    }

    @Test
    @GFGMethod(date = "21-08-2019", algo = "use hash map/set to keep track of already visited elements",
            url = "/print-distinct-elements-given-integer-array/")
    public void testPrintDistinctElementsUsingHashing() {
        int[] array = {10, 5, 3, 4, 3, 5, 6};
        int[] result = ArraySort.printDistinctElementsUsingHashing(array);
        assertArrayEquals(new int[]{10, 5, 3, 4, 6}, result);

        array = new int[]{12, 10, 9, 45, 2, 10, 10, 45};
        result = ArraySort.printDistinctElementsUsingHashing(array);
        assertArrayEquals(new int[]{12, 10, 9, 45, 2}, result);

        array = new int[]{1, 2, 3, 4, 5};
        result = ArraySort.printDistinctElementsUsingHashing(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);


        array = new int[]{1, 1, 1, 1, 1};
        result = ArraySort.printDistinctElementsUsingHashing(array);
        assertArrayEquals(new int[]{1}, result);

        array = new int[]{6, 10, 5, 4, 9, 120, 4, 6, 10};
        result = ArraySort.printDistinctElementsUsingHashing(array);
        assertArrayEquals(new int[]{6, 10, 5, 4, 9, 120}, result);

        array = new int[]{10, 5, 3, 4, 3, 5, 6};
        result = ArraySort.printDistinctElementsUsingHashing(array);
        assertArrayEquals(new int[]{10, 5, 3, 4, 6}, result);
    }

    @Test
    @GFGMethod(date = "21-08-2019", algo = "find a[0] using (p[0]+p[1]-p[len-1])/2, use a[0] to find other using starting elements of pair",
            url = "/construct-array-pair-sum-array/")
    public void testConstructArrayFromItsPairSumArray() {
        int[] pairSum = {14, 9, 10, 11, 12, 7};
        int[] result = ArraySort.constructArrayFromItsPairSumArray(pairSum, 4);
        assertArrayEquals(new int[]{6, 8, 3, 4}, result);

        pairSum = new int[]{15, 13, 11, 10, 12, 10, 9, 8, 7, 5};
        result = ArraySort.constructArrayFromItsPairSumArray(pairSum, 5);
        assertArrayEquals(new int[]{8, 7, 5, 3, 2}, result);
    }

    @Test
    @GFGMethod(date = "21-08-2019", algo = "iterate a2 from last,find correct pos of it in a[1],[if required]shift all element right by 1, move last of a1 at place of elem in a2",
            url = "/merge-two-sorted-arrays-o1-extra-space/")
    public void testMergeTwoSortedArrayWithConstantExtraSpace() {
        int[] array1 = {10};
        int[] array2 = {2, 3};
        ArraySort.mergeTwoSortedArrayWithConstantExtraSpace(array1, array2);
        assertArrayEquals(new int[]{2}, array1);
        assertArrayEquals(new int[]{3, 10}, array2);

        array1 = new int[]{1, 5, 9, 10, 15, 20};
        array2 = new int[]{2, 3, 8, 13};

        ArraySort.mergeTwoSortedArrayWithConstantExtraSpace(array1, array2);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, array1);
        assertArrayEquals(new int[]{10, 13, 15, 20}, array2);
    }

    @Test
    @GFGMethod(date = "22-08-2019", algo = "find max of first, min of second, return product",
            url = "/product-maximum-first-array-minimum-second/")
    public void testFindProductOfMaxOfFirstAndMinOfSecondArray() {
        int[] array1 = {5, 7, 9, 3, 6, 2};
        int[] array2 = {1, 2, 6, -1, 0, 9};
        int result = ArraySort.findProductOfMaxOfFirstAndMinOfSecondArray(array1, array2);
        assertEquals(-9, result);

        array1 = new int[]{1, 4, 2, 3, 10, 2};
        array2 = new int[]{4, 2, 6, 5, 2, 9};
        result = ArraySort.findProductOfMaxOfFirstAndMinOfSecondArray(array1, array2);
        assertEquals(20, result);

        array1 = new int[]{10, 2, 3, 6, 4, 1};
        array2 = new int[]{5, 1, 4, 2, 6, 9};
        result = ArraySort.findProductOfMaxOfFirstAndMinOfSecondArray(array1, array2);
        assertEquals(10, result);
    }

    @Test
    @GFGMethod(date = "22-08-2019", algo = "find count of max ele in both, return (c1*c2)/(len1*len2)",
            url = "/product-maximum-first-array-minimum-second/")
    public void testProbabilityOfRandomPairBeingMaximumWeightedTwoArray() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 3, 3};
        double result = ArraySort.probabilityOfRandomPairBeingMaximumWeightedTwoArray(array1, array2);
        assertEquals(0.222, result, 0.001);
    }

    @Test
    @GFGMethod(date = "22-08-2019", algo = "make a copy, sort the copy, count deviations at corresponding element in both, reverse the copy repeat, return min of both deviation count",
            url = "/minimum-de-arrangements-present-array-ap-arithmetic-progression/")
    public void testMinimumDearragementPresentInAPArray() {
        int[] array = {8, 6, 10, 4, 2};
        int result = ArraySort.minimumDearragementPresentInAPArray(array);
        assertEquals(3, result);

        array = new int[]{5, 10, 15, 25, 20};
        result = ArraySort.minimumDearragementPresentInAPArray(array);
        assertEquals(2, result);

        array = new int[]{5, 9, 21, 17, 13};
        result = ArraySort.minimumDearragementPresentInAPArray(array);
        assertEquals(2, result);
    }

    @Test
    @GFGMethod(date = "22-08-2019", algo = "prod sum will be min when one is inc other dec,check if pairs are same after sorting or not",
            url = "/de-arrangements-for-minimum-product-sum-of-two-arrays/")
    public void testDearragementForMinProductSumTwoArray() {
        int[] array1 = {4, 3, 2};
        int[] array2 = {7, 12, 5};
        int result = ArraySort.dearragementForMinProductSumTwoArray(array1, array2);
        assertEquals(3, result);

        array1 = new int[]{4, 3, 2};
        array2 = new int[]{1, 2, 3};
        result = ArraySort.dearragementForMinProductSumTwoArray(array1, array2);
        assertEquals(0, result);

        array1 = new int[]{1, 2, 3, 4};
        array2 = new int[]{6, 3, 4, 5};
        result = ArraySort.dearragementForMinProductSumTwoArray(array1, array2);
        assertEquals(2, result);
    }

    @Test
    @GFGMethod(date = "24-08-2019", algo = "k=1 min, k=2 max of first and last, k>=3 max element",
            url = "/divide-array-k-segments-maximize-maximum-segment-minimums/")
    public void testMaximumOfKSegmentsMinimumInArray() {
        int[] array = {1, 2, 3, 6, 5};
        int result = ArraySort.maximumOfKSegmentsMinimumInArray(array, 2);
        assertEquals(5, result);

        array = new int[]{4, -5, -3, -2, -1};
        result = ArraySort.maximumOfKSegmentsMinimumInArray(array, 1);
        assertEquals(-5, result);

        array = new int[]{-10, -9, -8, 2, 7, -6, -5};
        result = ArraySort.maximumOfKSegmentsMinimumInArray(array, 2);
        assertEquals(-5, result);
    }

    @Test
    @GFGMethod(date = "24-08-2019", algo = "sort the array check a[2]=a[0] or a[1], if all same nC3, if last 2 same nc2, if first 2 same or all diff n=nC1, where n is freq of 3rd element in sorted array",
            url = "/count-ways-form-minimum-product-triplets/")
    public void testCountWaysToFormMinProductTriplets() {
        int[] array = {1, 3, 2, 3, 4};
        int result = ArraySort.countWaysToFormMinProductTriplets(array);
        assertEquals(2, result);

        array = new int[]{2, 2, 2, 2, 2};
        result = ArraySort.countWaysToFormMinProductTriplets(array);
        assertEquals(10, result);

        array = new int[]{1, 3, 3, 1, 3, 2};
        result = ArraySort.countWaysToFormMinProductTriplets(array);
        assertEquals(1, result);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "sort both, sum abs diff between values at idx in both arrays",
            url = "/making-elements-of-two-arrays-same-with-minimum-incrementdecrement/")
    public void testMakingTwoArraySameWithMinimumIncrementDecrement() {
        int[] array1 = {3, 1, 1};
        int[] array2 = {1, 2, 2};
        int result = ArraySort.makingTwoArraySameWithMinimumIncrementDecrement(array1, array2);
        assertEquals(2, result);

        array1 = new int[]{3, 1, 1};
        array2 = new int[]{1, 1, 2};
        result = ArraySort.makingTwoArraySameWithMinimumIncrementDecrement(array1, array2);
        assertEquals(1, result);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "sort by start point, check if adj are completely overlapping by checking @i[1]>=@i+1[1]",
            url = "/check-interval-completely-overlaps/")
    public void testCheckIfIntervalsCompletelyOverlaps() {
        int[][] intervals = {{1, 3}, {1, 7}, {4, 8}, {2, 5}};
        boolean result = ArraySort.checkIfIntervalsCompletelyOverlaps(intervals);
        assertTrue(result);

        intervals = new int[][]{{1, 3}, {7, 9}, {4, 6}, {10, 13}};
        result = ArraySort.checkIfIntervalsCompletelyOverlaps(intervals);
        assertFalse(result);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "copy element except in interval in new array, sort, replace back in old array except the interval",
            url = "/sorting-array-except-elements-subarray/")
    public void testSortingElementExceptInSubarray() {
        int[] array = {10, 4, 11, 7, 6, 20};
        ArraySort.sortingElementExceptInSubarray(array, 1, 3);
        assertArrayEquals(new int[]{6, 4, 11, 7, 10, 20}, array);

        array = new int[]{5, 4, 3, 12, 14, 9};
        ArraySort.sortingElementExceptInSubarray(array, 1, 2);
        assertArrayEquals(new int[]{5, 4, 3, 9, 12, 14}, array);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "put ele at k in end, sort from 0 to end-1(leave last ele), from end upto k shift all by one to right, put array[k]=last",
            url = "/sorting-array-elements-except-one/")
    public void testSortingElementExceptOne() {
        int[] array = {10, 4, 11, 7, 6, 20};
        ArraySort.sortingElementExceptOne(array, 2);
        assertArrayEquals(new int[]{4, 6, 11, 7, 10, 20}, array);

        array = new int[]{30, 20, 10};
        ArraySort.sortingElementExceptOne(array, 0);
        assertArrayEquals(new int[]{30, 10, 20}, array);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "count zeros of right side of each 1 and sum",
            url = "/minimum-swaps-required-sort-binary-array/")
    public void testMinAdjacentSwapsRequiredToSortBinaryArray() {
        int[] array = {0, 0, 1, 0, 1, 0, 1, 1};
        int result = ArraySort.minAdjacentSwapsRequiredToSortBinaryArray(array);
        assertEquals(3, result);

        array = new int[]{0, 1, 0, 1, 0};
        result = ArraySort.minAdjacentSwapsRequiredToSortBinaryArray(array);
        assertEquals(3, result);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "make map of order ele and index, use custom sort comparator which compares the index of ele lookup in map",
            url = "/sort-linked-list-order-elements-appearing-array/")
    public void testSortArrayInOrderOfElementInOtherArray() {
        Integer[] array = {3, 2, 5, 8, 5, 2, 1};
        int[] order = {5, 1, 3, 2, 8};
        ArraySort.sortArrayInOrderOfElementInOtherArray(array, order);
        assertArrayEquals(new Integer[]{5, 5, 1, 3, 2, 2, 8}, array);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "use tree set, add all element, covert tree set to array",
            url = "/print-sorted-distinct-elements-array-c/")
    public void testPrintSortedDistinctElement() {
        int[] array = {1, 3, 2, 2, 1};
        int[] result = ArraySort.printSortedDistinctElement(array);
        assertArrayEquals(new int[]{1, 2, 3}, result);

        array = new int[]{1, 1, 1, 2, 2, 3};
        result = ArraySort.printSortedDistinctElement(array);
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "if max so far = current idx then we can make partition at that point",
            url = "/maximum-number-partitions-can-sorted-individually-make-sorted/")
    public void testMaxPartitionIndividuallySortedMakeArraySorted() {
        int[] array = {1, 0, 2, 3, 4};
        int result = ArraySort.maxPartitionIndividuallySortedMakeArraySorted(array);
        assertEquals(4, result);

        array = new int[]{2, 1, 0, 3};
        result = ArraySort.maxPartitionIndividuallySortedMakeArraySorted(array);
        assertEquals(2, result);

        array = new int[]{2, 1, 0, 3, 4, 5};
        result = ArraySort.maxPartitionIndividuallySortedMakeArraySorted(array);
        assertEquals(4, result);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "iterate i from 1 to sqrt(n), if divisible add n/i and i both if diff, else add only one(perfect square)",
            url = "/find-divisors-natural-number-set-1/")
    public void testFindAllDivisorsOfNaturalNumber() {
        int[] result = ArraySort.findAllDivisorsOfNaturalNumber(10);
        assertArrayEquals(new int[]{1, 10, 2, 5}, result);

        result = ArraySort.findAllDivisorsOfNaturalNumber(100);
        assertArrayEquals(new int[]{1, 100, 2, 50, 4, 25, 5, 20, 10}, result);

        result = ArraySort.findAllDivisorsOfNaturalNumber(125);
        assertArrayEquals(new int[]{1, 125, 5, 25}, result);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "keep separate list of quotient which are in dec order, reverse append to result",
            url = "/find-all-divisors-of-a-natural-number-set-2/")
    public void testFindAllDivisorsOfNaturalNumberSorted() {
        int[] result = ArraySort.findAllDivisorsOfNaturalNumberSorted(10);
        assertArrayEquals(new int[]{1, 2, 5, 10}, result);

        result = ArraySort.findAllDivisorsOfNaturalNumberSorted(100);
        assertArrayEquals(new int[]{1, 2, 4, 5, 10, 20, 25, 50, 100}, result);

        result = ArraySort.findAllDivisorsOfNaturalNumberSorted(125);
        assertArrayEquals(new int[]{1, 5, 25, 125}, result);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "from 1 to sqrt(n) if divisible count+=2, if perfect square then in end iteration count+=1",
            url = "/sort-elements-basis-number-factors/")
    public void testCountAllDivisorsOfNaturalNumber() {
        int result = ArraySort.countAllDivisorsOfNaturalNumber(10);
        assertEquals(4, result);

        result = ArraySort.countAllDivisorsOfNaturalNumber(100);
        assertEquals(9, result);

        result = ArraySort.countAllDivisorsOfNaturalNumber(125);
        assertEquals(4, result);
    }

    @Test
    @ALT(url = "/sort-basis-number-factors-using-stl/")
    @GFGMethod(date = "25-08-2019", algo = "make pair of ele and num divisors, sort acc to num div in desc reverse order",
            url = "/sort-elements-basis-number-factors/")
    public void testSortArrayBasedOnCountOfDivisorsOfElement() {
        int[] array = {5, 11, 10, 20, 9, 16, 23};
        ArraySort.sortArrayBasedOnCountOfDivisorsOfElement(array);
        assertArrayEquals(new int[]{20, 16, 10, 9, 5, 11, 23}, array);

        array = new int[]{104, 210, 315, 166, 441, 180};
        ArraySort.sortArrayBasedOnCountOfDivisorsOfElement(array);
        assertArrayEquals(new int[]{180, 210, 315, 441, 104, 166}, array);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "sort in inc order, init cut=@0, if ele>cut then update cut to ele, print len-idx else increase idx",
            url = "/ropes-left-every-cut/")
    public void testRopesLeftEveryCut() {
        int[] array = {5, 1, 1, 2, 3, 5};
        int[] result = ArraySort.ropesLeftEveryCut(array);
        assertArrayEquals(new int[]{4, 3, 2}, result);

        array = new int[]{5, 1, 6, 9, 8, 11, 2, 2, 6, 5};
        result = ArraySort.ropesLeftEveryCut(array);
        assertArrayEquals(new int[]{9, 7, 5, 3, 2, 1}, result);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "make freq tree map, starting lowest num in map calc rank of each ele and store back in map, traverse array and set value by looking up rank in map",
            url = "/rank-elements-array/")
    public void testRankElementsInArray() {
        int[] array = {20, 30, 10};
        double[] result = ArraySort.rankElementsInArray(array);
        assertArrayEquals(new double[]{2.0, 3.0, 1.0}, result, 0.01);

        array = new int[]{10, 12, 15, 12, 10, 25, 12};
        result = ArraySort.rankElementsInArray(array);
        assertArrayEquals(new double[]{1.5, 4.0, 6.0, 4.0, 1.5, 7.0, 4.0}, result, 0.01);

        array = new int[]{1, 2, 5, 2, 1, 60, 3};
        result = ArraySort.rankElementsInArray(array);
        assertArrayEquals(new double[]{1.5, 3.5, 6.0, 3.5, 1.5, 7.0, 5.0}, result, 0.01);

        array = new int[]{1, 2, 5, 2, 1, 25, 2};
        result = ArraySort.rankElementsInArray(array);
        assertArrayEquals(new double[]{1.5, 4.0, 6.0, 4.0, 1.5, 7.0, 4.0}, result, 0.01);
    }

    @Test
    @GFGMethod(date = "25-08-2019", algo = "by merging two at a time, and merging third with result of first two",
            desc = "(alt) can merge 3 at a time, will reduce temp space required,OR merge K sorted array using Min heap",
            url = "/merge-3-sorted-arrays/")
    public void testMergeThreeSortedArray() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {2, 3, 4};
        int[] array3 = {4, 5, 6, 7};
        int[] result = ArraySort.mergeThreeSortedArray(array1, array2, array3);
        assertArrayEquals(new int[]{1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 7}, result);

        array1 = new int[]{1, 2, 3, 5};
        array2 = new int[]{6, 7, 8, 9};
        array3 = new int[]{10, 11, 12};
        result = ArraySort.mergeThreeSortedArray(array1, array2, array3);
        assertArrayEquals(new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12}, result);

        array1 = new int[]{1, 2, 41, 52, 84};
        array2 = new int[]{1, 2, 41, 52, 67};
        array3 = new int[]{1, 2, 41, 52, 67, 85};
        result = ArraySort.mergeThreeSortedArray(array1, array2, array3);
        assertArrayEquals(new int[]{1, 1, 1, 2, 2, 2, 41, 41, 41, 52, 52, 52, 67, 67, 84, 85}, result);
    }

    @Test
    @GFGMethod(date = "28-08-2019", algo = "start from left, subtract k until next element becomes lower or equal",
            url = "/find-minimum-number-operation-make-array-decreasing/")
    public void testMinOperationsToMakeArrayDecreasing() {
        int[] array = {1, 1, 2, 3};
        int result = ArraySort.minSubtractionOperationsToMakeArrayDecreasing(array, 5);
        assertEquals(3, result);

        array = new int[]{5, 4, 3, 2, 1};
        result = ArraySort.minSubtractionOperationsToMakeArrayDecreasing(array, 5);
        assertEquals(0, result);
    }
}
