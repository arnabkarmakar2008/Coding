package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Solution : https://www.youtube.com/watch?v=Nabbpl7y4Lo
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class Permutations {


  /**
   * Backtrack recipe
   *
   * void backtrack(res, arguments) {
   *
   *   if (goal reached) {
   *     add solution to result
   *     return
   *   }
   *
   *   for (int i=0; i< number of choices; i++) {
   *     if (choices[i] is valid) {
   *       make choices[i]
   *       backtrack(res, arguments)
   *       undo choices[i]
   *     }
   *   }
   * }
   *
   * @param nums
   * @return
   */


  public static List<List<Integer>> permute(int[] nums) {
    List<Integer> currentList = new ArrayList<>();
    List<List<Integer>> answerList = new ArrayList<>();
    boolean[] used = new boolean[nums.length];

    backtrack(nums, currentList, answerList, used);

    return answerList;
  }

  public static void backtrack(int[] nums, List<Integer> currentList, List<List<Integer>> answerList, boolean[] used) {
    //base case
    if (currentList.size() == nums.length) {
      answerList.add(new ArrayList<>(currentList));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!used[i]) {
        used[i] = true;
        currentList.add(nums[i]);
        backtrack(nums, currentList, answerList, used);
        used[i] = false;
        currentList.remove(currentList.size()-1);
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {1,1,2};
    List<List<Integer>> answerList = permute(nums);
    System.out.println(answerList.size());
  }
}


