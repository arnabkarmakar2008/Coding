package com.example.coding.twopointers.leetcode.easy;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored
 * inside the array nums1. To accommodate this, nums1 has a length of m + n, where the
 * first m elements denote the elements that should be merged, and the last n elements are
 * set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArrays {

  /**
   * Start merging from last index
   * https://www.youtube.com/watch?v=P1Ic85RarKY
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int firstIndex = m-1;
    int secondIndex = n-1;
    int finalIndex = m+n-1;


    while (firstIndex >= 0 && secondIndex >= 0) {
      if (nums1[firstIndex] > nums2[secondIndex]) {
        nums1[finalIndex] = nums1[firstIndex];
        firstIndex--;
      } else {
        nums1[finalIndex] = nums2[secondIndex];
        secondIndex--;
      }

      finalIndex--;
    }

    while (secondIndex >=0) {
      nums1[finalIndex] = nums2[secondIndex];
      finalIndex--;
      secondIndex--;
    }
  }


  public static void main(String[] args) {
    int[] nums1 = {1,2,3,0,0,0};
    int[] nums2 = {2,5,6};
    merge(nums1, 3, nums2, 3);
    System.out.println(nums1);
  }
}
