package com.example.coding.dynamicprogramming.leetcode.knapsack;

/**
 * You are given two integer arrays of the same length nums1 and nums2. In one operation, you are allowed to
 * swap nums1[i] with nums2[i].
 *
 * For example, if nums1 = [1,2,3,8], and nums2 = [5,6,7,4], you can swap the element at i = 3 to obtain nums1 = [1,2,3,4]
 * and nums2 = [5,6,7,8].
 * Return the minimum number of needed operations to make nums1 and nums2 strictly increasing. The test cases are generated
 * so that the given input always makes it possible.
 *
 * An array arr is strictly increasing if and only if arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1]
 */
public class MinSwapToIncreasingSubSeq {


  /**
   * Case 1: a[i] > a[i-1] & b[i] > b[i-1] both arrays are strictly increaseing. So no swap at ith and i-1th position.
   * noSwap[i] = noSwap[i-1] //As we do not have to swap i-1, so cost will be same as i-1.
   * swap[i] = swap[i-1] + 1 // If we are swapping, ith index then we have to swap i-1 also to keep it increasring.
   *                         // cost will be cost of i-1th +1
   *
   * Case 2 : a[i] > b[i-1] & b[i] > a[i-1] // We have to swap either ith elemets or i-1th elements.
   *
   * swap[i] = noSwap[i-1] + 1 // As we are swapping ith element, so we cannot swap i-1th. So taking noSwap[i-1] and +1 for swapping ith element
   * noSwap[i] = swap[i-1] // We are not swapping ith, so have to swap i-1th elements.
   *
   * swap[i] = The cost to make both the arrays increasing until index ith and there will be swap at ith index
   * noSwap[i] = The cost to make both the arrays increasing until index ith and there will be no swap at ith index
   * @param a
   * @param b
   * @return
   */
  public static int minSwap(int[] a, int[] b) {
    int len = a.length;

    int[] swap = new int[1000];
    int[] noSwap = new int[1000];

    swap[0] = 1;
    noSwap[0] = 0;

    for (int i=1; i < len; i++) {

      if (a[i] > a[i-1] && b[i] > b[i-1]) {
        swap[i] = swap[i-1] + 1;
        noSwap[i] = noSwap[i-1];
      }

      if (a[i] > b[i-1] && b[i] > a[i-1]) {
        swap[i] = Math.min(swap[i], noSwap[i-1]+1);
        noSwap[i] = Math.min(noSwap[i],swap[i-1]);
      }
    }

    return Math.min(swap[len-1], noSwap[len-1]);

  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {

  }
}
