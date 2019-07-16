package org.gfg.array;


import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

@GFG(date = "16-07-2019", topic = "array rearrangement", url = "")
public class ArrayRearrangeTest {

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange such that a[i]=i or -1, using fix index", url = "/rearrange-array-arri/")
    public void testRearrangeAiIsI() {
        int[] array = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        ArrayRearrange.rearrangeAiIsI(array);
        Assert.assertArrayEquals(new int[]{-1, 1, 2, 3, 4, -1, 6, -1, -1, 9}, array);

        array = new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        ArrayRearrange.rearrangeAiIsI(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange such that a[i]=i or -1, using hash set", url = "/rearrange-array-arri/")
    public void testRearrangeAiIsIUsingHashSet() {
        int[] array = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        ArrayRearrange.rearrangeAiIsIUsingHashSet(array);
        Assert.assertArrayEquals(new int[]{-1, 1, 2, 3, 4, -1, 6, -1, -1, 9}, array);

        array = new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        ArrayRearrange.rearrangeAiIsIUsingHashSet(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange such that a[i]=i or -1, using swap", url = "/rearrange-array-arri/")
    public void testRearrangeAiIsIUsingSwap() {
        int[] array = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        ArrayRearrange.rearrangeAiIsIUsingSwap(array);
        Assert.assertArrayEquals(new int[]{-1, 1, 2, 3, 4, -1, 6, -1, -1, 9}, array);

        array = new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        ArrayRearrange.rearrangeAiIsIUsingSwap(array);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "reverse array", url = "/write-a-program-to-reverse-an-array-or-string/")
    public void testReverseArray() {
        int[] array = {1, 2, 3};
        ArrayRearrange.reverseArray(array, 0, array.length - 1);
        Assert.assertArrayEquals(new int[]{3, 2, 1}, array);

        array = new int[]{4, 5, 1, 2};
        ArrayRearrange.reverseArray(array, 0, array.length - 1);
        Assert.assertArrayEquals(new int[]{2, 1, 5, 4}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange array in increasing decreasing order by sorting", url = "/rearrange-array-arri-arrj-even-arri/")
    public void testRearrangeArrayInIncreasingDecreasingOrderBySorting() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayRearrange.rearrangeArrayInIncreasingDecreasingOrderUsingSorting(array);
        Assert.assertArrayEquals(new int[]{4, 5, 3, 6, 2, 7, 1}, array);

        array = new int[]{1, 2, 1, 4, 5, 6, 8, 8};
        ArrayRearrange.rearrangeArrayInIncreasingDecreasingOrderUsingSorting(array);
        Assert.assertArrayEquals(new int[]{4, 5, 2, 6, 1, 8, 1, 8}, array);
    }

    @Test
    @GFGMethod(date = "16-07-2019", algo = "rearrange array in increasing decreasing order by swapping with next", url = "/rearrange-array-arri-arrj-even-arri/")
    public void testRearrangeArrayInIncreasingDecreasingOrderBySwappingAdjacentElement() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrayRearrange.rearrangeArrayInIncreasingDecreasingOrderBySwappingAdjacentElement(array);
        Assert.assertArrayEquals(new int[]{1, 3, 2, 5, 4, 7, 6}, array);

        array = new int[]{1, 2, 1, 4, 5, 6, 8, 8};
        ArrayRearrange.rearrangeArrayInIncreasingDecreasingOrderBySwappingAdjacentElement(array);
        Assert.assertArrayEquals(new int[]{1, 2, 1, 5, 4, 8, 6, 8}, array);
    }
}
