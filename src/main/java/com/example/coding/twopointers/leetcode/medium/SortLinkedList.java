package com.example.coding.twopointers.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 */
public class SortLinkedList {

  /**
   * Divide the list into 2 halves and call merge sort kind of
   * @param head
   * @return
   */
  public static Link sortList(Link head) {
    if (head == null || head.next == null) {
      return head;
    }

    Link left = head;
    Link right = getMid(head);
    Link temp = right.next;
    right.next = null;
    right = temp;

    Link sortedLeft = sortList(left);
    Link sortedRight = sortList(right);

    return mergeSorted(sortedLeft, sortedRight);
  }

  private static Link mergeSorted(Link sortedLeft, Link sortedRight) {
    Link dummy = new Link(0);
    Link temp = dummy;


    while (sortedLeft!= null && sortedRight!= null) {
      if (sortedLeft.data < sortedRight.data) {
        temp.next = sortedLeft;
        sortedLeft = sortedLeft.next;
      } else {
        temp.next = sortedRight;
        sortedRight = sortedRight.next;
      }

      temp = temp.next;
    }

    if (sortedLeft != null) {
      temp.next = sortedLeft;
    } else if (sortedRight != null) {
      temp.next = sortedRight;
    }

    return dummy.next;
  }

  private static Link getMid(Link head) {
    Link slow = head;
    Link fast = head.next;

    while (fast != null && fast.next!= null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    Link head1 = new Link(7);
    head1.next = new Link(10);
    head1.next.next = new Link(6);
    head1.next.next.next = new Link(5);
    head1.next.next.next.next = new Link(13);
    head1.next.next.next.next.next = new Link(15);
    head1.next.next.next.next.next.next = new Link(14);

    Link sortedHead = sortList(head1);
    System.out.println(sortedHead.data);
  }
}
