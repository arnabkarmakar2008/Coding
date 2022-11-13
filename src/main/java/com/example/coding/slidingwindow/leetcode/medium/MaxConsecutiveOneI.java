package com.example.coding.slidingwindow.leetcode.medium;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 *
 */
public class MaxConsecutiveOneI {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        int maxTempWindow = 0;
        for (int start=0; start < nums.length; start++) {
            maxTempWindow = nums[start] == 0 ? 0 : maxTempWindow+1;
            maxLength = Math.max(maxLength, maxTempWindow);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
