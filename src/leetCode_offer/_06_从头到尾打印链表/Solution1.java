package leetCode_offer._06_从头到尾打印链表;

import leetCode.ListNode.ListNode;

public class Solution1 {
    public int[] reversePrint(ListNode head) {
        if(head == null) {
            return new int[]{};
        }
        ListNode currentHead = head;
        int nums = 1;
        while(head.next!=null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = currentHead;
            currentHead = next;
            nums++;
        }
        int[] res = new int[nums];
        for(int i=0;i<res.length;i++) {
            res[i] = currentHead.val;
            currentHead = currentHead.next;
        }
        return res;
    }
}