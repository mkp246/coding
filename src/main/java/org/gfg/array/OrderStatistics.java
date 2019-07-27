package org.gfg.array;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
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

    public static int[] getKMaxSumCombinationTwoArrays(int[] array1, int[] array2, int k) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> maxHeap = new PriorityQueue<>(Comparator.comparing(Pair::getKey, Comparator.reverseOrder()));
        HashSet<Pair<Integer, Integer>> pairs = new HashSet<>();

        maxHeap.add(new Pair<>(array1[array1.length - 1] + array2[array2.length - 1], new Pair<>(array1.length - 1, array2.length - 1)));
        pairs.add(new Pair<>(array1.length - 1, array2.length - 1));

        int[] result = new int[k];
        int resultPos = 0;
        Pair<Integer, Integer> tmpPair;
        for (int i = 0; i < k; i++) {
            Pair<Integer, Pair<Integer, Integer>> poll = maxHeap.poll();
            result[resultPos++] = poll.getKey();

            if (poll.getValue().getKey() > 0) {
                tmpPair = new Pair<>(poll.getValue().getKey() - 1, poll.getValue().getValue());
                if (!pairs.contains(tmpPair)) {
                    maxHeap.add(new Pair<>(array1[tmpPair.getKey()] + array2[tmpPair.getValue()], tmpPair));
                    pairs.add(tmpPair);
                }
            }

            if (poll.getValue().getValue() > 0) {
                tmpPair = new Pair<>(poll.getValue().getKey(), poll.getValue().getValue() - 1);
                if (!pairs.contains(tmpPair)) {
                    maxHeap.add(new Pair<>(array1[tmpPair.getKey()] + array2[tmpPair.getValue()], tmpPair));
                    pairs.add(tmpPair);
                }
            }
        }
        return result;
    }

    public static int maxSubArraySumUsingPrefixSum(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        int minPrefixSum = 0;
        int maxSubArraySum = Integer.MIN_VALUE;
        int tmp;
        for (int i = 0; i < array.length; i++) {
            tmp = array[i] - minPrefixSum;
            if (tmp > maxSubArraySum) {
                maxSubArraySum = tmp;
            }
            if (array[i] < minPrefixSum) {
                minPrefixSum = array[i];
            }
        }
        return maxSubArraySum;
    }

    public static int[] kMaxSubArraySumUsingPrefixSum(int[] array, int k) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        PriorityQueue<Integer> maxI = new PriorityQueue<>();
        int[] minI = new int[k];

        minI[0] = 0;
        int minIPos = 0;// max filled index in minI < k

        int tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= minIPos; j++) {
                tmp = array[i] - minI[j];
                if (maxI.size() < k) {
                    maxI.add(tmp);
                } else if (maxI.peek() < tmp) {
                    maxI.poll();
                    maxI.add(tmp);
                } else {
                    continue; // all subsequent diffs will be lower only
                }
            }
            if (minIPos < k - 1 || array[i] < minI[minIPos]) {
                int j = 0;
                while (array[i] > minI[j] && j <= minIPos) {
                    j++;
                }

                for (int l = k - 1; l > j; l--) {
                    minI[l] = minI[l - 1];
                }
                minI[j] = array[i];
                if (minIPos < k - 1) {
                    minIPos++;
                }
            }
        }

        int[] result = new int[k];
        int resultPos = k - 1;
        while (!maxI.isEmpty()) {
            result[resultPos--] = maxI.poll();//min heap, smallest first
        }
        return result;
    }

    public static int[][] kMaxSubArraySumNonOverlappingUsingKadane(int[] array, int k) {
        int[][] result = new int[k][];
        int resultPos = 0;
        int[] kadaneResult;
        for (int i = 0; i < k; i++) {
            kadaneResult = ArrayRearrange.findLargestSumContinuousSubarray(array);
            result[resultPos++] = kadaneResult;
            for (int j = kadaneResult[0]; j <= kadaneResult[1]; j++) {
                array[j] = Integer.MIN_VALUE;
            }
        }
        return result;
    }
}
