package com.example.coding.greedy.leetcode.medium;

/**
 * You are given an integer num. You can swap two digits at most once
 * to get the maximum valued number.
 *
 * Return the maximum valued number you can get.
 */
public class MaximumSwap {

    public static int maximumSwap(int num) {
        String numString = String.valueOf(num);

        int[] rightMaxIndexArray = new int[numString.length()];

        rightMaxIndexArray[numString.length()-1] = numString.length()-1;

        int rightMaxIndex = numString.length()-1;
        for (int ct = numString.length()-2; ct >=0; ct--) {
            int element = Integer.parseInt(String.valueOf(numString.charAt(ct)));
            int maxElement = Integer.parseInt(String.valueOf(numString.charAt(rightMaxIndex)));
            if (element > maxElement) {
                rightMaxIndex = ct;
                rightMaxIndexArray[ct] = ct;
            } else {
                rightMaxIndexArray[ct] = rightMaxIndex;
            }
        }

        StringBuilder stringBuilder = new StringBuilder(numString);

        for (int ct = 0; ct < rightMaxIndexArray.length; ct++) {
            int element = Integer.parseInt(String.valueOf(numString.charAt(ct)));
            int rightMaxElement = Integer.parseInt(String.valueOf(numString.charAt(rightMaxIndexArray[ct])));

            if (rightMaxElement > element) {
                stringBuilder.setCharAt(ct, Character.forDigit(rightMaxElement, 10));
                stringBuilder.setCharAt(rightMaxIndexArray[ct], Character.forDigit(element, 10));
                break;
            }
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) {
        int num = 99984592;

        System.out.println(maximumSwap(num));
    }
}
