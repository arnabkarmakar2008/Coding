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

    Link fastPointer = null;

    while (n > 0) {
      fastPointer = head.next;
      n--;
    }

    Link slowPointer = dummyNode;

    while (fastPointer != null) {
      fastPointer = fastPointer.next;
      slowPointer = slowPointer.next;
    }

    //delete
    slowPointer.next = slowPointer.next.next;

    return dummyNode.next;

  }


  public static void main(String[] args) {

  }

}
