package com.example.coding.greedy.leetcode.medium;

import java.util.Stack;

/**
 * Given a string s, remove duplicate letters so that every letter
 * appears once and only once. You must make sure your result is the smallest in
 * lexicographical order among all possible results.
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 */
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        int[] lastIndexArray = new int[26];
        boolean[] visitedArray = new boolean[26];

        for (int ct = 0; ct < s.length(); ct++) {
            char ch = s.charAt(ct);
            lastIndexArray[ch - 'a'] = ct;
        }

        Stack<Character> stack = new Stack<>();

        for (int ct = 0; ct < s.length(); ct++) {
            char ch = s.charAt(ct);

            if (visitedArray[ch - 'a']) {
                continue;
            }

            while (!stack.empty() && stack.peek() > ch && lastIndexArray[stack.peek() - 'a'] > ct) {
                visitedArray[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visitedArray[ch - 'a'] = true;

        }

        StringBuilder sb = new StringBuilder();

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();

    }


    public static void main(String[] args) {
        String input = "cbacdcbc";
        System.out.println(removeDuplicateLetters(input));
    }
}
