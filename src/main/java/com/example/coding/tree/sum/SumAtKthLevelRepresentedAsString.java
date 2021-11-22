package com.example.coding.tree.sum;

import com.example.coding.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SumAtKthLevelRepresentedAsString {

    public static int solve(String tree, int k) {
        int level = -1;
        int sum = 0;
        int n = tree.length();

        for (int i=0; i< n; i++) {
            if (tree.charAt(i) == '(') {
                level++;
            } else if (tree.charAt(i) == ')') {
                level--;
            } else {
                if (level == k) {
                    sum = sum + Integer.parseInt("" + tree.charAt(i));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        /**
         * IP = (0(5(6()())(4()(9()())))(7(1()())(3()())))
         * k = 2
         * OP = 14
         */


        SumAtKthLevelRepresentedAsString sumat = new SumAtKthLevelRepresentedAsString();
        String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";

        System.out.println(sumat.solve(tree, 2));
    }
}
