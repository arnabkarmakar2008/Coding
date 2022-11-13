package com.example.coding.math.leetcode.medium;

import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 *
 * The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will
 * be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical
 * expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: s = " 3+5 / 2 "
 * Output: 5
 */
public class BasicCalculatorII {
    public static int calculate(String str) {
        int sum = 0;
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+'; //Setting it to + to insert first num in stack.

        for (int i=0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))) {
                int val = 0;

                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    val = val * 10 + (str.charAt(i) - '0');
                    i++;
                }

                i--; //decrement i as it has been increased in prev loop.
                num = val;

                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(num * stack.pop());
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
            } else if (str.charAt(i) != ' ') {
                sign = str.charAt(i);
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3*3+2-1"));
    }
}
