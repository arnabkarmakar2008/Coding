package com.example.coding.prefixsum.basic;

/**
 * Find index of an array such that sum of all left and right elements are equal.
 * arr[] = {-7, 1, 5, 2, -4, 3, 0}
 * Index 3 is the point as -7+1+5 = -4+3+0
 */
public class FindEquilibriumOfAnArray {
    /**
     * We have to use prefix sum
     * @param arr
     * @return
     */
    public static int findEquilibriumIndex(int[] arr) {
        //First calculate the total sum of the array
        int totalSum = 0;

        for (int element : arr) {
            totalSum += element;
        }

        int prefixSum = arr[0];

        //0th index and size-1th index cannot be the point as there are no left or right elements.
        for (int ct = 1; ct < arr.length-1; ct++) {
            int rightSum = totalSum - arr[ct] - prefixSum;

            if (prefixSum == rightSum) {
                return ct;
            } else {
                prefixSum += arr[ct];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 10, -4, 3, 0};
        System.out.println(findEquilibriumIndex(arr));
    }
}
