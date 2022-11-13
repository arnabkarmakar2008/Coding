package com.example.coding.search.binary;


/**
 * Aditya
 *
 * https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9
 *
 * Nearly sorted meaning : ith element can be in index i+1 or i-1;
 */
public class SearchInNearlySortedArray {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                return mid;
            } else if (mid-1 >= start && nums[mid-1] == target) {
                return mid-1;
            } else if (mid+1 <= end && nums[mid+1] == target) {
                return mid+1;
            } else if (target < nums[mid-1]) {
                end = mid-2;
            } else if (target > nums[mid+1]) {
                start = mid+2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] num = {5,10, 30, 20, 40};
        System.out.println(search(num, 20));
    }
}
