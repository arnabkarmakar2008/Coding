package com.example.coding.math.leetcode.medium;

/**
 * You are given an n x n 2D matrix representing an image,
 * rotate the image by 90 degrees (clockwise).
 */
public class RotateImage {

    public static void rotateMatrixClockWise(int[][] matrix) {
        transpose(matrix);
        reverseRow(matrix);
    }

    public static void rotateMatrixAntiClockWise(int[][] matrix) {
        transpose(matrix);
        reverseColumn(matrix);
    }

    private static void transpose(int[][] matrix) {
        int len = matrix.length;
        for (int row = 0; row < len; row++) {
            for (int col = row; col < len; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }

    private static void reverseColumn(int[][] matrix) {
        int len = matrix.length;
        for (int col = 0; col < len; col++) {
            for (int row = 0, k = len-1; row < k; row++, k--) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[k][col];
                matrix[k][col] = temp;
            }
        }
    }

    private static void reverseRow(int[][] matrix) {
        int len = matrix.length;
        for (int row = 0; row < len; row++) {
            for (int col = 0, k = len-1; col < k; col++, k--) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][k];
                matrix[row][k] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //Rotate matrix 90 degree anti-clock wise
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        //rotateMatrixClockWise(mat);
        rotateMatrixAntiClockWise(mat);

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(" " + mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
