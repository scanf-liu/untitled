package leetCode_offer._06_从头到尾打印链表;

import leetCode.ListNode.ListNode;

public class Solution {
    public int[] reversePrint(ListNode head) {
        //if(head == null) return new int[0];
        int length = 0;
        ListNode now = head;
        while (now != null) {
            now = now.next;
            length++;
        }
        return reversePrint(new int[length], length - 1, head);
    }

    public int[] reversePrint(int[] ans, int located, ListNode head) {
        if (located == -1) return ans;
        if (head.next == null) {
            ans[located] = head.val;
            return ans;
        }
        reversePrint(ans, located - 1, head.next);
        ans[located] = head.val;
        return ans;
    }
}