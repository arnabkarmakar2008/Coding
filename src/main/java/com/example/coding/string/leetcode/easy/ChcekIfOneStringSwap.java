package com.example.coding.string.leetcode.easy;

public class ChcekIfOneStringSwap {

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int diff1 = -1;
        int diff2 = -1;

        for (int ct = 0; ct < s1.length(); ct++) {
            if (s1.charAt(ct) != s2.charAt(ct)) {
                if (diff1 == -1) {
                    diff1++;
                } else if (diff2 == -1) {
                    diff2++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "attack";
        String s2 = "defend";
        System.out.println(areAlmostEqual(s1, s2));
    }
}
