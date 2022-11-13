package com.example.coding.trie.grind169;

/**
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string
 * word that has the prefix prefix, and false otherwise.
 */
public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("ape");

        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}


class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int ct = 0; ct < word.length(); ct++) {
            char ch = word.charAt(ct);

            if (!current.containsKey(ch)) {
                current.put(ch, new TrieNode());
            }

            current = current.get(ch);

        }

        current.setEndNode(true);
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int ct = 0; ct < word.length(); ct++) {
            char ch = word.charAt(ct);

            if (current.containsKey(ch)) {
                current = current.get(ch);
            } else {
                return false;
            }
        }

        return current.endNode;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (int ct = 0; ct < prefix.length(); ct++) {
            char ch = prefix.charAt(ct);

            if (current.containsKey(ch)) {
                current = current.get(ch);
            } else {
                return false;
            }
        }

        return true;
    }

    boolean checkIfAllPrefixExists(String word) {
        TrieNode node = root;
        boolean flag = true;

        for (int i=0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                //if (node.)
            } else {
                return false;
            }
        }

        return false;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endNode;

    public TrieNode() {
    }

    public TrieNode(TrieNode[] children, boolean endNode) {
        this.children = children;
        this.endNode = endNode;
    }

    boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    void setEndNode(boolean flag) {
        endNode = flag;
    }
}