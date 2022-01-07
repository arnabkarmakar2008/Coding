package com.example.coding.matrix.leetcode.medium;

/**
 * Implement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of
 * integers in the constructor and supports two methods:
 *
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 *
 * Updates all values with newValue in the subrectangle whose upper left coordinate is (row1,col1)
 * and bottom right coordinate is (row2,col2).
 * 2. getValue(int row, int col)
 *
 * Returns the current value of the coordinate (row,col) from the rectangle.
 */
class Subrectangle {

  int[][] rect;

  public Subrectangle(int[][] rectangle) {
    this.rect = rectangle;
  }

  public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    for (int i = row1; i <=row2; i++) {
      for (int j=col1; j<=col2; j++) {
        rect[i][j] = newValue;
      }
    }
  }

  public int getValue(int row, int col) {
    return rect[row][col];
  }

}

public class SubrectangleQueries {



  public static void main(String[] args) {
    int[][] rect = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
    Subrectangle subrectangle = new Subrectangle(rect);

    System.out.println(subrectangle.getValue(0,2));
    subrectangle.updateSubrectangle(0,0,3,2,5);

    System.out.println(subrectangle.getValue(0,2));

    subrectangle.updateSubrectangle(3,0,3,2,10);

    System.out.println(subrectangle.getValue(0,2));
    System.out.println(subrectangle.getValue(3,1));
  }
}
