package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 *
 */
public class Subsets {

  public static List<List<Integer>> subsets(int[] nums) {
    List<Integer> currentList = new ArrayList<>();
    List<List<Integer>> answerList = new ArrayList<>();

    backtrack(nums, 0, new ArrayList<>(), answerList);

    return answerList;
  }

  public static void backtrack(int[] nums, int currentIndex, List<Integer> currentList, List<List<Integer>> answerList) {
    /*if (nums.length == currentIndex) {
      answerList.add(new ArrayList<>(currentList));
      return;
    }

    int current = nums[currentIndex];
    backtrack(nums, currentIndex+1, currentList, answerList);

    currentList.add(current);
    backtrack(nums, currentIndex+1, currentList, answerList);
    currentList.remove(currentList.size()-1);
*/
    answerList.add(new ArrayList<>(currentList));

    for (int i=currentIndex; i< nums.length; i++) {
      currentList.add(nums[i]);
      backtrack(nums, i+1, currentList, answerList);
      currentList.remove(currentList.size()-1);
    }
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    List<List<Integer>> resultList = subsets(nums);

    System.out.println(resultList);
  }
}
