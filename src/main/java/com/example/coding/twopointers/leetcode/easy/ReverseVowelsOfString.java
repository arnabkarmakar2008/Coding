package com.example.coding.twopointers.leetcode.easy;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 */
public class ReverseVowelsOfString {

  public static String reverseVowels(String s) {
    int start = 0;
    int end = s.length()-1;

    StringBuilder strBuilder = new StringBuilder(s);

    while (start < end) {
      char startPosition = strBuilder.charAt(start);
      char endPosition = strBuilder.charAt(end);

      if (isVowel(Character.toLowerCase(startPosition)) && isVowel(Character.toLowerCase(endPosition))) {
        strBuilder.setCharAt(start, endPosition);
        strBuilder.setCharAt(end, startPosition);

        start++;
        end--;
      } else if (isVowel(Character.toLowerCase(startPosition)) && ! isVowel(Character.toLowerCase(endPosition))) {
        end--;
      } else {
        start++;
      }

    }

    return strBuilder.toString();
  }

  public static boolean isVowel (char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
  }

  public static void main(String[] args) {
    String str = "hello";
    String reversedString = reverseVowels(str);
    System.out.println(reversedString);
  }
}
