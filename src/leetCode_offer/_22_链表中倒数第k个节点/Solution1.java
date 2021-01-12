package leetCode_offer._22_链表中倒数第k个节点;

import leetCode.ListNode.ListNode;

public class Solution1 {
    int helper = 0;
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode ans = null;
        if(head.next != null)
            ans = getKthFromEnd(head.next, k);
        helper++;
        if(helper == k) return head;
        return ans;
    }
}