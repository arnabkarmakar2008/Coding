package com.example.coding.twopointers.leetcode.medium;

/**
 * Given a 1-indexed array of integers numbers that is already sorted
 * in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an
 * integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 *
 * Your solution must use only constant extra space.
 */
public class TwoSumII {

  public static int[] twoSum(int[] numbers, int target) {
    int[] resultArray = new int[2];
    int startIndex = 0;
    int endIndex = numbers.length - 1;

    while (startIndex < endIndex) {
      int sum = numbers[startIndex] + numbers[endIndex];
      if (sum == target) {
        resultArray[0] = startIndex;
        resultArray[1] = endIndex;
        break;
      } else if (sum > target) {
        endIndex--;
      } else {
        startIndex++;
      }
    }

    return resultArray;
  }

  public static void main(String[] args) {
    int[] numbers = {2,7,11,15};
    int target = 13;

    int[] res = twoSum(numbers, target);

    System.out.println(res);
  }
}
