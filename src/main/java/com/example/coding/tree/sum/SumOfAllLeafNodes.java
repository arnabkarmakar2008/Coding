package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

public class SumOfAllLeafNodes {
    Node root;

    public SumOfAllLeafNodes(int key) {
        this.root = new Node(key);
    }

    public SumOfAllLeafNodes() {
        this.root = null;
    }

    public static int sum;

    public static void solve(Node root) {
        if (root == null) return;

        if (root.right == null && root.left == null) {
            sum = sum + root.key;
        }

        solve(root.left);
        solve(root.right);
    }

    public static void main(String[] args) {
        SumOfAllLeafNodes tree = new SumOfAllLeafNodes(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(8);
        tree.solve(tree.root);
        System.out.println(sum);
    }
}
