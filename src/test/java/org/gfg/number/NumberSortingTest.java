package org.gfg.number;


import com.mkp.GFGMethod;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NumberSortingTest {

    @Test
    @GFGMethod(date = "17-07-2019", algo = "sort number to make largest number by custom comparator", url = "/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/")
    public void testSortNumberArrayToFormBiggestNumber() {
        List<String> array = new ArrayList<>();
        array.add("54");
        array.add("546");
        array.add("548");
        array.add("60");
        String result = NumberSorting.sortNumberArrayToFormBiggestNumber(array);
        Assert.assertEquals("6054854654", result);

        array.clear();
        array.add("1");
        array.add("34");
        array.add("3");
        array.add("98");
        array.add("9");
        array.add("76");
        array.add("45");
        array.add("4");
        result = NumberSorting.sortNumberArrayToFormBiggestNumber(array);
        Assert.assertEquals("998764543431", result);
    }
}
