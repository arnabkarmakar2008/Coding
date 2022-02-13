package com.example.coding.matrix.leetcode.medium;

/**
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class WordSearch {

  public static boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols];

    for (int i=0; i< rows; i++) {
      for (int j=0; j< cols; j++) {
        if (dfs(board, visited, i,j,0,word)) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean dfs (char[][] board,boolean[][] visited,int row, int column, int wordPosition, String word) {
    if (word.length() - 1 == wordPosition) {
      return true;
    }

    if (row <0 || column < 0 || row >= board.length || column >= board[0].length
    || visited[row][column] == true || word.charAt(wordPosition)!= board[row][column]) {
      return false;
    }

    visited[row][column] = true;

    boolean bottom = dfs(board, visited, row+1, column, wordPosition+1, word);
    boolean up = dfs(board, visited, row-1, column, wordPosition+1, word);
    boolean right = dfs(board, visited, row, column+1, wordPosition+1, word);
    boolean left = dfs(board, visited, row, column-1, wordPosition+1, word);

    visited[row][column] = false;

    return (bottom||up||right||left);
  }

  public static void main(String[] args) {
    char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    String word = "ABCCXD";
    System.out.println(exist(board, word));
  }
}
