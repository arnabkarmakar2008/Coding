package com.example.coding.prefixsum.leetcode.easy;

/**
 * Given an integer array nums, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices
 * left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0,2));
    }
}

class NumArray {

    int[] sumArray;

    public NumArray(int[] nums) {
        this.sumArray = nums;

        for (int ct=1; ct < nums.length; ct++) {
            sumArray[ct] = nums[ct] + nums[ct-1];
        }
    }

    public int sumRange(int left, int right) {
        return sumArray[right] - (left == 0 ? 0 : sumArray[left-1]);
    }
}

