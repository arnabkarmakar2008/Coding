package com.example.coding.bst.leetcode;

import com.example.coding.tree.Node;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 */
public class LowestCommonAncestorOfBST {

    public static Node lowestCommonAncestor(Node root, int key1, int key2) {
        if (root == null) {
            return null;
        }

        if (root.key > key1 && root.key > key2) {
            return lowestCommonAncestor(root.left, key1, key2);
        } else if (root.key < key1 && root.key < key2) {
            return lowestCommonAncestor(root.right, key1, key2);
        } else {
            return root;
        }
    }


    public static void main(String[] args) {
        Node root = new Node (6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        Node lcaNode = lowestCommonAncestor(root, 4, 7);

        System.out.println("LCA Node :: " + lcaNode.key);
    }
}
