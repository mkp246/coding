package org.gfg.array.rotate;


import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

@GFG(date = "26-05-2019", topic = "Queries on Left and Right Circular shift on array", url = "/queries-left-right-circular-shift-array/", impls = RotateAndQueryRangeSum.class)
public class RotateAndQueryRangeSumTest {

    @Test
    @GFGMethod(date = "26-05-2019", algo = "using prefix sum and tracking total rotation, adjusting query range accordingly")
    public void testGetRangeSum() {
        int[] array = {1, 2, 3, 4, 5};
        RotateAndQueryRangeSum query = new RotateAndQueryRangeSum(array);

        query.rotateRight(3);
        int sum = query.getRangeSum(0, 2);
        Assert.assertEquals(12, sum);

        query.rotateLeft(1);
        sum = query.getRangeSum(1, 4);
        Assert.assertEquals(11, sum);
    }
}
