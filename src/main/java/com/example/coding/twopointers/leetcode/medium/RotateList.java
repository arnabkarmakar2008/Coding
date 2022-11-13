package com.example.coding.twopointers.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */
public class RotateList {

  public static Link rotateRight(Link head, int k) {
    Link leftPointer = head;
    Link rightPointer = head;
    int counter = k;
    while (counter > 0) {
      rightPointer = rightPointer.next;
      counter--;
    }

    while (rightPointer.next != null) {
      leftPointer = leftPointer.next;
      rightPointer = rightPointer.next;
    }

    rightPointer.next = head;

    head = leftPointer.next;
    leftPointer.next = null;

    return head;

  }

  public static void main(String[] args) {
    Link head1 = new Link(7);
    head1.next = new Link(10);
    head1.next.next = new Link(11);
    head1.next.next.next = new Link(12);
    head1.next.next.next.next = new Link(13);
    head1.next.next.next.next.next = new Link(14);
    head1.next.next.next.next.next.next = new Link(15);

    Link newHead = rotateRight(head1, 2);
  }
}
