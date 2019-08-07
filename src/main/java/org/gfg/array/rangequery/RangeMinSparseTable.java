package org.gfg.array.rangequery;

public class RangeMinSparseTable extends SparseTable {

    public RangeMinSparseTable(int[] array) {
        super(array);
    }

    @Override
    int getResult(int value1, int value2) {
        return Math.min(value1, value2);
    }
}
