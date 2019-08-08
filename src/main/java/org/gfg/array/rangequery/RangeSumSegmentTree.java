package org.gfg.array.rangequery;

public class RangeSumSegmentTree extends SegmentTree {

    public RangeSumSegmentTree(int[] array) {
        super(array);
    }

    @Override
    int getResult(int c1, int c2) {
        return c1 + c2;
    }

    @Override
    int getDefaultOutOfRangeValue() {
        return 0;
    }
}
