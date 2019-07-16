package org.gfg.array;


import com.mkp.ALT;
import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

@GFG(date = "16-07-2019", topic = "array rearrangement", url = "")
public class ArrayRearrangeTest {

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange such that a[i]=i or -1, using fix index", url = "/rearrange-array-arri/")
    public void testRearrangeAiIsI() {
        int[] array = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        ArrayRearrange.rearrangeAiIsI(array);
        Assert.assertArrayEquals(new int[]{-1, 1, 2, 3, 4, -1, 6, -1, -1, 9}, array);

        array = new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        ArrayRearrange.rearrangeAiIsI(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange such that a[i]=i or -1, using hash set", url = "/rearrange-array-arri/")
    public void testRearrangeAiIsIUsingHashSet() {
        int[] array = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        ArrayRearrange.rearrangeAiIsIUsingHashSet(array);
        Assert.assertArrayEquals(new int[]{-1, 1, 2, 3, 4, -1, 6, -1, -1, 9}, array);

        array = new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        ArrayRearrange.rearrangeAiIsIUsingHashSet(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange such that a[i]=i or -1, using swap", url = "/rearrange-array-arri/")
    public void testRearrangeAiIsIUsingSwap() {
        int[] array = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        ArrayRearrange.rearrangeAiIsIUsingSwap(array);
        Assert.assertArrayEquals(new int[]{-1, 1, 2, 3, 4, -1, 6, -1, -1, 9}, array);

        array = new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        ArrayRearrange.rearrangeAiIsIUsingSwap(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "reverse array", url = "/write-a-program-to-reverse-an-array-or-string/")
    public void testReverseArray() {
        int[] array = {1, 2, 3};
        ArrayRearrange.reverseArray(array, 0, array.length - 1);
        Assert.assertArrayEquals(new int[]{3, 2, 1}, array);

        array = new int[]{4, 5, 1, 2};
        ArrayRearrange.reverseArray(array, 0, array.length - 1);
        Assert.assertArrayEquals(new int[]{2, 1, 5, 4}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange array in increasing decreasing order by sorting", url = "/rearrange-array-arri-arrj-even-arri/")
    public void testRearrangeArrayInIncreasingDecreasingOrderBySorting() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayRearrange.rearrangeArrayInIncreasingDecreasingOrderUsingSorting(array);
        Assert.assertArrayEquals(new int[]{4, 5, 3, 6, 2, 7, 1}, array);

        array = new int[]{1, 2, 1, 4, 5, 6, 8, 8};
        ArrayRearrange.rearrangeArrayInIncreasingDecreasingOrderUsingSorting(array);
        Assert.assertArrayEquals(new int[]{4, 5, 2, 6, 1, 8, 1, 8}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange array in increasing decreasing order by swapping with next", url = "/rearrange-array-arri-arrj-even-arri/")
    public void testRearrangeArrayInIncreasingDecreasingOrderBySwappingAdjacentElement() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayRearrange.rearrangeArrayInIncreasingDecreasingOrderBySwappingAdjacentElement(array);
        Assert.assertArrayEquals(new int[]{1, 3, 2, 5, 4, 7, 6}, array);

        array = new int[]{1, 2, 1, 4, 5, 6, 8, 8};
        ArrayRearrange.rearrangeArrayInIncreasingDecreasingOrderBySwappingAdjacentElement(array);
        Assert.assertArrayEquals(new int[]{1, 2, 1, 5, 4, 8, 6, 8}, array);
    }


    @Test
    @GFGMethod(date = "16-07-2019", algo = "quick sort partition segregate and replace alternate negative(order not preserved)", url = "/rearrange-positive-and-negative-numbers-publish/")
    public void testRearrangeAlternatePositiveNegative() {
        int[] array = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        ArrayRearrange.rearrangeAlternatePositiveNegative(array);
        Assert.assertArrayEquals(new int[]{4, -3, 5, -1, 6, -7, 2, 8, 9}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "find out of order element and right rotate subarray till next opposite sign element(preserve order)", url = "/rearrange-array-alternating-positive-negative-items-o1-extra-space/")
    public void testRearrangeAlternateNegativePositiveUsingSubarrayRightRotate() {
        int[] array = {1, 2, 3, -4, -1, 4};
        ArrayRearrange.rearrangeAlternateNegativePositiveUsingSubarrayRightRotate(array);
        Assert.assertArrayEquals(new int[]{-4, 1, -1, 2, 3, 4}, array);

        array = new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        ArrayRearrange.rearrangeAlternateNegativePositiveUsingSubarrayRightRotate(array);
        Assert.assertArrayEquals(new int[]{-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}, array);
    }

    @Test
    @ALT(url = "/move-zeroes-end-array-set-2-using-single-traversal/", desc = "swapping element")
    @GFGMethod(date = "16-07-2019", algo = "move all zeros to end", url = "/move-zeroes-end-array/")
    public void testMoveAllZerosToEnd() {
        int[] array = {1, 2, 0, 4, 3, 0, 5, 0};
        ArrayRearrange.moveAllZerosToEnd(array);
        Assert.assertArrayEquals(new int[]{1, 2, 4, 3, 5, 0, 0, 0}, array);


        array = new int[]{1, 2, 0, 0, 0, 3, 6};
        ArrayRearrange.moveAllZerosToEnd(array);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 6, 0, 0, 0}, array);

        array = new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        ArrayRearrange.moveAllZerosToEnd(array);
        Assert.assertArrayEquals(new int[]{1, 9, 8, 4, 2, 7, 6, 9, 0, 0, 0, 0}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "using 2 pointer and sliding window", url = "/minimum-swaps-required-bring-elements-less-equal-k-together/")
    public void testMinSwapToBringTogether() {
        int[] array = {2, 1, 5, 6, 3};
        int swaps = ArrayRearrange.minSwapToBringTogether(array, 3);
        Assert.assertEquals(1, swaps);


        array = new int[]{2, 7, 9, 5, 8, 7, 4};
        swaps = ArrayRearrange.minSwapToBringTogether(array, 5);
        Assert.assertEquals(2, swaps);

        array = new int[]{2, 7, 9, 5, 8, 7, 4};
        swaps = ArrayRearrange.minSwapToBringTogether(array, 7);
        Assert.assertEquals(2, swaps);

        array = new int[]{2, 7, 9, 5, 8, 7, 4};
        swaps = ArrayRearrange.minSwapToBringTogether(array, 8);
        Assert.assertEquals(1, swaps);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "using inbuilt sorting", url = "/rearrange-positive-negative-numbers-using-inbuilt-sort-function/")
    public void testRearrangeAlternateNegativePositiveUsingInbuiltSort() {
        Integer[] array = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        ArrayRearrange.rearrangeAlternatePositiveNegativeUsingInbuiltSort(array);
        Assert.assertArrayEquals(new Integer[]{-13, -5, -7, -3, -6, 12, 11, 6, 5}, array);
    }
}
