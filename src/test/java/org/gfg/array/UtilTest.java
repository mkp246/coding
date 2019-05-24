package org.gfg.array;

import org.junit.Assert;
import org.junit.Test;

public class UtilTest {

    @Test
    public void testGcd() {
        Assert.assertEquals(3, Util.gcd(12, 3));
        Assert.assertEquals(1, Util.gcd(12, 7));
        Assert.assertEquals(4, Util.gcd(12, 4));
    }
}
