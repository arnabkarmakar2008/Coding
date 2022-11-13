package com.example.coding.slidingwindow.leetcode.medium;

/**
 * Given an array of integers nums and an integer k. A continuous subarray is called
 * nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 *
 *
 */
public class CountNumberOfNiceSubArrays {

    /**
     * It will be same as count subarray with K distinct elements.
     *
     * Count subarray with at most k - count subarray with at most k-1
     * @param nums
     * @param k
     * @return
     */
    public static int numberOfSubArrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private static int atMost(int[] nums, int k) {
        int start = 0;
        int result = 0;

        for (int end = 0; end < nums.length; end++) {
            int reminder = nums[end] %2;
            k = k - reminder; // If number is even then reminder will be 0 else it will be 1.

            while (k < 0) {
                k = k + nums[start] %2;
                start++;
            }

            result = result + (end-start+1);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;

        System.out.println(numberOfSubArrays(nums, k));
    }
}
