package org.alphacat.leetcode.solution.classic.listnode;



import org.alphacat.leetcode.datastructure.ListNode;

import java.util.HashSet;

public class Interview02_07 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerOfA = headA;
        ListNode pointerOfB = headB;
        while (pointerOfA != null || pointerOfB != null) {
            if (pointerOfA == pointerOfB) {
                return pointerOfA;
            }
            pointerOfA = pointerOfA == null ? headB : pointerOfA.next;
            pointerOfB = pointerOfB == null ? headA : pointerOfB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode pointer = headA;
        while (pointer != null) {
            set.add(pointer);
            pointer = pointer.next;
        }
        pointer = headB;
        while (pointer != null) {
            if (set.contains(pointer)) {
                return pointer;
            }
            pointer = pointer.next;
        }
        return null;
    }
}
