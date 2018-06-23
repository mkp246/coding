package gfg.array.rotation;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotateTest {
    @Test
    public void rotateByNUsingTempArrayTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        Rotate.rotateByNUsingTempArray(array, 2);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, array);
    }

    @Test
    public void leftRotateTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        Rotate.leftRotate(array, 2);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, array);
    }

    @Test
    public void leftRotateInGroupTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Rotate.leftRotateInGroup(array, 2);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8, 1, 2}, array);
    }

    @Test
    public void rotateByReversalTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Rotate.rotateByReversal(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, array);
    }

    @Test
    public void rotateByBlockSwapTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Rotate.rotateByBlockSwap(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, array);
        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        Rotate.rotateByBlockSwap(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, array);
    }
}