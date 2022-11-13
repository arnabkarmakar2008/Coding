package com.example.coding.math.leetcode.easy;

/**
 * Given an integer num, repeatedly add all its
 * digits until the result has only one digit, and return it.
 */
public class AddDigits {

    public static int addDigits(int num) {

        int sum = 0;

        while (num > 9) {

            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }

            num = sum;
            sum = 0;
        }

        return num;
    }

    public static void main(String[] args) {

    }
}
