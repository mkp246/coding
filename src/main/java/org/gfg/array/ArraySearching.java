package org.gfg.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraySearching {

    public static int searchInUnsortedArray(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1; // key not found in array 
    }

    public static void insertInEndOfArray(int[] array, int key, int total, int capacity) {
        if (total >= capacity) {
            throw new UnsupportedOperationException();
        }
        array[total] = key;
    }

    public static int deleteElementOfArray(int[] array, int key, int length) {
        boolean found = false;
        for (int i = 0; i < length; i++) {
            if (!found) {
                if (array[i] == key) {
                    found = true;
                }
            } else {
                array[i - 1] = array[i];
            }
        }
        return found ? length - 1 : length;
    }

    public static int binarySearchInSortedArray(int[] array, int start, int end, int key) {
        if (start <= end) {
            int mid = Util.getMid(start, end);
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                return binarySearchInSortedArray(array, start, mid - 1, key);
            } else {
                return binarySearchInSortedArray(array, mid + 1, end, key);
            }
        } else {
            return -1;
        }
    }

    public static int searchInArrayWhereAdjacentDifferenceIsOne(int[] array, int key) {
        int i = 0;
        while (i < array.length) {
            if (array[i] == key) {
                return i;
            } else {
                i += Math.abs(array[i] - key);
            }
        }
        return -1;
    }

    public static int searchInArrayWhereAdjacentDifferenceIsAtMostK(int[] array, int key, int maxDiff) {
        int i = 0;
        while (i < array.length) {
            if (array[i] == key) {
                return i;
            } else {
                i += Math.ceil(Math.abs(array[i] - key) / (double) maxDiff);
            }
        }
        return -1;
    }

    public static int[] findCommonInThreeSortedArray(int[] array1, int[] array2, int[] array3) {
        int len1 = array1.length;
        int len2 = array2.length;
        int len3 = array3.length;
        int pos1, pos2, pos3;
        pos1 = pos2 = pos3 = 0;
        List<Integer> result = new ArrayList<>();

        while (pos1 < len1 && pos2 < len2 && pos3 < len3) {
            if (array1[pos1] == array2[pos2]) {
                while (array3[pos3] < array1[pos1]) {
                    pos3++;
                }
                if (array3[pos3] == array1[pos1]) {
                    result.add(array1[pos1]);
                    pos3++;
                }
                pos1++;
                pos2++;
            } else if (array1[pos1] > array2[pos2]) {
                pos2++;
            } else {
                pos1++;
            }
        }
        return Occurance.intListToArray(result);
    }

    public static int findElementInInfiniteSortedArray(int[] array, int key) {
        int start = 0;
        int end = 1;
        while (end < array.length) {
            if (key <= array[end]) {
                return binarySearchInSortedArray(array, start, end, key);
            } else {
                start = end + 1;
                end *= 2;
                end = Math.min(end, array.length - 1);
            }
        }
        return -1;
    }

    public static int findOnlyRepetitiveElementInUnsortedArray1ToNMinus1UsingSumFormula(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int max = array.length - 1;
        int sum1ToNMinus1 = max * (max + 1) / 2;
        return sum - sum1ToNMinus1;
    }

    public static int findOnlyRepetitiveElementInUnsortedArray1ToNMinus1UsingHashing(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int element : array) {
            if (set.contains(element)) {
                return element;
            } else {
                set.add(element);
            }
        }
        return -1;
    }

    public static int testFindOnlyRepetitiveElementInUnsortedArray1ToNUsingXor(int[] array) {
        int xor = 0;
        for (int element : array) {
            xor ^= element;
        }
        int max = array.length - 1;
        int xor1TONMinus1 = xorTillX(max);
        return xor ^ xor1TONMinus1;
    }

    /**
     * xor from 0 ... number inclusive
     * using the property set of 4 consecutive number xored = 0 if first is divisible by 4
     *
     * @param number
     * @return
     */
    public static int xorTillX(int number) {
        int elementToXor = (number + 1) % 4;
        int xor = 0;
        for (int i = 0; i < elementToXor; i++) {
            xor ^= number--;
        }
        return xor;
    }

    public static int findElementAppearingOnceWhereOtherAppearTwiceUsingXor(int[] array) {
        int result = 0;
        for (int element : array) {
            result ^= element;
        }
        return result;
    }

    public static int maxSubarraySumExcludingCertainElement(int[] array, int[] exclude) {
        Arrays.sort(exclude);
        int maxSum = 0;
        int maxSumSoFar = 0;
        for (int i = 0; i < array.length; i++) {
            maxSumSoFar += array[i];
            if (binarySearchInSortedArray(exclude, 0, exclude.length - 1, array[i]) != -1) {
                maxSumSoFar = 0;
            } else if (maxSumSoFar < 0) {
                maxSumSoFar = 0;
            } else if (maxSumSoFar > maxSum) {
                maxSum = maxSumSoFar;
            }
        }
        return maxSum;
    }

    public static int findMaxEquilibriumSum(int[] array) {
        int length = array.length;

        int[] suffixSum = new int[length];
        suffixSum[length - 1] = array[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + array[i];
        }
        // convert array to prefix sum
        for (int i = 1; i < length; i++) {
            array[i] += array[i - 1];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (array[i] == suffixSum[i]) {
                if (array[i] > maxSum) {
                    maxSum = array[i];
                }
            }
        }
        return maxSum;
    }

    public static int findMaxEquilibriumSumWithConstantExtraSpace(int[] array) {
        return findMaxEquilibriumSumAndIdxWithConstantExtraSpace(array)[1];
    }

    /**
     * @param array
     * @return index, value as array
     */
    public static int[] findMaxEquilibriumSumAndIdxWithConstantExtraSpace(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }

        int maxSum = 0;
        int maxIdx = -1;
        int prefixSum = 0;
        int suffixSum;
        for (int i = 0; i < array.length; i++) {
            suffixSum = sum - prefixSum;
            prefixSum += array[i];
            if (prefixSum == suffixSum && prefixSum > maxSum) {
                maxSum = prefixSum;
                maxIdx = i;
            }
        }
        return new int[]{maxIdx, maxSum};
    }

    public static int findMaxEquilibriumIndexWithConstantExtraSpace(int[] array) {
        return findMaxEquilibriumSumAndIdxWithConstantExtraSpace(array)[0];
    }

    public static int[] findLeaders(int[] array) {
        int maxSoFar = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > maxSoFar) {
                maxSoFar = array[i];
                result.add(maxSoFar);
            }
        }
        return Occurance.intListToArray(result);
    }

    public static int findCeilingIndexInSortedArray(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] >= key) {
                return left;
            } else if (array[right] < key) {
                return -1;
            } else {
                int mid = Util.getMid(left, right);
                if (array[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

    /**
     * return majority ele with count more than length/2, else returns -1
     * using moore's voting algorithm
     *
     * @param array
     * @return
     */
    public static int findMajorityElementInArray(int[] array) {
        int maxElement = array[0];
        int maxCount = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == maxElement) {
                maxCount++;
            } else {
                if (maxCount == 0) {
                    maxElement = array[i];
                    maxCount++;
                } else {
                    maxCount--;
                }
            }
        }
        int count = 0;
        for (int element : array) {
            if (element == maxElement) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return maxElement;
        } else {
            return -1;
        }
    }

    public static boolean checkForMajorityOfElementInSortedArray(int[] array, int key) {
        int idx = findFirstIndexInSortedArray(array, key);
        if (idx == -1) {
            return false;
        } else if (array[idx] == array[idx + array.length / 2]) {
            return true;
        } else {
            return false;
        }
    }

    public static int findFirstIndexInSortedArray(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = Util.getMid(left, right);
            if (array[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (array[left] == key) {
            return left;
        } else {
            return -1;
        }
    }

    public static int findAPeakIndexInArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = Util.getMid(start, end);
            if (mid == 0) {
                end = 0;
                continue;
            }

            if (array[mid - 1] <= array[mid] && array[mid] >= array[mid + 1]) {
                return mid;
            } else if (array[mid - 1] > array[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if ((start == 0 && array[start] >= array[start + 1]) || (start == array.length - 1 && array[start - 1] <= array[start])) {
            return start;
        }
        return -1;
    }

    public static int[] findTwoNonRepeatingElementInArray(int[] array) {
        int xor = 0;
        for (int element : array) {
            xor ^= element;
        }
        int lastBitSet = xor & -xor;
        int x = 0; // last set bit same as xor last set bit
        int y = 0; // last set bit opposite of xor last set bit
        for (int element : array) {
            if ((element & lastBitSet) != 0) {
                x ^= element;
            } else {
                y ^= element;
            }
        }
        return new int[]{x, y};
    }

    public static int[] findTwoOddOccuranceElementInUnsortedArray(int[] array) {
        return findTwoNonRepeatingElementInArray(array);
    }

    public static int[] findTwoRepeatingElementInUnsortedArray(int[] array) {
        int max = array.length - 2;
        int xor1ToN = xorTillX(max);
        int xorAll = 0;
        for (int element : array) {
            xorAll ^= element;
        }
        int xXorY = xorAll ^ xor1ToN;
        int lastBitSet = xXorY & -xXorY;
        int x = 0;  //last set bit same as xor
        int y = 0;

        for (int element : array) {
            if ((element & lastBitSet) != 0) {
                x ^= element;
            } else {
                y ^= element;
            }
        }

        for (int i = 1; i <= max; i++) {
            if ((i & lastBitSet) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        return new int[]{x, y};
    }
}
