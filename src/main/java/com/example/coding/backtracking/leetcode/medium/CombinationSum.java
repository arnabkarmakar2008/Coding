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
 */
public class CombinationSum {

  /**
   * https://leetcode.com/problems/combination-sum/discuss/1777334/C%2B%2BorDetailed-Explanation-w-TREE-DIAGRAMor-RECURSION-%2B-BACKTRACKINGor-EACH-STEP-EXPLAINED
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

    for (int i=index; i<candidates.length; i++) {
      //When we consider element then we do not increase index as same candidate can be used multiple times.
      //if (target - candidates[i] > 0) {
        elements.add(candidates[i]);
        recursion(i, candidates, target - candidates[i], elements, ans);
        elements.remove(elements.size() - 1);
      //}
    }
  }

  public static void main(String[] args) {
    int[] candidates = {1,2};
    List<List<Integer>> ans = combinationSum(candidates, 3);
    System.out.println(ans);
  }

}
