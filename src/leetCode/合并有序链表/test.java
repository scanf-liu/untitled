package leetCode.合并有序链表;

/*将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


public class test {
    public static void main(String[] args) {
        ListNode tail1 = new ListNode(3, null);
        ListNode head1 = new ListNode(2, tail1);
        head1 = new ListNode(2, head1);
        head1 = new ListNode(1, head1);

        ListNode tail2 = new ListNode(5, null);
        ListNode head2 = new ListNode(2, tail2);
        head2 = new ListNode(2, head2);
        head2 = new ListNode(1, head2);

        ListNode head3 = Solution.mergeTwoLists(head1, head2);
        while (head3 != null) {
            System.out.println(head3.val);
            head3 = head3.next;
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head, tail;

        if (l1.val > l2.val) {
            head = tail = l2;
            l2 = l2.next;
        } else {
            head = tail = l1;
            l1 = l1.next;
        }

        while (l1 != null || l2 != null) {

            if (l1 == null) {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            } else if (l2 == null) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            } else {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }

        }
        return head;
    }
}