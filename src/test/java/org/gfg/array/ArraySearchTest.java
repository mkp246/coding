package org.gfg.array;

import com.mkp.GFG;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@GFG(date = "24-05-2019", topic = "array search", url = "/search-an-element-in-a-sorted-and-pivoted-array", impls = ArraySearch.class)
public class ArraySearchTest {

    @Test
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
}
