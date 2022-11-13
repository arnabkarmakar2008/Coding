package com.example.coding.math.leetcode.medium;

import java.util.Stack;

/**
 * Given a string s representing a valid expression,
 * implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings
 * as mathematical expressions, such as eval().
 * String contains + - ( )
 */
public class BasicCalculator {

    /**
     * https://www.youtube.com/watch?v=HUfUzA9Ekgo
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {

        int sum = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                //if number is 123. Then we have to take 1, then 10+2 = 12, then 12*10+3 = 123
                int val = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val *10 + (s.charAt(i) - '0');
                    i++;
                }

                i--; // i will be increased in prev loop. so decrease
                val = val * sign;
                sum += val;
                sign = 1; //reset sign

            } else if (ch == '(') {
                //put sum in stack and then put sign in stack
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;

            } else if (ch == ')') {
                //pop sign from stack. Then add sum from stack to current sum
                sum = sum * stack.pop();
                sum = sum + stack.pop();

            } else if (ch == '-') {
                //toggle sign here
                sign = sign * -1;
            }
        }

        return sum;

    }


    public static void main(String[] args) {
        System.out.println(calculate("1+2-4"));
    }
}
