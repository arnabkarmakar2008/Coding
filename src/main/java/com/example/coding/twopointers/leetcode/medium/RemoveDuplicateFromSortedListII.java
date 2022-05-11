package com.example.coding.twopointers.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

public class RemoveDuplicateFromSortedListII {

  /**
   * https://www.youtube.com/watch?v=R6-PnHODewY
   * @param head
   * @return
   */
  public static Link deleteDuplicates(Link head) {

    Link dummy = new Link(100);
    dummy.next = head;
    Link previous = dummy; // dummy node


    while (head != null) {
      if (head.next != null && head.data == head.next.data) {
        while (head.next != null && head.data == head.next.data) {
          head = head.next;
        }

        previous.next = head.next;
      } else {
        previous = previous.next;
      }

      head = head.next;

    }

    return dummy.next;

  }

  public static void main(String[] args) {
    Link head1 = new Link(1);
    head1.next = new Link(2);
    head1.next.next = new Link(3);
    head1.next.next.next = new Link(3);
    head1.next.next.next.next = new Link(4);
    head1.next.next.next.next.next = new Link(5);
    head1.next.next.next.next.next.next = new Link(5);

    Link newNode = deleteDuplicates(head1);
  }
}
