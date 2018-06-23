package gfg.array.rotation;

import gfg.array.reversal.Reverse;
import gfg.array.swap.BlockSwap;

/**
 * https://www.geeksforgeeks.org/array-rotation/
 * https://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
 * https://www.geeksforgeeks.org/block-swap-algorithm-for-array-rotation/
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

    private static void rotateByOne(int[] array) {
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        array[array.length - 1] = temp;
    }

    public static void leftRotate(int[] array, int positions) {
        for (int i = 0; i < positions; i++) {
            rotateByOne(array);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    public static void leftRotateInGroup(int[] array, int positions) {
        int groupLength = gcd(array.length, positions);
        for (int i = 0; i < groupLength; i++) {
            int temp = array[i];
            int j = i;
            while (true) {
                int k = j + positions;
                if (k >= array.length) break;
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
    }

    public static void rotateByReversal(int[] array, int positions) {
        Reverse.reverse(array, 0, positions - 1);
        Reverse.reverse(array, positions, array.length - 1);
        Reverse.reverse(array);
    }

    public static void rotateByBlockSwap(int[] array, int positions) {
        rotateByBlockSwap(array, positions, 0, array.length - 1);
    }

    private static void rotateByBlockSwap(int[] array, int positions, int start, int end) {
        int len = end - start + 1;
        if (len == 2 * positions) {
            BlockSwap.blockSwap(array, start, end, positions);
        } else if (len > 2 * positions) {
            BlockSwap.blockSwap(array, start, end - positions + 1, positions);
            rotateByBlockSwap(array, positions, start, end - positions);
        } else if (len < 2 * positions) {
            BlockSwap.blockSwap(array, start, start + positions, len - positions);
            rotateByBlockSwap(array, 2 * positions - len, end - positions + 1, end);
        }
    }
}
