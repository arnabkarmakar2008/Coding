package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class ReplaceNodeWithDepth {

    public static void replaceDepth(Node root, int level) {
        if (root == null) {
            return;
        }

        root.key = level;

        replaceDepth(root.left, level+1);
        replaceDepth(root.right, level+1);

    }

    public static void main(String[] args) {
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root.right.left.left = new Node(37);
        root.right.left.left.left = new Node(38);
        replaceDepth(root, 0);
        System.out.println(root.key);
    }
}
