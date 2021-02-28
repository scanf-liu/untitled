package leetCode.两数相加;

/*
*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
*
*
*
* */
public class test {
    public static void main(String[] args) {
        ListNode head1 = null;
        ListNode tail1 = null;
        int[] a1 = new int[]{1, 1, 2, 3, 4, 5};
        head1 = tail1 = new ListNode(a1[0]);
        for (int i = 1; i < a1.length; i++) {
            tail1.next = new ListNode(a1[i]);
            tail1 = tail1.next;
        }
        ListNode head2 = null;
        ListNode tail2 = null;
        int[] a2 = new int[]{3, 1, 3, 8, 4, 5};
        head2 = tail2 = new ListNode(a2[0]);
        for (int i = 1; i < a2.length; i++) {
            tail2.next = new ListNode(a2[i]);
            tail2 = tail2.next;
        }
        ListNode tail13 = Solution.addTwoNumbers(head1, head2);

        while (tail13 != null) {
            System.out.println(tail13.val);
            tail13 = tail13.next;
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int q = 0;
        int val1 = 0;
        int val2 = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                val1 = 0;
            } else {
                val1 = l1.val;
            }

            if (l2 == null) {
                val2 = 0;
            } else {
                val2 = l2.val;
            }

            int sum = val1 + val2 + q;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            q = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (q > 0) {
            tail.next = new ListNode(q);
        }
        return head;

    }
}