package com.example.coding.slidingwindow.variablesize;

public class LargestSubArrayOfSumK {
    public static void main(String[] args) {
        int[] intArray = {4,1,1,1,1,1,3,5};
        int windowSum = 8;
        largestSubArray(intArray, windowSum);
    }

    public static void largestSubArray(int[] intArray, int windowSum) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int maxSize = 0;

        while (end <= intArray.length-1) {
            sum = sum + intArray[end];

            if (sum < windowSum) {
                end ++;
            } else if (sum == windowSum) {
                maxSize = Math.max(maxSize, end - start +1);
                end ++;
            } else if ( sum > windowSum) {
                while (sum > windowSum) {
                    sum = sum - intArray[start];
                    start ++;
                }
                end ++;
            }
        }

        System.out.println("Largest subarray size = " + maxSize);
    }
}
