package com.example.coding.dynamicprogramming.leetcode.linear;


/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into
 * letters using the reverse of the mapping above (there may be multiple ways). For example, "11106"
 * can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6"
 * is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */
public class DecodeWays {

  public static int decode(String input) {

    /**
     * Possible cases
     * 1. 0 0
     * 2. 0 non zero
     * 3. non zero 0
     * 4. non zero non zero
     */

    int[] dp = new int[input.length()];

    dp[0] = 1; // We can decode 1st char in one way only and 1 char cannot be zero.

    for (int i=1; i<input.length(); i++) {

      if (input.charAt(i-1) == '0' && input.charAt(i) == '0') {
        dp[i] = 0;
      } else if (input.charAt(i-1) == '0' && input.charAt(i) != '0') {
        //if 03, then we can take only 3. We cannot take 03.
        dp[i] = dp[i-1];
      } else if (input.charAt(i-1) != '0' && input.charAt(i) == '0') {
        //We cannot take only last 0. We have to take 2 digit. Also we have to check 2 digits are
        //not more than 26.
        if (input.charAt(i-1) == '1' || input.charAt(i-1) == '2') {
          // It will check if it is 20 or 10
          dp[i] = i >= 2 ?  dp[i-2] : 1; //
        } else {
          dp[i] = 0;
        }
      } else {
        if (Integer.parseInt(input.substring(i-1, i+1)) <=26) {
          dp[i] = dp[i-1] + (i >= 2 ? dp[i-2] : 1);
        } else {
          dp[i] = dp[i-1]; //
        }

      }
    }

    return dp[input.length()-1];
  }

  public static void main(String[] args) {
    String input = "11106";

    System.out.println(decode(input));

  }
}
