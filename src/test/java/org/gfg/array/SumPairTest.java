package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

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
}
