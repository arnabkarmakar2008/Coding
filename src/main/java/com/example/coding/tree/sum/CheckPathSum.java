package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

/**
 * Check if any root to leaf path exists with target sum or not
 */
public class CheckPathSum {

    public static boolean hasPath(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (target - root.key) == 0;
        }

        return hasPath(root.left, target - root.key) ||
                hasPath(root.right, target - root.key);
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);

        System.out.println(hasPath(root, 9));
    }
}
