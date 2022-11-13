package com.example.coding.greedy.leetcode.easy;

/**
 * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s, split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of split balanced strings.
 */
public class SplitAStringInBalancedString {

    public static int balancedStringSplit(String s) {
        int leftCount = 0;
        int rightCount = 0;
        int resultCount = 0;


        for (int ct = 0; ct < s.length(); ct++) {
            char ch = s.charAt(ct);

            if (ch == 'L') {
                leftCount++;
            } else {
                rightCount++;
            }

            if (leftCount == rightCount) {
                resultCount++;
                leftCount = 0;
                rightCount = 0;
            }
        }

        return resultCount;
    }


    public static void main(String[] args) {
        String s = "RLLLLRRRLR";
        System.out.println(balancedStringSplit(s));
    }
}
