package org.gfg.array;

import com.mkp.ALT;
import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@GFG(date = "21-05-2019", topic = "array rotation", url = "/array-rotation", impls = ArrayRotation.class)
public class ArrayRotationTest {

    @Test
    @GFGMethod(date = "21-05-19", algo = "using temp array")
    public void testRotateUsingTempArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateUsingTempArray(array, 2);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, array);
    }

    @Test
    @ALT(url = "/split-array-add-first-part-end/")
    @GFGMethod(date = "23-05-2019", algo = "rotate by one")
    public void testRotateByOne() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateByOne(array);
        assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 1}, array);
        ArrayRotation.rotateByOne(array);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, array);
    }

    @Test
    @GFGMethod(date = "24-05-19", algo = "using rotate by one")
    public void testRotateUsingRotateByOne() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateUsingRotateByOne(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, array);
    }

    @Test
    @GFGMethod(date = "24-05-19", algo = "using juggling")
    public void testRotateUsingJuggling() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateUsingJuggling(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, array);

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ArrayRotation.rotateUsingJuggling(array, 4);
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4}, array);
    }

    @Test
    public void testReverseArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.reverseArray(array, 2, 6);
        assertArrayEquals(new int[]{1, 2, 7, 6, 5, 4, 3}, array);

        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.reverseArray(array, 1, 2);
        assertArrayEquals(new int[]{1, 3, 2, 4, 5, 6, 7}, array);
    }

    @Test
    @GFGMethod(date = "24-05-19", algo = "using reversal", url = "/program-for-array-rotation-continued-reversal-algorithm")
    public void testRotateUsingReversal() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateUsingReversal(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, array);

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ArrayRotation.rotateUsingReversal(array, 4);
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4}, array);
    }

    @Test
    public void testSwap() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.swap(array, 1, 5, 2);
        assertArrayEquals(new int[]{1, 6, 7, 4, 5, 2, 3}, array);
    }


    @Test
    @GFGMethod(date = "24-05-19", algo = "using block swap recursive", url = "/block-swap-algorithm-for-array-rotation")
    public void testRotateUsingBlockSwap() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateUsingBlockSwap(array, 0, array.length - 1, 3);
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, array);

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ArrayRotation.rotateUsingBlockSwap(array, 0, array.length - 1, 4);
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4}, array);
    }

    @Ignore("TODO")
    @Test
    @GFGMethod(date = "24-05-19", algo = "using block swap iterative", url = "/block-swap-algorithm-for-array-rotation")
    public void testRotateUsingBlockSwapIterative() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, array);
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4}, array);
    }

    @Test
    @GFGMethod(date = "26-05-2019", algo = "right rotate using reversal", url = "/reversal-algorithm-right-rotation-array/")
    public void testRightRotateUsingReversal() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayRotation.rightRotateUsingReversal(array, 3);
        assertArrayEquals(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, array);
    }

    @Test
    @GFGMethod(date = "26-05-2019", algo = "max hamming rotation", url = "/find-a-rotation-with-maximum-hamming-distance/")
    public void testMaxHammingAmongRotation() {
        int[] array = {1, 4, 1};
        int result = ArrayRotation.maxHammingAmongRotation(array);
        assertEquals(2, result);

        array = new int[]{2, 4, 8, 0};
        result = ArrayRotation.maxHammingAmongRotation(array);
        assertEquals(4, result);

        array = new int[]{2, 4, 6, 8};
        result = ArrayRotation.maxHammingAmongRotation(array);
        assertEquals(4, result);

        array = new int[]{2, 1, 2, 3, 2, 4};
        result = ArrayRotation.maxHammingAmongRotation(array);
        assertEquals(6, result);

        array = new int[]{1, 0, 1, 0, 1};
        result = ArrayRotation.maxHammingAmongRotation(array);
        assertEquals(4, result);

        array = new int[]{1, 1, 1, 1, 2, 2, 2};
        result = ArrayRotation.maxHammingAmongRotation(array);
        assertEquals(6, result);
    }

    @Test
    @GFGMethod(date = "27-05-2019", algo = "keep track of index where current index would come from just before each rotation", url = "/find-element-given-index-number-rotations/")
    public void testGetElementAtIndexAfterRangeRightRotations() {
        int[] array = {1, 2, 3, 4, 5};
        int[][] ranges = {{0, 2}, {0, 3}};
        int index = 1;
        int result = ArrayRotation.getElementAtIndexAfterRangeRightRotations(array, ranges, index);
        Assert.assertEquals(3, result);
    }

    @Test
    @GFGMethod(date = "27-05-2019", desc = "check if possible to sort array by rotation", algo = "keeping track of strict up/down", url = "/check-if-it-is-possible-to-sort-the-array-after-rotating-it/")
    public void testIsPossibleToSortByRotation() {
        boolean result = ArrayRotation.isPossibleToSortByRotation(new int[]{2, 3, 1, 2});
        Assert.assertTrue(result);

        result = ArrayRotation.isPossibleToSortByRotation(new int[]{1, 2, 3, 2});
        Assert.assertFalse(result);

        result = ArrayRotation.isPossibleToSortByRotation(new int[]{6, 8, 1, 2, 5});
        Assert.assertTrue(result);

        result = ArrayRotation.isPossibleToSortByRotation(new int[]{5, 2, 1, 8, 6});
        Assert.assertTrue(result);
    }
}
