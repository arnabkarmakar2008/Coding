package com.example.coding.search.playlist;

/**
 * Search element in nearly sorted array. Nearly means an item can be in ith, i-1th or i+1th position.
 * e.g 1 3 6 4 7 in this array 6 should be in 3rd index. Instead 6 is in 2nd index. 4 should be in 2nd index. But it is
 * in 3rd index.
 */
public class SearchInNearlySortedArray {

  public static boolean search(int[] nums, int target) {
    int low = 0;
    int high = nums.length-1;

    while (low <= high) {
      int mid = (low+high)/2;

      if (nums[mid] == target) {
        return true;
      }


      if ( (mid+1) <= high &&  nums[mid+1] == target) {
        return true;
      }

      if ( (mid-1) >= low &&  nums[mid-1] == target) {
        return true;
      }

      if (target < nums[mid]) {
        high = mid-2;
      } else if (target > nums[mid]) {
        low = mid+2;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,2,4,5,6,8,7};
    System.out.println(search(nums, 3));
  }

}
