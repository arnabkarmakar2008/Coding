package com.example.coding.math.leetcode.medium;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner
 * (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can
 * take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    matrix[i][j] = 1;
                }

                if (j == 0) {
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }

        return matrix[m-1][n-1];
    }

    public static void main(String[] args) {
        int row = 3;
        int col = 7;
        System.out.println(uniquePaths(row, col));
    }
}
