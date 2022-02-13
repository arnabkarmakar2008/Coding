package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

public class ConstructFromInAndPre {

    public static Node buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        Node root = new Node(pre[preStart]);

        if (preStart == preEnd || inStart == inEnd) {
            return root;
        }

        //Index of root in inorder
        int index = inStart;
        while (in[index] != pre[preStart]) {
            index++;
        }

        int numberOfLeftElement = index - inStart;

        root.left = buildTree(pre, preStart + 1, preStart + numberOfLeftElement, in, inStart, index-1);
        root.right = buildTree(pre, preStart + numberOfLeftElement+1, preEnd, in, index+1, inEnd);

        return root;

    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.println(root.key + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] inOrder = {4,2,5,1,6,3,7};
        int[] preOrder = {1,2,4,5,3,6,7};

        Node root = buildTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
        printInOrder(root);
    }
}
