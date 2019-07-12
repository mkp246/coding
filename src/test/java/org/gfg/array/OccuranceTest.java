package org.gfg.array;

import com.mkp.ALT;
import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

@ALT(url = "/amazon-interview-experience/")
@GFG(date = "11-07-2019", topic = "occurance of element in array", url = "/elements-that-occurred-only-once-in-the-array/", impls = Occurance.class)
public class OccuranceTest {

    @Test
    @GFGMethod(date = "11-07-2019", algo = "using soring checking if number not same as prev or next", tComp = "O(nlogn)")
    public void testFindOccuredOnceUsingSorting() {
        int[] array = {7, 7, 8, 8, 9, 1, 1, 4, 2, 2};
        int[] result = Occurance.findOccuredOnceUsingSorting(array);
        Assert.assertArrayEquals(new int[]{4, 9}, result);
    }

    @Test
    @GFGMethod(date = "11-07-2019", algo = "using hashing")
    public void testFindOccuredOnceUsingHashing() {
        int[] array = {7, 7, 8, 10, 9, 1, 1, 4, 2, 2};
        int[] result = Occurance.findOccuredOnceUsingHashing(array);
        Assert.assertArrayEquals(new int[]{4, 8, 9, 10}, result);
    }

    @Test
    @GFGMethod(date = "11-07-2019", algo = "using skipping duplicates")
    public void testFindOccuredOnceUsingIfDuplicatesAreTogether() {
        int[] array = {7, 7, 8, 10, 9, 1, 1, 4, 2, 2, 11};
        int[] result = Occurance.findOccuredOnceUsingIfDuplicatesAreTogether(array);
        Assert.assertArrayEquals(new int[]{8, 10, 9, 4, 11}, result);

        array = new int[]{7, 7, 7};
        result = Occurance.findOccuredOnceUsingIfDuplicatesAreTogether(array);
        Assert.assertArrayEquals(new int[]{}, result);
        array = new int[]{7, 7, 8};
        result = Occurance.findOccuredOnceUsingIfDuplicatesAreTogether(array);
        Assert.assertArrayEquals(new int[]{8}, result);
    }
}
