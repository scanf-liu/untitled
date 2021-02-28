package leetCode._148_排序链表;

import leetCode.ListNode.Construction;
import leetCode.ListNode.ListNode;


/*给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

进阶：

你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

双指针查找链表中点
*/

public class _148_排序链表 {
    public static void main(String[] args) {
        ListNode root = Construction.construct(new int[]{4, 2, 1, -1, 3});
        ;
        Construction.show(Solution.sortList(root));
    }
}

class Solution {
    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode slow = head; //慢指针
        ListNode fast = head.next; //快指针

        while (fast != null && fast.next != null) { //快慢指针找到链表中点
            slow = slow.next; //慢指针走一步
            fast = fast.next.next; //快指针走两步
        }
        ListNode rightHead = slow.next; //链表第二部分的头节点
        slow.next = null; //cut 链表

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    public static ListNode cut(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        return fast;
    }

    public static ListNode merge(ListNode root1, ListNode root2) {
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        while (root1 != null && root2 != null) {
            if (root1.val < root2.val) {
                temp.next = root1;
                root1 = root1.next;
            } else {
                temp.next = root2;
                root2 = root2.next;
            }
            temp = temp.next;
        }
        temp.next = (root1 != null ? root1 : root2);
        return root.next;
    }
}