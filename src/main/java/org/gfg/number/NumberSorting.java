package org.gfg.number;

import java.util.List;

public class NumberSorting {
    public static String sortNumberArrayToFormBiggestNumber(List<String> array) {
        array.sort((o1, o2) -> o2.concat(o1).compareTo(o1.concat(o2)));
        return array.stream().reduce(String::concat).get();
    }
}
