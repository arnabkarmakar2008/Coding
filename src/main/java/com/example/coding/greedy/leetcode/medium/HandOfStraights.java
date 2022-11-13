package com.example.coding.greedy.leetcode.medium;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Alice has some number of cards and she wants to rearrange the cards
 * into groups so that each group is of size groupSize, and consists of groupSize
 * consecutive cards.
 *
 * Given an integer array hand where hand[i] is the value written on the ith card
 * and an integer groupSize, return true if she can rearrange the cards, or false otherwise.
 */
public class HandOfStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;

        if (len % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int ct = 0; ct < hand.length; ct++) {
            map.put(hand[ct], map.getOrDefault(hand[ct], 0) +1);
        }

        while (!map.isEmpty()) {
            int firstKey = map.firstKey();

            for (int size=1; size < groupSize; size++) {
                int nextKey = firstKey + size;

                if (!map.containsKey(nextKey)) {
                    return false;
                } else {
                    map.put(nextKey, map.get(nextKey)-1);

                    if (map.get(nextKey) == 0) {
                        map.remove(nextKey);
                    }
                }
            }

            map.put(firstKey, map.get(firstKey) -1);

            if (map.get(firstKey) == 0) {
                map.remove(firstKey);
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        System.out.println(isNStraightHand(hand, groupSize));
    }
}
