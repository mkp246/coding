package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Test;

@GFG(date = "03-08-2019", topic = "array range queries", url = "/array-data-structure/array-range-queries/", impls = ArrayRangeQuery.class)
public class ArrayRangeQueryTest {

    @Test
    @GFGMethod(date = "03-08-2019", algo = "query square root decomposition (MO's algorithm)",
            url = "/mos-algorithm-query-square-root-decomposition-set-1-introduction/", tComp = "O((m+n)sqrt(n))")
    public void testFindRangeSumUsingMOAlgorithm() {
        int[] array = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        int[][] query = {{0, 4}, {1, 3}, {2, 4}};
        int[] result = ArrayRangeQuery.findRangeSumUsingMOAlgorithm(array, query);
    }
}
