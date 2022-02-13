package com.example.coding.matrix.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square
 * represented by 0. A move consists of choosing 0 and a 4-directionally adjacent number and
 * swapping it.
 *
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 *
 * Given the puzzle board board, return the least number of moves required so that the
 * state of the board is solved. If it is impossible for the state of the board to be solved,
 * return -1
 */
public class SlidingPuzzle {

  public static int slidingPuzzle(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;

    String finalString = "123450";
    String inputString = "";

    // Note : From 0 position it can move to index 1 and 3. From 1 position it can move to index 0,2,4.....
    int[][] directions = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        inputString = inputString + "" + board[i][j];

      }
    }

    Queue<String> queue = new LinkedList<>();
    Set<String> set = new HashSet<>();

    queue.add(inputString);
    set.add(inputString);


    int move = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      while (size > 0) {
        String topString = queue.remove();

        if (topString.equals(finalString)) {
          return move;
        }

        int zeroIndex = topString.indexOf('0');

        //Now move possible from zeroIndex position
        for (int dir : directions[zeroIndex]) {
          String updatedString = replace(topString, zeroIndex, dir);

          if (!set.contains(updatedString)) {
            set.add(updatedString);
            queue.add(updatedString);
          }
        }
        size--;
      }

      move++;
    }

    return -1;

  }

  private static String replace(String input, int index1, int index2) {
    char char1 = input.charAt(index1);
    char char2 = input.charAt(index2);

    StringBuffer sb = new StringBuffer(input);

    sb.setCharAt(index1, char2);
    sb.setCharAt(index2, char1);
    return sb.toString();
  }


  public static void main(String[] args) {
    int[][] board = {{4,1,2},{5,0,3}};
    System.out.println(slidingPuzzle(board));
  }
}
