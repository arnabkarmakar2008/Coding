package com.example.coding.greedy.leetcode.medium;

import java.util.Stack;

/**
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 *
 * The following rules define a valid string:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 */
public class ValidParenthesisString {

    /**
     * https://www.youtube.com/watch?v=2H9gMIIGyvY
     * @param s
     * @return
     */
    public static boolean checkValidString(String s) {

        int balance = 0;

        for (int i=0; i<=s.length()-1; i++) {
            if (s.charAt(i) == ')') {
                balance--;
            } else {
                balance++;
            }

            if (balance < 0) return false;
        }

        if (balance == 0) {
            return true;
        }

        //If balance > 0 then it is not possible to tell at this point balanced or not.

        balance = 0;
        //Traverse from right to left and watch for extra open bracket
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '(') {
                balance--;
            } else {
                balance++;
            }

            if (balance < 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        String str = "(((*))";
        System.out.println(checkValidString(str));
    }
}
