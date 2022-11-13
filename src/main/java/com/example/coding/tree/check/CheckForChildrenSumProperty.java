package com.example.coding.tree.check;

import com.example.coding.tree.Node;

/**
 * Given a binary tree, the task is to check for every node,
 * its value is equal to the sum of values of its immediate left and right child.
 * For NULL values, consider the value to be 0.
 */
public class CheckForChildrenSumProperty {

    Node root;

    public CheckForChildrenSumProperty(int k) {
        this.root = new Node(k);
    }

    public static int childrenSum(Node root) {
        if (root == null || (root.left == null && root.right== null)) {
            return 1;
        }

        int lSum = 0;
        int rSum = 0;
        if (root.left != null) {
            lSum = root.left.key;
        }

        if (root.right != null) {
            rSum = root.right.key;
        }

        if (root.key == (lSum+rSum) && childrenSum(root.left)!=0 && childrenSum(root.right)!=0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        CheckForChildrenSumProperty tree = new CheckForChildrenSumProperty(8);
        tree.root.left = new Node(5);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(3);
        //tree.root.right.left = new Node(2);
        //tree.root.right.right = new Node(10);

        int flag = childrenSum(tree.root);
        System.out.println(flag);
    }

}
