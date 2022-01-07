package com.example.coding.tree.lca;

import com.example.coding.tree.Node;

public class DistanceBetweenTwoNodes {
    /**
     * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
     */

    public static int d1;
    public static int d2;
    public static int dist;

    public static int findLevel(Node root, int key, int level) {
        if (root == null) {
            return -1;
        }

        if (root.key == key) {
            return level;
        }

        int leftLevel = findLevel(root.left, key, level+1);

        if (leftLevel != -1) {
            return leftLevel;
        } else {
            return findLevel(root.right, key, level+1);
        }
    }

    public static Node findLCAAndPopulateDistance(Node root, int k1, int k2, int level) {
        if (root == null) {
            return root;
        }

        if (root.key == k1) {
            d1 = level;
            return root;
        }

        if (root.key == k2) {
            d2 = level;
            return root;
        }

        Node leftNode = findLCAAndPopulateDistance(root.left, k1, k2, level+1);
        Node rightNode = findLCAAndPopulateDistance(root.right, k1, k2, level+1);

        if (leftNode != null && rightNode != null) {
            //LCA found
            dist = d1 + d2 - (2 * level);
            return root;
        }

        return leftNode != null ? leftNode : rightNode;

    }

    public static int findDistance(Node root, int k1, int k2) {
        d1 = -1;
        d2 = -1;
        dist = 0;
        Node lca = findLCAAndPopulateDistance(root, k1, k2, 1);

        if (d1 != -1 && d2 != -1) {
            return dist;
        }

        if (d1 != -1) {
            dist = findLevel(lca, k2, 0);
            return dist;
        }

        if (d2 != -1) {
            dist = findLevel(lca, k1, 0);
            return dist;
        }

        return -1;
    }

    public static void main(String[] args)
    {

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
        //System.out.println("Dist(4, 5) = " + findDistance(root, 4, 5));
        //System.out.println("Dist(4, 6) = " + findDistance(root, 4, 6));
        //System.out.println("Dist(3, 4) = " + findDistance(root, 3, 4));
        System.out.println("Dist(2, 4) = " + findDistance(root, 2, 4));
        //System.out.println("Dist(8, 5) = " + findDistance(root, 8, 5));
    }
}
