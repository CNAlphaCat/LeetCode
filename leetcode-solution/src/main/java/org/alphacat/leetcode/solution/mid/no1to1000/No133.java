package org.alphacat.leetcode.solution.mid.no1to1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/clone-graph/
 * 133. 克隆图
 * ☆☆☆☆
 * keyword:dfs
 */
public class No133 {

    private HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return copy(node);
    }

    private Node copy(Node node) {
        if (node == null) {
            return null;
        }

        int val = node.val;
        if (map.containsKey(val)) {
            return map.get(val);
        }

        Node copy = new Node(val);
        map.put(val, copy);

        List<Node> neighbors = node.neighbors;
        int size = neighbors.size();

        List<Node> copyNeighbors = new ArrayList<>(size);

        for (Node item : neighbors) {
            Node copyItem = copy(item);
            copyNeighbors.add(copyItem);
        }
        copy.neighbors = copyNeighbors;
        return copy;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
