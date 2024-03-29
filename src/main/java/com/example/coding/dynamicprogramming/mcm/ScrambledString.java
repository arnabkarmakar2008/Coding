package com.example.coding.dynamicprogramming.mcm;

public class ScrambledString {
    public static void main(String[] args) {
        /**
         * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
         * Below is one possible representation of A = “great”:
         *  great
         *    /    \
         *   gr    eat
         *  / \    /  \
         * g   r  e   at
         *            / \
         *           a   t
         * To scramble the string, we may choose any non-leaf node and swap its two children.
         *
         * For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.
         *
         *     rgeat
         *    /    \
         *   rg    eat
         *  / \    /  \
         * r   g  e   at
         *            / \
         *           a   t
         * We say that “rgeat” is a scrambled string of “great”.
         *
         * Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.
         *
         *     rgtae
         *    /    \
         *   rg    tae
         *  / \    /  \
         * r   g  ta  e
         *        / \
         *       t   a
         * We say that “rgtae” is a scrambled string of “great”.
         */
    }

    public static boolean solve(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        if (a.length() < 1) {
            return false;
        }

        int n = a.length();
        boolean flag = false;
        /**
         * String can be broken from 1 to n-1.
         * great can be broken as [g, reat], [gr,eat], [gre,at],[grea,t]
         */
        for (int i=1; i< n-1; i++) {

            /**
             * great :: gr eat
             * eatgr :: eat gr
             * Lets say we are break at index 2.
             * Then we have first section of a with last section of b and last section of a with first
             * section of b
             *
             */

            //If there is swap
            boolean condn1 = (solve(a.substring(0,i), b.substring(n-i)) == true &&
                    solve(a.substring(i), b.substring(0, n-i)) == true);


            //If there is no swap
            boolean condn2 = (solve(a.substring(0,i), b.substring(0, i)) == true &&
                    solve(a.substring(i), b.substring(i)) == true);

            if (condn1 || condn2) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
