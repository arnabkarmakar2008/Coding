package com.example.coding.tree.dp;

import com.example.coding.tree.Node;

/**
 * https://www.youtube.com/watch?v=zmPj_Ee3B8c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=47
 * Aditya Verma
 * DP on trees
 */
public class DiameterOfBinaryTree {
    //From a node, dia = 1 + height of left subtree + height of right subtree
    // Need to calculate dia for each node and update max

    static class MaxStore {
        int MAX = Integer.MIN_VALUE;
    }

    public static int diameter(Node node, MaxStore maxStore) {
        if (node == null) {
            return 0;
        }

        int leftDia = diameter(node.left, maxStore);
        int rightDia = diameter(node.right, maxStore);

        //If current node doesn't want to form max dia, then it will pass it to its root
        int temp = Math.max(leftDia, rightDia) + 1;

        int answer = Math.max(temp, 1 + (leftDia+rightDia));

        maxStore.MAX = Math.max(maxStore.MAX, answer);

        return temp;
    }

    public static void main(String[] args) {
        Node root = new Node (10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
        root.right.left.left = new Node(37);
        MaxStore maxStore = new MaxStore();

        diameter(root, maxStore);
        System.out.println("Dia=" + maxStore.MAX);
    }
}
