package com.example.coding.math.basic;

public class PalindromeNumber {
    /**
     * Have to reverse the num and then match.
     *
     * Reverse 124.
     * 1. 4
     * 2. 4*10 + 2 = 42
     * 3. 42*10 + 1 = 421
     *
     *
     * @param n
     * @return
     */

    public static boolean isPalindromeNum(int n) {
        /**
         * 404. How to get the first digit = 404%10 = 4 Then for 2nd digit 404/10 = 40. Again get 2nd digit 40%10 = 0
         *
         */
        int orgNumber = n;
        int prevDigit = 0;
        int revNumber = 0;

        while (n > 0) {
            revNumber = 10 * prevDigit + (n%10);
            prevDigit = revNumber;
            n = n/10;
        }

        return orgNumber == revNumber;


    }

    public static void main(String[] args) {
        int n = 403;

        System.out.println(isPalindromeNum(n));
    }
}
