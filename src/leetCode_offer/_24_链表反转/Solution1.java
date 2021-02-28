package leetCode_offer._24_链表反转;

import leetCode.ListNode.ListNode;

public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode temp1 = null;
        while (temp != null) {
            ListNode temp2 = temp.next;
            temp.next = temp1;
            temp1 = temp;
            temp = temp2;
        }
        return temp1;
    }
}