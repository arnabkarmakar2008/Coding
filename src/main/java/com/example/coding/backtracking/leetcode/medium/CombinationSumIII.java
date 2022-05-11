package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same
 * combination twice, and the combinations may be returned in any order.
 */
public class CombinationSumIII {

  /**
   *
   * @param k
   * @param n
   * @return
   */
  public static List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> resultList = new ArrayList<>();
    backtrack(1, k, n, new ArrayList<Integer>(), resultList);
    return resultList;
  }

  public static void backtrack(int start, int targetSize, int targetSum, List<Integer> currentList, List<List<Integer>> resultList) {
    if (targetSum == 0 && currentList.size() == targetSize) {
      resultList.add(new ArrayList<>(currentList));
      return;
    }

    if (targetSum < 0) {
      return;
    }


    for (int i = start; i <= 9; i++) {
      currentList.add(i);
      backtrack(i+1, targetSize, targetSum - i, currentList, resultList);
      currentList.remove(currentList.size()-1);
    }
  }

  public static void main(String[] args) {
    int k = 3;
    int sum = 9;
    List<List<Integer>> sumList = combinationSum3(k, sum);
    System.out.println(sumList);

  }
}
