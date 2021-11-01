package com.example.coding.dynamicprogramming.mcm;

public class PalindromePartition {
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        /**
         * Min number of partition to make a string palindrome
         * IP str = "nitik"
         * OP = 2 n iti k
         */
        String str = "nitikrt";
        System.out.println(isPalindrome(str, 0, str.length()-1));
        System.out.println("Min Partition :: " + solve(str, 0, str.length()-1));
    }

    public static int solve(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (isPalindrome(str, i, j)) {
            return 0;
        }

        for (int k=i; k<=j-1; k++) {
            int temp = 1 + solve(str, i, k) + solve(str, k+1, j);

            if (temp < min) {
                min = temp;
            }
        }

        return min;
    }

    public static boolean isPalindrome(String str, int i, int j) {

        if (i == j) {
            return true;
        }

        if (i > j ) {
            return true;
        }

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
