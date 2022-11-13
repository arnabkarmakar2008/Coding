package com.example.coding.twopointers.leetcode.medium;


/**
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in
 * the input character array chars. Note that group lengths that are 10 or longer will be split
 * into multiple characters in chars.
 *
 * After you are done modifying the input array, return the new length of the array.
 *
 * You must write an algorithm that uses only constant extra space.
 */
public class StringCompression {

  public static char[] compress(char[] chars) {

    int index = 0;
    int ansIndex = 0;

    while (index < chars.length) {
      int count = 0;
      char currentChar = chars[index];

      while (index < chars.length && chars[index] == currentChar) {
        count++;
        index++;
      }

      chars[ansIndex++] = currentChar;

      if (count > 1) {
        for (char ch : Integer.toString(count).toCharArray()) {
          chars[ansIndex++] = ch;
        }
      }
    }
    return chars;
  }


  public static void main(String[] args) {
    char[] chars = {'a', 'a','a', 'a','a', 'a','a', 'a','a', 'a','a', 'a','a', 'a','a', 'a','a', 'a', 'b', 'b', 'c'};
    char[] ansArray = compress(chars);
    System.out.println(ansArray);
  }
}
