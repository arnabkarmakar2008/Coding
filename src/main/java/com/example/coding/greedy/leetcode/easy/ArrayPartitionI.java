package com.example.coding.greedy.leetcode.easy;

import java.util.Arrays;

/**
 * Given an integer array nums of 2n integers, group these integers into
 * n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for
 * all i is maximized. Return the maximized sum.
 *
 * Input: nums = [6,2,6,5,1,2]
 * Output: 9
 * Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1)
 * + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 *
 *
 */
public class ArrayPartitionI {

    /**
     * In short, the sum of all number is fixed, to maximize the sum of smaller group, you want to minimize the diff of the sum of 2 groups.
     * And the best way to do that is to pair the numbers that are next to each other in sorted order.
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i =0; i<nums.length; i +=2) {
            sum += nums[i];
        }

        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};
        System.out.println(arrayPairSum(nums));
    }
}
