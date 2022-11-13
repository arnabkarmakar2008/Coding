package com.example.coding.bst.leetcode;

import com.example.coding.tree.Node;

/**
 * You are given the root of a binary search tree (BST),
 * where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without
 * changing its structure.
 *
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 */
public class RecoverBST {

    /**
     * https://leetcode.com/problems/recover-binary-search-tree/discuss/1962981/Idea-%3A-Inorder-Traversal-oror-Easy-to-understand
     *
     * Inorder traversal will give sorted array. Have to do inorder.
     *
     *
     * [4,8,9,40,10,60,80]
     *
     * In this inorder array 40 and 10 are not in correct position.
     * int first = -1;
     * int second = -1;
     * int prev = Integer.MIN_VALUE;
     *
     * for (int i=0; i<arr.len;i++) {
     *
     *     if (arr[i] < prev) {
     *         if (first == -1) {
     *             first = prev;
     *         }
     *
     *         second = arr[i]
     *     }
     *
     *     prev = arr[i];
     * }
     *
     * We have to do same for tree
     * @param root
     */

    public static Node first = null;
    public static Node second = null;
    public static Node previous = new Node(Integer.MIN_VALUE);

    public static void recoverTree(Node root) {
        if (root == null) return;
        recoverTree(root.left);

        //do operation here
        if (previous != null && root.key < previous.key) {
            if (first == null) {
                first = previous;
            }

            second = root;
        }

        previous = root;
        recoverTree(root.right);
    }

    public static void main(String[] args) {

    }
}
