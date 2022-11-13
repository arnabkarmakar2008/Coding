package com.example.coding.twopointers.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndOfList {

  /**
   * https://www.youtube.com/watch?v=XVuQxVej6y8
   * @param head
   * @param n
   * @return
   */
  public static Link removeNthFromEnd(Link head, int n) {
    Link dummyNode = new Link(0);
    dummyNode.next = head;

    Link rightPointer = null;

    while (n > 0) {
      rightPointer = head.next;
      n--;
    }

    Link leftPointer = dummyNode;

    while (rightPointer != null) {
      rightPointer = rightPointer.next;
      leftPointer = leftPointer.next;
    }

    //delete
    leftPointer.next = leftPointer.next.next;

    return dummyNode.next;

  }


  public static void main(String[] args) {

  }

}
