package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

import java.util.Vector;

public class VerticalWidthOfATree {

    public static void verticalWidth(Node node, int hd , Vector<Integer> vector) {
        if (node == null) {
            return;
        }

        if (!vector.contains(hd)) {
            vector.add(hd);
        }

        verticalWidth(node.left, hd-1, vector);
        verticalWidth(node.right, hd+1, vector);
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        Vector<Integer> vector = new Vector<>();
        vector.add(0);

        verticalWidth(root1, 0, vector);

        System.out.println("Vector Size = " + vector.size());

    }
}
