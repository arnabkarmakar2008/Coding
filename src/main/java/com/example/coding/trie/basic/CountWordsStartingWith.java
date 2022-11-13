package com.example.coding.trie.basic;

/**
 * https://www.youtube.com/watch?v=K5pcpkEMCN0
 */
public class CountWordsStartingWith {


}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;

        for (int ct = 0; ct < word.length(); ct++) {
            char ch = word.charAt(ct);

            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }

            node = node.get(ch);
            node.increasePrefix();

        }
        node.isEnd = true;
        node.increaseEnd();

    }

    int countWordsEqualTo(String word) {
        TrieNode node = root;

        for (int ct = 0; ct < word.length(); ct++) {
            char ch = word.charAt(ct);

            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return 0;
            }

        }

        return node.getEnd();
    }

    int countWordStartsWith(String word) {
        TrieNode node = root;

        for (int ct = 0; ct < word.length(); ct++) {
            char ch = word.charAt(ct);

            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return 0;
            }

        }

        return node.getPrefix();
    }

    void erase (String word) {
        TrieNode node = root;

        for (int ct = 0; ct < word.length(); ct++) {
            char ch = word.charAt(ct);

            if (node.containsKey(ch)) {
                node = node.get(ch);
                node.reducePrefix();
            } else {
                return;
            }

        }

        node.reduceEnd();
    }

    boolean checkIfAllPrefixExists(String word) {
        TrieNode node = root;
        boolean flag = true;

        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);

            if (node.containsKey(ch)) {
                node = node.get(ch);
                flag = flag & node.isEnd;

            } else {
                return false;
            }
        }

        return flag;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int countEndWith = 0;
    int countPrefix = 0;

    boolean isEnd;

    public TrieNode() {
    }


    boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    void put(char ch, TrieNode trieNode) {
        children[ch - 'a'] = trieNode;
    }

    void increaseEnd() {
        countEndWith++;
    }

    void increasePrefix() {
        countPrefix++;
    }

    void reduceEnd() {
        countEndWith--;
    }

    void reducePrefix() {
        countPrefix--;
    }

    void deleteEnd() {
        countEndWith--;
    }

    int getEnd() {
        return countEndWith;
    }

    int getPrefix() {
        return countPrefix;
    }
}


