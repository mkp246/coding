package org.gfg.string;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

@GFG(date = "27-05-2019", topic = "string rotation", url = "")
public class StringRotationTest {

    @GFGMethod(date = "27-05-2019", desc = "max continuous 1s in binary string after k substr rotation",
            algo = "note length of all 1s chunk, sort and sum highest k or all if k > number of 1s chunks",
            url = "/maximum-contiguous-1-possible-in-a-binary-string-after-k-rotations/")
    @Test
    public void testMaxContiguous1sInBinaryStringAfterSubStringRotations() {
        String string = "100110111";
        int result = StringRotation.maxContiguous1sInBinaryStringAfterSubStringRotations(string, 1);
        Assert.assertEquals(5, result);

        string = "100011001";
        result = StringRotation.maxContiguous1sInBinaryStringAfterSubStringRotations(string, 1);
        Assert.assertEquals(3, result);

        string = "001100111000110011100";
        result = StringRotation.maxContiguous1sInBinaryStringAfterSubStringRotations(string, 2);
        Assert.assertEquals(8, result);

        string = "10011110011";
        result = StringRotation.maxContiguous1sInBinaryStringAfterSubStringRotations(string, 1);
        Assert.assertEquals(6, result);
    }
}
