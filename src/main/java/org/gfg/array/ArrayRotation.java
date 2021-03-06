package org.gfg.array;

public class ArrayRotation {
    public static void rotateUsingTempArray(int[] array, int rotateBy) {
        int[] tempArray = new int[rotateBy];
        System.arraycopy(array, 0, tempArray, 0, rotateBy);
        System.arraycopy(array, rotateBy, array, 0, array.length - rotateBy);
        System.arraycopy(tempArray, 0, array, array.length - rotateBy, rotateBy);
    }

    public static void rotateByOne(int[] array) {
        int temp = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = temp;
    }

    public static void rotateUsingRotateByOne(int[] array, int rotateBy) {
        for (int i = 0; i < rotateBy; i++) {
            rotateByOne(array);
        }
    }

    public static void rotateUsingJuggling(int[] array, int rotateBy) {
        int gcd = Util.gcd(array.length, rotateBy);
        int temp, src, dest;
        for (int i = 0; i < gcd; i++) {
            temp = array[i];
            dest = i;
            while (true) {
                src = (dest + rotateBy) % array.length;
                if (src == i) {
                    array[dest] = temp;
                    break;
                } else {
                    array[dest] = array[src];
                    dest = src;
                }
            }
        }
    }

    public static void reverseArray(int[] array, int start, int end) {
        int temp;
        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateUsingReversal(int[] array, int rotateBy) {
        reverseArray(array, 0, rotateBy - 1);
        reverseArray(array, rotateBy, array.length - 1);
        reverseArray(array, 0, array.length - 1);
    }

    static void swap(int[] array, int fi, int si, int length) {
        int temp;
        for (int i = 0; i < length; i++) {
            temp = array[fi];
            array[fi] = array[si];
            array[si] = temp;
            fi++;
            si++;
        }
    }

    public static void rotateUsingBlockSwap(int[] array, int start, int end, int rotateBy) {
        int blockLength = end - start + 1;
        if (rotateBy == 0 || rotateBy == blockLength) return;

        //to rotate is half of array
        if (blockLength == 2 * rotateBy) {
            swap(array, start, start + rotateBy, rotateBy);
            return;
        }

        //A is shorter
        if (blockLength > 2 * rotateBy) {
            swap(array, start, end - rotateBy + 1, rotateBy);
            rotateUsingBlockSwap(array, start, end - rotateBy, rotateBy);
        } else {
            //B is shorter
            swap(array, start, start + rotateBy, blockLength - rotateBy);
            rotateUsingBlockSwap(array, start + blockLength - rotateBy, end, 2 * rotateBy - blockLength);
        }
    }

    public static void rightRotateUsingReversal(int[] array, int rotateBy) {
        reverseArray(array, 0, array.length - 1);
        reverseArray(array, 0, rotateBy - 1);
        reverseArray(array, rotateBy, array.length - 1);
    }

    public static int maxHammingAmongRotation(int[] array) {
        int maxHamming = 0;
        int tempHamming;
        for (int i = 1; i < array.length; i++) {
            tempHamming = 0;
            for (int j = i, k = 0; j < i + array.length; j++, k++) {
                if (array[j % array.length] != array[k]) tempHamming++;
            }
            if (tempHamming > maxHamming) maxHamming = tempHamming;
            if (maxHamming == array.length) break; //cant be higher than array length
        }
        return maxHamming;
    }

    /**
     * idea is to start from end as we are looking in final array.<br/>
     * and keep track of index from where that index was replaced with just before the that rotation <br/>
     * do till the the first ranges and we know which initial index(in original array) <br/>
     * would finally reach our desired index in the end
     */
    public static int getElementAtIndexAfterRangeRightRotations(int[] array, int[][] ranges, int index) {
        int[] range;
        for (int i = ranges.length - 1; i >= 0; i--) {
            range = ranges[i];
            if (isInRange(range[0], range[1], index)) {
                if (index == range[0]) {
                    index = range[1];
                } else {
                    index--;
                }
            }
        }
        return array[index];
    }

    private static boolean isInRange(int lower, int upper, int toCheck) {
        return lower <= toCheck && toCheck <= upper;
    }

    /**
     * keep track of strictly up and down, ignore equality
     * both of them can't me greater than 1 at same time
     * takes care of ascending/descending both
     */
    public static boolean isPossibleToSortByRotation(int[] array) {
        int downCount = 0, upCount = 0;
        int tempDiff;

        for (int i = 1; i < array.length && (downCount <= 1 || upCount <= 1); i++) {
            tempDiff = array[i - 1] - array[i];
            if (tempDiff > 0) {
                downCount++;
            } else if (tempDiff < 0) {
                upCount++;
            }
        }
        
        tempDiff = array[array.length - 1] - array[0];
        if (tempDiff > 0) {
            downCount++;
        } else if (tempDiff < 0) {
            upCount++;
        }

        return (upCount <= 1 || downCount <= 1);
    }
}
