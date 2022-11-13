package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less
 * than 150 combinations for the given input.
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 */
public class CombinationSum {

  /**
   * https://www.youtube.com/watch?v=OyZFFqQtu98
   * @param candidates
   * @param target
   * @return
   */
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<Integer> elements = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    recursion(0,candidates, target, elements, ans);
    return ans;
  }

  public static void recursion(int index, int[] candidates, int target, List<Integer> elements, List<List<Integer>> ans) {
    if (target == 0) {
      ans.add(new ArrayList<>(elements));
      return;
    }

    if (target < 0) {
      return;
    }
    //If we pick up the element
    for (int i = index; i<candidates.length; i++) {
      elements.add(candidates[i]);
      recursion(i, candidates, target-candidates[i], elements, ans);
      elements.remove(elements.size()-1);
    }
  }


  public static void main(String[] args) {
    int[] candidates = {1,2};
    List<List<Integer>> ans = combinationSum(candidates, 3);
    System.out.println(ans);
  }

}
