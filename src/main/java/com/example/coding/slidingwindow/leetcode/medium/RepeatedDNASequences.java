package com.example.coding.slidingwindow.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long
 * sequences (substrings) that occur more than once in a DNA molecule. You may return the answer
 * in any order.
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 */
public class RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        int start = 0;
        int end = 0;

        Map<String, Integer> map = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        while (end < s.length()) {

            if (end-start+1 < 10) {
                end++;
            } else if (end-start+1 == 10) {
                String substr = s.substring(start, end + 1 >= s.length() ? end : end+1);

                if (map.containsKey(substr)) {
                    resultList.add(substr);
                } else {
                    map.put(substr, map.getOrDefault(substr,0)+1);
                }

                start++;
                end++;
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> stringList = findRepeatedDnaSequences(s);
        System.out.println(stringList);
    }
}
