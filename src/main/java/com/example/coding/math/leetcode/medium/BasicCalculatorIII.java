package com.example.coding.math.leetcode.medium;

import java.util.Stack;

/**
 * This will need to handle both calculator I and Calculator II problem.
 * It will have +, -, *, / and ( and )
 *
 * https://www.youtube.com/watch?v=s_EKZnQUOp0
 *
 */
public class BasicCalculatorIII {
    public static int calculate(String str) {
        int sum = 0;
        int num = 0;

        /**
         * On (, we have to store stack and sign and reset sign.
         */

        Stack<Pair> stackPa = new Stack<>();
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
                cal(stack, num, sign);
            } else if (str.charAt(i) == '(') {
                stackPa.push(new Pair(stack, sign));
                sign = '+';
                stack = new Stack<>();
            } else if (str.charAt(i) == ')') {
                //Add all elements of stack
                int val = 0;
                while (!stack.isEmpty()) {
                    val += stack.pop();
                }

                //Restore sign
                Pair pair = stackPa.pop();
                stack = pair.st;
                sign = pair.sign;

                cal(stack, val, sign);
            } else if (str.charAt(i) != ' ') {
                sign = str.charAt(i);
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }

    public static void cal(Stack<Integer> stack, int val, char sign) {
        if (sign == '-') {
            stack.push(-val);
        } else if (sign == '+') {
            stack.push(val);
        } else if (sign == '*') {
            stack.push(val * stack.pop());
        } else if (sign == '/') {
            stack.push(stack.pop() / val);
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate("3*3+2-1"));
    }

    static class Pair {
        Stack<Integer> st;
        char sign;

        public Pair(Stack<Integer> st, char sign) {
            this.st = st;
            this.sign = sign;
        }
    }
}
