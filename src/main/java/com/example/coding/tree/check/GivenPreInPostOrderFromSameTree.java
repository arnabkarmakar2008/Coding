package com.example.coding.tree.check;

import com.example.coding.tree.Node;

import java.util.ArrayList;

public class GivenPreInPostOrderFromSameTree {

    Node root;

    public static int preIndex;
    public static ArrayList<Integer> arrayList = new ArrayList<>();

    public static int searchIndexOf(int[] arr, int start, int end, int key) {
        int index = 0;

        for (int i=start; i<= end; i++) {
            if (arr[i] == key) {
                index = i;
            }
        }

        return index;
    }

    public static Node constructTreeFromInAndPre(int[] in, int[] pre, int start, int end) {

        if (start > end) {
            return null;
        }

        Node temp = new Node(pre[preIndex++]);

        if (start == end) {
            return temp;
        }

        int index = searchIndexOf(in, start, end, temp.key);

        temp.left = constructTreeFromInAndPre(in, pre, 0, index-1);
        temp.right = constructTreeFromInAndPre(in, pre, index+1, end);

        return temp;
    }

    public static int postOrderTraversal(Node root, int[] postOrder, int index) {
        if (root == null) {
            return index;
        }

        index = postOrderTraversal(root.left, postOrder, index);
        index = postOrderTraversal(root.right, postOrder, index);

        if (root.key == postOrder[index]) {
            index++;
        } else {
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] inOrder = {4,2,5,1,3};
        int[] preOrder = {1,2,4,5,3};
        int[] postOrder = {4,5,2,3,1};

        Node tree = constructTreeFromInAndPre(inOrder, preOrder, 0, 4);
        int index = postOrderTraversal(tree, postOrder, 0);
        System.out.println(index); //index should be equal to length

    }
}
