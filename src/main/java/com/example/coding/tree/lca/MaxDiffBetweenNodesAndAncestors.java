package com.example.coding.tree.lca;

import com.example.coding.tree.Node;

public class MaxDiffBetweenNodesAndAncestors {

    public static int MAX_DIFF = Integer.MIN_VALUE;

    public static int maxDiffUtil(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.key;
        }

        int value = Math.min(maxDiffUtil(node.left), maxDiffUtil(node.right));

        MAX_DIFF = Math.max(MAX_DIFF, (node.key - value));

        return Math.min(value, node.key);
    }

    public static void main(String[] args) {

        // Let us create binary tree given
        // in the above example
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        maxDiffUtil(root);
        System.out.println(MAX_DIFF);
    }
}
