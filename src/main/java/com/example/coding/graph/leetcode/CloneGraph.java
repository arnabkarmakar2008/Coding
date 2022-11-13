package com.example.coding.graph.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public UndirectedNode cloneGraph(UndirectedNode node) {
        HashMap<Integer, UndirectedNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedNode dfs(UndirectedNode node, HashMap<Integer,UndirectedNode> map) {
        if (node == null) return null;

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        } else {
            UndirectedNode clone = new UndirectedNode(node.val);
            map.put(node.val, clone);

            for (UndirectedNode adjNode : node.neighbors) {
                clone.neighbors.add(adjNode);
            }
            return clone;
        }
    }

    public static void main(String[] args) {

    }
}

class UndirectedNode {
    public int val;
    public List<UndirectedNode> neighbors;
    public UndirectedNode() {
        val = 0;
        neighbors = new ArrayList<UndirectedNode>();
    }
    public UndirectedNode(int _val) {
        val = _val;
        neighbors = new ArrayList<UndirectedNode>();
    }
    public UndirectedNode(int _val, ArrayList<UndirectedNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
