package org.gfg.array.rangequery;

public class RangeGCDSparseTable extends SparseTable {
    public RangeGCDSparseTable(int[] array) {
        super(array);
    }

    @Override
    int getResult(int value1, int value2) {
        return gcd(value1, value2);
    }

    private int gcd(int value1, int value2) {
        if (value2 == 0) {
            return value1;
        } else {
            return gcd(value2, value1 % value2);
        }
    }
}
