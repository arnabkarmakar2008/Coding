package com.example.coding.trie.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a map that allows you to do the following:
 *
 * Maps a string key to a given value.
 * Returns the sum of the values that have a key with a prefix equal to a given string.
 * Implement the MapSum class:
 *
 * MapSum() Initializes the MapSum object.
 * void insert(String key, int val) Inserts the key-val pair into the map. If the key
 * already existed, the original key-value pair will be overridden to the new one.
 * int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix
 *
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 */
public class MapSumPairs {

    public static void main(String[] args) {

    }
}

class MapSum {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
        int value;

        public TrieNode() {
        }
    }

    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode current = root;

        for (int i =0 ; i< key.length(); i++) {
            char ch = key.charAt(i);

            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new TrieNode());
            }

            current = current.children.get(ch);
        }

        current.isWord = true;
        current.value = val;
    }

    public int sum(String prefix) {
        TrieNode current = root;

        for (int ct = 0; ct< prefix.length(); ct++) {
            char ch = prefix.charAt(ct);
            TrieNode nxt = root.children.get(ch);

            if (nxt == null) {
                return 0;
            }

            current = nxt;
        }

        return dfs(current);
    }

    private int dfs (TrieNode node) {
        int sum = 0;
        for (char c : node.children.keySet()) {
            sum += dfs(node.children.get(c));
        }

        return sum + node.value;
    }
}
