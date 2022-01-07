package com.example.coding.matrix.leetcode.medium;

import java.util.*;

/**
 * On an 8x8 chessboard, there can be multiple Black Queens and one White King.
 *
 * Given an array of integer coordinates queens that represents the positions of the Black Queens,
 * and a pair of coordinates king that represent the position of the White King, return the coordinates
 * of all the queens (in any order) that can attack the King.
 */
public class QueenThatCanAttackKing {

  public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    List<List<Integer>> list = new ArrayList<>();

    int kingRow = king[0];
    int kingCol = king[1];

    Set<String> queenSet = new HashSet<>();

    for (int i=0; i<queens.length;i++) {
      queenSet.add(queens[i][0]+"-"+queens[i][1]);
    }

    //Check right
    int ct = kingCol;
    ct++;
    while (ct < 8) {
      if (queenSet.contains(kingRow+"-"+ct)) {
        list.add(Arrays.asList(kingRow, ct));
        break;
      }

      ct++;
    }

    ct = kingCol;
    ct--;
    //Check left
    while (ct>=0) {
      if (queenSet.contains(kingRow+"-"+ct)) {
        list.add(Arrays.asList(kingRow, ct));
        break;
      }

      ct--;
    }

    //Check down
    ct = kingRow;
    ct++;
    while (ct < 8) {
      if (queenSet.contains(ct+"-"+kingCol)) {
        list.add(Arrays.asList(ct, kingCol));
        break;
      }
      ct++;
    }

    //Chcek up
    ct = kingRow;
    ct--;
    while (ct >= 0) {
      if (queenSet.contains(ct+"-"+kingCol)) {
        list.add(Arrays.asList(ct, kingCol));
        break;
      }
      ct--;
    }

    int rowCt = kingRow;
    int colCt = kingCol;
    rowCt--;
    colCt++;

    while (rowCt>=0 && colCt<8) {
      if (queenSet.contains(rowCt+"-"+colCt)) {
        list.add(Arrays.asList(rowCt, colCt));
        break;
      }
      rowCt--;
      colCt++;
    }

    rowCt = kingRow;
    colCt = kingCol;
    rowCt++;
    colCt++;

    while (rowCt<8 && colCt<8) {
      if (queenSet.contains(rowCt+"-"+colCt)) {
        list.add(Arrays.asList(rowCt, colCt));
        break;
      }
      rowCt++;
      colCt++;
    }

    rowCt = kingRow;
    colCt = kingCol;
    rowCt++;
    colCt--;

    while (rowCt<8 && colCt>=0) {
      if (queenSet.contains(rowCt+"-"+colCt)) {
        list.add(Arrays.asList(rowCt, colCt));
        break;
      }
      rowCt++;
      colCt--;
    }

    rowCt = kingRow;
    colCt = kingCol;
    rowCt--;
    colCt--;

    while (rowCt>=0 && colCt>=0) {
      if (queenSet.contains(rowCt+"-"+colCt)) {
        list.add(Arrays.asList(rowCt, colCt));
        break;
      }
      rowCt--;
      colCt--;
    }

    return list;

  }

  public static List<List<Integer>> queensAttacktheKingEfficient(int[][] queens, int[] king) {
    List<List<Integer>> list = new ArrayList<>();
    boolean[][] matrix = new boolean[8][8];

    for (int i=0; i< queens.length; i++) {
      matrix[queens[i][0]][queens[i][1]]  = true;
    }

    int[][] direction = {{0,1},{1,0},{0,-1},{-1,0},{-1,1},{1,1},{1,-1},{-1,-1}};

    for (int i=0; i<direction.length; i++) {
      int kRow = king[0] + direction[i][0];
      int kCol = king[1] + direction[i][1];

      while (kRow >=0 && kRow<8 && kCol >= 0 && kCol<8) {
        if (matrix[kRow][kCol] == true) {
          list.add(Arrays.asList(kRow, kCol));
          break;
        }

        kRow = kRow + direction[i][0];
        kCol = kCol + direction[i][1];
      }
    }

    return list;
  }

  public static void main(String[] args) {
    int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
    int[] king = {0,0};
    queensAttacktheKingEfficient(queens, king);

  }
}
