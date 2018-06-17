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
}