package org.gfg.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class OrderStatistics {
    public static int getKthSmallestNumberUsingSorting(int[] array, int k) {
        Arrays.sort(array);
        return array[k - 1];
    }

    public static int getKthSmallestNumberUsingPartition(int[] array, int start, int end, int k) {
        if (end - start + 1 >= k) {
            int pos = partition(array, start, end);
            if (pos - start == k - 1) {
                return array[pos];
            } else if (pos - start > k - 1) {
                return getKthSmallestNumberUsingPartition(array, start, pos - 1, k);
            } else {
                return getKthSmallestNumberUsingPartition(array, pos + 1, end, k - pos + start - 1);
            }
        }
        return 0;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                ArrayRearrange.swapIndex(array, i, start++);
            }
        }
        ArrayRearrange.swapIndex(array, start, end);
        return start;
    }

    public static int findLargestElement(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static int[] findThreeLargestElement(int[] array) {
        int first, second, third;
        first = second = third = array[0];
        for (int element : array) {
            if (element > first) {
                third = second;
                second = first;
                first = element;
            } else if (element > second) {
                third = second;
                second = element;
            } else if (element > third) {
                third = element;
            }
        }
        return new int[]{first, second, third};
    }

    public static int[] findElementHavingAtLeastTwoGreaterBySorting(int[] array) {
        Arrays.sort(array);
        int[] result = new int[array.length - 2];
        System.arraycopy(array, 0, result, 0, result.length);
        return result;
    }

    public static int[] findElementHavingAtLeastTwoGreaterByFindingSecondMaximum(int[] array) {
        int first, second;
        first = second = array[0];

        for (int element : array) {
            if (element > first) {
                second = first;
                first = element;
            } else if (element > second) {
                second = element;
            }
        }

        int[] result = new int[array.length - 2];
        int resultPos = 0;
        for (int element : array) {
            if (element < second) {
                result[resultPos++] = element;
            }
        }
        return result;
    }

    public static double[] getMeanAndMedian(int[] array) {
        Arrays.sort(array);
        double sum = 0;
        for (int element : array) {
            sum += element;
        }
        double mean = sum / array.length;
        double median;
        if (array.length % 2 == 0) {
            median = (array[array.length / 2] + array[array.length / 2 - 1]) / (double) 2;
        } else {
            median = array[array.length / 2];
        }
        return new double[]{mean, median};
    }

    public static int getMinProductOfKInteger(int[] array, int k) {
        Arrays.sort(array);
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= array[i];
        }
        return result;
    }

    public static int getKthLargestSumContinuousSubarray(int[] array, int k) {
        //convert to cumulative sum
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        PriorityQueue<Integer> sums = new PriorityQueue<>();
        int tmpSum = 0;
        // for seq starting at 0 exclusive, we need arr[-1]=0
        for (int i = 0; i < array.length; i++) {
            tmpSum = array[i];
            if (sums.size() < k) {
                sums.add(tmpSum);
            } else if (sums.peek() < tmpSum) {
                sums.poll();
                sums.add(tmpSum);
            }
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                tmpSum = array[j] - array[i - 1];
                if (sums.size() < k) {
                    sums.add(tmpSum);
                } else if (sums.peek() < tmpSum) {
                    sums.poll();
                    sums.add(tmpSum);
                }
            }
        }
        return sums.peek();
    }
}
