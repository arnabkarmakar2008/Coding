package com.example.coding.trie.leetcode.medium;

/**
 * Design a data structure that supports adding new words and finding if a
 * string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure
 * that matches word or false otherwise. word may contain dots '.' where dots can be matched
 * with any letter.
 *
 * https://www.youtube.com/watch?v=bGve8Va8FNo
 *
 *
 */
public class DesignAndSearchWords {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("pad");
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b."));
    }

}

class WordDictionary {

    WordDictNode root;

    public WordDictionary() {
        root = new WordDictNode();
    }

    public void addWord(String word) {
        WordDictNode node = root;

        for (int ct=0; ct < word.length(); ct++) {
            char ch = word.charAt(ct);

            if (!node.containsKey(ch)) {
                node.put(ch, new WordDictNode());
            }

            node = node.get(ch);
        }

        node.setEndNode(true);
    }

    public boolean search(String word) {
       return root.search(word.toCharArray(), 0);
    }
}


class WordDictNode {

    WordDictNode[] children = new WordDictNode[26];
    boolean endNode;

    public WordDictNode() {
    }

    boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    WordDictNode get(char ch) {
        return children[ch - 'a'];
    }

    void put(char ch, WordDictNode node) {
        children[ch - 'a'] = node;
    }

    void setEndNode(boolean flag) {
        this.endNode = flag;
    }

    boolean getEndNode() {
        return this.endNode;
    }

    boolean search(char[] chars, int startIndex) {
        var current = this;

        for (int ct = startIndex; ct < chars.length; ct++) {
            char ch = chars[ct];
            if (ch == '.') {
                // if char is '.', then it can match any char.
                // So fetch all no null children of current node and search rest of the chars
                // for each child node. If any of the child return true then we have match.
                for (WordDictNode node : current.children) {
                    if (node != null && node.search(chars, ct+1)) {
                        return true;
                    }
                }

                return false;

            } else {
                if (current.containsKey(ch)) {
                    current = current.get(ch);
                } else {
                    return false;
                }
            }
        }

        return current!= null && current.endNode;

    }
}
