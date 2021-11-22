package com.example.coding.linkedlist.main;

import java.io.DataInput;

public class DoublyLinkedList {
    public DoublyLink first;

    public DoublyLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        DoublyLink current = first;
        System.out.println("============");

        while (current != null) {
            System.out.println("{ " + current.data + " }");
            current = current.next;
        }
    }

    public void insertFirst(int value) {
        DoublyLink newLink = new DoublyLink(value);

        if (!isEmpty()) {
            newLink.next = first;
            newLink.previous = null;
            first.previous = newLink;
            first = newLink;
        } else {
            first = newLink;
        }
    }

    public void insertLast(int value) {
        DoublyLink newLink = new DoublyLink(value);
        DoublyLink current = first;

        if (isEmpty()) {
            first = newLink;
        } else {
            while (current.next != null) {
                current = current.next;
            }

            current.next = newLink;
            newLink.previous = current;
            newLink.next = null;
        }

    }

    public void insertAfter(int value, int newValue) {
        DoublyLink newLink = new DoublyLink(newValue);
        DoublyLink current = first;

        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key not found");
        } else {

            if (current.next == null) { //last node
                current.next = newLink;
                newLink.previous = current;
                newLink.next = null;
            } else {
                newLink.next = current.next;
                current.next.previous = newLink;
                newLink.previous = current;
                current.next = newLink;
            }
        }

    }

    public DoublyLink deleteNodeWithValue(int value) {
        DoublyLink current = first;

        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value is not there!!!");
            return null;
        } else {
            // match found
            if (current.next == null) {
                //delete last node
                current.previous.next = null;

            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }

            return current;
        }
    }

    public void reverseDoublyLinkedList() {
        DoublyLink current = first;
        DoublyLink temp = null;
        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }

        if (temp != null) {
            first = temp.previous;
        }

    }

    public void swapNthNodeFromStartAndEnd(int value) {
        DoublyLink current = first;
        int counter = 0;
        DoublyLink frontNode = null;
        DoublyLink endNode = null;
        DoublyLink lastNode = null;

        while (current != null) {
            counter++;

            if (value == counter) {
                frontNode = current;
            }

            if (current.next == null) {
                lastNode = current;
            }

            current = current.next;
        }

        current = lastNode;

        counter = 0;

        while (current.previous != null) {
            counter ++;

            if (counter == value) {
                endNode = current;
                break;
            }

            current = current.previous;

        }

        DoublyLink tempNext = endNode.next;
        DoublyLink tempPrev = endNode.previous;


        endNode.next = frontNode.next;
        endNode.previous = frontNode.previous;
        frontNode.next.previous = endNode;
        frontNode.previous.next = endNode;

        frontNode.next = tempNext;
        frontNode.previous = tempPrev;
        tempNext.previous = frontNode;
        tempPrev.next = frontNode;
    }

    public void printPairWithGivenSum(int value) {
        /**
         * Sorted list with unique values.
         * IP : 2->4->6->8->10
         * OP : 10,2 & 8,4 for value = 12
         */

        DoublyLink front = first;
        DoublyLink current = first;
        DoublyLink end = null;

        while (current.next != null) {
            current = current.next;
        }

        end = current;

        while (front.previous != end) {
            if ((end.data + front.data) == value) {
                if (front != end) {
                    System.out.println("(" + end.data + "," + front.data + ")");
                }
                front = front.next;
            } else if ((end.data + front.data) > value) {
                end = end.previous;
            } else if ((end.data + front.data) < value) {
                front = front.next;
            }
        }
    }

    public void rotateListAntiClock(int value) {
        DoublyLink last = first;

        DoublyLink temp = null;

        DoublyLink newFirst = null;

        int count = 0;

        while (last.next != null) {
            count++;
            if (count == value) {
                newFirst = last.next;
            }
            last = last.next;
        }

        newFirst.previous.next = null;
        newFirst.previous = null;
        last.next = first;
        first.previous = last;
        first = newFirst;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(6);
        list.insertLast(8);
        list.insertLast(10);


        list.displayList();

        System.out.println("=========");
        list.rotateListAntiClock(2);

        list.displayList();


        //list.printPairWithGivenSum(12);

        /*list.insertAfter(2,4);

        list.displayList();

        list.insertLast(10);

        list.displayList();

        list.insertAfter(10,11);

        list.displayList();

        list.deleteNodeWithValue(14);

        list.displayList();

        list.swapNthNodeFromStartAndEnd(2);

        list.displayList();*/

        /*list.reverseDoublyLinkedList();

        list.displayList();
*/
    }
}
