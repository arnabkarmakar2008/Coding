package com.example.coding.sort.leetcode.medium;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher
 * received for their ith paper and citations is sorted in an ascending order, return compute the researcher's
 * h-index.
 *
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have
 * at least h citations each, and the other n − h papers have no more than h citations each.
 *
 * If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * You must write an algorithm that runs in logarithmic time.
 */
public class HIndexII {

  /**
   * O(lonN)
   * @param citations
   * @return
   */
  public static int hIndex(int[] citations) {
    int len = citations.length;

    int index = 0;

    while (index <= len && (len-index) > citations[index]) {
      index++;
    }

    return len-index;
  }

  public static int hIndexBinarySearch(int[] citations) {
    int low = 0;
    int high = citations.length-1;
    int len = citations.length;

    while (low <= high) {
      int mid = low + (high-low)/2;

      if ((len - mid) == citations[mid]) {
        return citations[mid];
      } else if ((len - mid) > citations[mid]) {
        low = mid+1;
      } else {
        high = mid-1;
      }

    }

    return len - low;
  }

  public static void main(String[] args) {
    int[] citations = {0,1,3,5,6};
    System.out.println(hIndexBinarySearch(citations));
  }
}
