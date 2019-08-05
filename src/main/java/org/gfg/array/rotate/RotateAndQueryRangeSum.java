package org.gfg.array.rotate;

public class RotateAndQueryRangeSum {
    private int totalRotation = 0;
    private int[] prefixSum;

    public RotateAndQueryRangeSum(int[] array) {
        prefixSum = array;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
    }

    public void rotateLeft(int by) {
        totalRotation -= by;
    }

    public void rotateRight(int by) {
        totalRotation += by;
    }

    public int getRangeSum(int start, int end) {
        start = (start - totalRotation + prefixSum.length) % prefixSum.length;
        end = (end - totalRotation + prefixSum.length) % prefixSum.length;
        if (start < end) {
            return prefixSum[end] - (start == 0 ? 0 : prefixSum[start - 1]);
        } else {
            return prefixSum[prefixSum.length - 1] - prefixSum[start - 1] + (end == 0 ? 0 : prefixSum[end]);
        }
    }
}
