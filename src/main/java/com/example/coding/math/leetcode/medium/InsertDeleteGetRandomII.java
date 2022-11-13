package com.example.coding.math.leetcode.medium;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 * Note :: may contain duplicates
 */
public class InsertDeleteGetRandomII {

    /**
     * https://www.youtube.com/watch?v=a-UYY_DvCBY - pepcoding
     *
     * @param args
     */
    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        randomizedCollection.insert(3);

        randomizedCollection.remove(2);

        System.out.println(randomizedCollection.getRandom());

    }
}

class RandomizedCollection {

    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    public RandomizedCollection() {

    }

    public boolean insert(int val) {

        boolean contain = map.containsKey(val);

        if (! contain) {
            map.put(val, new LinkedHashSet<Integer>());
        }

        map.get(val).add(list.size());
        list.add(val);
        return ! contain;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int index = map.get(val).iterator().next();

            //remove index from list
            map.get(val).remove(index);

            //if index is not lst in the list
            if (index < list.size()-1) {
                int lastVal = list.get(list.size()-1);
                list.set(index, lastVal);
                map.get(lastVal).remove(list.size()-1);
                map.get(lastVal).add(index);
            }

            list.remove(list.size()-1);

            if (map.get(val).isEmpty()) {
                map.remove(val);
            }
            return true;
        }
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
