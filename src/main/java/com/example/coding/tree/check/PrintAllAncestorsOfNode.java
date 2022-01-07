package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class PrintAllAncestorsOfNode {

    public static boolean printAncestors(Node node, int k) {
        if (node == null) {
            return false;
        }

        if (node.key == k) {
            return true;
        }

        if (printAncestors(node.left, k) || printAncestors(node.right,k)) {
            System.out.println(node.key);
            return true;
        } else {
            return false;
        }


    }

    public static void main(String[] args) {

        // Let us create binary tree given
        // in the above example
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        printAncestors(root,8);
    }
}
