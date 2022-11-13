package com.example.coding.bst.leetcode;

import com.example.coding.tree.Node;

public class InOrderSuccessorinBST {

    public static Node inorderSuccessor(Node root, Node p) {
        Node successor = null;

        while (root != null) {
            if (root.key <= p.key) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        Node root = new Node (6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        Node successor = inorderSuccessor(root, new Node(0));

        System.out.println(successor.key);
    }
}
