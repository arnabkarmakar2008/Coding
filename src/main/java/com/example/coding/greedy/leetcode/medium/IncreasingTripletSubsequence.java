package com.example.coding.greedy.leetcode.medium;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 */
public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int firstSmall = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= firstSmall) {
                firstSmall = num;
            } else if (num <= secondSmall) {
                secondSmall = num;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,0,4,6};
        System.out.println(increasingTriplet(nums));
    }
}
