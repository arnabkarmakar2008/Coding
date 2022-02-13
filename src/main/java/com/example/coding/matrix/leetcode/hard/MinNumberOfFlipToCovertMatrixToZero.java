package com.example.coding.matrix.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a m x n binary matrix mat. In one step, you can choose one cell and flip it
 * and all the four neighbors of it if they exist (Flip is changing 1 to 0 and 0 to 1).
 * A pair of cells are called neighbors if they share one edge.
 *
 * Return the minimum number of steps required to convert mat to a zero matrix or -1 if you cannot.
 *
 * A binary matrix is a matrix with all cells equal to 0 or 1 only.
 *
 * A zero matrix is a matrix with all cells equal to 0.
 */
public class MinNumberOfFlipToCovertMatrixToZero {


  /**
   * Note :: Think of this as level order traversal of a tree. Initial matrix is a root.
   * Children are all possibilities with flipped values of the root. Then same for the children of children
   * (eliminating the duplicate states). You either find a level at which one of the children is zero matrix or run out
   * of possible states.
   * @param mat
   * @return
   */
  private static String serializeMatrix(int[][] mat) {
    String str = "";
    for (int i=0; i< mat.length; i++) {
      for (int j=0; j< mat[0].length; j++) {
        str = str + "" + mat[i][j];
      }
      str = str + "#";
    }

    return str;
  }

  private static boolean isZeroMatrix(int[][] mat) {
    for (int i=0; i< mat.length; i++) {
      for (int j=0; j< mat[0].length; j++) {
        if (mat[i][j] != 0) {
          return false;
        }
      }
    }

    return true;
  }

  private static void bfs (int[][] matrix, Map<String, Boolean> visitedMap, Queue<int[][]> queue) {
    int[][] tempMatrix = matrix;

    //Have to flip cell one by one. And if it is not there in map then store in map and queue.
    // This way we will avoid storing/vistig duplicate state.

    for (int i=0; i< matrix.length; i++) {
      for (int j=0; j<matrix[0].length; j++) {
        tempMatrix[i][j] = tempMatrix[i][j]^1;

        if (i+1 < matrix.length) tempMatrix[i+1][j] = tempMatrix[i+1][j]^1;
        if (j+1 < matrix[0].length) tempMatrix[i][j+1] = tempMatrix[i][j+1]^1;
        if (i-1 >= 0) tempMatrix[i-1][j] = tempMatrix[i-1][j]^1;
        if (j-1 >= 0) tempMatrix[i][j-1] = tempMatrix[i][j-1]^1;

        String serString = serializeMatrix(tempMatrix);

        if (!visitedMap.containsKey(serString)) {
          visitedMap.put(serString, true);
          queue.add(tempMatrix);
        }

      }
    }
  }


  public static int minFlips(int[][] mat) {
    int rows = mat.length;
    int cols = mat[0].length;

    Queue<int[][]> queue = new LinkedList<>();
    Map<String, Boolean> visitedMap = new HashMap<>();

    queue.add(mat); // Add original matrix. As this will be treated as root.
    visitedMap.put(serializeMatrix(mat), true);

    int level = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size >0) {
        int[][] topMatrix = queue.remove();

        if (isZeroMatrix(mat)) {
          return level;
        }

        // Add all neighbour matrix
        bfs(topMatrix, visitedMap, queue);

        size--;
      }

      level++; // Level will indicate number of flips.
    }

    return -1;

  }

  public static void main(String[] args) {
    int[][] mat = {{0,0},{0,1}};
    System.out.println(minFlips(mat));
  }
}
