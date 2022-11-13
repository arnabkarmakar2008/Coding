package com.example.coding.search.binary;

public class MinimumDiffElementInSortedArray {

    public static int solve(int[] nums, int element) {
        int start = 0;
        int end = nums.length-1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == element) {
                return 0;
            } else if (element > nums[mid]) {
                start = mid+1;

            } else {
                end = mid-1;
            }
        }

        //start will be the position if we were to insert element in the array. So we will get min
        //from element - nums[start-1]

        return element - nums[start-1];
    }


    public static void main(String[] args) {
        int[] nums = {4,6,10};
        int key = 7;
        System.out.println(solve(nums, key));
        //Find array element which will give min diff with key element.
    }
}
