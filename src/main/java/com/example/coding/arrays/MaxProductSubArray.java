package com.example.coding.arrays;

/**
 * Find max product from subarray.
 *
 * IP = {-1,6,2,0,7,9}
 * OP = 63 (7*9)
 */
public class MaxProductSubArray {

  /**
   * Have to keep previous max and min.
   * IP =     -1 , 6, 2, 0, 7, 9
   *
   * preMax = -1   6  12 0  7  63
   * preMin = -1  -1  -2 0  0  0
   * ans    = -1   6  12 12 12 63
   * currMax= -1   6  12 0  7  63
   * currMin= -1   -1 -2 0  0  0
   *
   *
   *
   * @param arr
   * @return
   */
  public static int maxProduct(int[] arr) {
    int len = arr.length;

    int prevMax = arr[0];
    int prevMin = arr[0];
    int answer = arr[0];

    int currentMax = arr[0];
    int currentMin = arr[0];

    for (int i=1; i<len; i++) {

      currentMax = Math.max(Math.max(prevMax*arr[i], prevMin*arr[i]) , arr[i]);
      currentMin = Math.min(Math.min(prevMax*arr[i], prevMin*arr[i]) , arr[i]);
      answer = Math.max(answer,Math.max(currentMax, currentMin));

      prevMax = currentMax;
      prevMin = currentMin;
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] arr = {-1,6,2,0,7,9};

    System.out.println(maxProduct(arr));
  }
}
