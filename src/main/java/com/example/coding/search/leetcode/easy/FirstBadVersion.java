package com.example.coding.search.leetcode.easy;

public class FirstBadVersion {

  public static void main(String[] args) {
    Solution sln = new Solution();
    System.out.println(sln.firstBadVersion(8));
  }
}

class VersionControl {
  boolean isBadVersion(int version) {
    if (version >= 5) {
      return true;
    }

    return false;
  }
}

class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int low = 1;
    int high = n;

    while (low <= high) {
      int mid = (low+high)/2;

       if (isBadVersion(mid)) {
         high = mid-1;
       } else {
         low = mid+1;
       }
    }

    return low;
  }
}
