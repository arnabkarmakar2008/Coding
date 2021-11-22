package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class CheckForSumTree {

    Node root;

    public CheckForSumTree(int value) {
        this.root = new Node(value);
    }

    public static int sumNode(Node node) {
        if (node == null) {
            return 0;
        }

        return sumNode(node.left) + node.key + sumNode(node.right);
    }

    public static int checkSumTree(Node root) {
        if (root == null || (root.right == null && root.left == null)) {
            return 1;
        }

        int ls;
        int rs;

        ls = sumNode(root.left);
        rs = sumNode(root.right);

        if ((root.key == (ls + rs)) && checkSumTree(root.left) != 0 && checkSumTree(root.right) !=0) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        CheckForSumTree tree = new CheckForSumTree(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        //tree.root.right.left = new Node(2);
        tree.root.right.right = new Node(2);

        System.out.println(checkSumTree(tree.root));
    }
}
