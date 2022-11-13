package com.example.coding.dynamicprogramming.LCS;

public class LongestRepeatingSubSequece {
  public static void main(String[] args) {
    String input = "AABEBCDD";
    System.out.println(longestRepeatingSubSequenceCount(input, input, input.length(), input.length()));

    /**
     * Output : ABD is the longest repeating subsequece.
     * AABEBCDD
     * AABEBCDD
     *
     * LCS = AABEBCDD. But we cannot take E ad C because they both are on the same index in both strings.
     * i.e. E & C are not repeating and present in the same index of both strings.
     */
  }

  public static int longestRepeatingSubSequenceCount(String input1, String input2, int m, int n) {
    int[][] t = new int[m+1][n+1];

    for (int i=0; i<m+1; i++) {
      for (int j=0; j<n+1; j++) {
        if (i==0) {
          t[i][j] = 0;
        } else if (j==0) {
          t[i][j] = 0;
        }
      }
    }

    for (int i=1; i<m+1; i++) {
      for (int j=1; j<n+1; j++) {
        if (input1.charAt(i-1) == input2.charAt(j-1) && i!=j) {
          //We do not want same index. so that is why i!=j
          t[i][j] = 1 + t[i-1][j-1];
        } else if (input1.charAt(i-1) != input2.charAt(j-1)){
          t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
        }
      }
    }

    return t[n][m];
  }
}
