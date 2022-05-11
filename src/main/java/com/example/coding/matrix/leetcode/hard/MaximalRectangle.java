package com.example.coding.matrix.leetcode.hard;

import javafx.util.Pair;

import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=dAVF2NpC3j4
 * Given a rows x cols binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area.
 */
public class MaximalRectangle {

  /**
   * Note: This problem is not same as maximal square. This is mostly similar as maximum histogram area.
   * We have to calculate max area row wise.
   * 1 0 1 0 0
   * 1 0 1 1 1
   * 1 1 1 1 1
   * 1 0 0 1 0
   *
   * Row 1 : 1 0 1 0 0
   * Row2  : 2 0 2 1 1 (We have set 0 if base is 0)
   * Row3  : 3 1 3 2 2
   * Row4  : 4 0 0 3 0
   * We have to calculate max area histogram for each row.
   *
   * @param matrix
   * @return
   */
  public static int maximalRectangle(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    int[] arr = new int[cols];

    int maxArea = Integer.MIN_VALUE;

    for (int i=0; i<rows; i++) {
      for (int j=0; j< cols; j++) {
        arr[j] = matrix[i][j] == 1 ? arr[j]+1 : 0;
      }

      int maxRowArea = maxHistogramArea(arr);
      maxArea = Math.max(maxArea, maxRowArea);
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
    System.out.println(maximalRectangle(matrix));
  }

  public static int maxHistogramArea(int[] array) {
    int[] leftArray = new int[array.length];
    int[] rightArray = new int[array.length];

    Stack<Pair<Integer, Integer>> stack = new Stack();

    //Smaller index to left
    for (int i = 0; i < array.length; i++) {
      if (stack.empty()) {
        leftArray[i] = 0; // There is no element in left. So we have to include till 0 index
      } else {
        while (!stack.empty() && stack.peek().getValue() >= array[i]) {
          stack.pop();
        }

        if (stack.empty()) {
          leftArray[i] = 0; // There is no element in left. So we have to include till 0 index
        } else {
          leftArray[i] = stack.peek().getKey() + 1;
        }
      }

      stack.push(new Pair(i, array[i]));

    }

    stack.clear();

    //Smaller index to right
    for (int i = array.length - 1; i >= 0; i--) {
      if (stack.empty()) {
        rightArray[i] = array.length - 1; // There is no smaller element in right. So we have to include till last index
      } else {
        while (!stack.empty() && stack.peek().getValue() >= array[i]) {
          stack.pop();
        }

        if (stack.empty()) {
          rightArray[i] = array.length - 1; // There is no smaller element in right. So we have to include till last index
        } else {
          rightArray[i] = stack.peek().getKey() - 1;
        }
      }

      stack.push(new Pair(i, array[i]));

    }

    // Calculate area
    //Formula = array[i] * (rightArray[i] - leftArray[i] + 1)
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
      maxArea = Math.max(maxArea, ((rightArray[i] - leftArray[i] + 1) * array[i]));
    }

    return maxArea;

  }
}
