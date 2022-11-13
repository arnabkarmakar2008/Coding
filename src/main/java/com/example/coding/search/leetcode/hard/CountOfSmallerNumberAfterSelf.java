package com.example.coding.matrix.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements
 * to the right of nums[i].
 *
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 *
 */
public class CountOfSmallerNumberAfterSelf {

    /**
     * https://www.youtube.com/watch?v=buDoT9ESw1c
     *
     * Construct BST from the array.
     * @param nums
     * @return
     */
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> answerList = new ArrayList<>();

        TreeNode root = new TreeNode(nums[nums.length-1]);
        answerList.add(0);

        for (int i = nums.length-2; i>=0; i--) {
            int count = insertNode(root, nums[i]);
            answerList.add(count);
        }

        Collections.reverse(answerList);

        return answerList;
    }

    private static int insertNode(TreeNode root, int num) {

        /**
         * Start from root node. If num > root.value, then increment answer = answr + root.count
         * If num < root.value, then increment root.counter value.
         */

        int smaller = 0;
        TreeNode temp = new TreeNode(num);
        boolean isConnected= false;

        while (! isConnected) {
            //if temp data is greater than root
            if (temp.value > root.value) {
                //increment answer count
                smaller = smaller + root.count;

                if (root.right == null) {
                    root.right = temp;
                    isConnected = true;
                } else {
                    root = root.right;
                }
            } else {
                root.count = root.count+1;
                if (root.left == null) {
                    root.left = temp;
                    isConnected = true;
                } else {
                    root = root.left;
                }
            }
        }

        return smaller;

    }


    public static void main(String[] args) {
        int[] nums = {7,5,2,6,1};
        List<Integer> list = countSmaller(nums);

        System.out.println(list);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        int count = 1;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
