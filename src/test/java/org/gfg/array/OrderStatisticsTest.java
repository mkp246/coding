package org.gfg.array;

import com.mkp.ALT;
import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Test;

import static org.junit.Assert.*;

@GFG(date = "24-07-2019", topic = " array order statistics", url = "/array-data-structure/array-order-statistics/")
public class OrderStatisticsTest {

    @Test
    @GFGMethod(date = "24-07-2019", algo = "(method 1)sort and get return array[k-1]", url = "kth-smallestlargest-element-unsorted-array/")
    public void testGetKthSmallestNumberUsingSorting() {
        int[] array = {7, 10, 4, 3, 20, 15};
        int result = OrderStatistics.getKthSmallestNumberUsingSorting(array, 3);
        assertEquals(7, result);

        result = OrderStatistics.getKthSmallestNumberUsingSorting(array, 4);
        assertEquals(10, result);
    }

    @Test
    @ALT(desc = "partition around median of median of 5 size blocks of n/5 at each step", url = "/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/")
    @ALT(desc = "partition around random element instead of last", url = "/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time-2/")
    @GFGMethod(date = "24-07-2019", algo = "(method 4)quick sort partition around last element", url = "kth-smallestlargest-element-unsorted-array/", tComp = "avg O(n), worst O(n^2)")
    public void testGetKthSmallestNumberUsingPartition() {
        int[] array = {12, 3, 5, 7, 4, 19, 26};
        int result = OrderStatistics.getKthSmallestNumberUsingPartition(array, 0, array.length - 1, 3);
        assertEquals(5, result);
    }
}
