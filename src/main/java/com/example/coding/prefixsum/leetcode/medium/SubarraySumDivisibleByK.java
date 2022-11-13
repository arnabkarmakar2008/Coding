package com.example.coding.prefixsum.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the number of
 * non-empty subarrays that have a sum divisible by k.
 *
 * A subarray is a contiguous part of an array.
 */
public class SubarraySumDivisibleByK {

    public static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int sum = 0;
        int count = 0;

        for (int ct =0 ; ct < nums.length; ct++) {
            sum += nums[ct];

            int rem = sum % k;

            if (rem < 0) {
                rem+=k; // Because -1 % 5 = -1, but we need the positive mod 4
            }

            if (map.containsKey(rem)) {
                count = count + map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem,0)+1);


        }

        return count++;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;

        System.out.println(subarraysDivByK(nums, k));
    }
}
