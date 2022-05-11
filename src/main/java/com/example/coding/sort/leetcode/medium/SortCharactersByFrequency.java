package com.example.coding.sort.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class SortCharactersByFrequency {
  /**
   * This will be similar to bucket sort...
   * @param s
   * @return
   */
  public static String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i=0; i<s.length(); i++) {
      char currentChar = s.charAt(i);
      map.put(currentChar, map.getOrDefault(currentChar,0)+1);
    }

    // Now create a bucket based on frequency.
    List<Character>[] bucket = new List[s.length()];

    for (Map.Entry<Character, Integer> mapEntry : map.entrySet()) {
      char currentChar = mapEntry.getKey();
      int frequency = mapEntry.getValue();

      List<Character> charList = bucket[frequency];

      if (charList == null) {
        charList = new ArrayList<>();
        bucket[frequency] = charList;
      }

      charList.add(currentChar);
    }

    StringBuilder sb = new StringBuilder();

    for (int i = bucket.length-1; i >=0; i--) {
      List<Character> charList = bucket[i];

      if (charList != null) {
        for (char ch : charList) {
          for (int j=1; j<=i; j++) {
            sb.append(ch);
          }
        }
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String str = "tree";
    System.out.println(frequencySort(str));
  }
}
