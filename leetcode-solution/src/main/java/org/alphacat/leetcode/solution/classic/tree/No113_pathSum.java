package org.alphacat.leetcode.solution.classic.tree;


import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 113. 路径总和 II
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No113_pathSum {
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
