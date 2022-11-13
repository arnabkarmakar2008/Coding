package com.example.coding.graph.leetcode;

import java.util.*;

/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi]
 * represent the departure and the arrival airports of one flight. Reconstruct the
 * itinerary in order and return it.
 *
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must
 * begin with "JFK". If there are multiple valid itineraries, you should return the
 * itinerary that has the smallest lexical order when read as a single string.
 *
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order
 * than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the
 * tickets once and only once.
 */
public class ReconstructItinerary {

    /**
     * https://www.youtube.com/watch?v=WYqsg5dziaQ
     * @param tickets
     * @return
     */
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();

        for (String[] tkt : tickets) {
            String src = tkt[0];
            String dest = tkt[1];

            adjMap.putIfAbsent(src, new PriorityQueue<>());
            adjMap.get(src).add(dest);
        }

        List<String> route = new LinkedList<>();
        Stack<String> stk = new Stack<>();

        stk.push("JFK");

        while (!stk.isEmpty()) {
            String src = stk.peek();

            if (adjMap.get(src).isEmpty()) {
                route.add(src);
                stk.pop();
            } else {
                String dest = adjMap.get(src).poll();
                stk.push(dest);
            }
        }

        return route;
    }

    public static void main(String[] args) {

    }
}
