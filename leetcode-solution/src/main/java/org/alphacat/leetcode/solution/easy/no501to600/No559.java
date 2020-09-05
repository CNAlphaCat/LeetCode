package org.alphacat.leetcode.solution.easy.no501to600;



import org.alphacat.leetcode.datastructure.Node;

import java.util.List;

public class No559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return getDepth(root, 1);
    }

    private int getDepth(Node root, int depth) {
        if (root == null) {
            return depth;
        }
        List<Node> nodeList = root.children;
        int maxDepth = depth;
        for (Node child : nodeList) {
            int tempDepth = getDepth(child, depth + 1);
            maxDepth = Math.max(maxDepth, tempDepth);
        }
        return maxDepth;
    }
}
