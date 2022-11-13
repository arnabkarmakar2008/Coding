package com.example.coding.math.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 *
 * Implement the Solution class:
 *
 * Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
 * int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.
 */
public class LinkedListRandomNodes {

    public static void main(String[] args) {
        Link head1 = new Link(7);
        head1.next = new Link(10);
        head1.next.next = new Link(11);
        head1.next.next.next = new Link(12);
        head1.next.next.next.next = new Link(13);
        head1.next.next.next.next.next = new Link(14);
        head1.next.next.next.next.next.next = new Link(15);

        Solution solution = new Solution(head1);
        System.out.println(solution.getRandom());
    }
}

/**
 * Reservoir sampling technique....
 *
 *
 *
 */
class Solution {

    Link head;

    public Solution(Link head) {
        this.head = head;
    }

    public int getRandom() {
        int result = -1;
        Link tempHead = head;
        Random random = new Random();

        for (int i = 1; tempHead!= null; i++) {
            if (random.nextInt(i) == i-1) {
                result = tempHead.data;
            }

            tempHead = tempHead.next;
        }

        return result;
    }
}
