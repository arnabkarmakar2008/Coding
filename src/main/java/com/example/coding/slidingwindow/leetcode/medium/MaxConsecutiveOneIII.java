package com.example.coding.slidingwindow.leetcode.medium;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive
 * 1's in the array if you can flip at most k 0's.
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 */
public class MaxConsecutiveOneIII {

    public static int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int oneCount = 0;
        int zeroCount = 0;

        int maxLength = Integer.MIN_VALUE;

        while (end < nums.length) {
            if (nums[end] == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }

            if (end-start+1 - oneCount < k) {
                end ++;
            } else if (end-start+1 - oneCount == k) {
                maxLength = Math.max(maxLength, end-start+1);
                end++;
            } else {
                if (nums[start] == 1) {
                    oneCount--;
                } else {
                    zeroCount--;
                }

                start++;
                end++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,0,1,0,1};
        int k = 2;

        System.out.println(longestOnes(nums, k));
    }
}
