package com.example.coding.string.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Please implement encode and decode
 *
 * Input: ["lint","code","love","you"]
 * Output: ["lint","code","love","you"]
 * Explanation:
 * One possible encode method is: "lint:;code:;love:;you"
 */
public class EncodeAndDecodeString {


    public static void main(String[] args) {

    }


    class EncodeDecode {
        public EncodeDecode() {

        }

        public String encode(String[] strs) {
            StringBuffer sb = new StringBuffer();
            for (String str : strs) {
                sb.append(str.length()).append("#").append(str);
            }

            return sb.toString();
        }

        public List<String> decode(String str) {
            List<String> list = new ArrayList<>();
            int start = 0;
            while (start < str.length()) {
                int end = start;
                while (str.charAt(end) != '#') {
                    end = end+1;
                }

                int length = Integer.parseInt(str.substring(start, end));

                //Now extract length size string
                String temString = str.substring(end+1, end+1+length);

                list.add(temString);

                start = end+1+length;
            }

            return list;
        }
    }
}
