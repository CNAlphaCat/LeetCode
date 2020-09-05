package org.alphacat.leetcode.solution.easy.no201to300;


import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class No257 {

    public List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePaths(root, new StringBuilder(), new LinkedList<>());
    }

    private List<String> binaryTreePaths
            (TreeNode root, StringBuilder sb, List<String> ans) {
        if (root == null) {
            return ans;
        }
        int value = root.val;
        if (sb.length() != 0) {
            sb.append("->");
        }
        sb.append(value);
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
            return ans;
        }
        ans = binaryTreePaths(root.left, new StringBuilder(sb), ans);
        ans = binaryTreePaths(root.right, new StringBuilder(sb), ans);
        return ans;
    }
}
