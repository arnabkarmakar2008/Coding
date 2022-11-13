package com.example.coding.greedy.leetcode.medium;

/**
 *
 * You are given an array of n strings strs, all of the same length.
 *
 * The strings can be arranged such that there is one on each line, making a grid. For example, strs = ["abc", "bce", "cae"] can be arranged as:
 *
 * abc
 * bce
 * cae
 * You want to delete the columns that are not sorted lexicographically.
 * In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
 *
 * Return the number of columns that you will delete.
 *
 *
 * You are given an array of n strings strs, all of the same length.
 *
 * The strings can be arranged such that there is one on each line, making
 * a grid. For example, strs = ["abc", "bce", "cae"] can be arranged as:
 *
 * abc
 * bce
 * cae
 */
public class DeleteColumnsToMakeSorted {

    public static int minDeletionSize(String[] strs) {
        int count = 0;

        for (int charCount =0 ; charCount < strs[0].length(); charCount++) {
            for (int strCount = 1; strCount < strs.length; strCount++) {
                if (strs[strCount].charAt(charCount) < strs[strCount-1].charAt(charCount)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] strs = {"cba","daf","ghi"};
        System.out.println(minDeletionSize(strs));
    }
}
