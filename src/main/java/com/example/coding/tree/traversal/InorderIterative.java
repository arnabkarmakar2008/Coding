package com.example.coding.tree.traversal;

import com.example.coding.tree.Node;

import java.util.Stack;

public class InorderIterative {

    public static void inOrderIterative(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (true) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.empty()) {
                    break;
                }

                current = stack.pop();
                System.out.println(current.key);
                current = current.right;
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

        inOrderIterative(root);
    }
}
