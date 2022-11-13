package com.example.coding.matrix.hard;

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
   * Check thi one : https://www.youtube.com/watch?v=NTop3VTjmxk   Striver
   *
   * Idea is to divide the elements of two arrays in two half. Lets call it left half and right half
   *
   * 1 3 4 | 7 10 12
   * 2 3   | 6 15
   *
   * In the above arrays, left elements will be 1 3 4 & 2 3 and right will be 7 10 12 & 6 15
   * Because 4 <=6 && 3<=7
   *
   * Now if total size of the two arrays is even then median will be {max(4,3) + min (7,6)}/2
   *
   *
   * This will be log(m+n)
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedianSortedArraysEfficient(int[] arr1, int[] arr2) {
    //Do binary search always on shorter array
    if (arr1.length > arr2.length) {
      return findMedianSortedArrays(arr2, arr1);
    }

    /**
     * arr1 = {7,12,14,15}
     * arr2 = {1,2,3,4,9,11}
     *
     * Now we will do BS on arr1. We can select min 1 element from arr1 and max 4 elements from arr1.
     *
     * Total there are 10 elements. So each half will have 5 elements.
     *
     * So if we are choosing 1 element from arr1 as left, then we have to choose 5-1 = 4 elements from arr2 as left.
     *
     * So for BS, low = 0 and high = arr1.len = 4. So mid = (0+4)/2 = 2. So we will pick 2 elements from arr1 first. So
     * there will be 5-2 = 3 elements will be picked from arr2.
     *
     * So if there are total 11 elements then 6th element will be the median. That will be highest element from left half.
     * If there are 12 elements then 5th and 6th elemenmt will contribute to the median.
     * So to calculate size of cut2 = size(arr1)+size(arr2)+1/2 - cut1 will work for both odd and even
     *
     * Note :
     */

    int low = 0;
    int high = arr1.length;

    int totalLength = (arr1.length+arr2.length);

    while (low <= high) {

      int cut1 = (low+high)/2;
      int cut2 = (arr1.length+arr2.length+1)/2 - cut1;

      int left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1-1];
      int left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1];

      int right1 = cut1 == arr1.length ? Integer.MAX_VALUE : arr1[cut1];
      int right2 = cut2 == arr2.length ? Integer.MAX_VALUE : arr2[cut2];

      if (left1 <= right2 && left2 <= right1) {

        double median = 0;

        if (totalLength%2 == 0) {
          //For even we havw to take max from left array and mi from right array.
          int max = Math.max(arr1[cut1-1], arr2[cut1-1]);
          int min = Math.min(arr2[cut2], arr2[cut2]);
          return (max+min)/2;
        } else {
          //For odd, it will be max from left array
          return Math.max(arr1[cut1-1], arr2[cut1-1]);

        }
      } else if (left1 > right2) {
        //there are more elements to pick from nums2. So shift high to mid-1;
        high = cut1-1;
      } else if (left2 > right1) {
        //there are more elements to pick from nums1. So shift low to mid+1;
        low = cut1+1;
      }

    }
    return 0.0;
  }

  public static void main(String[] args) {
    int[] nums1 = {1,2};
    int[] nums2 = {3,4};
    System.out.println(findMedianSortedArrays(nums1, nums2));
  }
}
