package com.example.coding.dynamicprogramming.leetcode.string;

/**
 * A string s is called happy if it satisfies the following conditions:
 *
 * s only contains the letters 'a', 'b', and 'c'.
 * s does not contain any of "aaa", "bbb", or "ccc" as a substring.
 * s contains at most a occurrences of the letter 'a'.
 * s contains at most b occurrences of the letter 'b'.
 * s contains at most c occurrences of the letter 'c'.
 * Given three integers a, b, and c, return the longest possible happy string.
 * If there are multiple longest happy strings, return any of them.
 * If there is no such string, return the empty string "".
 *
 * A substring is a contiguous sequence of characters within a string.
 */
public class HappyGreedyString {

  public static String longestDiverseString(int a, int b, int c) {
    int countA = 0;
    int countB = 0;
    int countC = 0;

    StringBuilder sb = new StringBuilder();

    int totalSize = a+b+c;

    for (int i=0; i< totalSize; i++) {

      if ((a >= b && a >= c && countA != 2) || (countB == 2 && a > 0) || (countC == 2 && a >0)) {
        sb.append("a");

        a--;
        countA++;
        countB = 0;
        countC = 0;


      } else if ((b >= a && b >= c && countB != 2) || (countA == 2 && b > 0) || (countC == 2 && b >0)) {
        sb.append("b");

        b--;
        countB++;
        countA = 0;
        countC = 0;
      } else if ((c >= a && c >= b && countC != 2) || (countA == 2 && c > 0) || (countB == 2 && c >0)) {
        sb.append("c");

        c--;
        countC++;
        countA = 0;
        countB = 0;
      }
    }

    return sb.toString();

  }

  public static void main(String[] args) {
    int a = 1;
    int b = 1;
    int c = 7;

    System.out.println(longestDiverseString(a,b,c));
  }
}
