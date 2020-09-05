package org.alphacat.leetcode.solution.classic.tree;


import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class No113 {
    private List<List<Integer>> res;
    private List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        initial();
        getPathSum(root, sum);
        return res;
    }

    private void getPathSum(TreeNode node, int crrSum) {
        if (node == null) {
            return;
        }
        int val = node.val;
        crrSum -= val;
        list.add(val);
        if (crrSum == 0 && node.left == null && node.right == null) {
            List<Integer> temp = new LinkedList<Integer>(list);
            res.add(temp);
        } else {
            getPathSum(node.left, crrSum);
            getPathSum(node.right, crrSum);
        }
        int n = list.size();
        if (n > 0) {
            list.remove(n - 1);
        }
    }

    private void initial() {
        res = new LinkedList<List<Integer>>();
        list = new LinkedList<Integer>();
    }
}
