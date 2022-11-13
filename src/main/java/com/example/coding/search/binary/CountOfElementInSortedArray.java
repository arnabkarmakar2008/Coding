package com.example.coding.search.binary;

public class CountOfElementInSortedArray {

    public static int numberOfCount(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        int firstIndex = -1;
        int lastIndex = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                end = mid-1;
                firstIndex = mid;
            } else if (target < nums[mid]) {
                end = mid-1;
            } else if(target > nums[mid]) {
                start = mid+1;
            }
        }

        start = 0;
        end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == target) {
                start = mid+1;
                lastIndex = mid;
            } else if (target < nums[mid]) {
                end = mid-1;
            } else if (target > nums[mid]) {
                start = mid+1;
            }
        }

        return lastIndex-firstIndex+1;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,3,4,4,4,5,6};
        System.out.println("Count = " + numberOfCount(nums, 4));
    }
}
