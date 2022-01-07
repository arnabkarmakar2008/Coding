package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class FindNextRightNodeOfAKey {

    public static Node findNextRight(Node node, int key, int level, int[] v) {
        if (node == null) {
            return null;
        }

        if (node.key == key) {
            v[0] = level;
            return null;
        }

        if (v[0] != -1) {
            if (v[0] == level) {
                return node;
            }
        }

        Node leftNode = findNextRight(node.left, key, level+1, v);

        if (leftNode != null) {
            return leftNode;
        }

        return findNextRight(node.right, key, level+1, v);

    }

    public static void main(String[] args) {
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root.right.left.left = new Node(37);

        int[] v = new int[1];
        v[0] = 0;
        Node node = findNextRight(root, 25, 1, v);
        System.out.println(node.key);

    }
}
