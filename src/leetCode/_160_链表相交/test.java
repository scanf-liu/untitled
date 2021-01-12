package leetCode._160_链表相交;

import leetCode.ListNode.*;
/*编写一个程序，找到两个单链表相交的起始节点。

如下面的两个链表：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

public class test {
    public static void main(String[] args) {
        ListNode node = Construction.construct(new int[]{1,2,3,4,5,6,7});
        ListNode node1 = new ListNode(9,node.next);
        System.out.println(Solution.getIntersectionNode(node,node1).val);
        System.out.println(Solution.getIntersectionNode1(node,node1).val);
    }
}

class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        int sizeA = 0, sizeB = 0;
        while(node1 != null){
            node1 = node1.next;
            sizeA++;
        }
        while(node2 != null){
            node2 = node2.next;
            sizeB++;
        }
        int length = Math.min(sizeA,sizeB);
        node1 = headA;
        node2 = headB;
        for(int i = 0; i < sizeA - length; i++){
            node1 = node1.next;
        }
        for(int i = 0; i < sizeB - length; i++){
            node2 = node2.next;
        }
        for(int i = 0; i < length; i++){
            if(node1 == node2) return node2;
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
