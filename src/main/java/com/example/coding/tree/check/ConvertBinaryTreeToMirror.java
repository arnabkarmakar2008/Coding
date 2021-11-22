package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class ConvertBinaryTreeToMirror {

    public static Node convertMirror(Node root) {
        if (root == null) {
            return null;
        }

        Node left = convertMirror(root.left);
        Node right = convertMirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.key);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inOrder(root);

        System.out.println("===========");

        convertMirror(root);

        inOrder(root);

    }
}
