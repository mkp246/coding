package org.gfg.array;

import com.mkp.GFGMethod;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
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

    @Test
    @GFGMethod(date = "15-08-2019", algo = "extended euclidean", url = "/euclidean-algorithms-basic-and-extended/")
    public void testExtendedEuclidean() {
        int[] result = Util.extendedEuclidean(30, 20);
        assertArrayEquals(new int[]{10, 1, -1}, result);

        result = Util.extendedEuclidean(35, 15);
        assertArrayEquals(new int[]{5, 1, -2}, result);
    }

    @Test
    @GFGMethod(date = "15-08-2019", algo = "(method 2)extended euclidean", url = "/multiplicative-inverse-under-modulo-m/")
    public void testModularMultiplicativeInverse() {
        int inverse = Util.modularMultiplicativeInverse(3, 11);
        assertEquals(4, inverse);

        inverse = Util.modularMultiplicativeInverse(10, 17);
        assertEquals(12, inverse);
    }

    @Test
    @GFGMethod(date = "15-08-2019", algo = "(method 3)fermat little theorem", url = "/multiplicative-inverse-under-modulo-m/")
    public void testModularMultiplicativeInverseUsingFermatsLittleTheorem() {
        int inverse = Util.modularMultiplicativeInverseUsingFermatsLittleTheorem(3, 11);
        assertEquals(4, inverse);

        inverse = Util.modularMultiplicativeInverseUsingFermatsLittleTheorem(10, 17);
        assertEquals(12, inverse);
    }
}
