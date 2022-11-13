package com.example.coding.dynamicprogramming.leetcode.linear;

import com.example.coding.tree.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 * called root.
 *
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized
 * that all houses in this place form a binary tree. It will automatically contact the police if two
 * directly-linked houses were broken into on the same night.
 *
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without
 * alerting the police.
 */
public class HouseRobberIII {

    public static int rob(Node root) {
        //return robRecursion(root);
        return robRecursionMemo(root, new HashMap<>());
    }

    private static int robRecursion(Node root) {
        //base cond
        if (root == null) {
            return 0;
        }

        int value = 0;

        //Check how much you will get if you rob child of left tree
        if (root.left != null) {
            value += robRecursion(root.left.left) + robRecursion(root.left.right);
        }

        //Similarly check how much you will get if you rob child right tree
        if (root.right != null) {
            value += robRecursion(root.right.left) + robRecursion(root.right.right);
        }

        //if you rob root then you can only rob grand children
        value += root.key;

        //Else you can rob left child and right child of root.
        int childRobValue = robRecursion(root.left) + robRecursion(root.right);

        return Math.max(value, childRobValue);

    }

    private static int robRecursionMemo(Node root, Map<Node, Integer> map) {
        //base cond
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int value = 0;

        //Check how much you will get if you rob child of left tree
        if (root.left != null) {
            value += robRecursion(root.left.left) + robRecursion(root.left.right);
        }

        //Similarly check how much you will get if you rob child right tree
        if (root.right != null) {
            value += robRecursion(root.right.left) + robRecursion(root.right.right);
        }

        //if you rob root then you can only rob grand children
        value += root.key;

        //Else you can rob left child and right child of root.
        int childRobValue = robRecursion(root.left) + robRecursion(root.right);
        int maxValue = Math.max(value, childRobValue);
        map.put(root, maxValue);
        return maxValue;

    }


    public static void main(String[] args) {
        Node root1 = new Node(3);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.right = new Node(3);
        root1.right.right = new Node(1);

        System.out.println(rob(root1));
    }
}
