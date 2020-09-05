package org.alphacat.leetcode.solution.hard;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Interview37 {
	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null) {
				return "[]";
			}
			StringBuilder sb = new StringBuilder("[");
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node == null) {
					sb.append("null,");
					continue;
				}
				queue.add(node.left);
				queue.add(node.right);
				sb.append(node.val + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("]");
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.equals("[]")) {
				return null;
			}
			data = data.substring(1, data.length() - 1);
			String[] strArr = data.split(",");
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			int headVal = Integer.parseInt(strArr[0]);
			TreeNode root = new TreeNode(headVal);
			queue.add(root);
			int i = 1;
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (!strArr[i].equals("null")) {
					int val = Integer.parseInt(strArr[i]);
					TreeNode temp = new TreeNode(val);
					node.left = temp;
					queue.add(temp);
				}
				i++;
				if (!strArr[i].equals("null")) {
					int val = Integer.parseInt(strArr[i]);
					TreeNode temp = new TreeNode(val);
					node.right = temp;
					queue.add(temp);
				}
				i++;
			}
			return root;
		}
	}
}
