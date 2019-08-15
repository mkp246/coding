package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.gfg.array.rangequery.BinaryIndexTree;
import org.gfg.array.rangequery.ConstantTimeRangeAddOperation;
import org.gfg.array.rangequery.MergeSortTreeForRangeOrderStatistics;
import org.gfg.array.rangequery.OutsideRangeGCD;
import org.gfg.array.rangequery.ProductOfArrayRangeUnderModuloP;
import org.gfg.array.rangequery.RangeGCDSegmentTree;
import org.gfg.array.rangequery.RangeGCDSparseTable;
import org.gfg.array.rangequery.RangeLCMSegmentTree;
import org.gfg.array.rangequery.RangeMinSegmentTree;
import org.gfg.array.rangequery.RangeMinSparseTable;
import org.gfg.array.rangequery.RangeSumSegmentTree;
import org.gfg.array.rangequery.SparseTable;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

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
    public void testSparseTableRangeGcd() {
        int[] array = {2, 3, 5, 4, 6, 8};
        SparseTable sparseTable = new RangeGCDSparseTable(array);

        int result = sparseTable.getQuery(0, 2);
        assertEquals(1, result);

        result = sparseTable.getQuery(3, 5);
        assertEquals(2, result);

        result = sparseTable.getQuery(2, 3);
        assertEquals(1, result);
    }

    @Test
    @GFGMethod(date = "07-08-2019", algo = "make full binary tree(stored as array), break segment as half, current node has sum of the segment under it",
            url = "/segment-tree-set-1-sum-of-given-range/", impls = RangeSumSegmentTree.class)
    public void testSegmentTreeRangeSum() {
        int[] array = {1, 3, 5, 7, 9, 11};
        RangeSumSegmentTree tree = new RangeSumSegmentTree(array);

        int result = tree.getQuery(1, 3);
        assertEquals(15, result);

        tree.updateValue(1, 10);
        result = tree.getQuery(1, 3);
        assertEquals(22, result);
    }

    @Test
    @GFGMethod(date = "07-08-2019", algo = "merge segments using lcm of segments",
            url = "/range-lcm-queries/", impls = RangeLCMSegmentTree.class)
    public void testSegmentTreeRangeLCM() {
        int[] array = {5, 7, 5, 2, 10, 12, 11, 17, 14, 1, 44};
        RangeLCMSegmentTree tree = new RangeLCMSegmentTree(array);

        int result = tree.getQuery(2, 5);
        assertEquals(60, result);

        result = tree.getQuery(5, 10);
        assertEquals(15708, result);

        result = tree.getQuery(0, 10);
        assertEquals(78540, result);
    }

    @Test
    @GFGMethod(date = "07-08-2019", algo = "merge using min, default value +INF",
            url = "/segment-tree-set-1-range-minimum-query/", impls = RangeMinSegmentTree.class)
    public void testSegmentTreeMinimumInRange() {
        int[] array = {7, 2, 3, 0, 5, 10, 3, 12, 18};
        RangeMinSegmentTree sparseTable = new RangeMinSegmentTree(array);

        int result = sparseTable.getQuery(0, 4);
        assertEquals(0, result);

        result = sparseTable.getQuery(4, 7);
        assertEquals(3, result);

        result = sparseTable.getQuery(7, 8);
        assertEquals(12, result);
    }

    @Test
    @GFGMethod(date = "08-08-2019", algo = "merge using gcd, out of range return 0",
            url = "/gcds-of-a-given-index-ranges-in-an-array/", impls = RangeGCDSegmentTree.class)
    public void testSegmentTreeRangeGcd() {
        int[] array = {2, 3, 5, 4, 6, 8};
        RangeGCDSegmentTree segmentTree = new RangeGCDSegmentTree(array);

        int result = segmentTree.getQuery(0, 2);
        assertEquals(1, result);

        result = segmentTree.getQuery(3, 5);
        assertEquals(2, result);

        result = segmentTree.getQuery(2, 3);
        assertEquals(1, result);
    }

    @Test
    @GFGMethod(date = "08-08-2019", algo = "keep gcd starting 0/ending at last upto index in new arrays, return gcd of starting[l-1] and ending[r+1]",
            url = "/queries-gcd-numbers-array-except-elements-given-range/", impls = OutsideRangeGCD.class)
    public void testOutsideRangeGcdUsingPrefixAndSuffixGCD() {
        int[] array = {2, 6, 9};
        OutsideRangeGCD segmentTree = new OutsideRangeGCD(array);

        int result = segmentTree.getQuery(0, 0);
        assertEquals(3, result);

        result = segmentTree.getQuery(1, 1);
        assertEquals(1, result);

        result = segmentTree.getQuery(1, 2);
        assertEquals(2, result);
    }

    @Test
    @GFGMethod(date = "12-08-2019", algo = "using BIT binary index tree",
            url = "/binary-indexed-tree-or-fenwick-tree-2/", impls = BinaryIndexTree.class)
    public void testBinaryIndexTreePrefixSum() {
        int[] array = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryIndexTree bit = new BinaryIndexTree(array);

        int result = bit.getQuery(5);
        assertEquals(12, result);

        bit.update(3, 6);
        result = bit.getQuery(5);
        assertEquals(18, result);
    }

    @Test
    @GFGMethod(date = "12-08-2019", algo = "prefix array st. pre[i] has decimal value of element after that including, res will be (pre[l]-pre[r])/2^(len-r-1)",
            url = "/queries-for-decimal-values-of-subarray-of-a-binary-array/")
    public void testDecimalValueOfBinarySubarray() {
        int[] array = {1, 0, 1, 0, 1, 1};
        int[][] queries = {{2, 4}, {4, 5}};

        int[] result = ArrayRangeQuery.decimalValueOfBinarySubarray(array, queries);
        assertArrayEquals(new int[]{5, 3}, result);
    }

    @Ignore("TODO not ure what's wrong, maybe answers are wrong")
    @Test
    @GFGMethod(date = "13-08-2019", algo = "each bit is independent, count zeros and ones at particular bit pos, if zeros are higher," +
            " set that bit in result, for <= unset(as 0 will cause more no. of ones in sum at that bit pos), ",
            url = "/number-whose-sum-of-xor-with-given-array-range-is-maximum/")
    public void testNumberWhoseSumOfXorWithRangeIsMaximum() {
        int[] array = {210, 11, 48, 22, 133};
        int[][] queries = {{1, 3}, {4, 14}, {2, 4}};

        int[] result = ArrayRangeQuery.numberWhoseSumOfXorWithRangeIsMaximum(array, queries);
        assertArrayEquals(new int[]{2147483629, 2147483647, 2147483629}, result);

        array = new int[]{20, 11, 18, 2, 13};
        queries = new int[][]{{1, 3}, {3, 5}, {2, 4}};
        result = ArrayRangeQuery.numberWhoseSumOfXorWithRangeIsMaximum(array, queries);
        assertArrayEquals(new int[]{2147483629, 2147483645, 2147483645}, result);
    }

    @Ignore("TODO")
    @Test
    @GFGMethod(date = "13-08-2019", algo = "",
            url = "/merge-sort-tree-for-range-order-statistics/")
    public void testMergeSortTreeForRangeOrderStatistics() {
        int[] array = {3, 2, 5, 1, 8, 9};
        MergeSortTreeForRangeOrderStatistics tree = new MergeSortTreeForRangeOrderStatistics(array);

        int result = tree.query(2, 5, 2);
        assertEquals(2, result);

        result = tree.query(1, 6, 4);
        assertEquals(5, result);
    }

    @Test
    @GFGMethod(date = "14-08-2019", algo = "xor of group of 4 starting 0 is 0, so can ignore group of 4",
            url = "/merge-sort-tree-for-range-order-statistics/")
    public void testRangeXorQueryIfElementIsXorOfPreviousElementAndIndex() {
        int result = ArrayRangeQuery.rangeXorQueryIfElementIsXorOfPreviousElementAndIndex(2, 4);
        assertEquals(7, result);

        result = ArrayRangeQuery.rangeXorQueryIfElementIsXorOfPreviousElementAndIndex(2, 8);
        assertEquals(9, result);

        result = ArrayRangeQuery.rangeXorQueryIfElementIsXorOfPreviousElementAndIndex(5, 9);
        assertEquals(15, result);
    }

    @Test
    @GFGMethod(date = "15-08-2019", algo = "sieve algorithm", url = "/sieve-of-eratosthenes/",
            tComp = "O(n*log(log(n))")
    public void testPrimesUsingSieveOfEratosthenes() {
        List<Integer> result = ArrayRangeQuery.primesUsingSieveOfEratosthenes(30);
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]", result.toString());

        result = ArrayRangeQuery.primesUsingSieveOfEratosthenes(10);
        assertEquals("[2, 3, 5, 7]", result.toString());

        result = ArrayRangeQuery.primesUsingSieveOfEratosthenes(20);
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19]", result.toString());


        result = ArrayRangeQuery.primesUsingSieveOfEratosthenes(50);
        assertEquals("[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]", result.toString());
    }

    @Test
    @GFGMethod(date = "15-08-2019", algo = "keep cumulative product and inverse modular cumulative product array",
            url = "/products-ranges-array/")
    public void testProductOfArrayRangeUnderModuloP() {
        int[] array = {1, 2, 3, 4, 5, 6};
        ProductOfArrayRangeUnderModuloP rangeProduct = new ProductOfArrayRangeUnderModuloP(array, 229);
        int result = rangeProduct.getQuery(2, 5);
        assertEquals(120, result);

        result = rangeProduct.getQuery(1, 3);
        assertEquals(6, result);

        array = new int[]{1, 2, 3, 4, 5, 6};
        rangeProduct = new ProductOfArrayRangeUnderModuloP(array, 113);
        result = rangeProduct.getQuery(2, 5);
        assertEquals(7, result);

        result = rangeProduct.getQuery(1, 3);
        assertEquals(6, result);
    }
}
