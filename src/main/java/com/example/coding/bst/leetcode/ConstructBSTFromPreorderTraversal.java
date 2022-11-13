package com.example.coding.bst.leetcode;

import com.example.coding.tree.Node;

/**
 * https://www.youtube.com/watch?v=UmJT3j26t1I
 */
public class ConstructBSTFromPreorderTraversal {

    public static int index = 0;

    public static Node constructTree(int[] arr) {
        return constructBST(arr, Integer.MAX_VALUE);
    }

    private static Node constructBST(int[] arr, int upperBound) {
        if (index == arr.length || arr[index] > upperBound) {
            return null;
        }

        Node root = new Node(arr[index++]);
        root.left = constructBST(arr, root.key);
        root.right = constructBST(arr, upperBound);
        return root;
    }

    public static void main(String[] args) {

    }
}
