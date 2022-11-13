package com.example.coding.search.binary;

public class BinarySearchOrderNotKnownArray {

    /**
     * Aditya Verma Playlist
     *
     * https://www.youtube.com/watch?v=gY2b-Q6wDEM&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=4
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int reverseSortedArray(int[] nums, int target) {

        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        int start = 0;
        int end = nums.length-1;
        boolean ascending = false;

        if (nums[start] < nums[end]) {
            ascending = true;
        }

        while (start <= end) {
            int mid = start + (start+end)/2;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {

                if (ascending) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            } else {
                if (ascending) {
                    end = mid-1;
                } else {
                    start = mid + 1;
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {20,17,15,14,13,12,10,9,8,4};
        System.out.println("Search index = " + reverseSortedArray(nums, 17));
    }
}
