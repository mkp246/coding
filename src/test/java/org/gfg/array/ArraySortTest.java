package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

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
}
