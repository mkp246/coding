package gfg.array.reversal;

public class Reverse {
    public static void reverse(int[] array) {
        reverse(array, 0, array.length - 1);
    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
