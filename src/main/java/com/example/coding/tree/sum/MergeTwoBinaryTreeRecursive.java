package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

public class MergeTwoBinaryTreeRecursive {
    Node root;

    public MergeTwoBinaryTreeRecursive(int key) {
        this.root = new Node(key);
    }

    public MergeTwoBinaryTreeRecursive() {
        root = null;
    }

    public static Node mergeBinaryTree(Node root1, Node root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root2;
        }

        root1.key = root1.key + root2.key;

        root1.left = mergeBinaryTree(root1.left,root2.left);
        root1.right = mergeBinaryTree(root1.right, root1.right);

        return root1;
    }

    public static void inorder(Node root) {
        if(root == null)
            return;

        inorder(root.left);
        System.out.println(root.key);
        inorder(root.right);
    }



    public static void main(String[] args) {
        MergeTwoBinaryTreeRecursive tree = new MergeTwoBinaryTreeRecursive(1);
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(5);
        root1.left.right = new Node(9);
        root1.right.left = new Node(8);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(6);
        root2.left.left = new Node(5);
        root2.left.right = new Node(9);
        root2.right.left = new Node(8);

        Node merged = mergeBinaryTree(root1, root2);
        inorder(merged);

    }
}
