package com.example.coding.slidingwindow.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {

    /**
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
     * @param mainString
     * @param searchString
     * @return
     */
    public static List<Integer> findAnagrams(String mainString, String searchString) {
        List<Integer> resultList = new ArrayList<>();

        if (searchString.length() > mainString.length()) {
            return resultList;
        }

        //Create frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : searchString.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        int counter = freqMap.size();
        int start = 0;
        int end = 0;

        while (end < mainString.length()) {
            char endChar = mainString.charAt(end);
            char startChar = mainString.charAt(start);

            if (freqMap.containsKey(endChar)) {
                freqMap.put(endChar, freqMap.get(endChar)-1);

                if (freqMap.get(endChar) == 0) {
                    counter--;
                }
            }

            end++;

            while (counter == 0) {
                if (freqMap.containsKey(startChar)) {
                    freqMap.put(startChar, freqMap.get(startChar)+1);

                    if (freqMap.get(startChar) > 0) {
                        counter++;
                    }
                }

                if (end - start == searchString.length()) {
                    resultList.add(start);
                }

                start++;
            }
        }

        return resultList;
     }

    public static void main(String[] args) {
        String mainString = "cbaebabacd";
        String searchString = "abc";

        List<Integer> resultList = findAnagrams(mainString, searchString);

        System.out.println(resultList.size());
    }
}
