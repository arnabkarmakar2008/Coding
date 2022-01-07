package com.example.coding.tree.misc;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestRightLeafNode {
    public static Node deepRightNode;
    public static Node deepLeftNode;

    public static void traverseLevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                Node temp = q.poll();

                if (temp.left != null) {
                    q.add(temp.left);

                    if (temp.left.left == null && temp.left.right == null) {
                        deepLeftNode = temp.left;
                    }
                }

                if (temp.right != null) {
                    q.add(temp.right);

                    if (temp.right.left == null && temp.right.right == null) {
                        deepRightNode = temp.right;
                    }
                }

                size--;
            }
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
        traverseLevelOrder(root);
        System.out.println("Deepest Right Leaf=" + deepRightNode.key);
        System.out.println("Deepest Left Leaf=" + deepLeftNode.key);
    }
}
