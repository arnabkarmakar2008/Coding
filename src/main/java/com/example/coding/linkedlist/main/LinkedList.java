package com.example.coding.linkedlist.main;

public class LinkedList {
    public Link first;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int value) {
        Link link = new Link(value);
        link.next = first;
        first = link;
    }

    public int deleteFirst() {
        Link temp = first;
        first = temp.next;
        return temp.data;
    }

    public void displayList() {
        Link current = first;

        while (current != null) {
            current.displayLink();
            current = current.next;
        }

    }

    public Link find(int value) {
        Link current = first;

        while (current.data != value ) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }

        return current;
    }

    public int delete(int value) {
        Link current = first;
        Link previous = first;

        while (current.data != value ) {
            if (current.next == null) {
                return 0;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current.data;

    }

    public int deleteFromPosition(int position) {
        Link temp = null;
        if (position == 0) {
            temp = first;
            first = first.next;
            return temp.data;
        } else {
            Link current = first;
            Link previous = first;
            int i = 0;
            while (i < position) {
                previous = current;
                current = current.next;
                i++;
            }

            if (current.next == null) {
                //Last position
                temp = current;
                previous.next = null;
                return current.data;
            } else {
                temp = current;
                previous.next = current.next;
                return temp.data;
            }

        }
    }

    public void insertAfter(int value, int newValue) {
        Link current = first;

        while (current.data != value) {
            if (current.next == null) {
                return;
            } else {
                current = current.next;
            }
        }

        Link newLink = new Link(newValue);
        Link temp = current.next;
        current.next = newLink;
        newLink.next = temp;
    }

    public int lengthRecursion(Link head) {
        if (head == null) {
            return 0;
        }

        return 1 + lengthRecursion(head.next);
    }

    public Link partition(Link node, int value) {
        Link lNode = null;
        Link gNode = null;
        Link lHead = null;
        Link gHead = null;

        Link eNode = null;
        Link eHead = null;

        while (node != null) {

            Link newLink = new Link(node.data);
            if (node.data < value) {
                if (lNode == null) {
                    lHead = newLink;
                    lNode = newLink;
                } else {
                    lNode.next = newLink;
                    lNode = newLink;
                }
            } else if (node.data == value) {
                if (eNode == null) {
                    eHead = newLink;
                    eNode = newLink;
                } else {
                    eNode.next = newLink;
                    eNode = newLink;
                }
            } else {
                if (gNode == null) {
                    gHead = newLink;
                    gNode = newLink;
                } else {
                    gNode.next = newLink;
                    gNode = newLink;
                }
            }

            node = node.next;
        }

        if (eHead != null) {
            lNode.next = eHead;
            eNode.next = gHead;
        } else {
            lNode.next = gHead;
        }

        return lHead;
    }

    public int getNth(int index) {
        if (index == 0) {
            return first.data;
        } else {
            int i = 0;
            Link current = first;
            while (i < index) {
                current = current.next;
                i ++ ;
            }

            if (current != null) {
                return current.data;
            }

            return 0;
        }
    }

    public int getNthFromEnd(int index) {
        int length = lengthRecursion(first);
        int indexFromFirst = length - index;
        return getNth(indexFromFirst);
    }

    public int occurrenceOfKey(int key) {
        int count = 0;
        Link current = first;

        while (current != null) {
            if (current.data == key)
            {
                count ++;
            }
            current = current.next;
        }
        return count;
    }

    /**
     * Floyd’s Cycle-Finding Algorithm
     */
    public void detectLoop() {
        //Move slow by one and fast by two... If they both meet then there is loop
        Link slowPointer = first;
        Link fastPointer = first;
        int flag = 0;
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            System.out.println("Loop found");
        } else {
            System.out.println("loop not detected");
        }
    }

    public int loopLength(Link first) {
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

    private int loopTraverse(Link link) {
        int count = 0;
        Link temp = link;

        while (temp.next != link) {
            count ++;
            temp = temp.next;
        }

        return count;
    }

    public boolean palindrome(LinkedList list) {
        if (list.first.next == null) {
            return true;
        }

        Link current = list.first;
        Link previous = list.first;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        int firstValue = list.first.data;
        int lastValue = current.data;

        Link newFirst = list.first.next;

        list.first = newFirst;
        previous.next = null;
        current = null;

        return Boolean.logicalAnd((firstValue == lastValue), palindrome(list));

    }
}
