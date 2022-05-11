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

  public static int compress(char[] chars) {

    int left = 0;
    int right = 0;
    int counter = 0;
    String str = "";

    while (left < chars.length) {
      if (chars[right] == chars[left]) {
        right++;
      } else {
        counter = (right - left);

        if (counter == 1) {
          str = str + chars[left];
        } else {
          str = str + chars[left] + counter;
        }

        left = right;
        right++;
      }
    }

    return str.length();
  }


  public static void main(String[] args) {
    char[] chars = {'a', 'a', 'b', 'b', 'c'};
    System.out.println(compress(chars));
  }
}
