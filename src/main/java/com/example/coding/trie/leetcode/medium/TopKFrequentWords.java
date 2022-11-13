package com.example.coding.trie.leetcode.medium;

import java.util.*;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest.
 * Sort the words with the same frequency by their lexicographical order.
 *
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 *
 */
public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        // Add in map with count
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word,0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, (a,b) ->
                a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            pq.add(mapEntry);
        }

        List<String> resultString = new ArrayList<>();

        for (int ct=1; ct<=k; ct++) {
            resultString.add(pq.poll().getKey());
        }

        return resultString;
    }

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};

        List<String> resultList = topKFrequent(words, 2);
    }
}
