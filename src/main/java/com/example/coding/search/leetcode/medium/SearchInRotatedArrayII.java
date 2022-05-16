package com.example.coding.search.leetcode.medium;

/**
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 *
 * You must decrease the overall operation steps as much as possible.
 *
 * NOTE :: Same as "Search in rotated array", but iut
 */
public class SearchInRotatedArrayII {

  /**
   * https://www.youtube.com/watch?v=1uu3g_uu8O0
   *
   * Get mid. Either low->mid or mid->high will be sorted. Now decide which part the target can belong. Discard other half.
   * @param nums
   * @param target
   * @return
   */
  public static boolean search(int[] nums, int target) {

    int low = 0;
    int high = nums.length-1;

    while (low <= high) {

      while (low < high && nums[low] == nums[low+1]) {
        low++;
      }

      while (low < high && nums[high] == nums[high-1]) {
        high--;
      }

      int mid = (low+high)/2;

      if (nums[mid] == target) {
        return true;
      } else if (nums[low] <= nums[mid]) {
        if (target >= nums[low] && target < nums[mid]) {
          high = mid-1;
        } else {
          low = mid+1;
        }
      } else if (nums[high] > nums[mid]) {
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid-1;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] nums = {2,5,6,0,0,1,2};

    System.out.println(search(nums, 3));
  }
}
