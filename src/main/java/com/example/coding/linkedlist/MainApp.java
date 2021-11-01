package com.example.coding.linkedlist;

import com.example.coding.linkedlist.main.Link;
import com.example.coding.linkedlist.main.LinkedList;

public class MainApp {
    public static void main(String[] args) {
        /*LinkedList list = new LinkedList();

        list.insertFirst(1);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(5);
        list.insertFirst(2);
        list.insertFirst(3);
        list.displayList();

        System.out.println("============");

        list.deleteFromPosition(1);
        System.out.println("============");
        list.displayList();

        list.deleteFromPosition(0);
        System.out.println("============");
        list.displayList();

        list.deleteFromPosition(4);
        System.out.println("============");
        list.displayList();

        System.out.println("Linkedlist length :: " + list.lengthRecursion(list.first));

        System.out.println("Get Nth Element :: " + list.getNth(4));

        System.out.println("Get Nth Element From End:: " + list.getNthFromEnd(3));

        System.out.println("Occurrence of Key :: " + list.occurrenceOfKey(2));

        list.detectLoop();

        LinkedList list2 = new LinkedList();
        Link head = new Link(1);
        head.next = new Link(2);
        head.next.next = new Link(3);
        head.next.next.next = new Link(4);
        head.next.next.next.next = new Link(5);
        head.next.next.next.next.next = new Link(6);
        head.next.next.next.next.next.next = new Link(7);
        head.next.next.next.next.next.next.next = head.next.next.next;

        System.out.println("Loop length :: " + loopLength(head));
*/
        LinkedList list3 = new LinkedList();
        list3.insertFirst(1);
        list3.insertFirst(1);
        list3.insertFirst(1);
        list3.insertFirst(1);
        list3.insertFirst(1);
        list3.displayList();
        System.out.println(list3.palindrome(list3));


    }

    public static int loopLength(Link first) {
        Link slowPointer = first;
        Link fastPointer = first;
        int flag = 0;
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return loopTraverse(slowPointer);
            }
        }
        return 0;
    }

    private static int loopTraverse(Link link) {
        int count = 1;
        Link temp = link;

        while (temp.next != link) {
            count ++;
            temp = temp.next;
        }

        return count;
    }
}
