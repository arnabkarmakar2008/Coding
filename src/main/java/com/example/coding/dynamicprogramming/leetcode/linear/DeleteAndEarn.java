package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * You are given an integer array nums. You want to maximize the number of points you get
 * by performing the following operation any number of times:
 *
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every
 * element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 */
public class DeleteAndEarn {

  /**
   * https://www.youtube.com/watch?v=qVfjmkL1naw
   * @param nums
   * @return
   */
  public static int deleteAndEarn(int[] nums) {


    int length = nums.length;

    int[] countArray = new int[10001]; //0 ... 10000

    //Store the count of each number in coutArray
    /**
     * IP = 3 2 3 7 4
     * countArray = 0 0 1 2 1 0 0 1 (count of 3 = 2, count of 2 = 1)
     * If we pick 3, then 2 and 4 will be deleted. So we can pick next 3 element as well. So if we select an element and it has
     * duplicates, then we will be  able to pick all duplicates as well.
     */
    for (int val : nums) {
      countArray[val]++;
    }

    int include = 0;
    int exclude = 0;

    for (int i=0; i<=10000; i++) {
      int newInclude = exclude + countArray[i]*i; // for including, we have to take previous exclude + current element
      int newExclude = Math.max(include, exclude); // for exclude, it will be max of pre include and exclude.

      include = newInclude;
      exclude = newExclude;
    }

    return Math.max(include, exclude);
  }

  public static void main(String[] args) {
    int[] nums = {2,2,3,3,3,4};
    System.out.println(deleteAndEarn(nums));
  }
}
