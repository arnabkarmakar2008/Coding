package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

public class FindDeepestNode {

    public static Node deepestNode;
    public static int MAX_LEVEL = Integer.MIN_VALUE;

    public static int findMaxDepth(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(findMaxDepth(node.left), findMaxDepth(node.right)) + 1;
    }

    public static void deepestNode(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.println(node.key);
        }

        if (level > 1) {
            deepestNode(node.left, level-1);
            deepestNode(node.right, level-1);
        }
    }

    public static void findDeepestNodeWithoutRecursion(Node root, int level) {
        if (root == null) {
            return;
        }

        if (root != null) {
            findDeepestNodeWithoutRecursion(root.left, ++level);

            if (level > MAX_LEVEL) {
                deepestNode = root;
                MAX_LEVEL = level;
            }

            findDeepestNodeWithoutRecursion(root.right, level);
        }


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
        //int maxHeight = findMaxDepth(root);
        //deepestNode(root, maxHeight);


        /////
        findDeepestNodeWithoutRecursion(root, 0);
        System.out.println(deepestNode.key);

    }
}
