package com.example.coding.slidingwindow.leetcode.medium;

/**
 * Given an array of positive integers nums and a positive integer target, return the
 * minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the
 * sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;

        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        while (end < nums.length) {
            sum = sum + nums[end];

            if (sum < target) {
                end++;
            } else if (sum >= target) {
                while (sum >= target) {
                    minLength = Math.min(minLength, end-start+1);
                    sum = sum - nums[start];
                    start++;
                }
                end++;
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }
}
