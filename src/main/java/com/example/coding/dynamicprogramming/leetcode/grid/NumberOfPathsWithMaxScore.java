package com.example.coding.dynamicprogramming.leetcode.grid;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a square board of characters. You can move on the board starting at
 * the bottom right square marked with the character 'S'.
 *
 * You need to reach the top left square marked with the character 'E'. The rest of the squares are
 * labeled either with a numeric character 1, 2, ..., 9 or with an obstacle 'X'. In one move you can go up,
 * left or up-left (diagonally) only if there is no obstacle there.
 *
 * Return a list of two integers: the first integer is the maximum sum of numeric characters you can collect,
 * and the second is the number of such paths that you can take to get that maximum sum, taken modulo 10^9 + 7.
 *
 * In case there is no path, return [0, 0]
 */
public class NumberOfPathsWithMaxScore {

  /**
   * Base cases : When we reach end, currentMaxSum = 0 and currentPathCount = 1
   * At start position, currentMaxSum = 0 and currentPathCount = 0
   * At obstacle : currentMaxSum = 0 and currentPathCount = 0
   * Choices : We can go 1> Left 2> Up 3> Up-Left
   * @param board
   * @return
   */

  public static int[] pathsWithMaxScore(List<String> board) {
    int size = board.size();

    int[][] sumDp = new int[size+1][size+1];
    int[][] countDp = new int[size+1][size+1];

    String firstRow = board.get(0).replace('E', '0');
    board.remove(0);
    board.add(0, firstRow);

    String lastRow = board.get(size-1).replace('S', '0');
    board.remove(size-1);
    board.add(size-1, lastRow);

    countDp[size-1][size-1] = 1;

    //countDp[size-1][size-1] =
    for (int i=size-1; i>=0; i--) {
      for (int j=size-1; j>=0; j--) {
        if (board.get(i).charAt(j) != 'X') {
          int charValue = board.get(i).charAt(j) - '0';
          int maxSumFromChoices = Math.max(Math.max(sumDp[i + 1][j], sumDp[i][j + 1]), sumDp[i + 1][j + 1]);
          sumDp[i][j] = charValue + maxSumFromChoices;

          if (maxSumFromChoices == sumDp[i + 1][j]) {
            countDp[i][j] = countDp[i][j] + countDp[i + 1][j];
          } else if (maxSumFromChoices == sumDp[i][j + 1]) {
            countDp[i][j] = countDp[i][j] + countDp[i][j + 1];
          } else if (maxSumFromChoices == sumDp[i + 1][j + 1]) {
            countDp[i][j] = countDp[i][j] + countDp[i + 1][j + 1];
          }
        }
      }
    }

    return new int[] {countDp[0][0] == 0 ? 0 : sumDp[0][0], countDp[0][0]};

  }


  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("E23");
    list.add("2X2");
    list.add("12S");

    int[] arr = pathsWithMaxScore(list);

    System.out.println(arr);
  }
}
