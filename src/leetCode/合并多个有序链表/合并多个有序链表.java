package leetCode.合并多个有序链表;/*给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

 

示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


public class 合并多个有序链表 {
    public static void main(String[] args) {


        ListNode tail1 = new ListNode(3,null);
        ListNode head1 = new ListNode(2,tail1);
        head1 = new ListNode(2,head1);
        head1 = new ListNode(1,head1);

        ListNode tail2 = new ListNode(5,null);
        ListNode head2 = new ListNode(2,tail2);
        head2 = new ListNode(2,head2);
        head2 = new ListNode(1,head2);


        ListNode tail3 = new ListNode(5,null);
        ListNode head3 = new ListNode(3,tail3);
        head3 = new ListNode(2,head3);
        head3 = new ListNode(1,head3);

        ListNode[] list = new ListNode[3];

        list[0] = head1;
        list[1] = head2;
        list[2] = head3;

        ListNode head4 = Solution.mergeKLists(list);
        while (head4 != null){
            System.out.println(head4.val);
            head4 = head4.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode[] tail = lists;
        ListNode head = null,tail1 = null;
        int k = 0;
        while (judge(tail)){

            int flag = -1, min = 10000;
            for (int i = 0; i < lists.length; i++){
                if (tail[i]!=null && tail[i].val < min ){
                    min = tail[i].val;
                    flag = i;
                }
            }

            if(k++ == 0){
                tail1 = tail[flag];
                tail[flag] = tail[flag].next;
                head = tail1;
            }else{
                tail1.next = tail[flag];
                tail[flag] = tail[flag].next;
                tail1 = tail1.next;
            }
        }


        return head;

    }


    public static boolean judge (ListNode[] lists){
        for (int i = 0; i < lists.length; i++){
            if (lists[i]!=null) return true;
        }
        return false;
    }
}