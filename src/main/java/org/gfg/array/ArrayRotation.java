package org.gfg.array;

public class ArrayRotation {
    public static void rotateUsingTempArray(int[] array, int rotateBy) {
        int[] tempArray = new int[rotateBy];
        System.arraycopy(array, 0, tempArray, 0, rotateBy);
        System.arraycopy(array, rotateBy, array, 0, array.length - rotateBy);
        System.arraycopy(tempArray, 0, array, array.length - rotateBy, rotateBy);
    }
}
