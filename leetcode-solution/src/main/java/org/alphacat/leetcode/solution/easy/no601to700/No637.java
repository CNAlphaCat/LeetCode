package org.alphacat.leetcode.solution.easy.no601to700;


import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No637 {

    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0;//这里类型不能写int
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            double avg = sum / n;
            res.add(avg);
        }
        return res;
    }
}
