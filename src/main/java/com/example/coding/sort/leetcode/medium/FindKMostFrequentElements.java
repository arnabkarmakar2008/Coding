package com.example.coding.sort.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 */
public class FindKMostFrequentElements {

  /**
   * It is bucket sort.
   *
   * Take hashmap and put count of all elements.
   * Now create take an array of size nums.length. We will store the frequency of occurrence of the
   * elements in that array.
   *
   * https://leetcode.com/problems/top-k-frequent-elements/discuss/81602/Java-O(n)-Solution-Bucket-Sort
   *
   * @param nums
   * @param k
   * @return
   */
  public static List<Integer> topKFrequent(int[] nums, int k) {

    Map<Integer,Integer> map = new HashMap<>();

    for (int i=0; i< nums.length; i++) {
      int mapValue = map.getOrDefault(nums[i],0);
      map.put(nums[i], mapValue+1);
    }

    List<Integer>[] bucket = new List[nums.length+1];

    for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
      int key = mapEntry.getKey();
      int value = mapEntry.getValue();

      if (bucket[value] == null) {
        bucket[value] = new ArrayList<>();
      }

      bucket[value].add(key);

    }

    List<Integer> resultList = new ArrayList<>();

    for (int counter = bucket.length-1; counter >= 0 && resultList.size()<k; counter--) {
      if (bucket[counter] != null) {
        resultList.addAll(bucket[counter]);
      }
    }

    return resultList;

  }


  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,3};
    int k = 2;
    List<Integer> resultList = topKFrequent(nums, k);
    System.out.println(resultList);
  }
}
