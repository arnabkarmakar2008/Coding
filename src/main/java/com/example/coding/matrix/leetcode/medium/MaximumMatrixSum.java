package com.example.coding.matrix.leetcode.medium;

/**
 * You are given an n x n integer matrix. You can do the following operation any number of times:
 *
 * Choose any two adjacent elements of matrix and multiply each of them by -1.
 * Two elements are considered adjacent if and only if they share a border.
 *
 * Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.
 */
public class MaximumMatrixSum {

  public static long maxMatrixSum(int[][] matrix) {
    /*
    Recognize that if there is an even amount of negative numbers, you can eliminate all the negatives signs in the following fashion:

    If there is a pair of adjacent negative numbers, just remove both negative signs
    If the remaining negative numbers are separated from each other, just swap their negative signs with the adjacent positive number until they are adjacent to each other, and then you can remove 2 negative signs at a time
    If there is an odd amount of negative sign, there will be a negative sign in the end, and we can move that negative sign to the smallest number in the matrix (by swapping as above)

    So, if the number of negative signs is even, the answer is the sum of the absolute value of all elements. If it is odd, we will have to minus 2 times the number with smallest absolute value (for we have to change + sign to -) to get the answer:
         */
    int min = Integer.MAX_VALUE;
    int negativeCount = 0;
    int sum = 0;
    for (int i=0; i< matrix.length; i++) {
      for (int j=0; j<matrix[0].length; j++) {
        sum+= Math.abs(matrix[i][j]); // If there are even -ve numbers, then can be turned into all +ve
        //by the operation and max will be sum of all elements. If there are odd number of -ve,
        //then at the end there will always be a single -ve entry and smallest element can be made -ve.

        if (matrix[i][j] < 0 ) {
          negativeCount++;
        }

        min = Math.min(min, Math.abs(matrix[i][j]));
      }

    }

    if (negativeCount%2 == 0) {
      return sum;
    } else {
      return sum - 2*min; // While doing sum we have included min element. So doing 2*min
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
    System.out.println(maxMatrixSum(matrix));
  }
}
