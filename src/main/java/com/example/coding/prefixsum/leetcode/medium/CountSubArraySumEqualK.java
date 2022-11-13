package com.example.coding.prefixsum.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number
 * of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class CountSubArraySumEqualK {

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int ct = 0; ct < nums.length; ct++) {
            sum += nums[ct];

            if (sum == k) {
                count++;
            }

            if (map.containsKey(sum - k)) {
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;

        System.out.println(subarraySum(nums, k));
    }
}
