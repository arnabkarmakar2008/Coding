package com.example.coding.sort.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

/**
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 */
public class InsertionSortList {

  /**
   * Main key is create dummy node. And place node between two nodes.
   * https://www.youtube.com/watch?v=Kk6mXAzqX3Y
   * @param head
   * @return
   */
  public static Link insertionSortList(Link head) {
    Link dummy = new Link(0);
    dummy.next = head;

    Link current = head.next;
    Link previous = head;

    while (current != null) {
      if (current.data >= previous.data) {
        previous = current;
        current = current.next;
        continue;
      } else {
        Link temp = dummy;

        while (current.data > temp.next.data) {
          temp = temp.next;
        }

        previous.next = current.next;
        current.next = temp.next;
        temp.next = current;
        current = previous.next;
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Link head1 = new Link(10);
    head1.next = new Link(8);
    head1.next.next = new Link(15);
    head1.next.next.next = new Link(7);
    head1.next.next.next.next = new Link(20);
    head1.next.next.next.next.next = new Link(50);
    head1.next.next.next.next.next.next = new Link(5);

    Link sortedHead = insertionSortList(head1);

    System.out.println(sortedHead.data);

  }
}
