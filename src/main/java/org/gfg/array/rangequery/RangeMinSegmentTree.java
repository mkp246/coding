package org.gfg.array.rangequery;

public class RangeMinSegmentTree extends SegmentTree {

    public RangeMinSegmentTree(int[] array) {
        super(array);
    }

    @Override
    int getResult(int c1, int c2) {
        return Math.min(c1, c2);
    }

    @Override
    int getDefaultOutOfRangeValue() {
        return Integer.MAX_VALUE;
    }
}
