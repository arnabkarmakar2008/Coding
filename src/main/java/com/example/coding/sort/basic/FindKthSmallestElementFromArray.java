package com.example.coding.sort.basic;

/**
 * Quick Select Algo. Almost similar as quick sort.
 *
 * Lets say we have to select 4th smallest element. So it will be 3rd index element from array after
 * partitioning based on quick sort.
 *
 */
public class FindKthSmallestElementFromArray {

  public static int findKthSmallest(int[] nums,int low, int high, int k) {
    int pivotElement = nums[high];
    int pivotIndex = partitionArray(nums, pivotElement);

    if (k > pivotIndex) {
      //Element will be in right side of array
      return findKthSmallest(nums, pivotIndex+1, high, k);
    } else if (k < pivotIndex) {
      //Element will be in left side of array
      return findKthSmallest(nums, low, pivotIndex-1, k);
    } else {
      //if equal then return pivot element
      return nums[pivotIndex];
    }
  }

  public static int partitionArray(int[] nums, int pivot) {
    int i = 0;
    int j = 0;

    while (i < nums.length && j < nums.length) {
      if (nums[i] > pivot) {
        i++;
      } else {
        swap(nums, i, j);
        i++;
        j++;
      }
    }

    return j-1;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  public static void main(String[] args) {
    int[] nums = {4,1,2,3,6,8,9};
    int num = findKthSmallest(nums, 0, nums.length-1, 3); //We are passing k-1 to change iit to index. So 3 means 4th smallest element
    System.out.println(num);
  }

}
