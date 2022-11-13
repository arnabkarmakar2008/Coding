package com.example.coding.twopointers.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not
 * passed as a parameter.
 *
 * Do not modify the linked list.
 */
public class LinkedListLoopEntryPoint {

  /**
   * https://www.youtube.com/watch?v=q9aTM-6__Ho
   * @param head
   * @return
   */
  public static Link detectCycle(Link head) {
    Link slowPointer = head;
    Link fastPointer = head;

    while (slowPointer.next!= null && fastPointer!= null && fastPointer.next!= null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;

      if (slowPointer == fastPointer) {
        //loop exists

        // This is the trick to get starting point of loop.
        // Initialize slowPointer to head again and increment slow and fast both by 1.
        slowPointer = head;

        while (slowPointer != fastPointer) {
          slowPointer = slowPointer.next;
          fastPointer = fastPointer.next;
        }

        return slowPointer;

      }
    }

    return null;
  }

  public static void main(String[] args) {
    Link head1 = new Link(1);
    head1.next = new Link(2);
    Link loopEntry = head1.next.next = new Link(3);
    head1.next.next.next = new Link(4);
    head1.next.next.next.next = new Link(5);
    head1.next.next.next.next.next = new Link(6);
    head1.next.next.next.next.next.next = loopEntry;

    Link startingNode = detectCycle(head1);
    System.out.println(startingNode.data);
  }
}
