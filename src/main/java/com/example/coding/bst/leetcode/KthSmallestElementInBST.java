package com.example.coding.bst.leetcode;

import com.example.coding.tree.Node;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 */
public class KthSmallestElementInBST {

    public static int count = 0;
    public static int result = Integer.MIN_VALUE;


    public static int kthSmallest(Node root, int k) {
        traverse(root, k);
        return result;
    }

    private static void traverse(Node root, int k) {
        if (root == null) return;

        traverse(root.left, k);
        count++;

        if (count == k) {
            result = root.key;
        }

        traverse(root.right, k);
    }

    public static void main(String[] args) {
        Node root = new Node (6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

    }
}
