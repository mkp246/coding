package gfg.array.rotation;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 */

public class Rotate {
    public static void rotateByNUsingTempArray(int[] array, int positions) {
        int[] temp = new int[positions];
        int i = 0;
        for (; i < positions; i++) {
            temp[i] = array[i];
        }
        for (; i < array.length; i++) {
            array[i - positions] = array[i];
        }
        int j = 0;
        for (i = array.length - positions; i < array.length; i++) {
            array[i] = temp[j++];
        }
    }
}
