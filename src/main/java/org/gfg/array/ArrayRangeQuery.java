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

    public static int[] decimalValueOfBinarySubarray(int[] array, int[][] queries) {
        int multiplier = 2;
        for (int i = array.length - 2; i >= 0; i--) {
            array[i] = array[i + 1] + array[i] * multiplier;
            multiplier <<= 1;
        }

        int[] result = new int[queries.length]; // query=[l,r]
        int resultPos = 0;
        for (int[] query : queries) {
            if (query[1] != array.length - 1) {
                result[resultPos++] = (array[query[0]] - array[query[1] + 1]) >> (array.length - 1 - query[1]);
            } else {
                result[resultPos++] = array[query[0]];
            }
        }
        return result;
    }

    public static int[] numberWhoseSumOfXorWithRangeIsMaximum(int[] array, int[][] queries) {
        int[][] ones = new int[32][array.length];
        int bitMask = 1;
        for (int i = 0; i < 32; i++) {
            if ((array[0] & bitMask) != 0) {
                ones[i][0] = 1;
            } else {
                ones[i][0] = 0;
            }
            bitMask <<= 1;
        }
        
        bitMask = 1;
        for (int i = 0; i < 32; i++) {
            for (int j = 1; j < array.length; j++) {
                if ((array[j] & bitMask) != 0) {
                    ones[i][j] = ones[i][j - 1] + 1;
                } else {
                    ones[i][j] = ones[i][j - 1];
                }
            }
            bitMask <<= 1;
        }

        int[] result = new int[queries.length];
        int resultPos = 0;
        for (int[] query : queries) {
            int number = 0;// holds the number to be xor with
            bitMask = 1;
            int numOnes, numZeros;
            if (query[1] > array.length - 1) {
                query[1] = array.length - 1;
            }
            for (int i = 0; i < 31; i++) {
                numOnes = ones[i][query[1]] - (query[0] == 0 ? 0 : ones[i][query[0] - 1]);
                numZeros = query[1] - query[0] + 1 - numOnes;
                if (numOnes >= numZeros) {
                    //nothing to do as all bit as unset during initialization
                } else {
                    number |= bitMask; //set the bit
                }
                bitMask <<= 1;
            }
            result[resultPos++] = number;
        }
        return result;
    }
}
