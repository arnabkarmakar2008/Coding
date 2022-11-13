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

  /**
   * https://www.youtube.com/watch?v=cQX3yHS0cLo
   *
   * @param input
   * @return
   */
  public static int decode(String input) {

    /**
     * Possible cases
     * 1. 0 0
     * 2. 0 non zero
     * 3. non zero 0
     * 4. non zero non zero
     */

    int[] dp = new int[input.length()]; //will contain number of ways to decode

    dp[0] = 1; // empty string can be decoded one way
    dp[1] = input.charAt(0) == '0' ? 0 : 1; // Single digit. If 0 then number of way is 0 else 1.

    for (int i=2; i < dp.length; i++) {
      int oneDigit = Integer.valueOf(input.substring(i-1,i)); //consider 1 digit only first. So have to take i-1th digit
      int twoDigit = Integer.valueOf(input.substring(i-2,i)); //Consider 2 digit. So have to take i-2th and i-1th digit

      if (oneDigit < 10) {
        dp[i] += dp[i-1]; //If one digit then add number of ways to the current-1 dp value.
      }

      if (twoDigit >=10 && twoDigit <=26) {
        dp[i] += dp[i-2]; ////If two digit then add number of ways to the current-2 dp value.
      }
    }

    return dp[input.length()-1];
  }

  public static void main(String[] args) {
    String input = "11106";

    System.out.println(decode(input));

  }
}
