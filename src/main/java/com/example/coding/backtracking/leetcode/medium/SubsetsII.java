package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class SubsetsII {

  public static Set<List<Integer>> subsets(int[] nums) {
    List<Integer> currentList = new ArrayList<>();
    Set<List<Integer>> answerList = new HashSet<>();

    backtrack(nums, 0, currentList, answerList);

    return answerList;
  }

  public static void backtrack(int[] nums, int currentIndex, List<Integer> currentList, Set<List<Integer>> answerSet) {
    if (nums.length == currentIndex) {
      answerSet.add(new ArrayList<>(currentList));
      return;
    }

    int current = nums[currentIndex];
    backtrack(nums, currentIndex+1, currentList, answerSet);

    currentList.add(current);
    backtrack(nums, currentIndex+1, currentList, answerSet);
    currentList.remove(currentList.size()-1);
  }

  public static void main(String[] args) {
    int[] nums = {1,2,2};
    Set<List<Integer>> resultSet = subsets(nums);

    System.out.println(resultSet);
  }
}
