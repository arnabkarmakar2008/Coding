package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumInBinaryTree {

    Node root;

    public MaxLevelSumInBinaryTree(int key) {
        this.root = new Node(key);
    }

    public MaxLevelSumInBinaryTree() {
        root = null;
    }

    public static int solve(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return root.key;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            while (size > 0) {
                Node temp = q.poll();
                sum = sum + temp.key;

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }

                size--;

            }

            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxLevelSumInBinaryTree tree = new MaxLevelSumInBinaryTree(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(-8);
        System.out.println(tree.solve(tree.root));

    }
}
