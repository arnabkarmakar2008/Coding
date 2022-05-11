package com.example.coding.dynamicprogramming.leetcode.multidm;

/**
 * 1. You are given N number of books. Every ith book has Ai number of pages.
 * 2. You have to allocate books to M number of students. There can be many ways or
 * permutations to do so. In each permutation, one of the M students will be allocated the
 * maximum number of pages. Out of all these permutations, the task is to find that particular
 * permutation in which the maximum number of pages allocated to a student is minimum of those
 * in all the other permutations and print this minimum value.
 * 3. Each book will be allocated to exactly one student. Each student has to be allocated at
 * least one book.
 * 4. Note: Return -1 if a valid assignment is not possible, and allotment should be in
 * contiguous order.
 */
public class AllocateMinNumberOfPages {

  /**
   * https://www.youtube.com/watch?v=okP-e2VpI_g
   * Here max number will range from max element from the array and sum of all elements.
   * This is a binary search problem. So initially low = max element of array and high = sum of all elements.
   * Now get the mid = low+high/2. Now find if by assigning mid number of pages to a student
   * if it is possible to divide the books between m students. Else calculate the mid again.
   *
   * @param bookArray
   * @param student
   * @return
   */
  public static int minBookPages(int[] bookArray, int student) {
    int maxElement = Integer.MIN_VALUE;
    int sumArray = 0;

    for (int pages : bookArray) {
      maxElement = Math.max(maxElement, pages);
      sumArray += pages;
    }

    int ans = 0;
    int hi = sumArray;
    int low = maxElement;

    while (low <= hi) {
      int mid = (low+hi)/2;

      if (findIfPossible(mid, bookArray, student)) {
        ans = mid;
        hi = mid-1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  public static boolean findIfPossible(int target, int[] bookArray, int studentCount) {
    int sum = 0;
    int studentNumber = 1;
    for (int i=0; i< bookArray.length; i++) {
      sum = sum + bookArray[i];

      if (sum > target) {
        sum = bookArray[i];
        studentNumber++;
      }
    }

    return studentNumber <= studentCount;
  }

  public static void main(String[] args) {
    int[] bookArray = {20,10,30,40};
    int student = 2;

    System.out.println(minBookPages(bookArray, student));

  }
}
