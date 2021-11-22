package com.example.coding.queue;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
    //Use LinkedHashSet to maintain insertion order
    private Set<Integer> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashSet<>(capacity);
    }

    /**
     * If present in cache then bring that element to front
     * @param key
     * @return
     */
    public boolean getKeyFromCache(int key) {
        if (!cache.contains(key)) {
            return false;
        }

        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void putKeyInCache(int key) {
        if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }

        cache.add(key);
    }

    public void referCache(int key) {
        if (!getKeyFromCache(key)) {
            putKeyInCache(key);
        }
    }

    public void display()
    {
        LinkedList<Integer> list = new LinkedList<>(cache);

        // The descendingIterator() method of java.util.LinkedList
        // class is used to return an iterator over the elements
        // in this LinkedList in reverse sequential order
        Iterator<Integer> itr = list.descendingIterator();

        while (itr.hasNext())
            System.out.println(itr.next() + " ");
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.referCache(1);
        cache.referCache(2);
        cache.referCache(3);
        cache.referCache(4);
        System.out.println("========");
        cache.display();

        cache.referCache(2);

        System.out.println("========");
        cache.display();

        cache.referCache(5);

        System.out.println("========");
        cache.display();
    }
}
