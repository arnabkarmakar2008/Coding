package com.example.coding.slidingwindow.leetcode.medium;

/**
 * Given a binary array nums and an integer goal, return the number of
 * non-empty subarrays with a sum goal.
 *
 * A subarray is a contiguous part of the array.
 *
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 */
public class CountBinarySubArraysWithSum {

    /**
     * https://leetcode.com/problems/binary-subarrays-with-sum/discuss/186683/C%2B%2BJavaPython-Sliding-Window-O(1)-Space
     *
     * ****NOTE:::::: Typical count subarray problem
     * @param nums
     * @param goal
     * @return
     */

    private static int atMostSum(int[] nums, int goal) {
        int start = 0, len = nums.length;
        int count = 0;
        for (int end=0; end < len; end++) {
            goal = goal - nums[end];

            while (goal < 0) {
                goal += nums[start++];
            }

            count += end-start+1;
        }
        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMostSum(nums, goal) - atMostSum(nums, goal-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;

        System.out.println(numSubarraysWithSum(nums,2));
    }
}
