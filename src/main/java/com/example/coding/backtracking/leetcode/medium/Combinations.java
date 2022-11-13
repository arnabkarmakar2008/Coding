package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 */
public class Combinations {

  /**
   * https://www.youtube.com/watch?v=q0s6m7AiM7o
   * @param n
   * @param k
   * @return
   */
  public static List<List<Integer>> combine(int n, int k) {
    List<Integer> currentList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();

    backtrack(n, 1, k, currentList, resultList);

    return resultList;
  }

  public static void backtrack(int n, int start, int k, List<Integer> currentList, List<List<Integer>> resultList) {

    //base
    if (currentList.size() == k) {
      resultList.add(new ArrayList<>(currentList));
      return;
    }

    for (int i = start; i<=n; i++) {
      currentList.add(i);
      backtrack(n, i+1, k, currentList, resultList);
      currentList.remove(currentList.size()-1);
    }
  }

  public static void main(String[] args) {
    int n = 4;
    int k = 2;
    List<List<Integer>> resultList = combine(n, k);
    System.out.println(resultList);
  }
}
