package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class CheckSymmetricBinaryTree {

    public static boolean checkMirror(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }

        if ( a== null || b == null) {
            return false;
        }

        return (a.key == b.key) && checkMirror(a.left, b.right) && checkMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println(checkMirror(root.left, root.right));
    }


}
