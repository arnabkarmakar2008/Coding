package com.example.coding.tree.traversal;

import com.example.coding.tree.Node;

import java.util.Stack;

public class PreorderIterative {

    public static void preOrderIterative(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            Node temp = stack.pop();
            System.out.println(temp.key);

            if (temp.right!= null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

    }

    public static void main(String[] args) {
        Node root = new Node (1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        preOrderIterative(root);
    }
}
