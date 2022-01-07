package com.example.coding.matrix.leetcode.medium;

/**
 * You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
 *
 * A stone '#'
 * A stationary obstacle '*'
 * Empty '.'
 * The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
 *
 * It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
 *
 * Return an n x m matrix representing the box after the rotation described above.
 */
public class RotatingTheBox {

  //Note : Start from the end column. Assign empty = colsize-1. If cell if empty do nothing.
  // If cell has value, then cell[i][empty] = cell[i][j] empty--;
  // If cell has blocker, then empty = j-1

  public static char[][] rotateTheBox(char[][] box) {
    int rows = box.length;
    int cols = box[0].length;

    char[][] box2 = new char[cols][rows];


    for (int i=0; i<rows; i++) {
      int empty = cols-1;
      for (int j= cols-1; j>=0; --j) {
        if (box[i][j] == '*') { //blocker
          empty = j-1;
        }

        if (box[i][j] == '#') {
          box[i][j] = '.';
          box[i][empty] = '#';
          --empty;
        }
      }
    }

    for (int i=0; i<rows; i++) {
      for (int j=cols-1; j>=0; j--) {
        box2[j][rows-1-i] = box[i][j];
      }
    }

    return box2;
  }

  public static void main(String[] args) {
    char[][] box = {{'#','.','*', '.'},{'#','#','*','.'}};
    char[][] box2 = rotateTheBox(box);

    System.out.println(box2.length);
  }
}
