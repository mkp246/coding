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

    @Test
    @GFGMethod(date = "25-07-2019", algo = "sorting", url = "/program-for-mean-and-median-of-an-unsorted-array/")
    public void testGetMeanAndMedian() {
        int[] array = {1, 3, 4, 2, 6, 5, 8, 7};
        double[] result = OrderStatistics.getMeanAndMedian(array);
        assertArrayEquals(new double[]{4.5, 4.5}, result, 0);

        array = new int[]{4, 4, 4, 4, 4};
        result = OrderStatistics.getMeanAndMedian(array);
        assertArrayEquals(new double[]{4, 4}, result, 0);

        array = new int[]{1, 3, 4, 2, 7, 5, 8, 6};
        result = OrderStatistics.getMeanAndMedian(array);
        assertArrayEquals(new double[]{4.5, 4.5}, result, 0);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "maintain 2 heap one has smaller(max heap), one has larger(min heap) than median",
            url = "/median-of-stream-of-running-integers-using-stl/", impls = RunningMedian.class)
    public void testGetMedianOfRunningStream() {
        int[] array = {5, 15, 10, 20, 3};
        RunningMedian runningMedian = new RunningMedian();
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = runningMedian.addAndGetMedian(array[i]);
        }
        assertArrayEquals(new double[]{5, 10, 10, 12.5, 10}, result, 0);

        array = new int[]{5, 10, 15};
        runningMedian = new RunningMedian();
        result = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = runningMedian.addAndGetMedian(array[i]);
        }
        assertArrayEquals(new double[]{5, 7.5, 10}, result, 0);
    }

    @Test
    @GFGMethod(date = "25-07-2019", algo = "sort and multiply smallest k integers", url = "/minimum-product-k-integers-array-positive-integers/")
    public void testGetMinProductOfKInteger() {
        int[] array = {198, 76, 544, 123, 154, 675};
        int result = OrderStatistics.getMinProductOfKInteger(array, 2);
        assertEquals(9348, result);

        array = new int[]{11, 8, 5, 7, 5, 100};
        result = OrderStatistics.getMinProductOfKInteger(array, 4);
        assertEquals(1400, result);
    }

    @Test
    @GFGMethod(date = "27-07-2019", algo = "cumulative sum diff will give range sum, calc all possible sums,put in mean heap only largest k element",
            url = "/k-th-largest-sum-contiguous-subarray/")
    public void testGetKthLargestSumContinuousSubarray() {
        int[] array = {20, -5, -1};
        int result = OrderStatistics.getKthLargestSumContinuousSubarray(array, 3);
        assertEquals(14, result);

        array = new int[]{10, -10, 20, -40};
        result = OrderStatistics.getKthLargestSumContinuousSubarray(array, 6);
        assertEquals(-10, result);
    }
}
