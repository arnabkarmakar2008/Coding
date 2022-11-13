package com.example.coding.greedy.leetcode.easy;

/**
 * Given an array of integers arr, return true if we can partition the array into three non-empty
 * parts with equal sums.
 *
 * Formally, we can partition the array if we can find indexes i + 1 < j
 * with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j]
 * + arr[j + 1] + ... + arr[arr.length - 1])
 */
public class PartitionArrayIn3EqualSum {

    public static boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        int eachPartSum = sum/3;
        int tempPartSum = 0;
        int partCount = 0;

        for (int i = 0; i < arr.length; i++) {
            tempPartSum += arr[i];

            if (tempPartSum == eachPartSum) {
                tempPartSum = 0;
                partCount++;
            }
        }

        return partCount >= 3 && sum%3 == 0;
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(canThreePartsEqualSum(arr));
    }
}
