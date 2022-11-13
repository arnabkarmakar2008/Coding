package com.example.coding.matrix.leetcode.medium;

/**
 * Given an m x n integer matrix, if an element is 0,
 * set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 */
public class SetMatrxiZero {

    /**
     * https://www.youtube.com/watch?v=T41rL0L3Pnw
     *
     * Maintain rowMatrix and colMatrix.
     *
     * So for m*n matrix create rowMatrix[m] and colMatrix[n].
     *
     * If mat[i][j] == 0 then rowMatrix[i] = zero and colMatrix[j] = 0;
     * Iterate through all the elements and fill arrays.
     *
     * Now traverse through colMatrix and if col value is zero then set zero in matrix for that col
     * Now traverse through rowMatrix and if row value is zero the set zero in matrix for that row.
     *
     * But here space complexity is O(m+n)
     *
     * We can sase space by treating 0th row as col matrix and 0th col as row matrix.
     * But we will have overlap for position 0,0. So for colMatrix we will take extra variable
     *
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int zeroRowVal = -1;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                int val = matrix[i][j];

                if (val == 0) {
                    matrix[0][j] = 0;

                    if (i == 0) {
                        zeroRowVal = 0;
                    } else {
                        matrix[i][0] = 0;
                    }
                }
            }
        }

        for (int i=1; i< matrix.length; i++) {
            for (int j = 1; j<matrix[0].length; j++) {
                if (matrix[0][j] ==0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //Now we have to handle first row and col.
        if (matrix[0][0] == 0) {
            for (int j=0; j< matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (zeroRowVal == 0) {
            for (int i=0; i< matrix[0].length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
