package gfg.array;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Simple {
    public static void main(String[] args) {
        printMethodName("countRotationDivBy8");
        System.out.println(countRotationDivBy8("43262488612"));
        printMethodSeparator();
        printMethodName("rotateMatrixBy180");
        int mat[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        rotateMatrixBy180(mat);
        printMethodSeparator();
        printMethodName("rotateMatrixBy180UsingTranspose");
        int mat1[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatrixBy180UsingTranspose(mat1);
        printMethodSeparator();
        printMethodName("printLeftRotateByN");
        int[] arr = {1, 3, 5, 7, 9};
        printLeftRotateByN(arr, 2);
        printLeftRotateByN(arr, 3);
        printLeftRotateByN(arr, 4);
        printMethodSeparator();
        printMethodName("blockSwapForRotation");
        int arr2[] = {1, 2, 3, 4, 5, 6, 7};
        blockSwapForRotation(arr2, 2);
        System.out.println(Arrays.toString(arr2));
        printMethodSeparator();
        printMethodName("blockSwapForRotationIterative");
        int arr3[] = {1, 2, 3, 4, 5, 6, 7};
        blockSwapForRotationIterative(arr3, 3);
        System.out.println(Arrays.toString(arr3));
        printMethodSeparator();
        printMethodName("pivotedBinarySearch");
        int arr4[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int result = pivotedBinarySearch(arr4, 3);
        System.out.println(result);
        printMethodSeparator();
    }

    public static int countRotationDivBy8(String string) {
        final int length = string.length();
        int count = 0;
        string += string.substring(0, 2);
        for (int i = 0; i < length; i++) {
            if (Integer.valueOf(string.substring(i, i + 3)) % 8 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void rotateMatrixBy180(int[][] matrix) {
        final int rows = matrix.length;
        final int cols = matrix[0].length;
        for (int i = rows - 1; i > -1; i--) {
            for (int j = cols - 1; j > -1; j--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static void invertRows(int[][] matrix) {
        int temp;
        for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
            for (int k = 0; k < matrix[0].length; k++) {
                temp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = temp;
            }
        }
    }

    public static void rotateMatrixBy180UsingTranspose(int[][] matrix) {
        matrix = transpose(matrix);
        invertRows(matrix);
        matrix = transpose(matrix);
        invertRows(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void printLeftRotateByN(int[] array, int rotation) {
        rotation %= array.length;
        for (int i = rotation; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        for (int i = 0; i < rotation; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println();
    }

    public static void blockSwapForRotation(int[] array, int positions) {
        blockSwapForRotation(array, positions, 0, array.length);
    }

    private static void blockSwapForRotation(int[] array, int positions, int blockStart, int blockSize) {
        if (blockSize == 0) {
            return;
        }
        if (blockSize == positions) {
            return;
        }
        if (positions == blockSize - positions) {
            blockSwap(array, blockStart, blockStart + positions, positions);
            return;
        }
        if (positions < blockSize - positions) {
            blockSwap(array, blockStart, blockStart + blockSize - positions, positions);
            blockSwapForRotation(array, positions, blockStart, blockSize - positions);
        } else {
            blockSwap(array, blockStart, blockStart + positions, blockSize - positions);
            blockSwapForRotation(array, positions, blockStart + blockSize - positions, positions - blockStart);
        }
    }

    public static void blockSwap(int[] array, int first, int second, int length) {
        int temp = 0;
        for (int i = 0; i < length; i++) {
            temp = array[first + i];
            array[first + i] = array[second + i];
            array[second + i] = temp;
        }
    }

    public static void blockSwapForRotationIterative(int[] array, int positions) {
        int blockStart;
        int blockEnd;
        if (positions == 0 || positions == array.length) {
            return;
        }
        blockStart = positions;
        blockEnd = array.length - positions;
        while (blockStart != blockEnd) {
            if (blockStart < blockEnd) {
                blockSwap(array, positions - blockStart, positions - blockStart + blockEnd, blockStart);
                blockEnd -= blockStart;
            } else {
                blockSwap(array, positions - blockStart, blockEnd, blockEnd);
                blockStart -= blockEnd;
            }
        }
    }

    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low == high) {
            if (arr[low] == key) return low;
            else return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (key < arr[mid]) {
            return binarySearch(arr, low, mid - 1, key);
        } else {
            return binarySearch(arr, mid + 1, high, key);
        }
    }

    public static int findPivot(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        if (high == low) return low;

        int mid = (low + high) / 2;

        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }
        if (arr[low] >= arr[mid]) {
            return findPivot(arr, low, mid - 1);
        }
        return findPivot(arr, mid + 1, high);
    }

    public static int pivotedBinarySearch(int[] arr, int key) {
        int pivot = findPivot(arr, 0, arr.length);
        if (pivot == -1) {
            return binarySearch(arr, 0, arr.length, key);
        }
        if (arr[pivot] == key) {
            return pivot;
        }
        if (arr[0] <= key) {
            return binarySearch(arr, 0, pivot - 1, key);
        }
        return binarySearch(arr, pivot + 1, arr.length, key);
    }

    public static void printMethodSeparator() {
        System.out.println("====================================");
    }

    public static void printMethodName(String name) {
        System.out.println("=====" + name + "=====");
    }
}
