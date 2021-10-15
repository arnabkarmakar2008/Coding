package com.example.coding.slidingwindow;


/**
 * Input: arr[] = {10, 12, 9, 8, 10, 15, 1, 3, 2}, K = 3
 * Output: 27
 * Explanation:
 * The subarray having K (= 3) consecutive elements is {9, 8, 10} whose sum of elements is 9 + 8 + 10 = 27, which is maximum.
 *
 * Input: arr[] = {7, 20, 2, 3, 4}, K = 2
 * Output: 7
 */
public class LargestSubArrayWithConsecutiveElements {
    public static void main(String[] args) {
        int[] intArray = {10, 12, 8, 9, 10, 15, 31, 30, 29, 28};
        int k = 3;

        int max = maxSubArray(intArray, 3);
        System.out.println(max);
    }

    public static int maxSubArray(int[]  intArray, int subArraySize) {

        int sum = 0;
        int windowLength = 0;
        int maxSum = 0;

        for (int index=0; index < intArray.length; index++ ) {
            if (index == 0) {
                sum = sum + intArray[index];
                windowLength = 1;
            } else {
                if (
                        (( ( (intArray[index - 1] + 1 == intArray[index] ) || (intArray[index - 1] -1 == intArray[index]))))
                        && windowLength <= subArraySize ) {
                    sum = sum + intArray[index];
                    windowLength ++;
                } else {
                    sum = intArray[index];
                    windowLength = 0;
                }
            }

            if (windowLength == subArraySize -1) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
