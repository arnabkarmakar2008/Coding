package com.example.coding.matrix.leetcode.easy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents
 * the pixel value of the image.
 *
 * You are also given three integers sr, sc, and color. You should perform a flood fill on
 * the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected
 * 4-directionally to the starting pixel of the same color as the starting pixel, plus any
 * pixels connected 4-directionally to those pixels (also with the same color), and so on.
 * Replace the color of all of the aforementioned pixels with color.
 *
 * Return the modified image after performing the flood fill.
 *
 */
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
