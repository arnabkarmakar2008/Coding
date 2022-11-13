package com.example.coding.math.leetcode.medium;

import java.util.Arrays;

/**
 * Given an integer array nums of size n, return the minimum number of
 * moves required to make all array elements equal.
 *
 * In one move, you can increment or decrement an element of the array by 1.
 *
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 */
public class MinimumMovesToEqualArrayElementsII {

    public static int minMoves(int[] nums) {

        int n = nums.length;
        //sort the array
        Arrays.sort(nums);

        //Find the median
        int mid = n%2 == 0 ? (nums[n/2] + nums[n/2-1])/2 : nums[n/2];

        int result = 0;
        for (int i=0; i< nums.length; i++) {
            result += Math.abs(mid-nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(minMoves(nums));
    }
}
