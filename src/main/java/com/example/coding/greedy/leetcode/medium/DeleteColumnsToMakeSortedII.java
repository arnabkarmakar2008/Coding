package com.example.coding.greedy.leetcode.medium;

import java.util.HashSet;

/**
 * You are given an array of n strings strs, all of the same length.
 *
 * We may choose any deletion indices, and we delete all the characters in those indices for each string.
 *
 * For example, if we have strs = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array
 * after deletions is ["bef", "vyz"].
 *
 * Suppose we chose a set of deletion indices answer such that after deletions,
 * the final array has its elements in lexicographic order (i.e., strs[0] <= strs[1] <= strs[2]
 * <= ... <= strs[n - 1]). Return the minimum possible value of answer.length.
 *
 *
 * Input: strs = ["ca","bb","ac"]
 * Output: 1
 * Explanation:
 * After deleting the first column, strs = ["a", "b", "c"].
 * Now strs is in lexicographic order (ie. strs[0] <= strs[1] <= strs[2]).
 * We require at least 1 deletion since initially strs was not in lexicographic order, so the answer is 1.
 */
public class DeleteColumnsToMakeSortedII {

    public static int minDeletionSize(String[] A) {
        HashSet<Integer> toBeDeleted = new HashSet<>();
        for(int row = 1; row < A.length; row++) {
            //Match current & prev row for all the columns
            for(int col = 0; col < A[row].length(); col++) {
                if(toBeDeleted.contains(col) || A[row - 1].charAt(col) == A[row].charAt(col)) continue;
                if(A[row - 1].charAt(col) > A[row].charAt(col)) {
                    /**
                     If current row character is less than prev row character for a column,
                     add that column to the Hashset
                     */
                    toBeDeleted.add(col);

                    /**
                     Restart row, cause deleting column might change ordering of previously ordered rows
                     */
                    row = 0;
                }
                break;
            }
        }
        return toBeDeleted.size();
    }

    public static void main(String[] args) {
        String[] strs = {"ca","bb","ac"};
        System.out.println(minDeletionSize(strs));
    }
}
