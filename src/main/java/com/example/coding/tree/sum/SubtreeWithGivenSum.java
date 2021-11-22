package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

public class SubtreeWithGivenSum {
    public Node root;

    public SubtreeWithGivenSum(int key) {
        this.root = new Node(key);
    }

    public SubtreeWithGivenSum() {
        this.root = null;
    }

    public static boolean flag;
    public static int counter;

    public int solve(Node node, int sum) {
        if (node == null) {
            return 0;
        }

        int leftSum = solve(node.left, sum);
        int rightSum = solve(node.right, sum);
        int nodeValue = node.key;

        if ((leftSum+rightSum+nodeValue) == sum) {
            flag = true;
            counter++;
        }

        return (leftSum+rightSum+nodeValue);
    }

    public static void main(String[] args) {
        SubtreeWithGivenSum tree = new SubtreeWithGivenSum(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(8);


        tree.solve(tree.root, 17);

        System.out.println(flag);
        System.out.println(counter);


    }
}
