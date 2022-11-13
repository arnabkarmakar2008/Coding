package com.example.coding.prefixsum.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if nums has a
 * continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.
 *
 * An integer x is a multiple of k if there exists an integer n such that x = n * k.
 * 0 is always a multiple of k.
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 *
 */
public class ContinuousSubArraySum {

    /**
     * https://www.youtube.com/watch?v=OKcrLfR-8mE
     *
     * This is one of those magics of remainder theorem :)
     *
     * (a+(n*x))%x is same as (a%x)
     *
     * For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42]
     * and the remainders are [5,1,1,5,0]. We got remainder 5 at index 0 and at index 3.
     * That means, in between these two indexes we must have added a number which is multiple of the k.
     * Hope this clarifies your doubt :)
     * @param nums
     * @param k
     * @return
     */
    public static boolean checkSubarraySum(int[] nums, int k) {
        int runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for (int ct = 0; ct < nums.length; ct++) {
            runningSum += nums[ct];
            int reminder = runningSum%k;

            //if we have seen this reminder before, then we have added elements whose sum is multiple of k
            if (map.containsKey(reminder)) {
                int prevReminderIndex = map.get(reminder);

                //If size of the subarray is greater than 2 then only return true
                if (ct - prevReminderIndex >= 2) {
                    return true;
                }
            } else {
                map.put(reminder, ct);
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 2;
        System.out.println(checkSubarraySum(nums,k));
    }
}
