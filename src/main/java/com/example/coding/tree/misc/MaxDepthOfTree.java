package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class MaxDepthOfTree {

    public static int maxDepth(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = maxDepth(node.left);
        int rightHeight = maxDepth(node.right);

        return (Math.max(leftHeight, rightHeight) +1);
    }

    public static void main(String[] args) {
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root.right.left.left = new Node(37);
        System.out.println("Max Depth=" + maxDepth(root));
    }
}
