package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

public class ConstructFromInAndPre {
    Node root;
    public static int index = 0;

    public Node constructTree(int[] pre, int[] in, int start, int end) {
        //Base cond
        if (start > end) {
            return null;
        }

        Node tNode = new Node(pre[index++]);

        if (start == end) {
            return tNode;
        }

        int intIndex = searchIndex(in, start, end, tNode.key);

        tNode.left = constructTree(pre, in, start, intIndex-1);
        tNode.right = constructTree(pre, in, intIndex+1, end);

        return tNode;
    }

    public int searchIndex(int[] arr, int start, int end, int key) {
        int i;
        for (i=start; i<=end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return i;
    }

    public void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.println(root.key + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] inOrder = {8,4,2,5,1,6,3,7};
        int[] preOrder = {1,2,4,8,5,3,6,7};
        ConstructFromInAndPre constructBinaryTreeFromInPreOrder = new ConstructFromInAndPre();


        Node root = constructBinaryTreeFromInPreOrder.constructTree(preOrder, inOrder, 0, 7);
        constructBinaryTreeFromInPreOrder.printInOrder(root);
    }
}
