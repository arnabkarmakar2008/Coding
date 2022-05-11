package com.example.coding.search.leetcode.hard;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {

  /**
   * This will be O(m+n) solution
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] mergedArray = mergeSortedArray(nums1, nums2);

    if (mergedArray.length % 2 == 0) {
      int index = mergedArray.length/2;
      int index2 = index-1;

      double returnValue = (mergedArray[index] + mergedArray[index2])/2.0;

      return returnValue;
    } else {
      int index = mergedArray.length/2;
      return mergedArray[index];
    }
  }

  public static int[] mergeSortedArray(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int[] mergedArray = new int[nums1.length + nums2.length];
    int counter = 0;

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        mergedArray[counter] = nums1[i];
        i++;
      } else {
        mergedArray[counter] = nums2[j];
        j++;
      }

      counter++;
    }

    while (i < nums1.length) {
      mergedArray[counter] = nums1[i];
      i++;
      counter++;
    }

    while (j < nums2.length) {
      mergedArray[counter] = nums2[j];
      j++;
      counter++;
    }

    return mergedArray;
  }


  /**
   * https://www.youtube.com/watch?v=jDJuW7tSxio
   *
   * This will be log(m+n)
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedianSortedArraysEfficient(int[] nums1, int[] nums2) {
    int low = 0;
    int high = nums1.length;

    int totalLength = (nums1.length+nums2.length);

    while (low <= high) {
      int numberOfLeftElmnt1 = low+high/2;
      int numberOfLeftElmnt2 = (totalLength+1)/2 - numberOfLeftElmnt1; // If total length is odd, then left will contain one more element.

      int numberOfLeftElmnt1m1 = numberOfLeftElmnt1 == 0 ? Integer.MIN_VALUE : nums1[numberOfLeftElmnt1-1];
      int numberOfLeftElmnt1Element = numberOfLeftElmnt1 == nums1.length ? Integer.MAX_VALUE : nums1[numberOfLeftElmnt1];

      int numberOfLeftElmnt2m1 = numberOfLeftElmnt2 == 0 ? Integer.MIN_VALUE : nums2[numberOfLeftElmnt2-1];
      int numberOfLeftElmnt2Element = numberOfLeftElmnt2 == nums2.length ? Integer.MAX_VALUE : nums2[numberOfLeftElmnt2];


      if (nums1[numberOfLeftElmnt1-1] <= nums2[numberOfLeftElmnt2] && nums2[numberOfLeftElmnt2-1] <= nums1[numberOfLeftElmnt1]) {

        double median = 0;

        if (totalLength%2 == 0) {
          //For even we havw to take max from left array and mi from right array.
          int max = Math.max(nums1[numberOfLeftElmnt1-1], nums2[numberOfLeftElmnt2-1]);
          int min = Math.min(nums1[numberOfLeftElmnt1], nums2[numberOfLeftElmnt2]);
          return (max+min)/2;
        } else {
          //For odd, it will be max from left array
          return Math.max(nums1[numberOfLeftElmnt1-1], nums2[numberOfLeftElmnt2-1]);

        }
      } else if (nums1[numberOfLeftElmnt1-1] > nums2[numberOfLeftElmnt2]) {
        //there are more elements to pick from nums2. So shift high to mid-1;
        high = numberOfLeftElmnt1-1;
      } else if (nums2[numberOfLeftElmnt2-1] > nums1[numberOfLeftElmnt1]) {
        //there are more elements to pick from nums1. So shift low to mid+1;
        low = numberOfLeftElmnt1+1;
      }

    }
    return 0;
  }

  public static void main(String[] args) {
    int[] nums1 = {1,2};
    int[] nums2 = {3,4};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }
}
