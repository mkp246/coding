package org.gfg.array.rangequery;

public class BinaryIndexTree {
    private int[] bit;
    private int arrayLength;

    public BinaryIndexTree(int[] array) {
        bit = new int[array.length + 1];
        arrayLength = array.length;
        construct(array);
    }

    private void construct(int[] array) {
        for (int i = 0; i < array.length; i++) {
            update(i, array[i]);
        }
    }

    public void update(int index, int diff) {
        // we need to update bit at idx+1 as @0 dummy node
        index++;
        while (index <= arrayLength) {
            bit[index] += diff;
            index += (index & -index);
        }
    }

    public int getQuery(int index) {
        int sum = 0;
        index++;
        while (index > 0) {
            sum += bit[index];
            index -= (index & -index);
        }
        return sum;
    }
}
