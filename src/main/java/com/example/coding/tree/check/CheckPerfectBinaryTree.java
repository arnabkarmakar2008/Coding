package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree, write a function to check whether the given Binary Tree is a perfect
 * Binary Tree or not.
 * A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all
 * leaves are at same level.
 */
public class CheckPerfectBinaryTree {
    Node root;

    public CheckPerfectBinaryTree(int k) {
        this.root = new Node(k);
    }

    private int findDepthOfLeftLeaf(Node node) {
        int level = 0;

        while (node != null) {
            node = node.left;
            level++;
        }

        return level;
    }

    public static boolean checkPerfectBinaryTree(Node root, int depthOfLeftMostLeaf, int level) {

        if (root == null) {
            return true;
        }

        //If leaf node then its depth must be same as depthOfLeftMostLeaf
        if (root.left == null && root.right == null) {
            return depthOfLeftMostLeaf == level+1;
        }

        //If internal node and one child is empty
        if (root.left == null || root.right == null) {
            return false;
        }
        return checkPerfectBinaryTree(root.left, depthOfLeftMostLeaf, level+1) &&
                checkPerfectBinaryTree(root.right, depthOfLeftMostLeaf, level+1);

    }

    public static void main(String[] args) {
        CheckPerfectBinaryTree tree = new CheckPerfectBinaryTree(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(9);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(10);

        int d = tree.findDepthOfLeftLeaf(tree.root);

        System.out.println(checkPerfectBinaryTree(tree.root, d, 0));
    }
}
