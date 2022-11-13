package com.example.coding.twopointers.leetcode.medium;


/**
 * Given a string s, reverse the order of characters in each word within a
 * sentence while still preserving whitespace and initial word order.
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 */
public class ReverseWordsInStringIII {

  public static String reverseWords(String s) {
    int start = 0;
    int end = 0;

    StringBuilder stringBuilder = new StringBuilder(s);

    while (end <= stringBuilder.length()) {
      if (end == stringBuilder.length() || s.charAt(end) == ' ') {
        reverse(stringBuilder, start, end-1);
        start = end + 1;
      }

      end++;
    }

    return stringBuilder.toString();
  }

  private static void reverse(StringBuilder str, int start, int end) {
    while (start < end) {
      char temp = str.charAt(end);
      str.setCharAt(end, str.charAt(start));
      str.setCharAt(start, temp);
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    String str = "the      sky is blue";
    System.out.println(reverseWords(str));
  }
}
