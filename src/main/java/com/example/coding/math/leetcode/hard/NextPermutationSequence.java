package com.example.coding.math.leetcode.hard;

import java.util.Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a
 * sequence or linear order.
 *
 * For example, for arr = [1,2,3], the following are all the permutations of
 * arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically greater
 * permutation of its integer. More formally, if all the permutations of the array are sorted
 * in one container according to their lexicographical order, then the next permutation of that
 * array is the permutation that follows it in the sorted container. If such arrangement is
 * not possible, the array must be rearranged as the lowest possible order
 * (i.e., sorted in ascending order).
 *
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a
 * lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 *
 * The replacement must be in place and use only constant extra memory.
 */
public class NextPermutationSequence {

    /**
     * https://www.youtube.com/watch?v=6qXO72FkqwM
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int size = nums.length;
        int lastPeakIndex = -1;
        //Find last peak index
        for (int i=1; i<size; i++) {
            if (nums[i] > nums[i-1]) {
                lastPeakIndex = i;
            }
        }

        //If lastPeakIndex = -1 is still -1 then array is descending. We just have to reverse the array
        if (lastPeakIndex == -1) {
            for (int i = 0; i < size / 2; i++) {
                swap(nums, i, size - i - 1);
            }

            return;
        }

        //Now from last peak to end, if we find any element between last peak and element before last peak, then
        // swap with that element with element before last peak.
        /**
         * e.g 6 7 2 4 8 3 1
         *
         * In this case 8 is the last peak. 4 is the before peak. But we have 3 which is between 4 and 8. So
         * replace 4 with 3.
         */
        int lastPeaNum = nums[lastPeakIndex];
        int index = lastPeakIndex;

        for (int i = lastPeakIndex+1; i<size; i++) {
            if (nums[i] > nums[lastPeakIndex-1] && nums[i] < nums[lastPeakIndex]) {
                index = i;
            }
        }

        swap(nums, lastPeakIndex-1, index);

        //Now sort asc from last peak index to end. Here from index is inclusive but last is not.
        Arrays.sort(nums, lastPeakIndex+1, size);

        System.out.println(nums);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {6,7,2,4,8,5,1};
        nextPermutation(nums);

        System.out.println(nums);
    }
}
