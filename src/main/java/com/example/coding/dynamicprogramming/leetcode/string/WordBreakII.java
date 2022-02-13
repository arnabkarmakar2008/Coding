package com.example.coding.dynamicprogramming.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s
 * to construct a sentence where each word is a valid dictionary word. Return all such
 * possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreakII {

  /**
   * Note : https://www.youtube.com/watch?v=necF6yyegiE
   *
   * IP: pineapplepenapple disct: pine, apple, pen
   *
   *
   * @param input
   * @param start
   * @param dictionary
   * @return
   */
  public static List<String> solve(String input, int start, Set<String> dictionary) {
    //https://www.youtube.com/watch?v=necF6yyegiE
    List<String> validSubStr = new ArrayList<>();

    if (start == input.length()) {
      validSubStr.add("");
      return validSubStr;
    }

    for (int end = start+1; end <= input.length(); end++) {
      String prefix = input.substring(start, end);

      if (dictionary.contains(prefix)) {
        //We found till pine, now call for applepenapple
        List<String> suffixList = solve(input, end, dictionary);
        for (String suffix : suffixList) {
          validSubStr.add(prefix + (suffix.equals("") ? "" : " " + suffix));
        }
      }
    }

    return validSubStr;
  }

  public static int countSentences(String str, Set<String> dictionary) {
    //https://www.youtube.com/watch?v=2NaaM_z_Jig
    int n = str.length();

    int[] dp = new int[n];

    for (int i=0; i< dp.length; i++) {
      for (int j=0; j<i; j++) {
        String wcheck = str.substring(j, i+1);

        if (dictionary.contains(wcheck)) {
          if (j > 0) {
            dp[i] += dp[j-1];
          } else {
            dp[i] += 1;
          }

        }
      }
    }

    return dp[str.length()-1];
  }

  public static void main(String[] args) {
    String input = "pineapplepenapple";
    Set<String> dictionary = new HashSet<>();
    dictionary.add("apple");
    dictionary.add("pen");
    dictionary.add("applepen");
    dictionary.add("pine");
    dictionary.add("pineapple");

    List<String> list = solve(input, 0, dictionary);

    for (String str : list) {
      System.out.println(str);
    }

  }
}
