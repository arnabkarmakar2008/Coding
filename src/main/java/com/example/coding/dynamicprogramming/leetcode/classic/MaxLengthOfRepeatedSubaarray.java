package com.example.coding.dynamicprogramming.leetcode.classic;

/**
 * Given two integer arrays nums1 and nums2, return the maximum length of a
 * subarray that appears in both arrays.
 */
public class MaxLengthOfRepeatedSubaarray {

  public static int recursiveSolution(int[] nums1, int index1, int[] nums2, int index2, int count) {

    if (index1 <= 0 || index2 <= 0) {
      return count;
    }

    int matchingIncludedCount = 0;
    int nonMatchingNotIncludedCount = 0;
    int nonMatchingIncludedCount = 0;

    matchingIncludedCount = count;
    if (nums1[index1] == nums2[index2]) {
      matchingIncludedCount = recursiveSolution(nums1, index1 - 1, nums2, index2 - 1, count + 1);
    }

    nonMatchingNotIncludedCount = recursiveSolution(nums1, index1 - 1, nums2, index2, count);
    nonMatchingIncludedCount = recursiveSolution(nums1, index1, nums2, index2-1, count);

    return Math.max(matchingIncludedCount, Math.max(nonMatchingNotIncludedCount, nonMatchingIncludedCount));
  }

  /**
   * https://www.youtube.com/watch?v=UZRkpGk943Q
   * @param nums1
   * @param nums2
   * @return
   */
  public static int dpSolution(int[] nums1, int[] nums2) {
    int[][] dp = new int[nums1.length+1][nums2.length+1];
    int maxLength = Integer.MIN_VALUE;
    for (int i=0; i<=nums1.length; i++) {
      for (int j=0; j<= nums2.length; j++) {
        if (i==0 || j==0) {
          dp[i][j] = 0;
        } else {

          if (nums1[i-1] == nums2[j-1]) {
            dp[i][j] = 1 + dp[i - 1][j - 1];
            maxLength = Math.max(maxLength, dp[i][j]);

          }
        }
      }
    }

    return maxLength;
  }

  public static int findLength(int[] nums1, int[] nums2) {
    return recursiveSolution(nums1, nums1.length-1, nums2, nums2.length-1, 0);
  }

  public static void main(String[] args) {
    int[] nums1 = {1,2,3,2,1};
    int[] nums2 = {3,2,1,4,7};

    //System.out.println(findLength(nums1, nums2));

    System.out.println(dpSolution(nums1, nums2));
  }
}
