package org.alphacat.leetcode.solution.easy.no501to600;



import org.alphacat.leetcode.datastructure.Node;

import java.util.ArrayList;
import java.util.List;

public class No589 {
    private List<Integer> ans;

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ans = new ArrayList<>();
        ans.add(root.val);
        preOrder(root);
        return ans;
    }

    private void preOrder(Node root) {
        List<Node> children = root.children;
        for (Node node : children) {
            ans.add(node.val);
            preOrder(node);
        }
    }
}
