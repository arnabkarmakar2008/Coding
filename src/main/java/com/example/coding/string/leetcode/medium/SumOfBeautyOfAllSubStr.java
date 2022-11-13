package com.example.coding.string.leetcode.medium;

/**
 * The beauty of a string is the difference in frequencies between the most
 * frequent and least frequent characters.
 *
 * For example, the beauty of "abaacc" is 3 - 1 = 2.
 * Given a string s, return the sum of beauty of all of its substrings.
 *
 *
 * Input: s = "aabcb"
 * Output: 5
 * Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
 */
public class SumOfBeautyOfAllSubStr {

    /**
     * https://leetcode.com/problems/sum-of-beauty-of-all-substrings/discuss/1096380/Java-or-T%3A-O(N2)-or-S%3A-O(1)-Get-the-beauty-of-all-substrings-and-sum-them
     * @param s
     * @return
     */
    public static int beautySum(String s) {

        //Have to get for all substrs.
        int resultSum = 0;

        for (int i = 0; i < s.length(); i++) {
            //initialize freq array
            int[] freqArray = new int[26];

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                freqArray[ch - 'a']++;
                resultSum = resultSum + beautySumArray(freqArray);

            }
        }

        return resultSum;

    }

    private static int beautySumArray(int[] freqArray) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int val : freqArray) {
            if (val != 0) {
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }

        return max - min;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }
}
