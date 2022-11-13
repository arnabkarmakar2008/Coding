package com.example.coding.matrix.hard;

/**
 * Given an array nums which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m subarrays.
 */
public class SplitArrayLargestSum {

    /**
     * This is same problem as allocate books.
     *
     * https://www.youtube.com/watch?v=okP-e2VpI_g&t=11s
     * @param nums
     * @param m
     * @return
     */
    public static int splitArray(int[] nums, int m) {
        int low = Integer.MIN_VALUE;
        int sum = 0;

        //answer should in between max element of the array and total sum of the array

        for (int i=0; i< nums.length; i++) {
            sum = sum + nums[i];
            low = Math.max(low, nums[i]);
        }

        int high = sum;
        int answer = 0;

        while (low <= high) {
            int mid = (low+high)/2;

            if (isPossibleToSplit(mid, nums, m)) {
                //reduce the range
                answer = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return answer;
    }

    /**
     * Is it possible to split nums array in m parts of sum target
     * @param target
     * @param nums
     * @param m
     * @return
     */
    private static boolean isPossibleToSplit(int target, int[] nums, int m) {
        int sum = 0;
        int splitCount = 1;

        for (int i=0; i< nums.length; i++) {
            sum = sum + nums[i];

            if (sum > target) {
                sum = nums[i];
                splitCount++;
            }
        }

        return splitCount <= m;
    }


    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;

        System.out.println(splitArray(nums, m));
    }
}
