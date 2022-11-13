package com.example.coding.greedy.leetcode.medium;

/**
 * Given an integer array nums, you need to find one continuous
 * subarray that if you only sort this subarray in ascending order, then the whole array
 * will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to
 *
 * make the entire array sorted in ascending order.
 */
public class ShortestUnsortedSunArray {

    /**
     * https://www.youtube.com/watch?v=GvAtQOMr8CQ
     *
     *
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int end = -1; // need to take this -1 if array is sorted. Then if we take end =0
        // then window size will be  0 - 0 +1 = 1. To avoid this taking end as -1
        int max = nums[0];

        /**
         * Start from left -> right. Find the last index where num is smaller than previous index.
         * If num is smaller than previous index means that is not at correct position
         */

        for (int i=1; i< nums.length; i++) {
            if (max > nums[i]) {
                end = i;
            } else {
                max = nums[i];
            }
        }

        int start = 0;
        int min = nums[nums.length-1];

        /**
         * Start from right -> left. Find the last index where num is greater than previous index.
         * If num is greater than previous index means that is not at correct position
         */
        for (int i = nums.length-2; i>=0; i--) {
            if (min < nums[i]) {
                start = i;
            } else {
                min = nums[i];
            }
        }

        return end - start +1;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }
}
