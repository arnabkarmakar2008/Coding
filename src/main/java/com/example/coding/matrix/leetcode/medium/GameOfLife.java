package com.example.coding.matrix.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton
 * devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1)
 * or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 */
public class GameOfLife {

  public static int[][] dimension = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};

  public static void gameOfLife(int[][] board) {
    int rows = board.length;
    int cols = board[0].length;

    Map<String, Integer> map = new HashMap<>();

    for (int i=0; i< rows; i++) {
      for (int j=0; j<cols; j++) {
        if (board[i][j] == 1 || board[i][j] == -2) {
          if (changeLiveCell(board, i, j)) {
            //live to dead -2 will represent live to dead. So -2 will be considered as live for calculation.
            map.put(i+"-"+j, 0);
            board[i][j] = -2; // will change -2 -> 0
          }
        } else if (board[i][j] == 0 || board[i][j] == -1) {
          //dead to live -1 will represent live
          if (changeDeadCell(board, i, j)) {
            map.put(i+"-"+j, 1);
            board[i][j] = -1; // will change -1 -> 1
          }
        }
      }
    }

    for (int i=0; i< rows; i++) {
      for (int j=0; j<cols; j++) {
        /*if (map.containsKey(i+"-"+j)) {
          board[i][j] = map.get(i+"-"+j);
        }*/

        if (board[i][j] == -2) {
          board[i][j] = 0;
        } else if (board[i][j] == -1) {
          board[i][j] = 1;
        }
      }
    }
  }

  public static boolean changeLiveCell (int[][] board, int row, int col) {
    /*Any live cell with fewer than two live neighbors dies as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population. */

    int liveCount = 0;
    for (int i=0; i<dimension.length; i++) {
      int newRow = row + dimension[i][0];
      int newCol = col + dimension[i][1];

      if (newRow >= 0 && newRow < board.length && newCol >=0 && newCol < board[0].length) {
        if (board[newRow][newCol] == 1 || board[newRow][newCol] == -2) {
          liveCount++;
        }
      }
    }

    if (liveCount < 2 || liveCount > 3) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean changeDeadCell (int[][] board, int row, int col) {
    //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction
    int liveCount = 0;
    for (int i=0; i<dimension.length; i++) {
      int newRow = row + dimension[i][0];
      int newCol = col + dimension[i][1];

      if (newRow >= 0 && newRow < board.length && newCol >=0 && newCol < board[0].length) {
        if (board[newRow][newCol] == 1 || board[newRow][newCol] == -2) {
          liveCount++;
        }
      }
    }

    return liveCount == 3 ? true : false;
  }

  public static void main(String[] args) {
    int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
    gameOfLife(board);
  }
}
