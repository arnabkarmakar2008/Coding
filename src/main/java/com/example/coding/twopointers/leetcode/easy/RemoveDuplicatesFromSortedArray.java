package com.example.coding.twopointers.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {

  /**
   *
   * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
   * that each unique element appears only once. The relative order of the elements should be kept the same.
   *
   * Since it is impossible to change the length of the array in some languages, you must instead have the
   * result be placed in the first part of the array nums. More formally, if there are k elements after
   * removing the duplicates, then the first k elements of nums should hold the final result.
   * It does not matter what you leave beyond the first k elements.
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
