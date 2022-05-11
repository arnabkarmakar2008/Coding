package com.example.coding.twopointers.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

/**
 * Given the head of a linked list and a value x, partition it such that all
 * nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartittionLinkedList {

  /**
   * https://www.youtube.com/watch?v=KT1iUciJr4g
   * Idea is to create two lists. One with smaller elements and another with value >=x.
   * Then at the end join the two lists back.
   * @param head
   * @param x
   * @return
   */
  public static Link partition(Link head, int x) {

    Link smallHead = new Link(0); //dummy small head
    Link bigHead = new Link(0); //dummy big head

    Link smallTail = smallHead;
    Link bigTail = bigHead;

    while (head != null) {
      if (head.data < x) {
        smallTail.next = head;
        smallTail = smallTail.next;
      } else {
        bigTail.next = head;
        bigTail = bigTail.next;
      }

      head = head.next;
    }

    smallTail.next = bigHead.next; //bigHead is dummy node.
    bigTail.next = null;

    return smallHead.next;
  }

  public static void main(String[] args) {
    Link head1 = new Link(1);
    head1.next = new Link(4);
    head1.next.next = new Link(3);
    head1.next.next.next = new Link(2);
    head1.next.next.next.next = new Link(5);
    head1.next.next.next.next.next = new Link(2);
    head1.next.next.next.next.next.next = new Link(6);

    Link newNode = partition(head1, 3);
    System.out.println(newNode.data);
  }
}
