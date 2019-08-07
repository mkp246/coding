package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.gfg.array.rangequery.ConstantTimeRangeAddOperation;
import org.gfg.array.rangequery.RangeGCDSparseTable;
import org.gfg.array.rangequery.RangeMinSparseTable;
import org.gfg.array.rangequery.SparseTable;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@GFG(date = "03-08-2019", topic = "array range queries", url = "/array-data-structure/array-range-queries/", impls = ArrayRangeQuery.class)
public class ArrayRangeQueryTest {

    @Test
    @GFGMethod(date = "03-08-2019", algo = "query square root decomposition (MO's algorithm)",
            url = "/mos-algorithm-query-square-root-decomposition-set-1-introduction/", tComp = "O((m+n)sqrt(n))")
    public void testFindRangeSumUsingMOAlgorithm() {
        int[] array = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        int[][] query = {{0, 4}, {1, 3}, {7, 8}, {4, 6}, {6, 8}, {8, 8}, {0, 5}, {3, 5}, {2, 4}};
        int[][] result = ArrayRangeQuery.findRangeSumUsingMOAlgorithm(array, query);
        assertArrayEquals(new int[][]{{1, 3, 4}, {0, 4, 8}, {2, 4, 6}, {0, 5, 12}, {3, 5, 8}, {4, 6, 12}, {7, 8, 10}, {6, 8, 15}, {8, 8, 8}}, result);
    }

    @Test
    @GFGMethod(date = "04-08-2019", algo = "keep index in map by element, look for indexes in range for ele",
            url = "/range-queries-for-frequencies-of-array-elements/")
    public void testGetFrequencyOfElementInRange() {
        int[] array = {2, 8, 6, 9, 8, 6, 8, 2, 11};
        int[] result = ArrayRangeQuery.getFrequencyOfElementInRange(array, new int[][]{{2, 8, 8}, {2, 5, 6}, {2, 4, 9}, {9, 9, 11}});
        assertArrayEquals(new int[]{3, 1, 1, 1}, result);
    }

    @Test
    @GFGMethod(date = "05-08-2019", algo = "at start add +ele, at end+1 add -ele, in end do cumulative sum",
            desc = "(alt) can do lazy updates in segment tree url = /lazy-propagation-in-segment-tree/",
            url = "/constant-time-range-add-operation-array/")
    public void testConstantTimeRangeAddOperation() {
        ConstantTimeRangeAddOperation operation = new ConstantTimeRangeAddOperation(6);
        operation.add(0, 2, 10);
        operation.add(1, 5, 100);
        operation.add(2, 3, 50);
        int[] result = operation.getArray();
        assertArrayEquals(new int[]{10, 110, 160, 150, 100, 100}, result);
    }

    @Test
    @GFGMethod(date = "07-08-2019", algo = "sparse table[i][j] stores min of 2^j element starting from i including",
            url = "/sparse-table/", impls = RangeMinSparseTable.class)
    public void testSparseTableMinimumInRange() {
        int[] array = {7, 2, 3, 0, 5, 10, 3, 12, 18};
        SparseTable sparseTable = new RangeMinSparseTable(array);

        int result = sparseTable.getQuery(0, 4);
        assertEquals(0, result);

        result = sparseTable.getQuery(4, 7);
        assertEquals(3, result);

        result = sparseTable.getQuery(7, 8);
        assertEquals(12, result);
    }

    @Test
    @GFGMethod(date = "07-08-2019", algo = "sparse table[i][j] stores gcd of 2^j element starting from i including",
            url = "/sparse-table/", impls = RangeGCDSparseTable.class)
    public void testSparseTableGcdOfRange() {
        int[] array = {2, 3, 5, 4, 6, 8};
        SparseTable sparseTable = new RangeGCDSparseTable(array);

        int result = sparseTable.getQuery(0, 2);
        assertEquals(1, result);

        result = sparseTable.getQuery(3, 5);
        assertEquals(2, result);

        result = sparseTable.getQuery(2, 3);
        assertEquals(1, result);
    }
}
