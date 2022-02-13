package com.example.coding.tree.construct;

import com.example.coding.tree.Node;

import java.util.HashSet;

public class ConstructFromInAndLevelOrder {

    public static Node constructTree(int[] in, int inStart, int inEnd, int[] level) {

        if (inStart > inEnd) {
            return null;
        }

        Node root = new Node(level[0]);

        if (level.length == 0) {
            return root;
        }

        //Get the index of root in inorder
        int index = inStart;
        while (in[index] != level[0]) {
            index++;
        }

        //Put all left tree element in hashset
        HashSet<Integer> set = new HashSet<>();
        for (int i = inStart; i<index; i++) {
            set.add(in[i]);
        }

        //Create leftLevel and rightLevel array
        int[] leftLevel = new int[index - inStart];
        int[] rightLevel = new int[inEnd - index];

        //Now traverse level order and create leftLevel and rightLevel
        int leftCounter = 0;
        int rightCounter = 0;
        for (int i=1; i<level.length; i++) {
            if (set.contains(level[i])) {
                leftLevel[leftCounter] = level[i];
                leftCounter++;
            } else {
                rightLevel[rightCounter] = level[i];
                rightCounter++;
            }
        }

        root.left = constructTree(in, inStart, index-1, leftLevel);
        root.right = constructTree(in, index+1, inEnd, rightLevel);

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
        int[] in = {4,2,5,1,6,3,7};
        int[] level = {1,2,3,4,5,6,7};

        Node root = constructTree(in, 0, in.length-1, level);
        printInOrder(root);
    }
}
