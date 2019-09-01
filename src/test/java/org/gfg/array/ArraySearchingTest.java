package org.gfg.array;

import com.mkp.GFG;
import com.mkp.GFGMethod;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@GFG(date = "01-09-2019", topic = "array searching", url = "/array-data-structure/array-searching/", impls = ArraySearching.class)
public class ArraySearchingTest {

    @Test
    @GFGMethod(date = "01-09-2019", algo = "linear search", url = "/search-insert-and-delete-in-an-unsorted-array/")
    public void testSearchInUnsortedArray() {
        int[] array = {12, 34, 10, 6, 40};
        int result = ArraySearching.searchInUnsortedArray(array, 40);
        assertEquals(4, result);

        result = ArraySearching.searchInUnsortedArray(array, 10);
        assertEquals(2, result);

        result = ArraySearching.searchInUnsortedArray(array, 9);
        assertEquals(-1, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "insert in end if cap > total, increment total else error",
            url = "/search-insert-and-delete-in-an-unsorted-array/")
    public void testInsertInEndOfArray() {
        int[] array = new int[20];
        array[0] = 12;
        array[1] = 16;
        array[2] = 20;
        array[3] = 40;
        array[4] = 50;
        array[5] = 70;
        int capacity = 20;
        int total = 6;
        ArraySearching.insertInEndOfArray(array, 26, total, capacity);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= total; i++) {
            result.append(array[i]).append(",");
        }
        assertEquals("12,16,20,40,50,70,26,", result.toString());
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "search key if found shift all the element to left by 1, decrement total count",
            url = "/search-insert-and-delete-in-an-unsorted-array/")
    public void testDeleteElementOfArray() {
        int[] array = {10, 50, 30, 40, 20};
        int count = ArraySearching.deleteElementOfArray(array, 30, array.length);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(array[i]).append(",");
        }
        assertEquals("10,50,40,20,", result.toString());
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "binary search", url = "/search-insert-and-delete-in-a-sorted-array/")
    public void testBinarySearchInSortedArray() {
        int[] array = {5, 6, 7, 8, 9, 10};
        int result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 10);
        assertEquals(5, result);

        result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 7);
        assertEquals(2, result);

        result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 5);
        assertEquals(2, result);

        result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 4);
        assertEquals(2, result);

        result = ArraySearching.binarySearchInSortedArray(array, 0, array.length - 1, 12);
        assertEquals(-1, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "jump forward by abs diff between ele and key, starting from 0",
            url = "/search-an-element-in-an-array-where-difference-between-adjacent-elements-is-1/")
    public void testSearchInArrayWhereAdjacentDifferenceIsOne() {
        int[] array = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3};
        int result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 3);
        assertEquals(7, result);

        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 2);
        assertEquals(8, result);

        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 4);
        assertEquals(6, result);

        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 10);
        assertEquals(-1, result);

        array = new int[]{1, 2, 3, 4, 5, 4};
        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsOne(array, 5);
        assertEquals(4, result);
    }

    @Test
    @GFGMethod(date = "01-09-2019", algo = "jump forward by ceil (abs diff between ele and key)/k, starting from 0",
            url = "/searching-array-adjacent-differ-k/")
    public void testSearchInArrayWhereAdjacentDifferenceIsAtMostK() {
        int[] array = {4, 5, 6, 7, 6};
        int result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsAtMostK(array, 6, 1);
        assertEquals(2, result);

        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsAtMostK(array, 8, 1);
        assertEquals(-1, result);

        array = new int[]{20, 40, 50, 70, 70, 60};
        result = ArraySearching.searchInArrayWhereAdjacentDifferenceIsAtMostK(array, 60, 20);
        assertEquals(5, result);
    }


    @Test
    @GFGMethod(date = "01-09-2019", algo = "find common in first two, check if common is present in tree, if present inc all ptr, else just first two ptr",
            url = "/find-common-elements-three-sorted-arrays/")
    public void testFindCommonInThreeSortedArray() {
        int[] array1 = {1, 5, 10, 20, 40, 80};
        int[] array2 = {6, 7, 20, 80, 100};
        int[] array3 = {3, 4, 15, 20, 30, 70, 80, 120};
        int[] result = ArraySearching.findCommonInThreeSortedArray(array1, array2, array3);
        assertArrayEquals(new int[]{20, 80}, result);

        array1 = new int[]{1, 5, 5};
        array2 = new int[]{3, 4, 5, 5, 10};
        array3 = new int[]{5, 5, 10, 20};
        result = ArraySearching.findCommonInThreeSortedArray(array1, array2, array3);
        assertArrayEquals(new int[]{5, 5}, result);
    }
}
