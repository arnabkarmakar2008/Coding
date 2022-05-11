package com.example.coding.sort.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 */
public class MajorityElementII {

  /**
   * For n elements there will be max 2 elements which will occur more than n/3 times.
   *
   * So lets say first element occurs (n/3+1) 2nd element = (n/3+1)
   * So rest of the elements will occur for n - (n/3+1) - (n/3+1) = n/3 - 2 which is less than n/3 -1. So max there
   * will be 2 element which can occur n/3+1 times.
   *
   * Idea is for n/3 there will be max 2 elements..n/4 there will be 3 elements and so on...
   *
   * https://www.youtube.com/watch?v=kymo4VgN-Qo
   *
   * @param nums
   * @return
   */
  public static List<Integer> majorityElement(int[] nums) {
    List<Integer> resultList = new ArrayList<>();
    int majorityElement1 = nums[0];
    int majorityCount1 = 0;

    int majorityElement2 = nums[0];
    int majorityCount2 = 0;

    for (int i=0; i< nums.length; i++) {

      if (nums[i] == majorityElement1) {
        majorityCount1++;
      } else if (nums[i] == majorityElement2) {
        majorityCount2++;
      } else if (majorityCount1 == 0) {
        majorityElement1 = nums[i];
        majorityCount1++;
      } else if (majorityCount2 == 0) {
        majorityElement2 = nums[i];
        majorityCount2++;
      } else {
        majorityCount1--;
        majorityCount2--;
      }

    }

    majorityCount1 = 0;
    majorityCount2 = 0;

    for (int i=0; i< nums.length; i++) {
      if (nums[i] == majorityElement1) {
        majorityCount1++;
      } else if (nums[i] == majorityElement2) {
        majorityCount2++;
      }
    }

    if (majorityCount1 > (nums.length/3)) {
      resultList.add(majorityElement1);
    }

    if (majorityCount2 > (nums.length/3)) {
      resultList.add(majorityElement2);
    }

    return resultList;
  }

  public static void main(String[] args) {
    int[] nums = {3,2,3,3,3,2,2,2,1};

    System.out.println(majorityElement(nums));
  }
}
