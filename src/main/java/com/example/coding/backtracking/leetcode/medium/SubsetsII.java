package com.example.coding.backtracking.leetcode.medium;

import java.util.*;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class SubsetsII {

  public static List<List<Integer>> subsets(int[] nums) {
    List<Integer> currentList = new ArrayList<>();
    List<List<Integer>> answerList = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(nums, 0, currentList, answerList);

    return answerList;
  }

  public static void backtrack(int[] nums, int currentIndex, List<Integer> currentList, List<List<Integer>> answerList) {
    /**if (nums.length == currentIndex) {
      answerSet.add(new ArrayList<>(currentList));
      return;
    }

    int current = nums[currentIndex];

    //Including the current choice
    currentList.add(current);
    backtrack(nums, currentIndex+1, currentList, answerSet);
    currentList.remove(currentList.size()-1);

    while (currentIndex+1 < nums.length && nums[currentIndex] == nums[currentIndex+1]) {
      currentIndex += 1;
    }

    //Not including the current choice
    backtrack(nums, currentIndex+1, currentList, answerSet);**/

    answerList.add(new ArrayList<>(currentList));

    for (int i=currentIndex; i< nums.length; i++) {
      if (i > currentIndex && nums[i] == nums[i-1]) continue;
      currentList.add(nums[i]);
      backtrack(nums, i+1, currentList, answerList);
      currentList.remove(currentList.size()-1);
    }
  }

  public static void main(String[] args) {
    int[] nums = {1,2,2};
    List<List<Integer>> resultSet = subsets(nums);

    System.out.println(resultSet);
  }
}
