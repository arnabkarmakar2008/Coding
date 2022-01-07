package com.example.coding.tree.lca;

import com.example.coding.tree.Node;

public class FindLCAOfNodes {

    public static Node findLCA(Node root, int key1, int key2) {
        if (root == null || root.key == key1 || root.key == key2) {
            return root;
        }

        Node leftNode = findLCA(root.left, key1, key2);
        Node rightNode = findLCA(root.right, key1, key2);

        if (leftNode == null) {
            return rightNode;
        } else if (rightNode == null) {
            return leftNode;
        } else if ((leftNode != null && rightNode  != null))
        {
            return root;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        Node root = new Node (1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);

        Node lcsNode = findLCA(root, 5,7);
        System.out.println("LCA Key = " + lcsNode.key);
    }
}
