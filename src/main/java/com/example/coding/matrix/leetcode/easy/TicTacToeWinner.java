package com.example.coding.matrix.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
 * <p>
 * Players take turns placing characters into empty squares ' '.
 * The first player A always places 'X' characters, while the second player B always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
 * <p>
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
 */
public class TicTacToeWinner {

  public static String tictactoe(int[][] moves) {
    int[] firstRow = new int[3];
    int[] firstCol = new int[3];
    int[] secondRow = new int[3];
    int[] secondCol = new int[3];

    int firstDiagonal1 = 0;
    int firstDiagonal2 = 0;
    int secondDiagonal1 = 0;
    int secondDiagonal2 = 0;


    int gameInd = 0;

    for (int i = 0; i < moves.length; i++) {
      int row = moves[i][0];
      int col = moves[i][1];

      if (i % 2 == 0) {
        gameInd = 1;

        if (++firstRow[row] == 3 || ++firstCol[col] == 3 || (row == col && ++firstDiagonal1 == 3) ||
                (row+col==2 && ++firstDiagonal2 ==3)) {
          return "first";
        }


      } else {
        if (++secondRow[row] == 3 || ++secondCol[col] == 3 || (row == col && ++secondDiagonal1 == 3) ||
                (row+col==2 && ++secondDiagonal2 ==3)) {
          return "second";
        }
      }

    }

    if (moves.length <9) {
      return "pending";
    }

    return "draw";
  }

  public static void main(String[] args) {
    int[][] moves = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};

    System.out.println(tictactoe(moves));
  }
}
