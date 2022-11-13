package com.example.coding.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumCountEqualK {

    public static int countSubarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0;

        prefixSum[0] = nums[0];

        for (int i=1; i< nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];

            if (prefixSum[i] == k) {
                count++;
            }

            if (prefixSumMap.containsKey(prefixSum[i] - k)) {
                count = count + prefixSumMap.get(prefixSum[i] - k);
            }

            int sum = prefixSumMap.getOrDefault(prefixSum[i], 0);
            prefixSumMap.put(prefixSum[i], sum+1);

        }

      return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,1,6,4,3};
        System.out.println(countSubarraySum(nums, 7));
    }
}
