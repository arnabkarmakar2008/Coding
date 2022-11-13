package com.example.coding.greedy.leetcode.medium;

import java.util.Stack;

/**
 * Given string num representing a non-negative integer num, and an
 * integer k, return the smallest possible integer after removing k digits from num.
 */
public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        int length = num.length();

        if (length == k) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (int ct = 0; ct < num.length(); ct++) {
            char ch = num.charAt(ct);

            while (!stack.empty() && k > 0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }
}
