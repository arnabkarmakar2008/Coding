package com.example.coding.search.playlist;

public class OrderAgnosticSearch {


  public static boolean search(int[] nums, int target) {
    int low = 0;
    int high = nums.length-1;

    while(low<=high) {
      int mid = low + (high-low)/2;

      if (nums[mid] == target) {
        return true;
      } else if (target > nums[mid]) {
        if (nums[nums.length-1] > nums[0]) {
          low = mid+1;
        } else {
          high = mid-1;
        }
      } else {
        if (nums[nums.length-1] > nums[0]) {
          high = mid-1;
        } else {
          low = mid+1;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    //int[] nums = {1,2,3,4,5,6,7,8};
    int[] nums = {8,6,5,4,2,1};
    int target = 0;
    System.out.println(search(nums, target));
  }
}
