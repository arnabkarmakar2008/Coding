package com.example.coding.twopointers.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */
public class IntersectionOfTwoArrays {

  public static int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> hashSet = new HashSet<>();

    Arrays.sort(nums1);

    for (int ct = 0; ct < nums2.length; ct++) {
      if (binarySearch(nums1, nums2[ct])) {
        hashSet.add(nums2[ct]);
      }
    }

    int[] resultArray = new int[hashSet.size()];
    int i = 0;
    for (Integer num : hashSet) {
      resultArray[i] = num;
      i++;
    }

    return resultArray;
  }

  public static boolean binarySearch(int[] nums, int target) {
    int low = 0;
    int high = nums.length-1;

    while (low <= high) {
      int mid = low + ((high - low)/2);

      if (nums[mid] == target) {
        return true;
      } else if (nums[mid] < target) {
        low = mid+1;
      } else {
        high = mid-1;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] num1 = {4,9,5};
    int[] num2 = {9,4,9,8,4};

    int[] intersectionArray = intersection(num1, num2);

    for (Integer num : intersectionArray) {
      System.out.println(num);
    }
  }
}
