package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class PrintRightView {

    public static int MAX_LEVEL = 0;

    public static void printRight(Node root, int level) {
        if (root == null) {
            return;
        }

        if (MAX_LEVEL < level) {
            System.out.println(root.key);
            MAX_LEVEL = level;
        }

        printRight(root.right, level+1);
        printRight(root.left, level+1);

    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        printRight(root1, 1);

    }
}
