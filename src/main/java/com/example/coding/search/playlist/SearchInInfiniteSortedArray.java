package com.example.coding.search.playlist;

public class SearchInInfiniteSortedArray {

  /**
   * Assign nums[1] as high. And compare target and high. If high is less than target then increase it by multiple of 2.
   *
   * @param nums
   * @param target
   * @return
   */
  public static boolean search(int[] nums, int target) {
    int low = 0;
    int high = 1;

    while (nums[high] < target) {
      low = high;
      high = high*2;
    }

    while (low <= high) {
      int mid = (low+high)/2;

      if (nums[mid] == target) {
        return true;
      } else if (target > nums[mid]) {
        low = mid+1;
      } else {
        high = mid-1;
      }


    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,16,20,22,25,28,30};
    int target = 25;

    System.out.println(search(nums, target));

  }
}
