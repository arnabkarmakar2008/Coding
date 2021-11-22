package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

public class ConstructFromInAndPost {

    public static int index = 0;

    public static Node construct(int[] inOrder, int[] postOrder, int start, int end) {
        if (start > end || index<0) {
            return null;
        }

        Node root = new Node(postOrder[index--]);

        if (start == end) {
            return root;
        }

        //Search index of root in InOrder array
        int inIndex = searchIndex(inOrder, start, end, root.key);

        root.right = construct(inOrder, postOrder, inIndex+1, end);
        root.left = construct(inOrder, postOrder, start, inIndex-1);

        return root;
    }

    public static int searchIndex(int[] arr, int start, int end, int key) {
        int i;
        for (i=start; i<=end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] inOrder = {4,8,10,12,14,20,22};
        int[] postOrder = {4,10,14,12,8,22,20};
        index = inOrder.length-1;

        Node root = construct(inOrder, postOrder, 0, inOrder.length-1);

        System.out.println(root.key);

    }
}
