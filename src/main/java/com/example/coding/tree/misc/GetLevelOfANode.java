package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class GetLevelOfANode {

    public static int getLevelOfNode(Node node, int key, int level) {
        if (node == null) {
            return -1;
        }

        if (node.key == key) {
            return level;
        }

        int levelLeft = getLevelOfNode(node.left, key, level+1);

        if (levelLeft != -1) {
            return levelLeft;
        } else {
            return getLevelOfNode(node.right, key, level+1);
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        System.out.println(getLevelOfNode(root1, 3, 1));
    }
}
