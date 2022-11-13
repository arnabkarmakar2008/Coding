package com.example.coding.bst.leetcode;

import com.example.coding.tree.Node;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never
 * differs by more than one.
 */
public class ConvertSortedArrayToBST {

    public static Node sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        Node root = helper(nums, 0, nums.length-1);
        return root;
    }

    public static Node helper(int[] nums, int low, int high) {

        if (low > high) {
            return null;
        }

        int mid = low + (high-low)/2;
        Node root = new Node(nums[mid]);
        root.left = helper(nums, low, mid-1);
        root.right = helper(nums, mid+1, high);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        Node root = sortedArrayToBST(nums);

        System.out.println(root.key);
    }
}
