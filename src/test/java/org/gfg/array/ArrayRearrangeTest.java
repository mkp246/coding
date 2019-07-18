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
    @ALT(url = "/rearrange-array-such-that-even-positioned-are-greater-than-odd/")
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
    @ALT(url = "rearrange-array-even-index-elements-smaller-odd-index-elements-greater/")
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

    @Test
    @ALT(url = "/rearrange-array-maximum-minimum-form/")
    @GFGMethod(date = "17-07-2019", algo = "rearrange smallest, largest, 2nd smallest, 2nd largest", url = "/rearrange-array-order-smallest-largest-2nd-smallest-2nd-largest/")
    public void testRearrangeMinMax() {
        int[] array = {5, 8, 1, 4, 2, 9, 3, 7, 6};
        int[] result = ArrayRearrange.rearrangeMinMax(array);
        Assert.assertArrayEquals(new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5}, result);

        array = new int[]{1, 2, 3, 4};
        result = ArrayRearrange.rearrangeMinMax(array);
        Assert.assertArrayEquals(new int[]{1, 4, 2, 3}, result);
    }

    @Test
    @GFGMethod(date = "17-07-2019", algo = "double first element if next non zero consecutive is same and push zeros to end", url = "/double-first-element-move-zero-end/")
    public void testDoubleFirstElementAndPushZerosToEnd() {
        int[] array = {2, 2, 0, 4, 0, 8};
        ArrayRearrange.doubleFirstElementAndPushZerosToEnd(array);
        Assert.assertArrayEquals(new int[]{4, 4, 8, 0, 0, 0}, array);

        array = new int[]{0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
        ArrayRearrange.doubleFirstElementAndPushZerosToEnd(array);
        Assert.assertArrayEquals(new int[]{4, 2, 12, 8, 0, 0, 0, 0, 0, 0}, array);
    }

    @Test
    @GFGMethod(date = "17-07-2019", algo = "Reorder an array according to given indexes using temp array", url = "/reorder-a-array-according-to-given-indexes/")
    public void testReorderAccordingToGivenIndexUsingTempArray() {
        int[] array = {10, 11, 12};
        int[] index = {1, 0, 2};
        ArrayRearrange.reorderAccordingToGivenIndexUsingTempArray(array, index);
        Assert.assertArrayEquals(new int[]{11, 10, 12}, array);

        array = new int[]{50, 40, 70, 60, 90};
        index = new int[]{3, 0, 4, 1, 2};
        ArrayRearrange.reorderAccordingToGivenIndexUsingTempArray(array, index);
        Assert.assertArrayEquals(new int[]{40, 60, 90, 50, 70}, array);
    }

    @Test
    @GFGMethod(date = "17-07-2019", algo = "Reorder an array according to given indexes using swapping", url = "/reorder-a-array-according-to-given-indexes/")
    public void testReorderAccordingToGivenIndexUsingSwapping() {
        int[] array = {10, 11, 12};
        int[] index = {1, 0, 2};
        ArrayRearrange.reorderAccordingToGivenIndexUsingSwapping(array, index);
        Assert.assertArrayEquals(new int[]{11, 10, 12}, array);

        array = new int[]{50, 40, 70, 60, 90};
        index = new int[]{3, 0, 4, 1, 2};
        ArrayRearrange.reorderAccordingToGivenIndexUsingSwapping(array, index);
        Assert.assertArrayEquals(new int[]{40, 60, 90, 50, 70}, array);
    }

    @Test
    @GFGMethod(date = "17-07-2019", algo = "using temp array", desc = "Rearrange array such that if arr[i] is j then arr[j] becomes i ", url = "/rearrange-array-arrj-becomes-arri-j/")
    public void testRearrangeArrIJBecomesArrJIUsingTempArray() {
        int[] array = {1, 3, 0, 2};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingTempArray(array);
        Assert.assertArrayEquals(new int[]{2, 0, 3, 1}, array);

        array = new int[]{2, 0, 1, 4, 5, 3};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingTempArray(array);
        Assert.assertArrayEquals(new int[]{1, 2, 0, 5, 3, 4}, array);

        array = new int[]{0, 1, 2, 3};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingTempArray(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3}, array);

        array = new int[]{3, 2, 1, 0};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingTempArray(array);
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0}, array);
    }

    @Test
    @GFGMethod(date = "17-07-2019", algo = "(single cycle only) store target permutation before replacing and apply on target till reach start", desc = "Rearrange array such that if arr[i] is j then arr[j] becomes i ", url = "/rearrange-array-arrj-becomes-arri-j/")
    public void testRearrangeArrIJBecomesArrJIUsingSwapForSingleCycle() {
        int[] array = {1, 3, 0, 2};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingSwapForSingleCycle(array);
        Assert.assertArrayEquals(new int[]{2, 0, 3, 1}, array);

        array = new int[]{2, 0, 1, 4, 5, 3};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingSwapForSingleCycle(array);
        try {
            Assert.assertArrayEquals(new int[]{1, 2, 0, 5, 3, 4}, array);
            Assert.fail("should not work for multi cycle be equal");
        } catch (AssertionError e) {
            Assert.assertTrue(true);
        }

        array = new int[]{0, 1, 2, 3};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingSwapForSingleCycle(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3}, array);

        array = new int[]{3, 2, 1, 0};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingSwapForSingleCycle(array);
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0}, array);
    }

    @Test
    @GFGMethod(date = "17-07-2019",
            algo = "(multi cycle)(add +1 to all as 0=-0)(invert sign of modified element) apply single loop logic, then skips all modified and apply again",
            desc = "Rearrange array such that if arr[i] is j then arr[j] becomes i ",
            url = "/rearrange-array-arrj-becomes-arri-j/")
    public void testRearrangeArrIJBecomesArrJIUsingSwapForMultiCycle() {
        int[] array = {1, 3, 0, 2};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingSwapForMultiCycle(array);
        Assert.assertArrayEquals(new int[]{2, 0, 3, 1}, array);

        array = new int[]{2, 0, 1, 4, 5, 3};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingSwapForMultiCycle(array);
        Assert.assertArrayEquals(new int[]{1, 2, 0, 5, 3, 4}, array);

        array = new int[]{0, 1, 2, 3};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingSwapForMultiCycle(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3}, array);

        array = new int[]{3, 2, 1, 0};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingSwapForMultiCycle(array);
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0}, array);
    }

    @Test
    @GFGMethod(date = "17-07-2019",
            algo = "using quotient and reminder to store new and old value respectively",
            desc = "Rearrange array such that if arr[i] is j then arr[j] becomes i ",
            url = "/rearrange-array-arrj-becomes-arri-j/")
    public void testRearrangeArrIJBecomesArrJIUsingQuotientAndReminder() {
        int[] array = {1, 3, 0, 2};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingQuotientAndReminder(array);
        Assert.assertArrayEquals(new int[]{2, 0, 3, 1}, array);

        array = new int[]{2, 0, 1, 4, 5, 3};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingQuotientAndReminder(array);
        Assert.assertArrayEquals(new int[]{1, 2, 0, 5, 3, 4}, array);

        array = new int[]{0, 1, 2, 3};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingQuotientAndReminder(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3}, array);

        array = new int[]{3, 2, 1, 0};
        ArrayRearrange.rearrangeArrIJBecomesArrJIUsingQuotientAndReminder(array);
        Assert.assertArrayEquals(new int[]{3, 2, 1, 0}, array);
    }

    @Test
    @GFGMethod(date = "17-07-2019",
            algo = "using quotient and reminder to store new and old value respectively",
            desc = "max, min, 2nd max, 2nd min ... sorted array",
            url = "/rearrange-array-maximum-minimum-form-set-2-o1-extra-space/")
    public void testRearrangeMaxMinUsingQuotientAndReminder() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayRearrange.rearrangeMaxMinUsingQuotientAndReminder(array);
        Assert.assertArrayEquals(new int[]{7, 1, 6, 2, 5, 3, 4}, array);

        array = new int[]{1, 2, 3, 4, 5, 6};
        ArrayRearrange.rearrangeMaxMinUsingQuotientAndReminder(array);
        Assert.assertArrayEquals(new int[]{6, 1, 5, 2, 4, 3}, array);

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayRearrange.rearrangeMaxMinUsingQuotientAndReminder(array);
        Assert.assertArrayEquals(new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5}, array);
    }

    @Test
    @ALT(desc = "quick sort lumuto partition", url = "/segregate-even-and-odd-numbers/")
    @GFGMethod(date = "17-07-2019", algo = "quick sort partition(Lumuto partition)", desc = "move all neg to start, pos to end, order not matter",
            url = "/move-negative-numbers-beginning-positive-end-constant-extra-space/")
    public void testMoveAllNegativeToStartPositiveToEnd() {
        int[] array = new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6};
        ArrayRearrange.moveAllNegativeToStartPositiveToEnd(array);
        Assert.assertArrayEquals(new int[]{-12, -13, -5, -7, -3, -6, 5, 6, 11}, array);

        array = new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9};
        ArrayRearrange.moveAllNegativeToStartPositiveToEnd(array);
        Assert.assertArrayEquals(new int[]{-1, -3, -7, 4, 5, 6, 2, 8, 9}, array);
    }

    @Test
    @GFGMethod(date = "18-07-2019", algo = "sort asc then swap with adjacent", desc = "dec inc order", url = "/sort-array-wave-form-2/")
    public void testSortArrayInWaveForm() {
        int[] array = {10, 5, 6, 3, 2, 20, 100, 80};
        ArrayRearrange.sortArrayInWaveForm(array);
        Assert.assertArrayEquals(new int[]{3, 2, 6, 5, 20, 10, 100, 80}, array);

        array = new int[]{20, 10, 8, 6, 4, 2};
        ArrayRearrange.sortArrayInWaveForm(array);
        Assert.assertArrayEquals(new int[]{4, 2, 8, 6, 20, 10}, array);

        array = new int[]{2, 4, 6, 8, 10, 20};
        ArrayRearrange.sortArrayInWaveForm(array);
        Assert.assertArrayEquals(new int[]{4, 2, 8, 6, 20, 10}, array);

        array = new int[]{3, 6, 5, 10, 7, 20};
        ArrayRearrange.sortArrayInWaveForm(array);
        Assert.assertArrayEquals(new int[]{5, 3, 7, 6, 20, 10}, array);

        array = new int[]{10, 90, 49, 2, 1, 5, 23};
        ArrayRearrange.sortArrayInWaveForm(array);
        Assert.assertArrayEquals(new int[]{2, 1, 10, 5, 49, 23, 90}, array);
    }

    @Test
    @GFGMethod(date = "18-07-2019", algo = "Hoare's partitionQuick Sort(2 pointer at even and odd)", desc = "pos at even, neg at odd, if unequal leave untouched", url = "/positive-elements-at-even-and-negative-at-odd-positions-relative-order-not-maintained/")
    public void testRearrangePosAtEvenNegAtOdd() {
        int[] array = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10};
        ArrayRearrange.rearrangePosAtEvenNegAtOdd(array);
        Assert.assertArrayEquals(new int[]{1, -3, 5, -3, 6, 6, 7, -4, 9, 10}, array);

        array = new int[]{-1, 3, -5, 6, 3, 6, -7, -4, -9, 10};
        ArrayRearrange.rearrangePosAtEvenNegAtOdd(array);
        Assert.assertArrayEquals(new int[]{3, -1, 6, -5, 3, -7, 6, -4, 10, -9}, array);
    }

    @Test
    @GFGMethod(date = "18-07-2019", algo = "find defective and replace with next defective other sign)", desc = "pos at even, neg at odd, if unequal leave untouched", url = "/positive-elements-at-even-and-negative-at-odd-positions-relative-order-not-maintained/")
    public void testRearrangePosAtEvenNegAtOddUsingSwapWithNextDefective() {
        int[] array = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10};
        ArrayRearrange.rearrangePosAtEvenNegAtOddUsingSwapWithNextDefective(array);
        Assert.assertArrayEquals(new int[]{1, -3, 5, -3, 6, 6, 7, -4, 9, 10}, array);
    }

    @Test
    @GFGMethod(date = "18-07-2019", algo = "keep track of prev element", desc = "replace elem with mult of prev and next, for start/end prev/next is same as element",
            url = "/replace-every-array-element-by-multiplication-of-previous-and-next/")
    public void testReplaceWithMultOfPreviousAndNext() {
        int[] array = {2, 3, 4, 5, 6};
        ArrayRearrange.replaceWithMultOfPreviousAndNext(array);
        Assert.assertArrayEquals(new int[]{6, 8, 15, 24, 30}, array);
    }

    @Test
    @GFGMethod(date = "18-07-2019", algo = "fisher yates shuffling", url = "/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/")
    public void testShuffleArrayUsingFisherYatesAlgorithm() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrayRearrange.shuffleArrayUsingFisherYatesAlgorithm(array);
        Assert.assertEquals(8, array.length);
    }

    @Test
    @ALT(desc = "dutch national flag problem", url = "http://www.csse.monash.edu.au/~lloyd/tildeAlgDS/Sort/Flag/")
    @GFGMethod(date = "18-07-2019", algo = "keep index at start, end, (find -ve at start, pos at end, swap)till start<end",
            url = "/segregate-even-and-odd-numbers/")
    public void testSegregateEvenAndOdd() {
        int[] array = {12, 34, 45, 9, 8, 90, 3};
        ArrayRearrange.segregateEvenAndOdd(array);
        Assert.assertArrayEquals(new int[]{12, 34, 90, 8, 9, 45, 3}, array);
    }

    @Test
    @GFGMethod(date = "18-07-2019", algo = "keep index at start, end, traverse array if even put ar start, if odd put at end",
            url = "/segregate-even-odd-set-2/")
    public void testSegregateEvenAndOddUsingTempArray() {
        int[] array = {12, 34, 45, 9, 8, 90, 3};
        ArrayRearrange.segregateEvenAndOddUsingTempArray(array);
        Assert.assertArrayEquals(new int[]{12, 34, 8, 90, 3, 9, 45}, array);

        array = new int[]{1, 9, 5, 3, 2, 6, 7, 11};
        ArrayRearrange.segregateEvenAndOddUsingTempArray(array);
        Assert.assertArrayEquals(new int[]{2, 6, 11, 7, 3, 5, 9, 1}, array);

        array = new int[]{1, 3, 2, 4, 7, 6, 9, 10};
        ArrayRearrange.segregateEvenAndOddUsingTempArray(array);
        Assert.assertArrayEquals(new int[]{2, 4, 6, 10, 9, 7, 3, 1}, array);
    }
}
