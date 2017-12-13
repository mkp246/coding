package gfg.array;

import java.util.Arrays;
import java.util.Hashtable;

import static gfg.array.Simple.printMethodSeparator;
import static gfg.array.Simple.printMethodName;
import static gfg.array.Simple.blockSwap;

public class Rearrangement {
    public static void main(String[] args) {
        printMethodName("arrangeOddAndEven");
        int[] array1 = {3, 6, 12, 1, 5, 8};
        arrangeOddAndEven(array1);
        System.out.println(Arrays.toString(array1));
        printMethodSeparator();
        printMethodName("rearrangePositiveNegativeUsingSort");
        Integer array2[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        rearrangePositiveNegativeUsingSort(array2);
        System.out.println(Arrays.toString(array2));
        printMethodSeparator();
        printMethodName("rearrangePositiveNegativeUsingInsertionSort");
        int array3[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        rearrangePositiveNegativeUsingInsertionSort(array3);
        System.out.println(Arrays.toString(array3));
        printMethodSeparator();
        printMethodName("shuffleArray");
        int array4[] = {1, 3, 5, 7, 2, 4, 6, 8};
        shuffleArray(array4, 0, array4.length - 1);
        System.out.println((Arrays.toString(array4)));
        printMethodSeparator();
        printMethodName("shuffleArrayNoExtraSpace");
        int array5[] = {1, 3, 5, 7, 2, 4, 6, 8};
        shuffleArrayNoExtraSpace(array5);
        System.out.println(Arrays.toString(array5));
        printMethodSeparator();
        String str1 = "01101100101101101100000";
        printMethodName("rearrangeBinaryStringAlternateXYOccurrences");
        rearrangeBinaryStringAlternateXYOccurrences(str1, 1, 2);
        printMethodSeparator();
        printMethodName("sortInWaveUsingSortFunction");
        int array6[] = {10, 90, 49, 2, 1, 5, 23};
        sortInWaveUsingSortFunction(array6);
        System.out.println(Arrays.toString(array6));
        printMethodSeparator();
        printMethodName("sortInWaveEffecient");
        int array7[] = {10, 90, 49, 2, 1, 5, 23};
        sortInWaveEffecient(array7);
        System.out.println(Arrays.toString(array7));
        printMethodSeparator();
        printMethodName("");
        int array8[] = {6, 4, 2, 1, 8, 3};
        sortInWaveReverseCondition(array8);
        System.out.println(Arrays.toString(array8));
        printMethodSeparator();
        printMethodName("positiveEvenNegativeOddPositions");
        int array9[] = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10};
        positiveEvenNegativeOddPositions(array9);
        System.out.println(Arrays.toString(array9));
        printMethodSeparator();
        printMethodName("negativeAtStartNoOrdering");
        int array10[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        negativeAtStartNoOrdering(array10);
        System.out.println((Arrays.toString(array10)));
        printMethodSeparator();
        printMethodName("smallestLargestPairedOrder");
        int array11[] = {5, 8, 1, 4, 2, 9, 3, 7, 6};
        smallestLargestPairedOrder(array11);
        System.out.println(Arrays.toString(array11));
        printMethodSeparator();
        printMethodName("isPossibleDistinctAdjacentElementsArray");
        int[] array12 = {7, 1, 1, 7};
        isPossibleDistinctAdjacentElementsArray(array12);
        printMethodSeparator();
        printMethodName("maxSumConsecutiveDifferencesCircularArray");
        int[] array13 = {1, 2, 8, 4};
        System.out.println(maxSumConsecutiveDifferencesCircularArray(array13));
        printMethodSeparator();
        printMethodName("largestSmallestPairedOrderConstantExtraSpace");
        int arr14[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        largestSmallestPairedOrderConstantExtraSpace(arr14);
        System.out.println(Arrays.toString(arr14));
        printMethodSeparator();
        printMethodName("threeWayPartition");
        int arr15[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        threeWayPartition(arr15, 10, 20);
        System.out.println(Arrays.toString(arr15));
        printMethodSeparator();
        printMethodName("segregatePositiveAndNegative");
        int arr16[] = {1, -1, -3, -2, 7, 5, 11, 6};
        segregatePositiveAndNegative(arr16);
        System.out.println(Arrays.toString(arr16));
        printMethodSeparator();
        printMethodName("alternatePositiveaAndNegativeUsingPartition");
        int arr17[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        alternatePositiveaAndNegativeUsingPartition(arr17);
        System.out.println(Arrays.toString(arr17));
        printMethodSeparator();
    }

    public static void arrangeOddAndEven(int[] array) {
        int start = 0, end = array.length - 1;
        while (true) {
            while ((start < array.length) && (start + array[start]) % 2 == 0) {
                start++;
            }
            while ((end > -1) && (end + array[end]) % 2 == 0) {
                end--;
            }
            if (start >= end) {
                break;
            }
            blockSwap(array, start, end, 1);
        }
    }

    public static void rearrangePositiveNegativeUsingSort(Integer[] array) {
        Arrays.sort(array, (o1, o2) -> {
            if (o1 > 0 && o2 < 0) return 1;
            else if (o1 < 0 && o2 > 0) return -1;
            else return 0;
        });
    }

    public static void rearrangePositiveNegativeUsingInsertionSort(int[] array) {
        int positiveIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) continue;
            else {
                circularRightRotate(array, positiveIndex, i);
                positiveIndex++;
            }
        }
    }

    private static void circularRightRotate(int[] array, int start, int end) {
        int temp = array[end];
        for (int i = end; i > start; i--) {
            array[i] = array[i - 1];
        }
        array[start] = temp;
    }

    public static void rearrangePositiveNegativeUsingOptimizedMergeSort(int[] array, int left, int right) {
        if (left > right) {
            int mid = left + (right - left) / 2;
            rearrangePositiveNegativeUsingOptimizedMergeSort(array, left, mid);
            rearrangePositiveNegativeUsingOptimizedMergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int p1, p2;
        if (array[left] < 0 && array[right] >= 0) {
        }
        if (array[left] < 0 && array[right] >= 0) {

        }
        if (array[left] < 0 && array[right] >= 0) {

        }
        if (array[left] < 0 && array[right] >= 0) {

        }

    }

    /**
     * only handles cases where size = 2^n
     *
     * @param array
     * @param left
     * @param right O(n log n)
     */
    public static void shuffleArray(int[] array, int left, int right) {
        if (right - left == 1) return;
        int mid = (left + right + 1) / 2;
        int size = (1 - left + right) / 4;
        blockSwap(array, mid - size, mid, size);
        shuffleArray(array, left, mid - 1);
        shuffleArray(array, mid, right);
    }

    /**
     * @param array O(n)
     */
    public static void shuffleArrayNoExtraSpace(int[] array) {
        int half = array.length / 2;
        int temp = array[2]; //holds current data to go to next location
        array[2] = array[1];
        int current = 2;
        int temp1;
        int dest; //destination of current data
        do {
            dest = (current < half) ? 2 * current : 2 * (current - half) + 1;
            temp1 = array[dest];
            array[dest] = temp;
            temp = temp1;
            current = dest;
        } while (current != 1);
        array[current] = temp;
    }

    public static void rearrangeBinaryStringAlternateXYOccurrences(String string, int x, int y) {
        int countX = 0;
        int countY = 0;
        for (int i = 0; i < string.length(); i++) {
            int _s = string.charAt(i) == '0' ? countX++ : countY++;
        }
        while (true) {
            if (countX == 0) {
                while (countY > 0) {
                    System.out.print("1");
                    countY--;
                }
                break;
            } else if (countY == 0) {
                while (countX > 0) {
                    System.out.print("0");
                    countX--;
                }
                break;
            }
            for (int i = 0; i < x && countX > 0; i++, countX--) {
                System.out.print("0");
            }
            for (int i = 0; i < y && countY > 0; i++, countY--) {
                System.out.print("1");
            }
        }
        System.out.println("");
    }

    public static void sortInWaveUsingSortFunction(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i <= array.length - 2; ) {
            blockSwap(array, i, ++i, 1);
            i++;
        }
    }

    public static void sortInWaveEffecient(int[] array) {
        for (int i = 0; i <= array.length - 2; i++) {
            if (i % 2 == 0) {
                if (array[i] < array[i + 1]) {
                    blockSwap(array, i, i + 1, 1);
                }
            } else {
                if (array[i] > array[i + 1]) {
                    blockSwap(array, i, i + 1, 1);
                }
            }
        }
    }

    public static void sortInWaveReverseCondition(int[] array) {
        for (int i = 0; i <= array.length - 2; i++) {
            if (i % 2 == 0) {
                if (array[i] > array[i + 1]) {
                    blockSwap(array, i, i + 1, 1);
                }
            } else {
                if (array[i] < array[i + 1]) {
                    blockSwap(array, i, i + 1, 1);
                }
            }
        }
    }

    public static void positiveEvenNegativeOddPositions(int[] array) {
        int evenCursor = 0;
        int oddCursor = 1;
        while (evenCursor < array.length && oddCursor < array.length) {
            if (array[evenCursor] < 0 && array[oddCursor] > 0) {
                blockSwap(array, evenCursor, oddCursor, 1);
                evenCursor += 2;
                oddCursor += 2;
            } else {
                if (array[evenCursor] > 0) {
                    evenCursor += 2;
                }
                if (array[oddCursor] < 0) {
                    oddCursor += 2;
                }
            }
        }
    }

    public static void negativeAtStartNoOrdering(int[] array) {
        int positiveIndex = 0;
        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            if (array[currentIndex] < 0) {
                blockSwap(array, positiveIndex++, currentIndex, 1);
            }
        }
    }

    public static void smallestLargestPairedOrder(int[] array) {
        Arrays.sort(array);
        int forward = 0;
        int backward = array.length - 1;
        int current = 0;
        int[] tempArray = new int[array.length];
        while (backward > forward) {
            tempArray[current++] = array[forward++];
            tempArray[current++] = array[backward--];
        }
        if (backward == forward) {
            tempArray[current] = array[forward];
        }
        System.arraycopy(tempArray, 0, array, 0, array.length);
    }

    public static void isPossibleDistinctAdjacentElementsArray(int[] array) {
        Hashtable<Integer, Integer> count = new Hashtable<>();
        for (int value : array) {
            if (count.containsKey(value)) {
                count.put(value, count.get(value) + 1);
            } else {
                count.put(value, 1);
            }
        }
        int maxOccurance = 0;
        for (int val : count.values()) {
            maxOccurance = (maxOccurance < val) ? val : maxOccurance;
        }
        boolean isPossible = maxOccurance < (array.length + 1) / 2;
        System.out.println(isPossible);
    }

    public static int maxSumConsecutiveDifferencesCircularArray(int[] array) {
        Arrays.sort(array);
        int sum = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sum += 2 * array[array.length - i - 1];
            sum -= 2 * array[i];
        }
        return sum;
    }

    /**
     * @param array
     */
    public static void largestSmallestPairedOrderConstantExtraSpace(int[] array) {
        int size = array.length;
        int max = array[size - 1] + 1;
        int minIdx = 0, maxIdx = size - 1;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                array[i] = (array[maxIdx--] % max) * max + array[i];
            } else {
                array[i] = (array[minIdx++] % max) * max + array[i];
            }
        }
        for (int i = 0; i < size; i++) {
            array[i] = array[i] / max;
        }
    }

    public static void threeWayPartition(int[] array, int lowVal, int highVal) {
        int left = 0, right = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (i == right) break;
            if (array[i] < lowVal) {
                blockSwap(array, i, left++, 1);
            } else if (array[i] > highVal) {
                blockSwap(array, i--, right--, 1);
            }
        }
    }

    public static void segregatePositiveAndNegative(int[] array) {
        int[] temp = Arrays.copyOf(array, array.length);
        int cursor = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                array[cursor++] = temp[i];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < 0) {
                array[cursor++] = temp[i];
            }
        }
    }

    /**
     * using quick sort partition
     * time O(n)
     * space O(1)
     */
    public static void alternatePositiveaAndNegativeUsingPartition(int[] array) {
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                blockSwap(array, i, left++, 1);
            }
        }
        int posStart = left;
        for (int i = 0; i <= posStart; i += 2) {
            blockSwap(array, i, left++, 1);
            posStart++;
        }
    }
}
