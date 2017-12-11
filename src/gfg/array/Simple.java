package gfg.array;

import java.util.Arrays;

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

    private static void printMethodSeparator() {
        System.out.println("====================================");
    }

    private static void printMethodName(String name) {
        System.out.println("=====" + name + "=====");
    }
}
