package com.example.coding.trie.leetcode.medium;

/**
 * Given an array of strings words representing an English Dictionary,
 * return the longest word in words that can be built one character at a time by
 * other words in words.
 *
 * If there is more than one possible answer, return the longest word with the
 * smallest lexicographical order. If there is no answer, return the empty string.
 *
 * Input: words = ["w","wo","wor","worl","world"]
 * Output: "world"
 * Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 */
public class LongestDictWord {

    static String longestWord = "";

    public static void longestWord(String[] words) {
       LongestDictWordTrie trie = new LongestDictWordTrie();

       for (String word : words) {
           trie.insert(word);
       }

       dfs(trie.root);

    }

    private static void dfs(LongestDictWordNode root) {
        for (LongestDictWordNode children : root.children) {
            if (children != null && children.word != null) {
                if (longestWord.length() < children.word.length()) {
                    longestWord = children.word;
                }

                dfs(children);
            }
        }


    }

    /**
     * https://www.youtube.com/watch?v=MbvGOab6Sfg
     * To form a longest word, each node of trie need to be end node.
     * e.g
     * a -> ap -> app->appl->apple
     * a is end
     * p is end
     * p is end
     * l is end
     * e is end.
     *
     * So for each child we have to check if there is ending or not. If yes then
     * have to dfs that node.
     *
     * Lexicographical smallest : We will traverse child fri=om array which is stored from a -> z.
     * So always smaller element will update the longestWord for same length word.
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        longestWord(words);
        System.out.println(longestWord);
    }

}

class LongestDictWordTrie {
    LongestDictWordNode root;

    public LongestDictWordTrie() {
        this.root = new LongestDictWordNode();
    }

    void insert (String word) {
        LongestDictWordNode current = root;
        for (int i =0 ; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new LongestDictWordNode();
            }

            current = current.children[ch - 'a'];
        }

        current.word = word;
    }
}

class LongestDictWordNode {
    LongestDictWordNode[] children = new LongestDictWordNode[26];
    String word;
}
