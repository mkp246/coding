package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

@GFG(date = "25-05-2019", topic = "array sum pair", url = "/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum", impls = SumPair.class)
public class SumPairTest {

    @Test
    @GFGMethod(date = "25-05-2019", algo = "unsorted array sum pair using sorting", url = "/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x")
    public void testHasUnsortedArrayTwoCandidates() {
        int[] array = {1, 4, 45, 6, 10, -8};
        boolean result = SumPair.hasUnsortedArrayTwoCandidatesUsingSorting(array, 16);
        Assert.assertTrue(result);

        result = SumPair.hasUnsortedArrayTwoCandidatesUsingSorting(array, 55);
        Assert.assertTrue(result);

        result = SumPair.hasUnsortedArrayTwoCandidatesUsingSorting(array, 10);
        Assert.assertTrue(result);

        result = SumPair.hasUnsortedArrayTwoCandidatesUsingSorting(array, 45);
        Assert.assertFalse(result);

        result = SumPair.hasUnsortedArrayTwoCandidatesUsingSorting(array, 100);
        Assert.assertFalse(result);
    }

    @Test
    @GFGMethod(date = "25-05-2019", algo = "unsorted array sum pair using hash set", url = "/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x")
    public void testGetUnsortedArraySumPairUsingHashing() {
        int[] array = {1, 4, 45, 6, 10, 8};
        int[] pair = SumPair.getUnsortedArraySumPairUsingHashing(array, 16);
        Assert.assertArrayEquals(new int[]{6, 10}, pair);

        pair = SumPair.getUnsortedArraySumPairUsingHashing(array, 18);
        Assert.assertArrayEquals(new int[]{10, 8}, pair);

        pair = SumPair.getUnsortedArraySumPairUsingHashing(array, 17);
        Assert.assertNull(pair);
    }

    @Test
    @GFGMethod(date = "25-05-2019", algo = "sorted rotated array sum pair using pivot")
    public void testHasSortedAndRotatedArrayTwoCandidates() {
        int[] array = {11, 15, 6, 8, 9, 10};

        boolean result = SumPair.hasSortedAndRotatedArrayTwoCandidates(array, 16);
        Assert.assertTrue(result);

        result = SumPair.hasSortedAndRotatedArrayTwoCandidates(array, 12);
        Assert.assertFalse(result);
    }

    @Test
    @GFGMethod(date = "25-05-2019", algo = "sorted rotated array sum pair count using pivot")
    public void testCountSortedAndRotatedArrayPairsWithSum() {
        int[] array = {11, 15, 6, 7, 9, 10};
        int result = SumPair.countSortedAndRotatedArrayPairsWithSum(array, 16);
        Assert.assertEquals(2, result);
    }

    @Test
    @GFGMethod(date = "25-05-2019", algo = "two unsorted array sum pairs using hashing", tComp = "nlog(n)", url = "/given-two-unsorted-arrays-find-pairs-whose-sum-x")
    public void testGetTwoUnsortedArraysSumPairsUsingHashing() {
        int[] array1 = {1, 0, -4, 7, 6, 4};
        int[] array2 = {0, 2, 4, -3, 2, 1};
        ArrayList<int[]> result = SumPair.getTwoUnsortedArraysSumPairsUsingHashing(array1, array2, 8);
        Assert.assertEquals(4, result.size());
        Assert.assertArrayEquals(new int[]{6, 2}, result.get(0));
        Assert.assertArrayEquals(new int[]{4, 4}, result.get(1));
        Assert.assertArrayEquals(new int[]{6, 2}, result.get(2));
        Assert.assertArrayEquals(new int[]{7, 1}, result.get(3));
    }
}
