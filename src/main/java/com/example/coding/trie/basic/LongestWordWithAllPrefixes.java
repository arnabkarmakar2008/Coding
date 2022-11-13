package com.example.coding.trie.basic;

/**
 * Input : n ni, ninj, ninja, ninga
 *
 * For ninja all prefixes are present. But for ninga all are not present. So ninja will
 * be the answer.
 *
 * https://www.youtube.com/watch?v=AWnBa91lThI&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=3
 */
public class LongestWordWithAllPrefixes {
    public static String longestWord(int size, String[] words) {
        Trie trie = new Trie();

        for (int ct =0; ct < size; ct++) {
            trie.insert(words[ct]);
        }

        String longest = "";

        for (int ct =0; ct < size; ct++) {
            if (trie.checkIfAllPrefixExists(words[ct])) {
                if (words[ct].length() > longest.length()) {
                    longest = words[ct];
                } else if (words[ct].length() == longest.length() && words[ct].compareTo(longest) < 0 ) {
                    //if same length then return lexico small
                    longest = words[ct];
                }
            }
        }

        return longest;
    }
}

