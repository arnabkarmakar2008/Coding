package com.example.coding.twopointers.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {

  /**
   * https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/1973113/100-Simple-Explanation
   * @param nums
   * @return
   */
  public static int removeDuplicates(int[] nums) {
    //As we are not going to change anything for element at index 0, starting pointer from 1.

    int leftPointer = 1;
    int rightPointer = 1;

    int counter = 1;

    //If rightCounter is encountering element for the first time then place it at leftPointer
    // and increase both left and right
    //else keep leftPointer and increment right.
    while (counter < nums.length) {
      if (nums[rightPointer-1] == nums[rightPointer]) {
        rightPointer++;
      } else {
        nums[leftPointer] = nums[rightPointer];
        leftPointer++;
        rightPointer++;
      }

      counter++;
    }

    return leftPointer;
  }

  public static void main(String[] args) {
    int[] nums = {0,0,1,1,1,2,2,3,3,4};
    System.out.println(removeDuplicates(nums));
  }
}
