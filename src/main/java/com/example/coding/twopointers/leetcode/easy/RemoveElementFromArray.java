package com.example.coding.twopointers.leetcode.easy;

public class RemoveElementFromArray {

  public static int removeElement(int[] nums, int val) {
    int counter = 0;

    for (int index=0; index< nums.length; index++) {
      if (nums[index] != val) {
        nums[counter] = nums[index];
        counter++;
      }
    }

    return counter;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,2,2,3,0,4,2};
    System.out.println(removeElement(nums, 2));
  }
}
