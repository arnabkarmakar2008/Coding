package com.example.coding.trie.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In English, we have a concept called root, which can be followed by some other word to form another
 * longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other",
 * we can form a new word "another".
 *
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the
 * successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace
 * it with the root that has the shortest length.
 *
 * Return the sentence after the replacement.
 *
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 *
 *
 */
public class ReplaceWords {

    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] tokens = sentence.split(" ");
        WordDictionary trie = buildTrie(dictionary);
        return replaceWords(tokens, trie);

    }

    private static String replaceWords(String[] tokens, WordDictionary trie) {
        StringBuilder sb = new StringBuilder();

        for (String token : tokens) {
            String replacedString = getShortestReplacement(token, trie);
            sb.append(replacedString);
            sb.append(" ");
        }

        return sb.toString();
    }

    private static String getShortestReplacement(String token, WordDictionary trie) {
        StringBuilder sb = new StringBuilder();
        WordDictNode currentNode = trie.root;
        for (int ct = 0; ct < token.length(); ct++) {
            char ch = token.charAt(ct);
            if (currentNode.containsKey(ch)) {
                sb.append(ch);

                if (currentNode.get(ch).getEndNode()) {
                    return sb.toString();
                }
                currentNode = currentNode.get(ch);
            } else {
                return token;
            }
        }

        return token;
    }

    private static WordDictionary buildTrie(List<String> dict) {
        WordDictionary trie = new WordDictionary();

        for (String str : dict) {
            trie.addWord(str);
        }

        return trie;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.addAll(Arrays.asList("cat","bat","rat"));

        String sentence = "the cattle was rattled by the battery";

        System.out.println(replaceWords(dict, sentence));
    }


}
