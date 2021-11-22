package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

import java.util.Stack;

public class ConstructFromStringWithBrackets {

    static class Index {
        int leftStart;
        int leftClose;
        int rightStart;
        int rightClose;
    }

    public static Index findIndex(String str) {
        Stack<Character> s = new Stack<>();
        Index index = new Index();

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push('(');
            } else if (str.charAt(i) == ')') {
                s.pop();
            }

            if (s.size() == 1 && i > 1) {
                index.leftClose = i;
                index.rightStart = i+1;
                break;
            }
        }

        return index;
    }

    public static Node solve(String str) {
        if (str == null) {
            return null;
        }

        if (str.length() == 3) {
            return new Node(Integer.parseInt(""+str.charAt(1)));
        }

        Node root = new Node(Integer.parseInt(""+str.charAt(1)));

        Index indx = findIndex(str);

        root.left = solve(str.substring(2, indx.leftClose+1));
        root.right = solve(str.substring(indx.rightStart, (str.length()-1)));

        return root;
    }

    public static void main(String[] args) {
        String str = "(2(3(4)(5))(4))";
        Node root = solve(str);
        System.out.println(root);
    }


}
