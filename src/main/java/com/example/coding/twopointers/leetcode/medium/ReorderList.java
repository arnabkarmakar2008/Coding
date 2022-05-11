package com.example.coding.twopointers.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {

  /**
   * Get the middle of the list. Then we have to reverse the 2nd half of the list.
   *
   * https://www.youtube.com/watch?v=S5bfdUTrKLM&t=1s
   * @param head
   */
  public static void reorderList(Link head) {

    //Get the middle of the list
    Link slowPointer = head;
    Link fastPointer = head.next;

    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }

    Link middleHead = slowPointer.next;

    Link previousNode = null;

    //Reverse the second half of the list
    while (middleHead != null) {
      Link tempNode = middleHead.next;
      middleHead.next = previousNode;
      previousNode = middleHead;
      middleHead = tempNode;
    }

    //merge two half of the lists
    //previousNode would be the head of the 2nd half
    Link first = head;
    Link second = previousNode;

    while (second != null) {
      Link temp1 = first.next;
      Link temp2 = second.next;

      first.next = second;
      second.next = temp1;

      //shift pointers
      first = temp1;
      second = temp2;

    }

  }

  public static void main(String[] args) {

  }

}
