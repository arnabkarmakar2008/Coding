package com.example.coding.priorityqueue.leetcode.medium;

import com.example.coding.linkedlist.main.Link;

public class MergeKSortedLists {

    public static Link mergeKLists(Link[] lists) {
        return mergeLists(lists, 0, lists.length-1);
    }

    private static Link mergeLists(Link[] lists, int low, int high) {
        if (low > high) {
            return null;
        }

        if (low == high) {
            return lists[low];
        }

        int mid = low + (high-low)/2;

        Link leftList = mergeLists(lists, low, mid);
        Link rightList = mergeLists(lists, mid+1, high);

        Link mergedList = mergeSortedList(leftList, rightList);

        return mergedList;
    }


    private static Link mergeSortedList(Link list1, Link list2) {

        if (list1 == null) return list2;

        if (list2 == null) return list1;

        Link dummy = new Link(-100);
        Link prev = dummy;

        Link l1 = list1;
        Link l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }

        prev.next = l1 == null ? l2 : l1;


        return dummy.next;
    }


    public static void main(String[] args) {

    }

}
