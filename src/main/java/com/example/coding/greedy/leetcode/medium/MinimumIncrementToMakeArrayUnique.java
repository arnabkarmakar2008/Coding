package com.example.coding.greedy.leetcode.medium;

import java.util.Arrays;

/**
 * You are given an integer array nums. In one move, you can pick an index i
 * where 0 <= i < nums.length and increment nums[i] by 1.
 *
 * Return the minimum number of moves to make every value in nums unique.
 *
 * The test cases are generated so that the answer fits in a 32-bit integer.
 *
 */
public class MinimumIncrementToMakeArrayUnique {

    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int result = 0;

        for(int ct = 1; ct <nums.length; ct++) {
            if (nums[ct] <= nums[ct-1]) {
                result += nums[ct-1] + 1 - nums[ct];
                nums[ct] = nums[ct-1] +1;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums));
    }
}
