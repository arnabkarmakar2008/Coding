package com.example.coding.twopointers.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

public class RemoveDuplicateFromSortedList {

  public static Link deleteDuplicates(Link head) {
    Link currentNode = head;


    while (currentNode.next != null) {
      if (currentNode.data == currentNode.next.data) {
        currentNode.next = currentNode.next.next;
      } else {
        currentNode = currentNode.next;
      }
    }

    return head;

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
