package com.example.coding.string.leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
 * so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 */
public class MinRemoveToMakeValidParantheses {

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int ct = 0; ct < s.length(); ct++) {
            char ch = s.charAt(ct);

            if (Character.isAlphabetic(ch)) {
                continue;
            }

            if (ch == '(') {
                stack.push(ct);
            } else {
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(ct);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>(stack);

        for (int i=0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));

            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }
}
