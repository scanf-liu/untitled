package leetCode.链表的删除;

import java.util.ArrayList;
import java.util.List;

/*给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class test {
    public static void main(String[] args) {
        ListNode a = new ListNode(5, null);
        a = new ListNode(55, a);
        a = new ListNode(555, a);
        a = new ListNode(5555, a);
        a = new ListNode(55555, a);
        a = Solution.removeNthFromEnd(a, 5);
        for (int i = 0; i < 4; i++) {
            System.out.println(a.val);
            a = a.next;
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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        List<ListNode> list = new ArrayList<ListNode>();

        while (tail != null) {
            list.add(tail);
            tail = tail.next;
        }
        list.add(null);
        if (list.size() == 0 || list.size() == 1) {
            return null;
        }
        if (n == list.size() - 1) {
            list.remove(0);
        } else {
            list.get(list.size() - n - 2).next = list.get(list.size() - n);
        }

        return list.get(0);
    }
}
