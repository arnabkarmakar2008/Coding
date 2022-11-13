package com.example.coding.tree.dp;

import com.example.coding.tree.Node;

/**
 * Max sum between leaf to leaf
 *
 * https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=49
 *
 * Aditya Verma
 */
public class MaxPathSubBetweenTwoLeaves {

    public static int maxLeaftToLeafPathSum(Node root) {
        MaxStore maxStore = new MaxStore();

        return solve(root, maxStore);
    }

    private static int solve(Node root, MaxStore maxStore) {
        if (root == null) return 0;

        int leftMax = solve(root.left, maxStore);
        int rightMax = solve(root.right, maxStore);

        int temp = Math.max(leftMax, rightMax) + root.key;

        //If root is leaf then only it can consider its own value
        if (root.left == null && root.right == null) {
            temp = Math.max(temp, root.key);
        }

        int answer = Math.max(temp, leftMax+rightMax+root.key);
        maxStore.MAX = Math.max(maxStore.MAX, answer);

        return temp;
    }

    static class MaxStore {
        int MAX = Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
    }

}
