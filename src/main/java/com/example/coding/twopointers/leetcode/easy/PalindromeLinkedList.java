package com.example.coding.twopointers.leetcode.easy;

import com.example.coding.linkedlist.main.Link;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 */
public class PalindromeLinkedList {

  public static boolean isPalindrome(Link head) {
    Link slowPointer = head;
    Link fastPointer = head;

    while (fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }

    Link secondHead = null;

    if (fastPointer.next == null) {
      slowPointer = slowPointer.next; // In case of odd node
    }

    fastPointer = head;

    slowPointer = reverseList(slowPointer);

    while (slowPointer != null) {
      if (fastPointer.data != slowPointer.data) {
        return false;
      }

      fastPointer = fastPointer.next;
      slowPointer = slowPointer.next;
    }

    return true;
  }

  private static Link reverseList(Link head) {
    Link previous = null;

    while (head != null) {
      Link temp = head.next;
      head.next = previous;
      previous = head;
      head = temp;
    }

    return previous;
  }




  public static void main(String[] args) {
    Link head1 = new Link(7);
    head1.next = new Link(10);
    head1.next.next = new Link(11);
    head1.next.next.next = new Link(10);
    head1.next.next.next.next = new Link(7);


    System.out.println(isPalindrome(head1));



  }
}
