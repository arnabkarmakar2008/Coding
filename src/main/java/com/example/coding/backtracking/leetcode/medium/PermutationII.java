package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 *
 * https://www.youtube.com/watch?v=D6zucvsR2Tg
 *
 */
public class PermutationII {

  public static List<List<Integer>> permute(int[] nums) {
    List<Integer> currentList = new ArrayList<>();
    List<List<Integer>> answerList = new ArrayList<>();
    boolean[] used = new boolean[nums.length];


    Map<Integer, Integer> numberMap = new HashMap<>();

    for (int num : nums) {
      int count = numberMap.getOrDefault(num, 0);
      numberMap.put(num, count+1);
    }


    backtrack(nums, currentList, answerList, numberMap);

    return answerList;
  }

  public static void backtrack(int[] nums, List<Integer> currentList, List<List<Integer>> answerList, Map<Integer, Integer> numberMap) {
    //base case
    if (currentList.size() == nums.length) {
      answerList.add(new ArrayList<>(currentList));
      return;
    }

    for (Map.Entry<Integer, Integer> set : numberMap.entrySet()) {

      int key = set.getKey();
      int value = set.getValue();

      if (value > 0 ) {

        numberMap.put(key, numberMap.get(key)-1);

        currentList.add(key);
        backtrack(nums, currentList, answerList, numberMap);

        numberMap.put(key, numberMap.get(key)+1);
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
