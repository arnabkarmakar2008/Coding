package com.example.coding.matrix.leetcode.easy;

public class AvailableRookCapture {

  public static int numRookCaptures(char[][] board) {
    int count = 0;
    for (int i=0; i< 8; i++) {
      for (int j=0; j< 8; j++) {
        if (board[i][j] == 'R') {
          for (int left = j-1; left >=0; left--) {
            if (board[i][left] == 'B') {
              break;
            } else {
              if (board[i][left] == 'P') {
                System.out.println("Under Artack :: " + i +" " + left);
                count++;
                break;
              }
            }
          }

          for (int left = j+1; left <=7; left++) {
            if (board[i][left] == 'B') {
              break;
            } else {
              if (board[i][left] == 'P') {
                System.out.println("Under Artack :: " + i +" " + left);
                count++;
                break;
              }
            }
          }

          for (int up = i-1; up >=0; up--) {
            if (board[up][j] == 'B') {
              break;
            } else {
              if (board[up][j] == 'P') {
                System.out.println("Under Artack :: " + up +" " + j);
                count++;
                break;
              }
            }
          }

          for (int up = i+1; up <=7; up++) {
            if (board[up][j] == 'B') {
              break;
            } else {
              if (board[up][j] == 'P') {
                System.out.println("Under Artack :: " + up +" " + j);
                count++;
                break;
              }
            }
          }
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    char[][] board = {
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','P',' ',' ',' ',' '},
            {' ',' ',' ','R','B',' ',' ','P'},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','P',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' ',' '}
    };

    System.out.println(numRookCaptures(board));
  }
}
