package com.example.coding.tree.check;

import com.example.coding.tree.Node;

public class CheckIdenticalTree {

    public static boolean checkIdentical (Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.key == root2.key) && checkIdentical(root1.left, root2.left)
                && checkIdentical(root1.right, root2.right);

    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        System.out.println(checkIdentical(root1, root2));

    }
}
