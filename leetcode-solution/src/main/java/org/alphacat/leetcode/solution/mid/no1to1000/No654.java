package org.alphacat.leetcode.solution.mid.no1to1000;


import org.alphacat.leetcode.datastructure.TreeNode;

public class No654 {
    private int[] nums;
    int n;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        initial(nums);
        return buildTree(0, n - 1);
    }

    private TreeNode buildTree(int begin, int end) {
        if (begin > end || begin < 0 || end >= n) {
            return null;
        }
        maxData max = findMax(begin, end);
        TreeNode root = new TreeNode(max.maxNum);
        root.left = buildTree(begin, max.index - 1);
        root.right = buildTree(max.index + 1, end);
        return root;
    }

    private void initial(int[] _nums) {
        this.nums = _nums;
        this.n = nums.length;
    }

    private maxData findMax(int begin, int end) {
        maxData res = new maxData();
        res.maxNum = nums[begin];
        res.index = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] > res.maxNum) {
                res.maxNum = nums[i];
                res.index = i;
            }
        }
        return res;
    }

    private class maxData {
        int maxNum;
        int index;
    }
}
