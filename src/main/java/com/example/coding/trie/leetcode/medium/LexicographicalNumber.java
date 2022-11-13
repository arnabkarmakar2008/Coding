package com.example.coding.trie.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return all the numbers in the range [1, n] sorted in
 * lexicographical order.
 *
 * You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 */
public class LexicographicalNumber {

    /**
     * The idea is pretty simple. If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
     * Then we visit every node in pre-order.
     *        1        2        3    ...
     *       /\        /\       /\
     *    10 ...19  20...29  30...39   ....
     *
     *    https://leetcode.com/problems/lexicographical-numbers/discuss/86231/Simple-Java-DFS-Solution
     * @param n
     * @return
     */

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> resultList = new ArrayList<>();
        for (int i=1; i <=9; i++) {
            dfs(i, n, resultList);
        }

        return resultList;
    }

    private static void dfs (int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        } else {
            result.add(current);
            for (int ct = 0; ct <=9; ct++) {
                if ((current * 10 + ct) > n) {
                    return;
                }

                dfs(current * 10 + ct, n, result);
            }
        }
    }

    public static void main(String[] args) {
        int n = 110;
        List<Integer> intList = lexicalOrder(n);
        System.out.println(intList);
    }
}
