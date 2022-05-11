package com.example.coding.twopointers.leetcode.medium;

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at
 * least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned
 * string should only have a single space separating the words. Do not include any extra spaces.
 */
public class ReverseWordsInString {

  /**
   * https://www.youtube.com/watch?v=RgYLxtlkKo8
   * @param s
   * @return
   */
  public static String reverseWords(String s) {
    char[] charArray = s.toCharArray();

    int start = 0;
    int end = charArray.length - 1;

    //Remove leading spaces
    while (start <= end && charArray[start] == ' ') {
      start++;
    }

    //Remove trailing spaces
    while (start <= end && charArray[end] == ' ') {
      end--;
    }

    reverse(charArray, start, end);

    int i = start;
    int j = start;
    int mark = start; // As there may be more than one space between words, so size may shrink. So have to keep new pointer.

    while (j <= end) {

      if (charArray[j] != ' ') {
        charArray[mark] = charArray[j];
        mark++;
      }

      if (j == end || charArray[j] == ' ') {

        if (j == end) {
          break;
        }

        reverse(charArray, i, mark-1);
        charArray[mark] = ' '; // As we need to keep a single space between words.
        i = mark;

        while (charArray[j] == ' ') {
          j++;
        }

        j = j-1;

      }

      j++;
    }

    return new String(charArray, start, mark - start);
  }

  private static void reverse(char[] charArray, int start, int end) {
    while (start < end) {
      char temp = charArray[end];
      charArray[end] = charArray[start];
      charArray[start] = temp;
      start++;
      end--;
    }
  }


  public static void main(String[] args) {
    String str = "the sky is blue";
    System.out.println(reverseWords(str));
  }
}
