package com.example.coding.matrix.hard;

/**
 * Given an m x n matrix matrix and an integer k, return the max sum of a rectangle
 * in the matrix such that its sum is no larger than k.
 *
 * It is guaranteed that there will be a rectangle with a sum no larger than k.
 *
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2,
 * and 2 is the max number no larger than k (k = 2).
 *
 */
public class MaxSumOfRectangleNoLargerThanK {

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1},{0,-2,3}};
        System.out.println(maxSumSubmatrix(matrix, 2));
    }
}
