package com.example.coding.twopointers.leetcode.easy;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {

  public static void reverseString(char[] charArray) {

    int start = 0;
    int end = charArray.length-1;

    while (start < end) {
      char temp = charArray[end];
      charArray[end] = charArray[start];
      charArray[start] = temp;
      start++;
      end--;
    }

  }

  public static void main(String[] args) {
    char[] str = {'a', 'b', 'c', 'd'};
    reverseString(str);

    for (char ch : str) {
      System.out.print(" "+ch);
    }
  }
}
