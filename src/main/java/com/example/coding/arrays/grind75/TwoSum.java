package com.example.coding.arrays.grind75;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices
 * of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] resArr = new int[2];

        for (int ct = 0; ct < nums.length; ct++) {
            if (nums[ct] >= target) continue;
            int rem = Math.abs(target - nums[ct]);

            if (map.containsKey(rem)) {
                resArr[0] = map.get(rem);
                resArr[1] = ct;
                return resArr;
            } else {
                map.put(nums[ct], ct);
            }


        }

        return resArr;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] resultArr = twoSum(nums, target);

        for (int indx : resultArr)
            System.out.println(indx);
    }
}
