package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

import java.util.Stack;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 *
 * The whole input represents a binary tree. It contains an integer followed by zero, one or
 * two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child
 * binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 * Input: "-4(2(3)(1))(6(5))"
 * Output: {-4,2,6,3,1,5}
 * Explanation:
 * The output is look like this:
 *       -4
 *      /  \
 *     2    6
 *    / \   /
 *   3   1 5
 */
public class ConstructFromStringWithBrackets {

    /**
     * https://www.youtube.com/watch?v=ye4b7nH0Hx8
     * @param str
     * @return
     */

    public static Node solve(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        int index = 0;
        int sign = 1;

        while (index < str.length()) {
            char ch = str.charAt(index);


            if (ch == '-') {
                sign = -1;
            }
            else if (Character.isDigit(ch)) {

                int num = 0;

                while (index < str.length() && Character.isDigit(str.charAt(index))) {
                    num = num*10 + Character.getNumericValue(str.charAt(index));
                    index++;
                }

                index--;

                Node node = new  Node(num * sign);

                //change sign back
                sign = 1;

                if (!stack.isEmpty()) {
                    Node root = stack.peek();

                    if (root.left == null) {
                        root.left = node;
                    } else {
                        root.right = node;
                    }
                }

                stack.push(node);



            } else if (ch == ')') {
                stack.pop();
            }

            index++;
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String str = "-4(2(3)(1))(6(5))";
        Node root = solve(str);
        System.out.println(root);
    }


}
