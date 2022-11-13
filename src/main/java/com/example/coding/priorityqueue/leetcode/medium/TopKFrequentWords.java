package com.example.coding.priorityqueue.leetcode.medium;

import java.util.*;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest.
 * Sort the words with the same frequency by their lexicographical order.
 */
public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> resultStringList = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) +1);
        }

        /**
         * @karan33 the solution is using min-heap, which keeps heap's size to K. With min-heap,
         * the top K elements are actually at the bottom of the heap. Hence, at case where a.getValue() == b.getValue(),
         * we want to add "abd" before "abc" into the min-heap, so that when executing line result.add(0, pq.poll().getKey());,
         * abc will go before abd in the result. Hope this help!
         */

        PriorityQueue<Map.Entry<String, Integer>> minPQ = new PriorityQueue<>((a,b) -> a.getValue().equals(
                b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());

        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            minPQ.offer(mapEntry);

            if (minPQ.size() > k) {
                minPQ.poll();
            }
        }

        while (!minPQ.isEmpty()) {
            resultStringList.add(0,     minPQ.poll().getKey());
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> a.compareTo(b));

        pq.add("abc");
        pq.add("abd");
        pq.add("aaa");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        return resultStringList;
    }

    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> resultString = topKFrequent(words, 2);
        System.out.println(resultString);
    }
}
