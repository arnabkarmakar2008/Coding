package com.example.coding.dynamicprogramming.leetcode.string;

/**
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters
 * to make two strings equal.
 */
public class MinASCIIDelete {

  /**
   * Note : https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/642422/for-those-who-have-no-clue-%3A-step-by-step
   *
   * RE-WORDING question : get the sum of all characters which do not form longest Common Subsequence.
   * @param s1
   * @param s2
   * @return
   */
  public static int minimumDeleteSum(String s1, String s2) {
    return recursion(s1,s2,0,0);
  }


  /**
   *
   * f(s1,s2) = f(c1r1, c2r2) if c1=c2 then f(r1,r2). Else min ( f(r1,c2r2), f(c1r1,r2) )
   *
   * c1 : first char, r1 : rest
   * c2 : first char, r2 : rest
   */

  public static int recursion(String a, String b, int aIndex, int bIndex) {
    int n = a.length();
    int m = b.length();

    //Base case
    if (aIndex == n || bIndex == m) {
      if (aIndex == n && bIndex == m) return 0;

      return aIndex == n ? deadEndSum(b, bIndex) : deadEndSum(a, aIndex);

    }

    int sum = 0;

    if (a.charAt(aIndex) == b.charAt(bIndex)) {
      sum = recursion(a,b,aIndex+1, bIndex+1);
    } else {
      sum = Math.min (Integer.valueOf(a.charAt(aIndex)) + recursion(a,b, aIndex+1, bIndex),
              Integer.valueOf(b.charAt(bIndex)) + recursion(a,b, aIndex, bIndex+1));
    }

    return sum;
  }

  private static int deadEndSum(String s, int index) {
    int sum = 0;

    while (index < s.length()) {
      sum += Integer.valueOf(s.charAt(index));
      index++;
    }

    return sum;
  }


  public static int minimumDeleteSumDP(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    int[][] dp = new int[n+1][m+1];

    for (int i=1; i<=n; i++) {
      dp[i][0] = dp[i-1][0] + Integer.valueOf(s1.charAt(i-1));
    }

    for (int j=1; j<=m; j++) {
      dp[0][j] = dp[0][j-1] + Integer.valueOf(s2.charAt(j-1));
    }

    for (int i=1; i<=n; i++) {
      for (int j=1; j<=m; j++) {

        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          dp[i][j] = Math.min(Integer.valueOf(s1.charAt(i-1)) + dp[i-1][j],
                  Integer.valueOf(s2.charAt(j-1)) + dp[i][j-1]);
        }
      }
    }

    return dp[n][m];
  }


  public static void main(String[] args) {
    String s1 = "sea";
    String s2 = "eat";

    System.out.println(minimumDeleteSumDP(s1,s2));
  }
}
