package org.alphacat.leetcode.solution.mid.interview;



import org.alphacat.leetcode.datastructure.ListNode;
import org.alphacat.leetcode.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Interview04_03 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<ListNode> queueHelper = new LinkedList<>();
        ListNode head = new ListNode(0);
        ListNode crrListNode = head;
        TreeNode right = tree;
        TreeNode tempRight = right;
        queue.add(tree);
        int depth = 1;
        while (!queue.isEmpty()) {
            TreeNode crrNode = queue.poll();
            TreeNode crrLeft = crrNode.left;
            TreeNode crrRight = crrNode.right;
            ListNode tempListNode = new ListNode(crrNode.val);
            crrListNode.next = tempListNode;
            crrListNode = tempListNode;
            if (crrLeft != null) {
                queue.add(crrLeft);
                tempRight = crrLeft;
            }
            if (crrRight != null) {
                queue.add(crrRight);
                tempRight = crrRight;
            }
            if (crrNode == right) {
                if(!queue.isEmpty()){
                    depth++;
                }
                right = tempRight;
                queueHelper.add(head.next);
                head.next = null;
                crrListNode = head;
            }
        }
        ListNode[] res = new ListNode[depth];
        for (int i = 0; i < depth; i++) {
            res[i] = queueHelper.poll();
        }
        return res;
    }
}
