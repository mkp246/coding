package gfg.array;

import java.util.Arrays;
import java.util.PriorityQueue;

import static gfg.array.Simple.printMethodSeparator;
import static gfg.array.Simple.printMethodName;
import static gfg.array.Simple.blockSwap;

public class OrderStats {
    public static void main(String[] args) {
        printMethodName("findLargest");
        int[] arr1 = {10, 324, 45, 90, 9808};
        System.out.println(findLargest(arr1));
        printMethodSeparator();
        printMethodName("minNumberToAddToMakeMedian");
        int[] arr2 = {10, 20, 30};
        System.out.println(minNumberToAddToMakeMedian(arr2, 10));
        printMethodSeparator();
        printMethodName("kthSmallest");
        int arr3[] = {10, 4, 5, 8, 6, 11, 26};
        System.out.println(kthSmallest(arr3, 0, arr3.length - 1, 3));
        printMethodSeparator();
        printMethodName("findMeanOfMatrix");
        int matrix1[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        System.out.println(findMeanOfMatrix(matrix1));
        System.out.println(findMedianOfMatrix(matrix1));
        printMethodSeparator();
        printMethodName("minProductPositiveArray");
        int[] arr4 = {198, 76, 544, 123, 154, 675};
        System.out.println(minProductPositiveArray(arr4, 2));
        printMethodSeparator();
        printMethodName("kthLargestSumSubArray");
        int[] arr5 = {10, -10, 20, -40};
        System.out.println(kthLargestSumSubArray(arr5, 6));
        printMethodSeparator();
        printMethodName("maxDiffkLength");
        int[] arr6 = {1, 7, 4, 8, -1, 5, 2, 1};
        System.out.println(maxDiffkLength(arr6, 3));
        printMethodSeparator();
    }

    public static int findLargest(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int val : array) {
            if (val > max) max = val;
        }
        return max;
    }

    public static int minNumberToAddToMakeMedian(int[] array, int median) {
        int l = 0, h = 0, e = 0;
        for (int val : array) {
            if (val < median) l++;
            else if (val == median) e++;
            else h++;
        }
        if (l > h) return l - h - e + 1;
        else return h - l - e;
    }

    /**
     * std quick sort partition uses last element as pivot
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partitionQuickSort(int[] array, int left, int right) {
        int pivot = array[right];
        int cursor = left;
        int i;
        for (i = left; i <= right - 1; i++) {
            if (array[i] <= pivot) {
                blockSwap(array, cursor++, i, 1);
            }
        }
        blockSwap(array, cursor, i, 1);
        return cursor;
    }

    public static int kthSmallest(int[] array, int left, int right, int k) {
        //check if invalid k
        if (k < 0 || k > right - left + 1) return Integer.MAX_VALUE;
        else {
            int index = partitionQuickSort(array, left, right);
            if (index - left == k - 1) return array[index];
            if (index - left > k - 1) return kthSmallest(array, left, index - 1, k);
            else return kthSmallest(array, index + 1, right, k);
        }
    }

    public static double findMedianOfMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n % 2 == 1) {
            return matrix[n / 2][n / 2];
        } else {
            return (double) (matrix[n / 2 - 1][n - 1] + matrix[n / 2][0]) / 2;
        }
    }

    public static double findMeanOfMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum / (double) (matrix.length * matrix.length);
    }

    public static int minProductPositiveArray(int[] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int val : array) {
            queue.add(val);
        }
        int i = 0;
        int product = 1;
        while (i < k) {
            product *= queue.remove();
            i++;
        }
        return product;
    }

    public static int kthLargestSumSubArray(int[] array, int k) {
        int[] sum = new int[array.length + 1];
        sum[0] = 0;
        for (int i = 0; i < array.length; i++) {
            sum[i + 1] += sum[i] + array[i];
        }
        PriorityQueue<Integer> quene = new PriorityQueue<>();
        int sumDelta = 0;
        for (int i = 1; i <= array.length; i++) {
            for (int j = i; j <= array.length; j++) {
                sumDelta = sum[j] - sum[i - 1];
                if (quene.size() < k) quene.add(sumDelta);
                else if (quene.peek() < sumDelta) {
                    quene.poll();
                    quene.add(sumDelta);
                }
            }
        }
        return quene.peek();
    }

    public static int maxDiffkLength(int[] array, int k) {
        Arrays.sort(array);
        int sum = 0;
        for (int val : array) {
            sum += val;
        }
        int diff1 = 0, diff2 = 0;
        for (int i = 0; i < k; i++) {
            diff1 += array[i];
            diff2 += array[array.length - 1];
        }
        return sum - 2 * ((diff1 > diff2) ? diff2 : diff1);
    }


}