package com.example.coding.math.leetcode.medium;

/**
 * Given an integer array nums of size n, return the minimum number of
 * moves required to make all array elements equal.
 *
 * In one move, you can increment n - 1 elements of the array by 1.
 */
public class MinimumMovesToEqualArrayElements {

    public static int minMoves(int[] nums) {
        /**
         * Here instead of moving n-1 number up by 1, down a number in every move.
         *
         * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93817/It-is-a-math-question
         */

        //Find min element in array
        int min = nums[0];
        int result = 0;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        for (int i=0; i< nums.length; i++) {
            result = result + nums[i] - min;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(minMoves(nums));
    }
}
