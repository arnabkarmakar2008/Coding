package com.example.coding.sort.leetcode.medium;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher
 * received for their ith paper, return compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at
 * least h citations each, and the other n − h papers have no more than h citations each.
 *
 * If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class HIndex {

  public static int hIndex(int[] citations) {
    return 0;
  }

  public static void main(String[] args) {
    int[] citations = {3,0,6,1,5};
    System.out.println(hIndex(citations));
  }
}
