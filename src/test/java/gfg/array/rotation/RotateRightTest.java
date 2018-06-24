package gfg.array.rotation;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateRightTest {

    @Test
    public void rotateTest() {
        int[] array = {1, 2, 3, 4, 5};
        RotateRight.rotate(array);
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, array);
    }

    @Test
    public void pivotedBinarySearchTest() {
        int array[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        assertEquals(8, RotateRight.pivotedBinarySearch(array, key));
    }

    @Test
    public void pairInSortedRotatedTest() {
        int[] array = {11, 15, 6, 8, 9, 10};
        int sum = 16;
        assertTrue(RotateRight.pairInSortedRotated(array, sum));
        array = new int[]{11, 15, 26, 38, 9, 10};
        sum = 35;
        assertTrue(RotateRight.pairInSortedRotated(array, sum));
        array = new int[]{11, 15, 26, 38, 9, 10};
        sum = 45;
        assertFalse(RotateRight.pairInSortedRotated(array, sum));

        array = new int[]{9, 10, 11, 15, 26, 38};
        sum = 35;
        assertTrue(RotateRight.pairInSortedRotated(array, sum));

    }
}