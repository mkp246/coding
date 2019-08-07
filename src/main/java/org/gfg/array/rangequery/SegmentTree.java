package org.gfg.array.rangequery;

import org.gfg.array.Util;

public class SegmentTree {
    private int[] tree;
    private int arrayLength;
    private int[] array;

    public SegmentTree(int[] array) {
        this.array = array;
        arrayLength = array.length;
        int height = Util.log2Floor(array.length) + 1;
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxSize];
        constructUntil(array, 0, array.length - 1, 0);
    }

    private int constructUntil(int[] array, int segStart, int segEnd, int currentIndex) {
        if (segStart == segEnd) {
            tree[currentIndex] = array[segStart];
        } else {
            int mid = Util.getMid(segStart, segEnd);
            int c1 = constructUntil(array, segStart, mid, 2 * currentIndex + 1);
            int c2 = constructUntil(array, mid + 1, segEnd, 2 * currentIndex + 2);
            tree[currentIndex] = getResult(c1, c2);
        }
        return tree[currentIndex];
    }

    private int getResult(int c1, int c2) {
        return c1 + c2;
    }

    public int getQuery(int start, int end) {
        if (start < 0 || end > arrayLength - 1 || start > end) {
            return -1; // invalid input
        }
        return getQueryUntil(0, arrayLength - 1, start, end, 0);
    }

    private int getQueryUntil(int segStart, int segEnd, int qStart, int qEnd, int currentIndex) {
        if (segStart >= qStart && segEnd <= qEnd) {
            // segment within range  
            return tree[currentIndex];
        } else if (segStart > qEnd || segEnd < qStart) {
            //segment outside range 
            return 0;
        } else {
            // segment overlapping range 
            int mid = Util.getMid(segStart, segEnd);
            int c1 = getQueryUntil(segStart, mid, qStart, qEnd, 2 * currentIndex + 1);
            int c2 = getQueryUntil(mid + 1, segEnd, qStart, qEnd, 2 * currentIndex + 2);
            return getResult(c1, c2);
        }
    }

    public void updateValue(int index, int value) {
        if (index < 0 || index > arrayLength - 1) {
            // invalid index
            return;
        }
        int diff = value - array[index];
        updateUntil(0, arrayLength - 1, index, diff, 0);
    }

    private void updateUntil(int segStart, int segEnd, int index, int diff, int currentIndex) {
        if (segStart <= index && segEnd >= index) {
            //index inside segment, if outside no updates required 
            tree[currentIndex] = getResult(tree[currentIndex], diff);
            if (segStart != segEnd) {
                // not reached to leaf node
                int mid = Util.getMid(segStart, segEnd);
                updateUntil(segStart, mid, index, diff, 2 * currentIndex + 1);
                updateUntil(mid + 1, segEnd, index, diff, 2 * currentIndex + 2);
            }
        }
    }
}
