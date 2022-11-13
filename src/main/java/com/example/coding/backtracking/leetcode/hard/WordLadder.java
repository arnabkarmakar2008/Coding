package com.example.coding.backtracking.leetcode.hard;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words
 * in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class WordLadder {

  /**
   * https://www.youtube.com/watch?v=ZVJ3asMoZ18&t=606s
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   */
  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>();
    boolean endWordPresent = false;

    for (String word : wordList) {
      if (word.equals(endWord)) {
        endWordPresent = true;
      }
      wordSet.add(word);
    }

    if (endWordPresent == false) {
      return 0;
    }

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    int depth = 0;

    while (!queue.isEmpty()) {
      depth = depth+1;
      int qSize = queue.size();

      while (qSize > 0) {
        String current = queue.poll();

        for (int i=0; i<current.length(); i++) {
          StringBuilder temp = new StringBuilder(current);

          for (char c = 'a'; c<='z'; c++) { //replace each char with a-> z and see if it is present in the list.
            temp.setCharAt(i, c);

            if (temp.toString().equals(current)) {
              // If it is exact same word then ignore
              continue;
            }

            if (temp.toString().equals(endWord)) {
              return depth+1;
            }

            if (wordSet.contains(temp.toString())) {
              queue.add(temp.toString());
              wordSet.remove(temp.toString());
            }

          }
        }

        qSize--;
      }
    }

    return depth;
  }

  public static void main(String[] args) {
    String begin = "hit";
    String end = "cog";
    List<String> wordList = new ArrayList<>();
    wordList.add("hot");
    wordList.add("dot");
    wordList.add("dog");
    wordList.add("lot");
    wordList.add("log");
    wordList.add("cog");

    int depth = ladderLength(begin, end, wordList);

    System.out.println(depth);
  }
}
