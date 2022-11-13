package com.example.coding.search.binary;

/**
 * Aditya Verma Playlist
 * https://www.youtube.com/watch?v=4WmTRFZilj8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=7
 *
 */
public class NumberOfTimesSortedArrayIsRotated {

    /**
     * Number of rotation is equal to the index of min element
     * @param nums
     * @return
     */
    public static int numberOfTimesRotated(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;

            if ( (mid == 0 && nums[mid] < nums[mid+1]) || (mid == nums.length-1 && nums[mid] < nums[mid-1])) {
                return mid;
            } else if (nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]) {
                return mid;
            } else if (nums[start] <= nums[mid]) {
                start = mid+1;
            } else if (nums[mid] <= nums[end]) {
                end = mid-1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] nums= {11,12,15,18,2,5,6,8};
        System.out.println(numberOfTimesRotated(nums));
    }
}
