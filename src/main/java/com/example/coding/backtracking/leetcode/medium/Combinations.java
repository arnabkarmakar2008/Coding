package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
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
