package org.gfg.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilTest {

    @Test
    public void testGcd() {
        assertEquals(3, Util.gcd(12, 3));
        assertEquals(1, Util.gcd(12, 7));
        assertEquals(4, Util.gcd(12, 4));
        assertEquals(4, Util.gcd(4, 12));
        assertEquals(2, Util.gcd(2, 0)); // not sure if should be allowed or not
    }

    @Test
    public void testLog2Floor() {
        assertEquals(3, Util.log2Floor(12));
        assertEquals(2, Util.log2Floor(7));
        assertEquals(2, Util.log2Floor(4));
        assertEquals(0, Util.log2Floor(1));
    }

    @Test
    public void testGetMid() {
        assertEquals(7, Util.getMid(3, 12));
        assertEquals(9, Util.getMid(7, 12));
        assertEquals(8, Util.getMid(4, 12));
        assertEquals(0, Util.getMid(0, 1));
        assertEquals(0, Util.getMid(0, 0));
    }

    @Test
    public void testLcm() {
        assertEquals(12, Util.lcm(3, 12));
        assertEquals(84, Util.lcm(12, 7));
        assertEquals(12, Util.lcm(12, 4));
        assertEquals(0, Util.lcm(0, 1));
        assertEquals(18, Util.lcm(9, 6));
    }
}
