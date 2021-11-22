package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class CheckForChildrenSumProperty {

    Node root;

    public CheckForChildrenSumProperty(int k) {
        this.root = new Node(k);
    }

    public static boolean checkFlag = true;

    public static int childrenSum(Node root) {
        if (root == null) {
            return 0;
        }
        int lSum = 0;
        int rSum = 0;
        if (root.left != null) {
            lSum = childrenSum(root.left);
        }

        if (root.right != null) {
            rSum = childrenSum(root.right);
        }

        if ((lSum+rSum) != 0 && root.key != (lSum+rSum)) {
            checkFlag = false;
        }

        return root.key;

    }

    public static void main(String[] args) {
        CheckForChildrenSumProperty tree = new CheckForChildrenSumProperty(8);
        tree.root.left = new Node(5);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(2);
        //tree.root.right.left = new Node(2);
        //tree.root.right.right = new Node(10);

        childrenSum(tree.root);
        System.out.println(checkFlag);
    }

}
