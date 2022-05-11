package com.example.coding.twopointers.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets
 *  [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

  /**
   * https://www.code-recipe.com/post/three-sum
   * @param nums
   * @return
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> resultList = new ArrayList<>();

    for (int index1 = 0; index1+2 < nums.length; index1++) {

      //Duplicate check
      if (index1 > 0 && nums[index1] == nums[index1-1]) {
        continue;
      }


      int index2 = index1+1;
      int index3 = nums.length-1;

      while (index2 < index3) {
        if (nums[index1] + nums[index2] + nums[index3] == 0) {
          resultList.add(new ArrayList<>(Arrays.asList(index1, index2, index3)));
          index3--;

          //Have to perform duplicate check from right
          while (index2 < index3 && nums[index3] == nums[index3+1]) {
            index3--;
          }

        } else if (nums[index1] + nums[index2] + nums[index3] < 0) {
          index2++;
        } else {
          index3--;
        }
      }
    }

    return resultList;
  }

  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};
    List<List<Integer>> list = threeSum(nums);

    System.out.println(list);

  }
}
