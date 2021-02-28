package leetCode_offer._52_两个链表第一个公共子节点;

import leetCode.ListNode.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode help1 = headA;
        ListNode help2 = headB;
        //Boolean flag = false;
        while (help1 != help2) {
            if (help1 == null) help1 = headB;
            else help1 = help1.next;
            if (help2 == null) help2 = headA;
            else help2 = help2.next;
        }
        return help1;
    }
}