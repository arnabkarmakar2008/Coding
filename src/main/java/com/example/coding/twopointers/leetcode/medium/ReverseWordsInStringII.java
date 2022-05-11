package com.example.coding.twopointers.leetcode.medium;


/**
 * Given an input string, reverse string word by word. No leading and trailing white spaces.
 * Words are separated by single space.
 * Input : "the sky is blue"
 * Output : "blue is sky the"
 *
 *
 */
public class ReverseWordsInStringII {

  /**
   * This problem is almost same as III. Just we have to reverse the string again.
   * "AB CD" - > "CD AB"
   *
   * In II, we are doing "BA DC". So do one more reverse and we will get "CD AB"
   *
   * @param s
   * @return
   */
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

    reverse(stringBuilder, 0, stringBuilder.length()-1);

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
    String str = "the sky is blue";
    System.out.println(reverseWords(str));
  }
}
