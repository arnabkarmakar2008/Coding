package com.example.coding.prefixsum.leetcode.medium;

public class RangeSumQuery2D {

    public static void main(String[] args) {

    }
}

class NumMatrix {

    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;;
        int col = matrix[0].length;
        sumMatrix = new int[row+1][col+1];


        /**
         * sumRange(r1,c1, r2, c2) =
         * sum(r2,c2) - sum(r1-1,c2) - sum(r2, c1-1) + sum(r1-1, c1-1)
         */

        //We are taking sum matrix bigger just to avoid out of bound cases
        for (int i = 1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1] + matrix[i-1][j-1];

                //sumMatrix[i-1][j-1] :: We are adding this value twice. So just reducing it.
                //matrix[i-1][j-1] :: Because sumMatrix is bigger. So to map index we have to take i-1 and j-1
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2][col2] - sumMatrix[row2][col1-1] - sumMatrix[row1-1][col2] + sumMatrix[row1-1][col1-1];
    }
}
