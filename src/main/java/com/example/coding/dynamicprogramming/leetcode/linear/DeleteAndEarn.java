package com.example.coding.dynamicprogramming.leetcode.linear;

/**
 * You are given an integer array nums. You want to maximize the number of points you get
 * by performing the following operation any number of times:
 *
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every
 * element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 */
public class DeleteAndEarn {

  /**
   * The optimal final result can be derived by keep updating 2 variables skip_i, take_i, which stands for:
   * skip_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you skip the ith bucket.
   * take_i : the best result for sub-problem of first (i+1) buckets from 0 to i, while you take the ith bucket.
   *
   * DP formula:
   * take[i] = skip[i-1] + values[i];
   * skip[i] = Math.max(skip[i-1], take[i-1]);
   * take[i] can only be derived from: if you skipped the [i-1]th bucket, and you take bucket[i].
   * skip[i] through, can be derived from either take[i-1] or skip[i-1], whatever the bigger;
   *
   * https://leetcode.com/problems/delete-and-earn/discuss/109895/JavaC%2B%2B-Clean-Code-with-Explanation
   *
   * @param nums
   * @return
   */
  public static int deleteAndEarn(int[] nums) {
    int n = 10001;
    int[] values = new int[n];

    for (int num : nums) {
      values[num] += num;
    }

    int take = 0, skip = 0;

    for (int i=0; i<n; i++) {
      int takei = skip + values[i];
      int skipi = Math.max(take, skip);

      take = takei;
      skip = skipi;
    }

    return Math.max(take, skip);
  }

  public static void main(String[] args) {
    int[] nums = {2,2,3,3,3,4};
    System.out.println(deleteAndEarn(nums));
  }
}
