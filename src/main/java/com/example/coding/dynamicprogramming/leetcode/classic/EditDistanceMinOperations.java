package com.example.coding.dynamicprogramming.leetcode.classic;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
public class EditDistanceMinOperations {

  /**
   * https://www.youtube.com/watch?v=AuYujVj646Q&t=1078s
   * @param str1
   * @param str2
   * @param i
   * @param j
   * @return
   */
  private static int recursion(String str1, String str2, int i, int j) {
    //Base cases
    if (i == str1.length() && j == str2.length()) {
      return 0;
    }

    if (i == str1.length()) {
      return str2.length() - j;
    }

    if (j == str2.length()) {
      return str1.length() - i;
    }

    int result = -1;
    if (str1.charAt(i) == str2.charAt(j)) {
      result = recursion(str1, str2, i+1, j+1);
    } else {
      //We can replace, delete and insert
      int replace = 1 + recursion(str1, str2, i+1, j+1); // orse and rs. If we replace o with r from second string, then call recusrion for rse and s.

      int delete = 1 + recursion(str1, str2, i+1, j); // orse and rs. If we delete o, then call recusrion for rse and rs.

      int insert = 1 + recursion(str1, str2, i, j+1); // orse and rs. If we insert r (rorse, rs), then call recusrion for orse and s.

      result = Math.min(Math.min(replace, delete), insert);
    }

    return result;
  }

  public static int dynamicProgramming(String str1, String str2) {
    int[][] dp = new int[str1.length()+1][str2.length()+1];

    dp[0][0] = 0 ;

    for (int i = 1; i < dp.length; i++) {
      dp[i][0] = i;
    }

    for (int j = 1; j < dp[0].length; j++) {
      dp[0][j] = j;
    }

    for (int i=1; i < dp.length; i++) {
      for (int j=1; j < dp[0].length; j++) {
        if (str1.charAt(i-1) == str2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          // Here we are matching from right to left
          //replace = dp[i-1][j-1]
          //Delete = dp[i-1][j]
          //insert = dp[i][j-1]
          dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
        }
      }
    }

    return dp[str1.length()][str2.length()];
  }

  public static int minDistance(String word1, String word2) {
    //return recursion(word1, word2, 0, 0);
    return dynamicProgramming(word1, word2);
  }


  public static void main(String[] args) {
    String str1 = "horse";
    String str2 = "ros";

    System.out.println(minDistance(str1, str2));
  }

}
