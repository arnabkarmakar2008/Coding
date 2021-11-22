package com.example.coding.tree;

public class LargestSubtreeSum {
    public Node root;

    int maxSum = Integer.MIN_VALUE;

    public LargestSubtreeSum(int key) {
        this.root = new Node(key);
    }

    public LargestSubtreeSum() {
        this.root = null;
    }

    public int solve(Node node) {
        if (node == null) {
            return 0;
        }

        int leftSum = solve(node.left);
        int rightSum = solve(node.right);
        int nodeValue = node.key;
        maxSum = Math.max(maxSum, (leftSum+rightSum+nodeValue));

        return (leftSum+rightSum+nodeValue);
    }

    public static void main(String[] args) {
        LargestSubtreeSum tree = new LargestSubtreeSum(1);
        tree.root.left = new Node(-2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(-6);
        tree.root.right.right = new Node(2);

        int value = tree.solve(tree.root);

        System.out.println(value);


    }
}
