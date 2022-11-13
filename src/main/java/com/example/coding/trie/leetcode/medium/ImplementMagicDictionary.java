package com.example.coding.trie.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementMagicDictionary {


}

class MagicDict {
    Map<String, List<int[]>> map = new HashMap<>();

    public MagicDict() {
    }

    public void buildDict(String[] dictionary) {
        /*
        From each word, remove one char and store the rest string as key with index and removed char as pair
        hello

        Remove h : key = ello <0,h>
        Remove e : key = hllo <1,e>
        Remove l : key = helo <2,l>
        Remove l : key = helo <3,l>
        Remove o : key = hell <4,0>
         */
        for (int ct = 0; ct < dictionary.length; ct++) {
            String word = dictionary[ct];

            for (int i=0; i<word.length();i++) {
                char ch = word.charAt(i);
                String key = word.substring(0,i) + word.substring(i+1);
                int[] arr = {i, ch};

                List<int[]> list = map.getOrDefault(key, new ArrayList<>());
                list.add(arr);

                map.put(key, list);

            }
        }
    }

    public boolean search(String searchWord) {
        //Remove one by one char from word and check map if it is present as key.
        //if yes then if index is matching but chars are not then we have match

        // Lets say we have hllo <1, e> in map. And searchWord = hmllo. Now if we change m to
        // e we should have match. So we remove m from hmllo and get hllo. Now hllo is in map
        // and at the same index we have e and m.
        for (int ct = 0; ct < searchWord.length(); ct++) {
            char ch = searchWord.charAt(ct);

            String key = searchWord.substring(0,ct) + searchWord.substring(ct+1);
            if (map.containsKey(key)) {
                List<int[]> list = map.get(key);

                for (int[] arr : list) {
                    if (arr[0] == ct && arr[1] != ch) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
