package com.example.coding.stack;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestSmallerToLeftIndex {
    public static void main(String[] args) {
        /**Given an array, print the Next Greater Element (NGE) for every element.
         * The Next greater Element for an element x is the first greater element on the
         * right side of x in array. Elements for which no greater element exist,
         * consider next greater element as -1.
         *
         * IP int[] arr = {1,3,2,4}
         * OP = {-1,1,1,2}
         */
       int[] arr = {1,3,2,4,5,3};
       System.out.println("Array = " + solve(arr, 6));

    }

    public static List<Integer> solve(int[] arr, int size) {
        List<Integer> list = new ArrayList<>();

        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i<size; i++) {
            if (stack.empty()) {
                list.add(-1);
            } else if (stack.peek().getValue() < arr[i]) {
                list.add(stack.peek().getKey());
            } else if (stack.peek().getValue() >= arr[i]) {
                while (!stack.empty() && stack.peek().getValue() >= arr[i]) {
                    stack.pop();
                }

                if (stack.empty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek().getKey());
                }
            }

            stack.push(new Pair(i,arr[i]));

        }

        return list;

    }
}
