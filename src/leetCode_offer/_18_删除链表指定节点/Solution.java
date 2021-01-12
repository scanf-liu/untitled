package leetCode_offer._18_删除链表指定节点;

import leetCode.ListNode.ListNode;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode nodeBefore = head, node = head.next;
        while(node != null && node.val != val){
            nodeBefore = node;
            node = node.next;
        }
        nodeBefore.next = node.next;
        return head;
    }
}