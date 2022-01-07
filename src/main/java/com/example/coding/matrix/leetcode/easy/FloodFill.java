package com.example.coding.matrix.leetcode.easy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

    int totalRow = image.length;
    int totalCol = image[0].length;

    Queue<Pair<Integer,Integer>> queue = new LinkedList<>();

    queue.add(new Pair<>(sr, sc));
    int srcColor = image[sr][sc];
    image[sr][sc] = newColor;

    while (!queue.isEmpty()) {
      Pair<Integer, Integer> tempPair = queue.remove();

      int row = tempPair.getKey();
      int col = tempPair.getValue();

      if (col-1 >= 0 && image[row][col-1] == srcColor) {
        image[row][col-1] = newColor;
        queue.add(new Pair<>(row, col-1));
      }

      if (col+1 <= totalCol-1 && image[row][col+1] == srcColor) {
        image[row][col+1] = newColor;
        queue.add(new Pair<>(row, col+1));
      }

      if (row-1 >= 0 && image[row-1][col] == srcColor) {
        image[row-1][col] = newColor;
        queue.add(new Pair<>(row-1, col));
      }

      if (row+1 <= totalRow-1 && image[row+1][col] == srcColor) {
        image[row+1][col] = newColor;
        queue.add(new Pair<>(row+1, col));
      }

    }

    return image;
  }

  public static void main(String[] args) {
    //int[][] image = {{1,1,1},{1,1,0},{1,0,1}};

    int[][] image = {{0,0,0},{0,0,0}};
    floodFill(image, 0,0, 2);
  }
}
