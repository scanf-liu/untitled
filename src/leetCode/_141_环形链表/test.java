package leetCode._141_环形链表;

import leetCode.ListNode.ListNode;

import java.net.Socket;

public class test {
    public static void main(String[] args) {
        ListNode tail = new ListNode(8,null);
        ListNode a = new ListNode(1, tail);
        ListNode b = new ListNode(6, a);
        ListNode c = new ListNode(5, b);
        tail.next = c;
        ListNode d = new ListNode(111,c);
        System.out.println(Solution.hasCycle(d));
    }
}

class Solution{
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        //快慢两个指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //慢指针每次走一步
            slow = slow.next;
            //快指针每次走两步
            fast = fast.next.next;
            //如果相遇，说明有环，直接返回true
            if (slow == fast)
                return true;
        }
        //否则就是没环
        return false;
    }
}


