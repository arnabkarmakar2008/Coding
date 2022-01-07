package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class DistanceFromRootToGivenNode {

    public static int DIST;

    public static void calculateDistance(Node node, int key, int distance) {
        if (node == null) {
            return;
        }

        if (node.key == key) {
            DIST = distance;
        }

        calculateDistance(node.left, key, distance+1);
        calculateDistance(node.right, key, distance+1);
    }


    public static void main(String[] args) {
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root.right.left.left = new Node(37);

        calculateDistance(root, 37, 1);
        System.out.println(DIST);

    }
}
