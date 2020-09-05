package org.alphacat.leetcode.solution.easy.no801to900;


import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeftTree(root1, new ArrayList<>());
        List<Integer> list2 = getLeftTree(root2, new ArrayList<>());
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getLeftTree(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }
        list = getLeftTree(node.left, list);
        return getLeftTree(node.right, list);
    }
}
