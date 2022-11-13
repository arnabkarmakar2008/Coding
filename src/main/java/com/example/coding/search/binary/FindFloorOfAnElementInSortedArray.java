package com.example.coding.search.binary;

/**
 * https://www.youtube.com/watch?v=5cx0xerA8XY&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=11
 * Immediate lowest element from target
 *
 *
 *
 */
public class FindFloorOfAnElementInSortedArray {

    public static int findFloor(int[] nums, int element) {
        int start = 0;
        int end = nums.length-1;
        int answer = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if (nums[mid] == element) {
                return nums[mid];
            } else if (nums[mid] < element) {
                answer = nums[mid];
                start = mid+1;
            } else if (nums[mid] > element) {
                end = mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,8,10,10,12,19};
        int element = 5;
        System.out.println(findFloor(nums, element));
    }
}

