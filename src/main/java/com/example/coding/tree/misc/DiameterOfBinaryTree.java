package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class DiameterOfBinaryTree {
    //From a node, dia = 1 + height of left subtree + height of right subtree
    // Need to calculate dia for each node and update max

    static class MaxStore {
        int MAX = Integer.MIN_VALUE;
    }

    public static int diameter(Node node, MaxStore maxStore) {
        if (node == null) {
            return -1;
        }

        int leftHeight = diameter(node.left, maxStore);
        int rightHeight = diameter(node.right, maxStore);

        maxStore.MAX = Math.max(maxStore.MAX, (1+leftHeight+rightHeight));

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root.right.left.left = new Node(37);
        MaxStore maxStore = new MaxStore();

        diameter(root, maxStore);
        System.out.println("Dia=" + maxStore.MAX);
    }
}
