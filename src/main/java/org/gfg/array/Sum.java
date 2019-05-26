package org.gfg.array;

public class Sum {
    public static int findMaxSumIndexMultValue(int[] array) {
        int r0 = 0;
        int index = 0;
        int arraySum = 0;
        for (int element : array) {
            r0 += index++ * element;
            arraySum += element;
        }
        int currValue = r0;
        int maxValue = currValue;
        for (int j = 1; j < array.length; j++) {
            currValue = currValue - arraySum + array.length * array[j - 1];
            if (currValue > maxValue) {
                maxValue = currValue;
            }
        }
        return maxValue;
    }
}
