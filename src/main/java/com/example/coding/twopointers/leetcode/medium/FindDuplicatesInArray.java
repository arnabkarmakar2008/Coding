package com.example.coding.twopointers.leetcode.medium;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is
 * in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindDuplicatesInArray {

  /**
   * Floyd's Cycle Detection Algo here....
   *
   * https://www.youtube.com/watch?v=dfIqLxAf-8s
   *  0 1 2 3 4
   * [3,4,1,4,2]
   *
   * 0th index value is 3, so go to index 3: value is 4; go to index 4: value is 2; go to index 2: value is 1
   * ; go to index 1: value is 4.
   *
   * So the linked list will look like 3 -> 4 -> 2 -> 1 -> 4 (cycle here from already existing node 4)
   *
   * Floyds Algo : Use fast and slow pointer. When fast == slow, assign fast/slow = head and move both pointer by 1.
   * When equal that will be duplicate element. And duplicate will occur before loop starting point.
   * Loop starting point will have more than one incoming edge from repeating element.
   *
   * Note :::: This will not work if element start from 0.
   * @param nums
   * @return
   */
  public static int findDuplicate(int[] nums) {
    int slowPointer = nums[0];
    int fastPointer = nums[0];

    do {
      slowPointer = nums[slowPointer];
      fastPointer = nums[nums[fastPointer]];
    } while (slowPointer != fastPointer);

    fastPointer = nums[0];

    while (slowPointer != fastPointer) {
      slowPointer = nums[slowPointer];
      fastPointer = nums[fastPointer];
    }

    return fastPointer;
  }

  public static void main(String[] args) {
    int[] nums = {3,4,1,4,2};
    System.out.println(findDuplicate(nums));
  }
}
