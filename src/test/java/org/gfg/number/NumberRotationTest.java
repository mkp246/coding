package org.gfg.number;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

@GFG(date = "27-05-2019", topic = "number's rotations", url = "", impls = NumberRotation.class)
public class NumberRotationTest {

    @Test
    @GFGMethod(date = "27-05-2019", algo = "count even and odd rotation", url = "/count-rotations-of-n-which-are-odd-and-even/")
    public void testCountEvenAndOddRotations() {
        int[] counts = NumberRotation.countEvenAndOddRotations(1234);
        Assert.assertArrayEquals(new int[]{2, 2}, counts);

        counts = NumberRotation.countEvenAndOddRotations(246);
        Assert.assertArrayEquals(new int[]{3, 0}, counts);
    }

    @Test
    public void testNumDigits() {
        int digits = NumberRotation.numDigits(123);
        Assert.assertEquals(3, digits);

        digits = NumberRotation.numDigits(3);
        Assert.assertEquals(1, digits);

        digits = NumberRotation.numDigits(9984);
        Assert.assertEquals(4, digits);

        digits = NumberRotation.numDigits(123000);
        Assert.assertEquals(6, digits);
    }

    @Test
    @GFGMethod(date = "27-05-2019", algo = "Generate all rotations of a number", url = "/generate-all-rotations-of-a-number/")
    public void testGetAllRotation() {
        int[] rotations = NumberRotation.getAllRotation(1445);
        Assert.assertArrayEquals(new int[]{4451, 4514, 5144}, rotations);

        rotations = NumberRotation.getAllRotation(123);
        Assert.assertArrayEquals(new int[]{231, 312}, rotations);
    }

    @Test
    @GFGMethod(date = "27-05-2019", algo = "Check if all the rotations of a number is >= number or not",
            url = "/check-whether-all-the-rotations-of-a-given-number-is-greater-than-or-equal-to-the-given-number-or-not/")
    public void testIsAllRotationsGreaterOrEqual() {
        Assert.assertTrue(NumberRotation.isAllRotationsGreaterOrEqual(123));
        Assert.assertFalse(NumberRotation.isAllRotationsGreaterOrEqual(231));
        Assert.assertFalse(NumberRotation.isAllRotationsGreaterOrEqual(312));
        Assert.assertFalse(NumberRotation.isAllRotationsGreaterOrEqual(21));
        Assert.assertTrue(NumberRotation.isAllRotationsGreaterOrEqual(12));
        Assert.assertTrue(NumberRotation.isAllRotationsGreaterOrEqual(1));
        Assert.assertTrue(NumberRotation.isAllRotationsGreaterOrEqual(0));
        Assert.assertFalse(NumberRotation.isAllRotationsGreaterOrEqual(2214));
        Assert.assertTrue(NumberRotation.isAllRotationsGreaterOrEqual(1224));
        Assert.assertFalse(NumberRotation.isAllRotationsGreaterOrEqual(2124));
    }
}
