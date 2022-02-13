package com.example.coding.matrix.leetcode.hard;

import java.util.*;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells,
 * adjacent cells are horizontally or vertically neighboring. The same letter cell may
 * not be used more than once in a word.
 */
public class WordSearchII {

  static Set<String> res = new HashSet<String>();

  /**
   * Have to use Trie here. ********* Need to learn
   * @param board
   * @param words
   * @return
   */
  public static List<String> findWords(char[][] board, String[] words) {
    int rows = board.length;
    int cols = board[0].length;
    Trie trie = new Trie();
    boolean[][] visited = new boolean[rows][cols];

    // Put words in trie
    for (int ct=0; ct < words.length; ct++) {
      trie.insert(words[ct]);
    }

    for (int i=0; i<rows; i++) {
      for (int j=0; j<cols; j++) {
        dfs(board, visited, "", i, j, trie);
      }
    }

    return new ArrayList<String>(res);
  }

  public static void dfs(char[][] board, boolean[][] visited, String str, int row, int col, Trie trie) {
    if (row <0 || col <0 || row>= board.length || col>=board[0].length || visited[row][col] == true) {
      return;
    }

    if (!trie.startsWith(str)) {
      return;
    }

    str += board[row][col];

    if (trie.search(str)) {
      res.add(str);
    }

    visited[row][col] = true;

    dfs (board, visited, str, row+1, col, trie);
    dfs (board, visited, str, row-1, col, trie);
    dfs (board, visited, str, row, col+1, trie);
    dfs (board, visited, str, row, col-1, trie);

    visited[row][col] = false; //backtracking

  }

  public static void main(String[] args) {
    char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
    String[] words = {"oath","pea", "eat", "rain"};
    List<String> list = findWords(board, words);

    for (String str : list) {
      System.out.println(str);
    }
  }


}

class TrieNode {
  public TrieNode[] children = new TrieNode[26];
  public String item = "";

  // Initialize your data structure here.
  public TrieNode() {
  }
}

class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.item = word;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) return false;
      node = node.children[c - 'a'];
    }
    return node.item.equals(word);
  }

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public boolean startsWith(String prefix) {
    TrieNode node = root;
    for (char c : prefix.toCharArray()) {
      if (node.children[c - 'a'] == null) return false;
      node = node.children[c - 'a'];
    }
    return true;
  }
}
