package com.example.coding.sort.basic;

public class MergeSort {

  public static int[] mergeSort(int[] nums, int low, int high) {

    if (low == high) {
      int[] newArray = new int[1];
      newArray[0] = nums[low];
      return newArray;
    }

    int mid = (low+high)/2;

    int[] leftSortedArray = mergeSort(nums, low, mid);
    int[] rightSortedArray = mergeSort(nums, mid+1, high);
    int[] mergedSortedArray = mergeTwoSortedArrays(leftSortedArray, rightSortedArray);

    return mergedSortedArray;

  }

  private static int[] mergeTwoSortedArrays(int[] array1, int[] array2) {
    int pointer1 = 0;
    int pointer2 = 0;
    int newPointer = 0;

    int[] newArray = new int[array1.length+array2.length];

    while (pointer1 < array1.length && pointer2 < array2.length) {
      if (array1[pointer1] < array2[pointer2]) {
        newArray[newPointer] = array1[pointer1];
        pointer1++;
      } else {
        newArray[newPointer] = array2[pointer2];
        pointer2++;
      }
      newPointer++;
    }

    while (pointer1 < array1.length) {
      newArray[newPointer] = array1[pointer1];
      newPointer++;
      pointer1++;
    }

    while (pointer2 < array2.length) {
      newArray[newPointer] = array2[pointer2];
      newPointer++;
      pointer2++;
    }

    return newArray;
  }

  public static void main(String[] args) {
    int[] nums = {2,9,5,1,3};
    int[] sorted = mergeSort(nums, 0, nums.length-1);

    for (int num : sorted) {
      System.out.println(num);
    }
  }
}
