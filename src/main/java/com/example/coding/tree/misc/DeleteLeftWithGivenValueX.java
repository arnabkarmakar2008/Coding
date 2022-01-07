package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class DeleteLeftWithGivenValueX {

    public static Node deleteLeaf(Node root, int k) {
        if (root == null) {
            return null;
        }

        root.left = deleteLeaf(root.left, k);
        root.right = deleteLeaf(root.right, k);

        if (root.key == k && root.right== null && root.left == null) {
            return null;
        }

        return root;
    }
}
