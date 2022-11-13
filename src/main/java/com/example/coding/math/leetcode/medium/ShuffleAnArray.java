package com.example.coding.math.leetcode.medium;

import java.util.Random;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 * All permutations of the array should be equally likely as a result of the shuffling.
 *
 * Implement the Solution class:
 *
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 */
public class ShuffleAnArray {


    public static void main(String[] args) {

        Solution solution = new Solution(new int[]{2,3,4,5,6,7,8,9});


    }

    static class Solution {

        int[] nums;
        Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] copyArray = nums.clone();

            for (int i = nums.length-1; i >0; i--) {
                int randomIndex = random.nextInt(i+1); // have to generate number from 0 uptil nums.length-1
                int temp = copyArray[randomIndex];
                copyArray[randomIndex] = copyArray[i];
                copyArray[i] = temp;
            }

            return copyArray;
        }
    }

}
