package com.example.coding.matrix.leetcode.easy;

public class FlippingImage {

  public static int[][] flipAndInvertImage(int[][] image) {

    for (int i=0; i<image.length; i++) {
      for (int j=0, k = image[0].length-1; j<= k; j++, k--) {

        if (j < k) {
          int temp = image[i][k];
          image[i][j] = image[i][k];
          image[i][k] = temp;

          if(image[i][k] == 1)
            image[i][k] = 0;
          else
            image[i][k] = 1;

          if(image[i][j] == 1)
            image[i][j] = 0;
          else
            image[i][j] = 1;


        } else {
          if(image[i][k] == 1)
            image[i][k] = 0;
          else
            image[i][k] = 1;
        }


      }
    }

    return image;

  }

  public static void main(String[] args) {
    int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
    flipAndInvertImage(image);
  }
}
