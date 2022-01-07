package com.example.coding.tree.lca;

import com.example.coding.tree.Node;

public class FindLCAOfDeepestNodes {


    /**
     * LCA by level *************
     * @param root
     * @param currentLevel
     * @param level
     * @return
     */
    public static Node findLCAByLevel(Node root, int currentLevel, int level) {
        if (root == null) {
            return null;
        }

        if (currentLevel == level) {
            return root;
        }

        Node leftNode = findLCAByLevel(root.left, currentLevel+1, level);
        Node rightNode = findLCAByLevel(root.right, currentLevel+1, level);

        if (leftNode != null && rightNode != null) {
            return root;
        }

        return leftNode!= null ? leftNode : rightNode;
    }

    public static int findHeightOfTree (Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeightOfTree(root.left);
        int rightHeight = findHeightOfTree(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        int level = findHeightOfTree(root);

        System.out.println(level);

        Node node = findLCAByLevel(root, 1, level);

        System.out.println("LCA of deepest node == " + node.key);
    }
}
