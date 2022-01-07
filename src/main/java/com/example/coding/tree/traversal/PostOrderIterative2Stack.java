package com.example.coding.tree.traversal;

import com.example.coding.tree.Node;

import java.util.Stack;

public class PostOrderIterative2Stack {

    public static void postOrderIterative(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while(!stack1.empty()) {
            Node temp = stack1.pop();
            stack2.push(temp);

            if (temp.left != null) {
                stack1.push(temp.left);
            }

            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }

        while(!stack2.empty()) {
            System.out.println(stack2.pop().key);
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

        postOrderIterative(root);
    }
}
