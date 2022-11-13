package com.example.coding.string.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character, but a character may
 * map to itself.
 */
public class IsomorphicString {

    /**
     * https://www.youtube.com/watch?v=7yF-U1hLEqQ
     * egg -> add true
     *
     * here e->a, g->d. So g should always map to d.
     *
     * foo -> bar false
     * f->b but o is mapping to a and r which is not allowed.
     *
     * Also if egg is isomorphic to add, then add should also be isomorphic to egg.
     *
     * This is why have to have to maps.
     *
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int ct = 0; ct < s.length(); ct++) {
            char c1 = s.charAt(ct);
            char c2 = t.charAt(ct);

            if ((mapST.containsKey(c1) && mapST.get(c1) != c2) || mapTS.containsKey(c2) && mapTS.get(c2) != c1) {
                return false;
            }

            mapST.put(c1, c2);
            mapTS.put(c2, c1);
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }
}
