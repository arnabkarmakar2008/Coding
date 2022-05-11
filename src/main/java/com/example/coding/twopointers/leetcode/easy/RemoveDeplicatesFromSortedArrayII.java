package com.example.coding.twopointers.leetcode.easy;

public class RemoveDeplicatesFromSortedArrayII {

  public static int removeDuplicates(int[] nums) {
    int leftPointer = 2;
    int rightPointer = 2;




    while (rightPointer < nums.length) {
      if (nums[rightPointer] != nums[leftPointer-2]) {
        nums[leftPointer] = nums[rightPointer];
        leftPointer++;
        rightPointer++;
      } else {
        rightPointer++;
      }

    }

    return leftPointer;
  }


  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,3,3,3,4,4};
    System.out.println(removeDuplicates(nums));
  }
}
