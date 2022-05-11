package com.example.coding.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single dots.
 * Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 *
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312"
 * and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be
 * formed by inserting dots into s. You are not allowed to reorder or remove any digits in s.
 * You may return the valid IP addresses in any order.
 */
public class RestoreIPAddresses {

  /**
   * https://www.youtube.com/watch?v=61tN4YEdiTM
   * @param s
   * @return
   */
  public static List<String> restoreIpAddresses(String s) {
    List<String> resultString = new ArrayList<>();
    backtrack(s, 0, 0, resultString, "");

    return resultString;
  }

  public static void backtrack(String inputString, int index, int dotCount, List<String> resultString, String currentString) {
    if (dotCount == 4 && index == inputString.length()) {
      resultString.add(currentString);
      return;
    }

    if (dotCount > 4) {
      return;
    }

    for (int i = index; i < index+3; i++) {
      if ( Integer.parseInt(inputString.substring(index, i+1)) < 256 && (i == index || inputString.charAt(index) == '0')) {
        backtrack(inputString, i+1, dotCount+1, resultString, currentString + inputString.substring(index, i+1) + ".");
      }
    }
  }

  public static void main(String[] args) {

  }
}
