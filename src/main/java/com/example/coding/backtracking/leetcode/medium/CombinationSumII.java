package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all
 * unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {

  /**
   * https://www.youtube.com/watch?v=IER1ducXujU
   * @param candidates
   * @param target
   * @return
   */
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<Integer> elements = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
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

    for (int i = index; i<candidates.length; i++) {
      if (i == index || candidates[i] != candidates[i-1]) {
        elements.add(candidates[i]);
        recursion(i+1, candidates, target-candidates[i], elements, ans);
        elements.remove(elements.size()-1);
      }
    }

  }

  public static void main(String[] args) {
    int[] candidates = {10,1,2,7,6,1,5};
    Arrays.sort(candidates);
    List<List<Integer>> ans = combinationSum(candidates, 8);
    System.out.println(ans);
  }

}
