package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfAllNumberFormedFromRootToLeaf {

    Node root;

    public SumOfAllNumberFormedFromRootToLeaf(int key) {
        this.root = new Node(key);
    }

    public SumOfAllNumberFormedFromRootToLeaf() {
        root = null;
    }

    public static int solve(Node root, int val) {
        if (root == null) {
            return 0;
        }

        val = val*10 + root.key;

        if (root.right == null && root.left == null) {
            return val;
        }

        return solve(root.left, val) + solve(root.right, val);
    }

    public static void main(String[] args) {
        /**
         * IP =   6
         *      /  \
         *      3   5
         *     / \   \
         *    2   5  4
         * 632 + 635 + 654 = ?
         *
         *
         *
         */

        SumOfAllNumberFormedFromRootToLeaf tree = new SumOfAllNumberFormedFromRootToLeaf(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(8);
        System.out.println(tree.solve(tree.root, 0));
    }
}
