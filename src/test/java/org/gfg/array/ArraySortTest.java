package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
}
