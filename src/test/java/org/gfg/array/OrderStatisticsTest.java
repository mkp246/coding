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
    @GFGMethod(date = "24-07-2019", algo = "(method 4)quick sort partition around last element", url = "/kth-smallestlargest-element-unsorted-array/", tComp = "avg O(n), worst O(n^2)")
    public void testGetKthSmallestNumberUsingPartition() {
        int[] array = {12, 3, 5, 7, 4, 19, 26};
        int result = OrderStatistics.getKthSmallestNumberUsingPartition(array, 0, array.length - 1, 3);
        assertEquals(5, result);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "assume largest @0, traverse update largest if greater found", url = "/c-program-find-largest-element-array/")
    public void testFindLargestElement() {
        int[] array = {10, 20, 4};
        int result = OrderStatistics.findLargestElement(array);
        assertEquals(20, result);

        array = new int[]{20, 10, 20, 4, 100};
        result = OrderStatistics.findLargestElement(array);
        assertEquals(100, result);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "keep track of 3 highest number", url = "/find-the-largest-three-elements-in-an-array/")
    public void testFindThreeLargestElement() {
        int[] array = {10, 4, 3, 50, 23, 90};
        int[] result = OrderStatistics.findThreeLargestElement(array);
        assertArrayEquals(new int[]{90, 50, 23}, result);

        array = new int[]{12, 13, 1, 10, 34, 1};
        result = OrderStatistics.findThreeLargestElement(array);
        assertArrayEquals(new int[]{34, 13, 12}, result);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "(method 2) sorting and print first n-2 elements", url = "/find-elements-array-least-two-greater-elements/")
    public void testFindElementHavingAtLeastTwoGreaterBySorting() {
        int[] array = {2, 8, 7, 1, 5};
        int[] result = OrderStatistics.findElementHavingAtLeastTwoGreaterBySorting(array);
        assertArrayEquals(new int[]{1, 2, 5}, result);

        array = new int[]{7, -2, 3, 4, 9, -1};
        result = OrderStatistics.findElementHavingAtLeastTwoGreaterBySorting(array);
        assertArrayEquals(new int[]{-2, -1, 3, 4}, result);

        array = new int[]{2, -6, 3, 5, 1};
        result = OrderStatistics.findElementHavingAtLeastTwoGreaterBySorting(array);
        assertArrayEquals(new int[]{-6, 1, 2}, result);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "(method 3)find 2nd largest and print less element than that", url = "/find-elements-array-least-two-greater-elements/")
    public void testFindElementHavingAtLeastTwoGreaterByFindingSecondMaximum() {
        int[] array = {2, 8, 7, 1, 5};
        int[] result = OrderStatistics.findElementHavingAtLeastTwoGreaterByFindingSecondMaximum(array);
        assertArrayEquals(new int[]{2, 1, 5}, result);

        array = new int[]{7, -2, 3, 4, 9, -1};
        result = OrderStatistics.findElementHavingAtLeastTwoGreaterByFindingSecondMaximum(array);
        assertArrayEquals(new int[]{-2, 3, 4, -1}, result);

        array = new int[]{2, -6, 3, 5, 1};
        result = OrderStatistics.findElementHavingAtLeastTwoGreaterByFindingSecondMaximum(array);
        assertArrayEquals(new int[]{2, -6, 1}, result);
    }
}
