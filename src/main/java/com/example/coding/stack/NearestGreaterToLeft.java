package com.example.coding.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToLeft {
    public static void main(String[] args) {
        /**Given an array, print the Next Greater Element (NGE) for every element.
         * The Next greater Element for an element x is the first greater element on the
         * right side of x in array. Elements for which no greater element exist,
         * consider next greater element as -1.
         *
         * IP int[] arr = {1,3,2,4}
         * OP = {3,4,4,-1}
         */
       int[] arr = {1,3,2,4};
       System.out.println("Array = " + solve(arr, 4));

    }

    public static List<Integer> solve(int[] arr, int size) {
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i<size; i++) {
            if (stack.empty()) {
                list.add(-1);
            } else if (stack.peek() > arr[i]) {
                list.add(stack.peek());
            } else if (stack.peek() <= arr[i]) {
                while (!stack.empty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }

                if (stack.empty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }

            stack.push(arr[i]);

        }

        return list;

    }
}
