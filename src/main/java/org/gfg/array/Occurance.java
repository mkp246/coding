package org.gfg.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Occurance {
    public static int[] findOccuredOnceUsingSorting(int[] array) {
        Arrays.sort(array);
        List<Integer> result = new ArrayList<>();
        int index = 0;
        //first and last needs to have special check to prevent out of bound index 
        if (array[index] != array[index + 1]) result.add(array[index]);
        for (index = 1; index < array.length - 1; index++) {
            if (array[index - 1] != array[index] && array[index] != array[index + 1]) result.add(array[index]);
        }
        if (array[index - 1] != array[index]) result.add(array[index]);

        int[] resultArray = new int[result.size()];
        index = 0;
        for (int number : result) {
            resultArray[index++] = number;
        }
        return resultArray;
    }

    public static int[] findOccuredOnceUsingHashing(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int element : array) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            if ((int) entry.getValue() == 1) {
                result.add((Integer) entry.getKey());
            }
        }

        return intListToArray(result);
    }

    public static int[] intListToArray(List<Integer> result) {
        int[] resultArray = new int[result.size()];
        int index = 0;
        for (int number : result) {
            resultArray[index++] = number;
        }
        return resultArray;
    }

    public static int[] findOccuredOnceUsingIfDuplicatesAreTogether(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                result.add(array[i]);
                break;
            }
            if (array[i] == array[i + 1]) {
                while (i + 1 < array.length && array[i + 1] == array[i]) i++;
            } else {
                result.add(array[i]);
            }
        }
        return intListToArray(result);
    }
}
