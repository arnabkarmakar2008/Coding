package com.example.coding.stack;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class StockSpan {
    public static void main(String[] args) {
        /**
         * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
         * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
         * For example, if an array of 7 days prices is given as
         * {100, 80, 60, 70, 60, 75, 85},
         * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
         */
        int arr[] = {100,80, 60,70,60,75,85};
        System.out.println(solve(arr, 7 ));
    }

    public static List<Integer> solve(int[] arr, int size) {
        List<Integer> list = new ArrayList<>();

        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i<size; i++) {
            if (stack.empty()) {
                list.add(-1);
            } else if (stack.peek().getValue() > arr[i]) {
                list.add(stack.peek().getKey());
            } else if (stack.peek().getValue() <= arr[i]) {
                while (!stack.empty() && stack.peek().getValue() <= arr[i]) {
                    stack.pop();
                }

                if (stack.empty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek().getKey());
                }
            }

            stack.push(new Pair(i, arr[i]));

        }

        List<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < list.size(); i ++ ) {
            int x = i - list.get(i);

            finalList.add(x);
        }

        return finalList;

    }
}
