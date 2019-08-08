package org.gfg.array.rangequery;

import org.gfg.array.Util;

public class RangeLCMSegmentTree extends RangeSumSegmentTree {

    public RangeLCMSegmentTree(int[] array) {
        super(array);
    }

    @Override
    int getResult(int c1, int c2) {
        return Util.lcm(c1, c2);
    }

    @Override
    public void updateValue(int index, int value) {
        throw new UnsupportedOperationException("update operation is not supported");
    }

    @Override
    int getDefaultOutOfRangeValue() {
        return 1;
    }
}
