package com.example.coding.prefixsum.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array nums, return the maximum length of a
 * contiguous subarray with an equal number of 0 and 1.
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 */
public class ContiguousArray {

    /**
     * Change 0 to -1 in the array first. Now when the running sum is 0, that means we have equal number of 1's and 0's.
     * But we have to store the running sum in map with index. If we get the same running sum again,
     * that means in between index elements are equal number of 1's and 0's.
     * If running sum is 0 at any point then from starting till this index we have equal number of 0's and 1's
     *
     * Nice solution I also do same .
     * This technique can be used for more problems also like:
     * https://leetcode.com/contest/biweekly-contest-32/problems/find-longest-awesome-substring/
     * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
     *
     *
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int runningSum = 0;
        int maxLength = Integer.MIN_VALUE;

        for (int ct =0; ct < nums.length; ct++) {
            runningSum += nums[ct] == 1 ? 1 : -1;

            if (map.containsKey(runningSum)) {
                maxLength = Math.max(maxLength, ct - map.get(runningSum));
            } else {
                map.put(runningSum, ct);
            }
        }

        return maxLength;
    }


    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,0,1};
        System.out.println(findMaxLength(nums));
    }
}
