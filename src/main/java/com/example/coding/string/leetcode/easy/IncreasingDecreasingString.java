package com.example.coding.string.leetcode.easy;

/**
 * You are given a string s. Reorder the string using the following algorithm:
 *
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 */
public class IncreasingDecreasingString {

    public static String sortString(String s) {
        int[] frequencyArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequencyArray[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            for (int ct=0; ct < frequencyArray.length; ct++) {
                if (frequencyArray[ct] > 0) {
                    char ch = (char)(ct + 'a');
                    sb.append(ch);
                    frequencyArray[ct]--;
                    flag1 = true;
                }
            }

            for (int ct=frequencyArray.length-1; ct >=0; ct--) {
                if (frequencyArray[ct] > 0) {
                    char ch = (char)(ct + 'a');
                    sb.append(ch);
                    frequencyArray[ct]--;
                    flag2 = true;
                }
            }

            if (flag1 == false && flag2 == false) {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        System.out.println(sortString(s));
    }
}
