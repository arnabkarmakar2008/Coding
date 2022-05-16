package com.example.coding.search.leetcode.medium;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the
 * array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 *
 */
public class FindMinimumInRotatedSortedArray {

  /**
   * Divide array in two parts. First element of the 2nd part will be the lowest element of the array.
   *
   * Only first element of 2nd part will be lesser than its left element. Otherwise all elements of array will
   * be greater than its left element.
   *
   * Last element of the 1st part will be greater than its right element.
   *
   * @param nums
   * @return
   */
  public static int findMin(int[] nums) {
    int low = 0;
    int high = nums.length-1;

    //If array is rotated for n times then elements will be in original order. So just return first element from the array
    if (nums[low] <= nums[high]) {
      return nums[low];
    }

    while (low <= high) {

      int mid = (low+high)/2;

      if (nums[mid] > nums[mid+1]) {
        //This is the last element of 1st half

        //Note : we have to write this loop first for test case like below:
        // 5 1 2 3 4
        return mid+1;
      } else if (nums[mid] < nums[mid-1]) {
        //This is the first element of 2nd half
        return mid;
      } else if (nums[mid] >= nums[low]) {
        //Min will always lie in unsorted part. This is checking if 1st part is sorted then discard first part
        low = mid+1;
      } else if (nums[mid] <= nums[high]) {
        //This is checking if second part is sorted then discard 2nd part
        high = mid-1;
      }
    }

    return -1;

  }



  public static void main(String[] args) {
    int[] nums = {3,4,5,1,2};
    System.out.println(findMin(nums));
  }
}
