package com.example.coding.string.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of strings arr. A string s is formed by the concatenation of a
 * subsequence of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no
 * elements without changing the order of the remaining elements.
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are:
 * - ""
 * - "un"
 * - "iq"
 * - "ue"
 * - "uniq" ("un" + "iq")
 * - "ique" ("iq" + "ue")
 * Maximum length is 4.
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
 */
public class MaxLengthOfConcatenatedStringUniqueChar {

    public static int maxLength(List<String> arr) {
        int maxLength = Integer.MIN_VALUE;
        List<String> resultList = new ArrayList<>();
        resultList.add("");

        for (String str : arr) {
            if (!isUnique(str)) continue;
            List<String> tempList = new ArrayList<>();
            for (String resultListStr : resultList) {
                String tempStr = str + resultListStr;

                if (isUnique(tempStr)) {
                    tempList.add(tempStr);
                }
            }

            resultList.addAll(tempList);
        }

        for (String str : resultList) {
            maxLength = Math.max(maxLength, str.length());
        }

        return maxLength;
    }

    private static boolean isUnique(String str) {
        boolean[] unqArr = new boolean[26];

        for (int ct = 0; ct < str.length(); ct++) {
            char ch = str.charAt(ct);

            if (unqArr[ch - 'a']) {
                return false;
            } else {
                unqArr[ch - 'a'] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("un", "iq", "ue");
        System.out.println(maxLength(stringList));
    }
}
