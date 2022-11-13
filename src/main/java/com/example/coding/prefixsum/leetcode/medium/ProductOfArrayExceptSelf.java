package com.example.coding.prefixsum.leetcode.medium;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {

    /**
     * Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except
     * 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right.
     * We can get lefts and rights:
     *
     * Numbers:     2    3    4     5
     * Lefts:            2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5
     * Let’s fill the empty with 1:
     *
     * Numbers:     2    3    4     5
     * Lefts:       1    2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5     1
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        //Calculate left product and store it in same result array
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i< nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }

        // Now to save space store right just in variable
        int right = 1;

        for (int i = nums.length-1; i>=0; i--) {
            res[i] *= right;
            right = right * nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] resultArray = productExceptSelf(nums);
    }
}
