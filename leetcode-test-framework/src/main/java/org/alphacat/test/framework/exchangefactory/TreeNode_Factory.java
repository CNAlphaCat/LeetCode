package org.alphacat.test.framework.exchangefactory;



import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode_Factory implements TestHelperFactory<TreeNode> {

    @Override
    public TreeNode deserialize(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        String[] nodes = s.substring(1, s.length() - 1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList();
        TreeNode parent = root;
        boolean isLeft = true;
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = getNode(nodes[i]);
            if (isLeft) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
            if (cur != null) {
                parents.add(cur);
            }
            isLeft = !isLeft;
            if (isLeft) {
                parent = parents.poll();
            }
        }
        return root;
    }

    private TreeNode getNode(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.valueOf(val));
    }

    @Override
    public String serialize(TreeNode output) {
        if (output == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(output);
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
}
