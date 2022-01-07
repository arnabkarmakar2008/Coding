package com.example.coding.search.binary;

public class BinarySearch {
  public static int search(int[] array, int left, int right, int key) {
    if (left > right) {
      return -1;
    }

    int middle = left + (right-left)/2;

    if (array[middle] == key) {
      return middle;
    } else if (key < array[middle]) {
      return search(array, 0, middle-1, key);
    } else {
      return search(array, middle+1, array.length-1, key);
    }
  }

  public static void main(String[] args) {
    int[] array = {1,2,3,4,5,6,7,8,9};

    System.out.println(search(array, 0, 8, 10));
  }
}
