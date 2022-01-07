package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class RemoveHalfNodes {

    public static Node removeHalfdNodes(Node root) {
        if (root == null) {
            return null;
        }

        Node leftChild = removeHalfdNodes(root.left);
        Node rightChild = removeHalfdNodes(root.right);

        if (leftChild == null && rightChild == null) {
            return root;
        }

        if (leftChild == null) {
            return root.right;
        }

        if (rightChild == null) {
            return root.left;
        }

        return root;
    }

}
