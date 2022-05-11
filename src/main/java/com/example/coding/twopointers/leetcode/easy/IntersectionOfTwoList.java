package com.example.coding.twopointers.leetcode.easy;

import com.example.coding.linkedlist.main.Link;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at
 * which the two lists intersect. If the two linked lists have no intersection at all, return null.
 */
public class IntersectionOfTwoList {

  /**
   * https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
   * @param headA
   * @param headB
   * @return
   */
  public static Link getIntersectionNode(Link headA, Link headB) {
    if (headA == null || headB == null) {
      return null;
    }

    Link a = headA;
    Link b = headB;

    while (a != b) {
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }

    return a;
  }

  public static void main(String[] args) {
    Link intersect = new Link(10);
    intersect.next = new Link(20);
    intersect.next.next = new Link(30);
    intersect.next.next.next = null;

    Link head1 = new Link(1);
    head1.next = new Link(2);
    head1.next.next = new Link(3);
    head1.next.next.next = intersect;

    Link head2 = new Link(5);
    head2.next = new Link(6);
    head2.next.next = intersect;

    Link point = getIntersectionNode(head1, head2);

    System.out.println(point.data);
  }
}
