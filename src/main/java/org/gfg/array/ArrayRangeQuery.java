package org.gfg.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

public class ArrayRangeQuery {

    public static int[][] findRangeSumUsingMOAlgorithm(int[] array, int[][] query) {
        double blockSize = Math.sqrt(array.length);
        Arrays.sort(query, (o1, o2) -> {
            if ((int) (o1[0] / blockSize) == (int) (o2[0] / blockSize)) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[][] result = new int[query.length][3];
        int resultPos = 0;
        int currL = 0, currR = 0, currSum = array[0];
        for (int[] element : query) {
            while (currL < element[0]) {
                currSum -= array[currL++];
            }
            while (currL > element[0]) {
                currSum += array[--currL];
            }

            while (currR < element[1]) {
                currSum += array[++currR];
            }
            while (currR > element[1]) {
                currSum -= array[currR--];
            }
            result[resultPos][0] = element[0];
            result[resultPos][1] = element[1];
            result[resultPos++][2] = currSum;
        }

        return result;
    }

    /**
     * query format [start,end,element]
     *
     * @param array
     * @param queries
     * @return
     */
    public static int[] getFrequencyOfElementInRange(int[] array, int[][] queries) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.putIfAbsent(array[i], new ArrayList<>());
            map.get(array[i]).add(i);
        }
        int[] result = new int[queries.length];
        int resultPos = 0;
        for (int[] query : queries) {
            ArrayList<Integer> indexes = map.get(query[2]);
            int start = 0, end = 0;
            //this loop can be done in O(log(n)) as sorted element
            while (indexes.get(start) < query[0] - 1) {
                start++;
            }
            end = start;
            while (end < indexes.size() && indexes.get(end) <= query[1] - 1) {
                end++;
            }
            result[resultPos++] = end - start;
        }
        return result;
    }
}
