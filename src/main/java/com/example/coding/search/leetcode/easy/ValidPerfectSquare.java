package com.example.coding.search.leetcode.easy;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 */
public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;

        while (low <= high) {
            int mid = (low+high)/2;

            int midsquare = mid * mid;

            if (midsquare == num) {
                return true;
            } else if (midsquare > num) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(isPerfectSquare(17));
    }

}
