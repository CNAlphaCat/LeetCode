package org.alphacat.leetcode.solution.mid.no1to1000;


import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;

        List ans = new LinkedList<>();

        while (!queue.isEmpty()) {
            int n = queue.size();
            List levelList = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if ((level & 1) == 1) {
                    levelList.add(node.val);
                } else {
                    levelList.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(levelList);
            level++;
        }
        return ans;
    }
}
