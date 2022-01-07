package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

public class MaxPathSumOfBinaryTree {

    public static int MAX_SUM = Integer.MIN_VALUE;

    public static int maxPathSumTraverse( Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = maxPathSumTraverse(node.left);
        int rightSum = maxPathSumTraverse(node.right);

        MAX_SUM = Math.max(MAX_SUM, (node.key + leftSum + rightSum));

        return node.key + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left = new Node(2);
        root.right = new Node(8);
        root.right.left = new Node(-9);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(6);
        root.left.right.right.left = new Node(10);
        maxPathSumTraverse(root);
        System.out.println(MAX_SUM);
    }
}
