package org.gfg.array.rangequery;

public class ConstantTimeRangeAddOperation {
    private int size;
    private int[] array;

    public ConstantTimeRangeAddOperation(int size) {
        this.size = size;
        array = new int[size];
    }

    public void add(int startIndex, int endIndex, int element) {
        if (startIndex < size) {
            array[startIndex] += element;
        }
        if (endIndex + 1 < size) {
            array[endIndex + 1] -= element;
        }
    }

    public int[] getArray() {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        return array;
    }

    public int getSize() {
        return size;
    }
}
