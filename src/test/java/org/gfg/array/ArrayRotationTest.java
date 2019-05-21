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
}
