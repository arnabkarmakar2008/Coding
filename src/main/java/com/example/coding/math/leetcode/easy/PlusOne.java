package com.example.coding.math.leetcode.easy;

/**
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer. The digits are ordered from
 * most significant to least significant in left-to-right order. The large integer does not
 * contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; //when digit is less than 9, result will be returned from here.
            }

            digits[i] = 0; //when digit is greater than 9 then 9+1 = 10. So 0.
        }

        int[] newArray = new int[digits.length + 1]; //digit contains all 9s. Then size will be one more
        newArray[0] = 1;
        return newArray;
    }

    public static void main(String[] args) {
        int[] digits = {1,2,3};
        int[] result = plusOne(digits);
    }
}
