package org.alphacat.leetcode.solution.mid.no1to1000;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 102. 二叉树的层序遍历
 * ————————————————————————————————————————————————————————————————————————————
 * 题目描述：
 * ————————————————————————————————————————————————————————————————————————————
 * keyword:
 * 题解：
 * ————————————————————————————————————————————————————————————————————————————
 * 笔记：
 * ————————————————————————————————————————————————————————————————————————————
 * 相关题目：
 * ————————————————————————————————————————————————————————————————————————————
 */
public class No102_levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new LinkedList<>();
		}
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> resList = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> temp = new LinkedList<>();
			int n = q.size();
			for (int i = 0; i < n; ++i) {
				TreeNode tempNode = q.poll();
				temp.add(tempNode.val);
				if (tempNode.left != null) {
					q.add(tempNode.left);
				}
				if (tempNode.right != null) {
					q.add(tempNode.right);
				}
			}
			resList.add(temp);
		}
		return resList;
    }
}
