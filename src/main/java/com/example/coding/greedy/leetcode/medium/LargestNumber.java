package com.example.coding.greedy.leetcode.medium;

import java.util.Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNumber {

    public static String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];

        for (int ct = 0; ct < nums.length; ct++) {
            strArr[ct] = String.valueOf(nums[ct]);
        }

        Arrays.sort(strArr, (str1,str2) -> (str2+str1).compareTo(str1+str2));

        StringBuilder sb = new StringBuilder();

        for (String str : strArr) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
