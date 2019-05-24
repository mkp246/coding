package org.gfg.array;

public class ArrayRotation {
    public static void rotateUsingTempArray(int[] array, int rotateBy) {
        int[] tempArray = new int[rotateBy];
        System.arraycopy(array, 0, tempArray, 0, rotateBy);
        System.arraycopy(array, rotateBy, array, 0, array.length - rotateBy);
        System.arraycopy(tempArray, 0, array, array.length - rotateBy, rotateBy);
    }

    public static void rotateByOne(int[] array) {
        int temp = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = temp;
    }

    public static void rotateUsingRotateByOne(int[] array, int rotateBy) {
        for (int i = 0; i < rotateBy; i++) {
            rotateByOne(array);
        }
    }

    public static void rotateUsingJuggling(int[] array, int rotateBy) {
        int gcd = Util.gcd(array.length, rotateBy);
        int temp, src, dest;
        for (int i = 0; i < gcd; i++) {
            temp = array[i];
            dest = i;
            while (true) {
                src = (dest + rotateBy) % array.length;
                if (src == i) {
                    array[dest] = temp;
                    break;
                } else {
                    array[dest] = array[src];
                    dest = src;
                }
            }
        }
    }

    public static void reverseArray(int[] array, int start, int end) {
        int temp;
        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateUsingReversal(int[] array, int rotateBy) {
        reverseArray(array, 0, rotateBy - 1);
        reverseArray(array, rotateBy, array.length - 1);
        reverseArray(array, 0, array.length - 1);
    }
}
