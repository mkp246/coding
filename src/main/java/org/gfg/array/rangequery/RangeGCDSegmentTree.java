package org.gfg.array.rangequery;

import org.gfg.array.Util;

public class RangeGCDSegmentTree extends SegmentTree {

    public RangeGCDSegmentTree(int[] array) {
        super(array);
    }

    @Override
    int getResult(int c1, int c2) {
        return Util.gcd(c1, c2);
    }

    @Override
    int getDefaultOutOfRangeValue() {
        return 0;
    }
}
