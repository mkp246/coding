package org.gfg.array;

import com.mkp.ALT;
import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

@GFG(date = "26-05-2019", topic = "max sum i * arr[i] with only rotation allowed", url = "/find-maximum-value-of-sum-iarri-with-only-rotations-on-given-array-allowed/", impls = Sum.class)
public class SumTest {

    @Test
    @ALT(url = "/maximum-sum-iarri-among-rotations-given-array/")
    @GFGMethod(date = "26-05-2019", algo = "calculate efficiently Rj from Rj-1")
    public void testFindMaxSumIndexMultValue() {
        int[] array = {1, 20, 2, 10};
        int result = Sum.findMaxSumIndexMultValue(array);
        Assert.assertEquals(72, result);

        array = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        result = Sum.findMaxSumIndexMultValue(array);
        Assert.assertEquals(330, result);

        array = new int[]{8, 3, 1, 2};
        result = Sum.findMaxSumIndexMultValue(array);
        Assert.assertEquals(29, result);

        array = new int[]{3, 2, 1};
        result = Sum.findMaxSumIndexMultValue(array);
        Assert.assertEquals(7, result);

    }
}
