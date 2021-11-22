package com.example.coding.linkedlist;

import com.example.coding.linkedlist.main.Link;
import com.example.coding.linkedlist.main.LinkedList;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
        /*LinkedList list3 = new LinkedList();
        list3.insertFirst(1);
        list3.insertFirst(1);
        list3.insertFirst(1);
        list3.insertFirst(1);
        list3.insertFirst(1);
        list3.displayList();
        System.out.println(list3.palindrome(list3));*/


        /*Link head = new Link(11);
        head.next = new Link(11);
        head.next.next = new Link(11);
        head.next.next.next = new Link(12);
        head.next.next.next.next = new Link(13);
        head.next.next.next.next.next = new Link(13);
        head.next.next.next.next.next.next = new Link(14);

        Link modifiedHead = removeDuplicateInSortedList(head);

        modifiedHead.displayLink();
*/
        /*Link head = new Link(7);
        head.next = new Link(10);
        head.next.next = new Link(11);
        head.next.next.next = new Link(9);
        head.next.next.next.next = new Link(8);
        head.next.next.next.next.next = new Link(13);
        head.next.next.next.next.next.next = new Link(14);

        Link modifiedHead = swapNodesWithoutSwappingData(head, 10, 14);

        modifiedHead.displayLink();*/

        Link head1 = new Link(7);
        head1.next = new Link(10);
        head1.next.next = new Link(11);
        head1.next.next.next = new Link(12);
        head1.next.next.next.next = new Link(13);
        head1.next.next.next.next.next = new Link(14);
        head1.next.next.next.next.next.next = new Link(15);

        Link head2 = new Link(6);
        head2.next = new Link(7);
        head2.next.next = new Link(10);
        head2.next.next.next = new Link(11);

        Link mergedLink = intersectionOfSortedList(head1, head2);

        mergedLink.displayLink();

        Link reverseLink = reverseList(head2);
        reverseLink.displayLink();

    }

    public static Link reverseList(Link head) {
        Link current = head;
        Stack<Link> stack= new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        Link newHead = null;
        Link temp = null;

        while (!stack.empty()) {
            Link link = stack.pop();
            if (newHead == null) {
                newHead = link;
                temp = newHead;
            } else {
                temp.next = link;
                temp = temp.next;

            }
        }

        if (temp != null) {
            temp.next = null;
        }

        return newHead;
    }

    public static Link intersectionOfSortedList(Link head1, Link head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        if (head1.data == head2.data) {
            Link link = new Link(head1.data);
            link.next = intersectionOfSortedList(head1.next, head2.next);
            return link;
        } else if (head1.data < head2.data) {
            return intersectionOfSortedList(head1.next, head2);
        } else {
            return intersectionOfSortedList(head1, head2.next);
        }
    }

    public static Link swapNodesWithoutSwappingData(Link first, int key1, int key2) {
        Link key1Link = null;
        Link key1Previous = null;

        Link key2Link = null;
        Link key2Previous = null;

        Link current = first;
        Link previous = first;

        while (current != null) {
            if (current.data == key1) {
                key1Link = current;
                key1Previous = previous;
            }

            if (current.data == key2) {
                key2Link = current;
                key2Previous = previous;
            }

            previous = current;
            current = current.next;
        }

        if (key1Link == null || key2Link == null) {
            System.out.println("Key do not exist!!!!!");
        } else {
            Link tempNext = key2Link.next;
            Link tempPrevious = key2Previous;

            key2Link.next = key1Link.next;
            key1Previous.next = key2Link;

            key1Link.next = tempNext;
            tempPrevious.next = key1Link;


        }

        return first;

    }

    public static Link removeDuplicateInSortedList(Link first) {
        Link head = first;
        Link current = first.next;
        Link previous = first;

        while (current.next != null) {
            if (previous.data == current.data) {
                previous.next = current.next;
                current = current.next;
            } else {
                previous = current;
                current = current.next;
            }
        }

        return head;
    }

    public static Link removeDuplicateInUnSortedList(Link first) {
        Set<Integer> set = new HashSet<>();
        Link head = first;
        Link current = first;
        Link previous = first;

        while (current!= null) {
            if (set.contains(current.data)) {
                previous.next = current.next;
                current = current.next;
            } else {
                set.add(current.data);
                previous = current;
                current = current.next;
            }
        }

        return head;
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
