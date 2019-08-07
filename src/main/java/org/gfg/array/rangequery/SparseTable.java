package org.gfg.array.rangequery;

import org.gfg.array.Util;

import java.util.Arrays;

public abstract class SparseTable {
    private int[][] lookup;

    public SparseTable(int[] array) {
        buildTable(array);
    }

    private void buildTable(int[] array) {
        int iMax = array.length;
        int jMax = Util.log2Floor(array.length) + 1;
        lookup = new int[iMax][jMax];


        for (int i = 0; i < iMax; i++) {
            lookup[i][0] = array[i];
        }

        for (int j = 1; j < jMax; j++) {
            for (int i = 0; i < iMax; i++) {
                if (i + (1 << j) <= iMax) {
                    lookup[i][j] = getResult(lookup[i][j - 1], lookup[i + (1 << (j - 1))][j - 1]);
                }
            }
        }
    }

    public int getQuery(int start, int end) {
        int length = end - start + 1;
        int j = Util.log2Floor(length);
        int c1 = lookup[start][j];
        int c2 = lookup[start + length - (1 << j)][j];
        return getResult(c1, c2);
    }

    abstract int getResult(int value1, int value2);

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int[] element : lookup) {
            builder.append(Arrays.toString(element));
            builder.append("\n");
        }
        return builder.toString();
    }
}
