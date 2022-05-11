package com.example.coding.twopointers.leetcode.easy;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase
 * letters and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {

  public static boolean isPalindrome(String s) {
    if (s.isEmpty()) {
      return true;
    }

    int head = 0;
    int tail = s.length()-1;

    char charHead;
    char charTail;

    while (head <= tail) {
      charHead = s.charAt(head);
      charTail = s.charAt(tail);

      if (!Character.isLetterOrDigit(charHead)) {
        head++;
      } else if (!Character.isLetterOrDigit(charTail)) {
        tail--;
      } else {
        if (Character.toLowerCase(charHead) != Character.toLowerCase(charTail)) {
          return false;
        }

        head++;
        tail--;
      }

    }

    return true;
  }

  public static void main(String[] args) {
    String s = "A man, a plan, a canal: Panama";
    System.out.println(isPalindrome(s));
  }
}
