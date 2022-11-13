package com.example.coding.greedy.leetcode.medium;

import java.util.Arrays;

/**
 *  Given an array of non-negative integers nums, you are initially
 *  positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 */
public class JumpGameII {

    public static int minJumpGreedy(int[] nums) {
        //Take two pointer for window
        /**
         * {2,3,1,1,4}
         *
         * From 0th position we can jump to 1st or 2nd position. So left will be at 1st and right will be at 2nd
         * https://www.youtube.com/watch?v=dJ7sWiOoK7g
         *
         */

        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            int farthest = 0;

            for (int i=left; i<=right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            left = right +1;
            right = farthest;
            result++;

        }

        return result;
    }

    public static int minJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dpMinJump(nums, 0, dp);

    }

    private static int dpMinJump(int[] nums, int start, int[] dp) {

        //base case
        if (start >= nums.length-1) {
            return 0;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        int minJump = Integer.MAX_VALUE;

        for (int ct = start+1; ct <= start + nums[start]; ct++) {
            minJump = Math.min(minJump, 1 + dpMinJump(nums, ct, dp));
        }

        return dp[start] = minJump;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(minJump(nums));
    }
}
