package com.example.coding.slidingwindow;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] intArray = {10, 12, 8, 9, 10, 15, 31, 30, 29, 28};
        int k = 3;

        int max = maxSumSubArray(intArray, 3);
        System.out.println(max);
    }

    public static int maxSumSubArray(int[]  intArray, int subArraySize) {
        int maxSum = 0;
        int sum = 0;
        int windowStart = 0;
        int windowEnd = 0;

        while (windowEnd <= intArray.length -1) {
            sum = sum + intArray[windowEnd];

            if (windowEnd - windowStart + 1 < subArraySize) {
                windowEnd ++;
            } else if (windowEnd - windowStart + 1 == subArraySize) {
                maxSum = Math.max(sum, maxSum);
                sum = sum - intArray[windowStart];
                windowStart ++;
                windowEnd ++;
            }
        }

        return maxSum;
    }
}
