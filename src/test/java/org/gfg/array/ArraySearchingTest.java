package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@GFG(date = "01-09-2019", topic = "array searching", url = "/array-data-structure/array-searching/", impls = ArraySearching.class)
public class ArraySearchingTest {

    @Test
    @GFGMethod(date = "01-09-2019", algo = "linear search", url = "/search-insert-and-delete-in-an-unsorted-array/")
    public void testSearchInUnsortedArray() {
        int[] array = {12, 34, 10, 6, 40};
        int result = ArraySearching.searchInUnsortedArray(array, 40);
        assertEquals(4, result);

        result = ArraySearching.searchInUnsortedArray(array, 10);
        assertEquals(2, result);

        result = ArraySearching.searchInUnsortedArray(array, 9);
        assertEquals(-1, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "insert in end if cap > total, increment total else error",
            url = "/search-insert-and-delete-in-an-unsorted-array/")
    public void testInsertInEndOfArray() {
        int[] array = new int[20];
        array[0] = 12;
        array[1] = 16;
        array[2] = 20;
        array[3] = 40;
        array[4] = 50;
        array[5] = 70;
        int capacity = 20;
        int total = 6;
        ArraySearching.insertInEndOfArray(array, 26, total, capacity);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= total; i++) {
            result.append(array[i]).append(",");
        }
        assertEquals("12,16,20,40,50,70,26,", result.toString());
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "search key if found shift all the element to left by 1, decrement total count",
            url = "/search-insert-and-delete-in-an-unsorted-array/")
    public void testDeleteElementOfArray() {
        int[] array = {10, 50, 30, 40, 20};
        int count = ArraySearching.deleteElementOfArray(array, 30, array.length);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(array[i]).append(",");
        }
        assertEquals("10,50,40,20,", result.toString());
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "binary search", url = "/search-insert-and-delete-in-a-sorted-array/")
    public void testBinarySearchInSortedArray() {
        int[] array = {5, 6, 7, 8, 9, 10};
        int result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 10);
        assertEquals(5, result);

        result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 7);
        assertEquals(2, result);

        result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 5);
        assertEquals(0, result);

        result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 4);
        assertEquals(-1, result);

        result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 12);
        assertEquals(-1, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "jump forward by abs diff between ele and key, starting from 0",
            url = "/search-an-element-in-an-array-where-difference-between-adjacent-elements-is-1/")
    public void testSearchInArrayWhereAdjacentDifferenceIsOne() {
        int[] array = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3};
        int result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 3);
        assertEquals(7, result);

        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 2);
        assertEquals(8, result);

        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 4);
        assertEquals(6, result);

        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 10);
        assertEquals(-1, result);

        array = new int[]{1, 2, 3, 4, 5, 4};
        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 5);
        assertEquals(4, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "jump forward by ceil (abs diff between ele and key)/k, starting from 0",
            url = "/searching-array-adjacent-differ-k/")
    public void testSearchInArrayWhereAdjacentDifferenceIsAtMostK() {
        int[] array = {4, 5, 6, 7, 6};
        int result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsAtMostK(array, 6, 1);
        assertEquals(2, result);

        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsAtMostK(array, 8, 1);
        assertEquals(-1, result);

        array = new int[]{20, 40, 50, 70, 70, 60};
        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsAtMostK(array, 60, 20);
        assertEquals(5, result);
    }


    @Test
    @GFGMethod(date = "01-09-2019", algo = "find common in first two, check if common is present in tree, if present inc all ptr, else just first two ptr",
            url = "/find-common-elements-three-sorted-arrays/")
    public void testFindCommonInThreeSortedArray() {
        int[] array1 = {1, 5, 10, 20, 40, 80};
        int[] array2 = {6, 7, 20, 80, 100};
        int[] array3 = {3, 4, 15, 20, 30, 70, 80, 120};
        int[] result = ArraySearching.findCommonInThreeSortedArray(array1, array2, array3);
        assertArrayEquals(new int[]{20, 80}, result);

        array1 = new int[]{1, 5, 5};
        array2 = new int[]{3, 4, 5, 5, 10};
        array3 = new int[]{5, 5, 10, 20};
        result = ArraySearching.findCommonInThreeSortedArray(array1, array2, array3);
        assertArrayEquals(new int[]{5, 5}, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "set start=0, end =1, if key<=@end,bin search else start=end+1, end*=2,repeat",
            url = "/find-position-element-sorted-array-infinite-numbers/")
    public void testFindElementInInfiniteSortedArray() {
        int[] array = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int result = ArraySearching.findElementInInfiniteSortedArray(array, 10);
        assertEquals(4, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "sum all element, subtract ele sum by n*(n*1)/2 formula",
            url = "/find-repetitive-element-1-n-1/")
    public void testFindOnlyRepetitiveElementInUnsortedArray1ToNUsingSumFormula() {
        int[] array = {1, 3, 2, 3, 4};
        int result = ArraySearching.findOnlyRepetitiveElementInUnsortedArray1ToNMinus1UsingSumFormula(array);
        assertEquals(3, result);

        array = new int[]{1, 5, 1, 2, 3, 4};
        result = ArraySearching.findOnlyRepetitiveElementInUnsortedArray1ToNMinus1UsingSumFormula(array);
        assertEquals(1, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "keep track of visited element in hash set,if set contains ele return ele",
            url = "/find-repetitive-element-1-n-1/")
    public void testFindOnlyRepetitiveElementInUnsortedArray1ToNUsingHashing() {
        int[] array = {1, 3, 2, 3, 4};
        int result = ArraySearching.findOnlyRepetitiveElementInUnsortedArray1ToNMinus1UsingHashing(array);
        assertEquals(3, result);

        array = new int[]{1, 5, 1, 2, 3, 4};
        result = ArraySearching.findOnlyRepetitiveElementInUnsortedArray1ToNMinus1UsingHashing(array);
        assertEquals(1, result);

        array = new int[]{9, 8, 2, 6, 1, 8, 5, 3, 4, 7};
        result = ArraySearching.findOnlyRepetitiveElementInUnsortedArray1ToNMinus1UsingHashing(array);
        assertEquals(8, result);
    }


    @Test
    @GFGMethod(date = "01-09-2019", algo = "xor all ele, xor 1 to N-1, xor both",
            desc = "(alt) make ele @value -ve to mark the presence, where already neg return that element",
            url = "/find-repetitive-element-1-n-1/")
    public void testFindOnlyRepetitiveElementInUnsortedArray1ToNUsingXor() {
        int[] array = {1, 3, 2, 3, 4};
        int result = ArraySearching.testFindOnlyRepetitiveElementInUnsortedArray1ToNUsingXor(array);
        assertEquals(3, result);

        array = new int[]{1, 5, 1, 2, 3, 4};
        result = ArraySearching.testFindOnlyRepetitiveElementInUnsortedArray1ToNUsingXor(array);
        assertEquals(1, result);

        array = new int[]{9, 8, 2, 6, 1, 8, 5, 3, 4, 7};
        result = ArraySearching.testFindOnlyRepetitiveElementInUnsortedArray1ToNUsingXor(array);
        assertEquals(8, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "xor all element",
            url = "/find-element-appears-array-every-element-appears-twice/")
    public void testFindElementAppearingOnceWhereOtherAppearTwiceUsingXor() {
        int[] array = {7, 3, 5, 4, 5, 3, 4};
        int result = ArraySearching.findElementAppearingOnceWhereOtherAppearTwiceUsingXor(array);
        assertEquals(7, result);

        array = new int[]{2, 3, 5, 4, 5, 3, 4};
        result = ArraySearching.findElementAppearingOnceWhereOtherAppearTwiceUsingXor(array);
        assertEquals(2, result);

        array = new int[]{15, 18, 16, 18, 16, 15, 89};
        result = ArraySearching.findElementAppearingOnceWhereOtherAppearTwiceUsingXor(array);
        assertEquals(89, result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "kadane algorithm, if element is present in exclude list reset sum to 0 in addition to when sum goes -ve",
            url = "/maximum-subarray-sum-excluding-certain-elements/")
    public void testMaxSubarraySumExcludingCertainElement() {
        int[] array = {1, 7, -10, 6, 2};
        int[] exclude = {5, 6, 7, 1};
        int result = ArraySearching.maxSubarraySumExcludingCertainElement(array, exclude);
        assertEquals(2, result);

        array = new int[]{3, 4, 5, -4, 6};
        exclude = new int[]{1, 8, 5};
        result = ArraySearching.maxSubarraySumExcludingCertainElement(array, exclude);
        assertEquals(7, result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "make prefix and suffix sum array,compare both, out of all equal value return max",
            desc = "at index i if prefix sum 0 to i is equal to suffix sum i to end, called equilibrium",
            url = "/maximum-equlibrium-sum-array/")
    public void testFindMaxEquilibriumSum() {
        int[] array = {-1, 2, 3, 0, 3, 2, -1};
        int result = ArraySearching.findMaxEquilibriumSum(array);
        assertEquals(4, result);

        array = new int[]{-2, 5, 3, 1, 2, 6, -4, 2};
        result = ArraySearching.findMaxEquilibriumSum(array);
        assertEquals(7, result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "calculate array sum,from this cal prefix and suffix sum",
            url = "/maximum-equlibrium-sum-array/")
    public void testFindMaxEquilibriumSumWithConstantExtraSpace() {
        int[] array = {-1, 2, 3, 0, 3, 2, -1};
        int result = ArraySearching.findMaxEquilibriumSumWithConstantExtraSpace(array);
        assertEquals(4, result);

        array = new int[]{-2, 5, 3, 1, 2, 6, -4, 2};
        result = ArraySearching.findMaxEquilibriumSumWithConstantExtraSpace(array);
        assertEquals(7, result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "calculate array sum,from this calculate prefix and suffix sum",
            url = "/equilibrium-index-of-an-array/")
    public void testFindMaxEquilibriumIndexWithConstantExtraSpace() {
        int[] array = {-1, 2, 3, 0, 3, 2, -1};
        int result = ArraySearching.findMaxEquilibriumIndexWithConstantExtraSpace(array);
        assertEquals(3, result);

        array = new int[]{-2, 5, 3, 1, 2, 6, -4, 2};
        result = ArraySearching.findMaxEquilibriumIndexWithConstantExtraSpace(array);
        assertEquals(3, result);

        array = new int[]{-7, 1, 5, 2, -4, 3, 0};
        result = ArraySearching.findMaxEquilibriumIndexWithConstantExtraSpace(array);
        assertEquals(3, result);

        array = new int[]{-1, 2, 3};
        result = ArraySearching.findMaxEquilibriumIndexWithConstantExtraSpace(array);
        assertEquals(-1, result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "keep track of max so far on right of element,traverse from right",
            desc = "ele is called leader if it greater than all element on its right",
            url = "/leaders-in-an-array/")
    public void testFindLeaders() {
        int[] array = {16, 17, 4, 3, 5, 2};
        int[] result = ArraySearching.findLeaders(array);
        assertArrayEquals(new int[]{2, 5, 17}, result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "use binary search",
            desc = "smallest ele in array which is greater than given key",
            url = "/ceiling-in-a-sorted-array/")
    public void testFindCeilingIdxInSortedArray() {
        int[] array = {1, 2, 8, 10, 10, 12, 19};
        int result = ArraySearching.findCeilingIndexInSortedArray(array, 0);
        assertEquals(0, result);

        result = ArraySearching.findCeilingIndexInSortedArray(array, 1);
        assertEquals(0, result);

        result = ArraySearching.findCeilingIndexInSortedArray(array, 5);
        assertEquals(2, result);

        result = ArraySearching.findCeilingIndexInSortedArray(array, 20);
        assertEquals(-1, result);

        result = ArraySearching.findCeilingIndexInSortedArray(array, 3);
        assertEquals(2, result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "moore's voting algorithm",
            desc = "if element appears more than len/2 times",
            url = "/majority-element/")
    public void testFindMajorityElementInArray() {
        int[] array = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int result = ArraySearching.findMajorityElementInArray(array);
        assertEquals(4, result);

        array = new int[]{3, 3, 4, 2, 4, 4, 2, 4};
        result = ArraySearching.findMajorityElementInArray(array);
        assertEquals(-1, result);

        array = new int[]{1, 3, 3, 1, 2};
        result = ArraySearching.findMajorityElementInArray(array);
        assertEquals(-1, result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "use bin search to find 1st occurance, check if @len/2+idx is same",
            url = "/check-for-majority-element-in-a-sorted-array/")
    public void testCheckForMajorityOfElementInSortedArray() {
        int[] array = {1, 2, 3, 3, 3, 3, 10};
        boolean result = ArraySearching.checkForMajorityOfElementInSortedArray(array, 3);
        assertTrue(result);

        array = new int[]{1, 1, 2, 4, 4, 4, 6, 6};
        result = ArraySearching.checkForMajorityOfElementInSortedArray(array, 4);
        assertFalse(result);

        array = new int[]{1, 1, 1, 2, 2};
        result = ArraySearching.checkForMajorityOfElementInSortedArray(array, 1);
        assertTrue(result);

        array = new int[]{1, 2, 3, 4, 4, 4, 4};
        result = ArraySearching.checkForMajorityOfElementInSortedArray(array, 4);
        assertTrue(result);

        array = new int[]{1, 2, 3, 4, 4, 4, 4};
        result = ArraySearching.checkForMajorityOfElementInSortedArray(array, 5);
        assertFalse(result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "use binary search modified",
            url = "/find-a-peak-in-a-given-array/")
    public void testFindAPeakIndexInArray() {
        int[] array = {5, 10, 20, 15};
        int result = ArraySearching.findAPeakIndexInArray(array);
        assertEquals(2, result);

        array = new int[]{10, 20, 15, 2, 23, 90, 67};
        result = ArraySearching.findAPeakIndexInArray(array);
        assertEquals(1, result);

        array = new int[]{10, 20, 30, 40, 50};
        result = ArraySearching.findAPeakIndexInArray(array);
        assertEquals(4, result);

        array = new int[]{100, 80, 60, 50, 20};
        result = ArraySearching.findAPeakIndexInArray(array);
        assertEquals(0, result);
    }

    @Test
    @GFGMethod(date = "02-09-2019", algo = "xor all, divide ele in 2 group one which has last set bit in all xor bit set, other not set",
            desc = "each element appears twice except 2 element",
            url = "/find-two-non-repeating-elements-in-an-array-of-repeating-elements/")
    public void testFindTwoNonRepeatingElementInArray() {
        int[] array = {2, 4, 7, 9, 2, 4};
        int[] result = ArraySearching.findTwoNonRepeatingElementInArray(array);
        assertArrayEquals(new int[]{7, 9}, result);
    }

    @Test
    @GFGMethod(date = "03-09-2019", algo = "xor all, divide ele in 2 group one which has last set bit in all xor bit set, other not set",
            desc = "same as find two non repeating element in array where others appear twice",
            url = "/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/")
    public void testFindTwoOddOccuranceElementInUnsortedArray() {
        int[] array = {12, 23, 34, 12, 12, 23, 12, 45};
        int[] result = ArraySearching.findTwoOddOccuranceElementInUnsortedArray(array);
        assertArrayEquals(new int[]{45, 34}, result);

        array = new int[]{4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
        result = ArraySearching.findTwoOddOccuranceElementInUnsortedArray(array);
        assertArrayEquals(new int[]{100, 5000}, result);

        array = new int[]{10, 20};
        result = ArraySearching.findTwoOddOccuranceElementInUnsortedArray(array);
        assertArrayEquals(new int[]{10, 20}, result);

        array = new int[]{4, 2, 4, 5, 2, 3, 3, 1};
        result = ArraySearching.findTwoOddOccuranceElementInUnsortedArray(array);
        assertArrayEquals(new int[]{5, 1}, result);
    }
}
