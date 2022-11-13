package com.example.coding.math.leetcode.medium;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode tempNode = new ListNode();
        ListNode headNode = new ListNode();
        tempNode.next = headNode;
        while (l1 != null || l2 != null || carryOver != 0) {
            int newVal = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carryOver;
            int newNodeVal = 0;

            if (newVal >= 10) {
                carryOver = newVal/10;
                newNodeVal = newVal%10;
            } else {
                carryOver = 0;
                newNodeVal = newVal;
            }

            headNode.val = newNodeVal;
            headNode.next = new ListNode();
            headNode = headNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        /*if (l1 == null && l2 == null && carryOver!=0) {
            headNode.val = carryOver;
        }*/

        return tempNode.next;

    }

    public static void main(String[] args) {
        ListNode firstNode = new ListNode(9);
        firstNode.next = new ListNode(9);
        firstNode.next.next = new ListNode(9);

        ListNode secondNode = new ListNode(9);
        secondNode.next = new ListNode(9);
        secondNode.next.next = new ListNode(9);

        ListNode result = addTwoNumbers(firstNode, secondNode);

        System.out.println(result.val);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }