package org.gfg.array;

import com.mkp.ALT;
import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@GFG(date = "24-05-2019", topic = "array search", url = "/search-an-element-in-a-sorted-and-pivoted-array", impls = ArraySearch.class)
public class ArraySearchTest {

    @Test
    @GFGMethod(date = "15-05-2019", algo = "binary search")
    public void testBinarySearch() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

        int index = ArraySearch.binarySearch(array, 0, array.length - 1, 2);
        assertEquals(1, index);

        index = ArraySearch.binarySearch(array, 0, array.length - 1, 6);
        assertEquals(5, index);

        index = ArraySearch.binarySearch(array, 0, array.length - 1, 7);
        assertEquals(6, index);

        index = ArraySearch.binarySearch(array, 0, array.length - 1, 9);
        assertEquals(-1, index);

        index = ArraySearch.binarySearch(array, 0, array.length - 1, -5);
        assertEquals(-1, index);

        array = new int[]{2, 3, 4, 5, 6, 7, 9, 15, 24, 100};

        index = ArraySearch.binarySearch(array, 0, array.length - 1, 4);
        assertEquals(2, index);
        index = ArraySearch.binarySearch(array, 0, array.length - 1, 9);
        assertEquals(6, index);
        index = ArraySearch.binarySearch(array, 0, array.length - 1, 24);
        assertEquals(8, index);
        index = ArraySearch.binarySearch(array, 0, array.length - 1, 100);
        assertEquals(9, index);
        index = ArraySearch.binarySearch(array, 0, array.length - 1, 20);
        assertEquals(-1, index);
        index = ArraySearch.binarySearch(array, 0, array.length - 1, 200);
        assertEquals(-1, index);
        index = ArraySearch.binarySearch(array, 0, array.length - 1, 0);
        assertEquals(-1, index);
    }

    @Test
    @ALT(url = "/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/", desc = "(method 2)Find the maximum element in an array which is first increasing and then decreasing")
    @ALT(url = "/find-minimum-element-in-a-sorted-and-rotated-array")
    @ALT(url = "/find-rotation-count-rotated-sorted-array/")
    @GFGMethod(date = "25-05-2019", algo = "find pivot using binary search in sorted and rotated array")
    public void testFindPivot() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        int pivot = ArraySearch.findPivot(array, 0, array.length - 1);
        assertEquals(-1, pivot);

        array = new int[]{4, 5, 6, 7, 1, 2, 3};
        pivot = ArraySearch.findPivot(array, 0, array.length - 1);
        assertEquals(4, pivot);

        array = new int[]{2, 3, 4, 5, 6, 7, 1};
        pivot = ArraySearch.findPivot(array, 0, array.length - 1);
        assertEquals(6, pivot);

        array = new int[]{2, 3, 4, 5, 6, 7, 9, 15, 24, 100};
        pivot = ArraySearch.findPivot(array, 0, array.length - 1);
        assertEquals(-1, pivot);

        array = new int[]{15, 24, 100, 2, 3, 4, 5, 6, 7, 9};
        pivot = ArraySearch.findPivot(array, 0, array.length - 1);
        assertEquals(3, pivot);

        array = new int[]{9, 15, 24, 100, 2, 3, 4, 5, 6, 7};
        pivot = ArraySearch.findPivot(array, 0, array.length - 1);
        assertEquals(4, pivot);
    }

    @Test
    @GFGMethod(date = "25-05-2019", algo = "search in sorted and rotated array using pivot and binary search ")
    public void testFindInSortedAndRotatedArray() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

        int pivot = ArraySearch.findInSortedAndRotatedArray(array, 0);
        assertEquals(-1, pivot);

        pivot = ArraySearch.findInSortedAndRotatedArray(array, 5);
        assertEquals(4, pivot);

        pivot = ArraySearch.findInSortedAndRotatedArray(array, 7);
        assertEquals(6, pivot);

        pivot = ArraySearch.findInSortedAndRotatedArray(array, 100);
        assertEquals(-1, pivot);

        array = new int[]{4, 5, 6, 7, 1, 2, 3};

        pivot = ArraySearch.findInSortedAndRotatedArray(array, 1);
        assertEquals(4, pivot);

        pivot = ArraySearch.findInSortedAndRotatedArray(array, 6);
        assertEquals(2, pivot);

        pivot = ArraySearch.findInSortedAndRotatedArray(array, 3);
        assertEquals(6, pivot);

        pivot = ArraySearch.findInSortedAndRotatedArray(array, -10);
        assertEquals(-1, pivot);

        pivot = ArraySearch.findInSortedAndRotatedArray(array, 200);
        assertEquals(-1, pivot);

        array = new int[]{9, 15, 24, 100, 2, 3, 4, 5, 6, 7};
        pivot = ArraySearch.findInSortedAndRotatedArray(array, 2);
        assertEquals(4, pivot);

        pivot = ArraySearch.findInSortedAndRotatedArray(array, 6);
        assertEquals(8, pivot);

        pivot = ArraySearch.findInSortedAndRotatedArray(array, 24);
        assertEquals(2, pivot);

    }
}
