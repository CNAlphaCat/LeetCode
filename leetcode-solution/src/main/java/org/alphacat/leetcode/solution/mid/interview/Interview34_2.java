package org.alphacat.leetcode.solution.mid.interview;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Interview34_2 {
	private List<List<Integer>> res;
	int sum;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		initial(sum);
		getSumPath(root, 0, new LinkedList<Integer>());
		return res;
	}

	private void getSumPath(TreeNode t, int crrSum, List<Integer> list) {
		if (t == null) {
			return;
		}
		int val = t.val;
		crrSum += val;
		if (t.left == null && t.right == null && crrSum == this.sum) {
			list.add(val);
			res.add(list);
		}else {
			list.add(val);
			List<Integer> lefList = list;
			List<Integer> rightList = copy(list);
			getSumPath(t.left, crrSum, lefList);
			getSumPath(t.right, crrSum, rightList);
		}
	}

	private void initial(int sum) {
		res = new LinkedList<List<Integer>>();
		this.sum = sum;
	}

	private List<Integer> copy(List<Integer> list) {
		List<Integer> res = new LinkedList<Integer>();
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			int temp = (int) it.next();
			res.add(temp);
		}
		return res;
	}
}
