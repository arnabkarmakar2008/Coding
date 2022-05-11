package com.example.coding.backtracking.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */
public class NQueen {

  /**
   * https://www.youtube.com/watch?v=i05Ju7AftcM
   * @param n
   * @return
   */
  public static List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];

    for (int row=0; row<n; row++) {
      for (int col=0; col<n; col++) {
        board[row][col] = '.';
      }
    }

    List<List<String>> ansList = new ArrayList<>();

    backtrack(0, board, ansList);

    return ansList;

  }

  public static void backtrack(int column, char[][] board, List<List<String>> answerList) {
    //base
    if (column == board.length) {
      answerList.add(construct(board));
      return;
    }

    for (int row=0; row < board.length; row++) {

      if (isSafe(board, row, column)) {
        board[row][column] = 'Q';
        backtrack(column+1, board, answerList);
        board[row][column] = '.';
      }
    }

  }

  public static List<String> construct(char[][] board) {
    List<String> stringList = new ArrayList<>();

    for (int row=0; row < board.length; row++) {
      String str = new String(board[row]);
      stringList.add(str);
    }

    return stringList;
  }

  public static void main(String[] args) {
    List<List<String>> list = solveNQueens(4);
    System.out.println(list);
  }

  private static boolean isSafe(char[][] board, int row, int col) {
    int dupRow = row;
    int dupCol = col;

    /**
     * We are moving from left->right. So we have to check left, upper left diag and lower left diag
     */

    //upper left diag
    while (row >= 0 && col>= 0) {
      if (board[row][col] == 'Q') return false;
      row--;
      col--;
    }

    row = dupRow;
    col = dupCol;

    //lower left diag
    while (row < board.length && col>= 0) {
      if (board[row][col] == 'Q') return false;
      row++;
      col--;
    }

    row = dupRow;
    col = dupCol;

    //left
    while (col >=0) {
      if (board[row][col] == 'Q') return false;
      col--;
    }

    return true;
  }
}
