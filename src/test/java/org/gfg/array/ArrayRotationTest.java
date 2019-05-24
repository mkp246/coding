package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

@GFG(date = "21-05-2019", algo = "array rotation", url = "/array-rotation", impls = ArrayRotation.class)
public class ArrayRotationTest {

    @Test
    @GFGMethod(date = "21-05-19", variant = "using temp array")
    public void testRotateUsingTempArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateUsingTempArray(array, 2);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, array);
    }

    @Test
    @GFGMethod(date = "23-05-2019", variant = "rotate by one")
    public void testRotateByOne() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateByOne(array);
        assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 1}, array);
        ArrayRotation.rotateByOne(array);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 1, 2}, array);
    }

    @Test
    @GFGMethod(date = "24-05-19", variant = "using rotate by one")
    public void testRotateUsingRotateByOne() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateUsingRotateByOne(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, array);
    }

    @Test
    @GFGMethod(date = "24-05-19", variant = "using juggling")
    public void testRotateUsingJuggling() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayRotation.rotateUsingJuggling(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 7, 1, 2, 3}, array);

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        ArrayRotation.rotateUsingJuggling(array, 4);
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4}, array);
    }
}
