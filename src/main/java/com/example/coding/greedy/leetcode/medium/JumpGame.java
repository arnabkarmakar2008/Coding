package com.example.coding.greedy.leetcode.medium;

/**
 * You are given an integer array nums. You are initially
 * positioned at the array's first index, and each element in the array
 * represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int lastGoodIndexPosition = nums.length-1;

        for (int ct = nums.length-1; ct >=0; ct--) {
            if (ct + nums[ct] >= lastGoodIndexPosition) {
                lastGoodIndexPosition = ct;
            }
        }

        return lastGoodIndexPosition == 0;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

}
