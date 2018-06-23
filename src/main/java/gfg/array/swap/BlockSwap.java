package gfg.array.swap;

public class BlockSwap {
    public static void blockSwap(int[] array, int first, int second, int length) {
        int temp;
        for (int i = 0; i < length; i++) {
            temp = array[first + i];
            array[first + i] = array[second + i];
            array[second + i] = temp;
        }
    }
}
