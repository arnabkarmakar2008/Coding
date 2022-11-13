package com.example.coding.arrays.grind75;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of
 * each number sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {

    public static int[] sortedSquares(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        int[] resArray = new int[nums.length];

        for (int ct = resArray.length-1; ct >=0; ct--) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                resArray[ct] = nums[start] * nums[start];
                start++;
            } else {
                resArray[ct] = nums[end] * nums[end];
                end--;
            }
        }

        return resArray;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] resultNum = sortedSquares(nums);

        for (int val : resultNum) {
            System.out.println(val);
        }
    }
}
