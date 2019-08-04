package org.gfg.array;

import java.util.Arrays;

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
}
