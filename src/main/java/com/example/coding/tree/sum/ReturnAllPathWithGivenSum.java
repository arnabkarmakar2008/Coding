package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

import java.util.ArrayList;

/**
 * https://www.youtube.com/watch?v=ojxo9QjPKvA&list=PL-Jc9J83PIiHgjQ9wfJ8w-rXU368xNX4L&index=52
 */
public class ReturnAllPathWithGivenSum {

    public static ArrayList<ArrayList<Integer>> getAllPaths(Node root, int targetSum) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        solve(root, resultList, list, targetSum);

        return resultList;
    }

    private static void solve(Node root, ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> list, int target) {

        if (root == null) return;

        //If leaf node then check if target is zero or not
        if (root.left == null && root.right == null) {
            if (target - root.key == 0) {
                ArrayList<Integer> baseList = new ArrayList<>(list);
                baseList.add(root.key);
                resultList.add(baseList);
            }

            return;
        }

        list.add(root.key);

        solve(root.left, resultList, list, target - root.key);
        solve(root.right, resultList, list, target - root.key);

        list.remove(list.size()-1);
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
