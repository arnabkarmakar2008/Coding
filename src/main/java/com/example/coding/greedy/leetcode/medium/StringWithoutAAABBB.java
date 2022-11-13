package com.example.coding.greedy.leetcode.medium;

/**
 * Given two integers a and b, return any string s such that:
 *
 * s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
 * The substring 'aaa' does not occur in s, and
 * The substring 'bbb' does not occur in s.
 */
public class StringWithoutAAABBB {

    /**
     * https://leetcode.com/problems/string-without-aaa-or-bbb/solution/
     * @param countA
     * @param countB
     * @return
     */

    public static String strWithout3a3b(int countA, int countB) {
        StringBuilder str = new StringBuilder();

        while (countA > 0 || countB > 0) {
            boolean appendA = false;
            int length = str.length();
            if (length >=2 && str.charAt(length-1) == str.charAt(length-2)) {
                if (str.charAt(length-1) == 'b') {
                    appendA = true;
                }
            } else {
                if (countA > countB) {
                    appendA = true;
                }
            }

            if (appendA) {
                countA--;
                str.append('a');
            } else {
                countB--;
                str.append('b');
            }
        }

        return str.toString();

    }


    public static void main(String[] args) {
        int a = 4;
        int b = 1;

        System.out.println(strWithout3a3b(a,b));
    }
}
