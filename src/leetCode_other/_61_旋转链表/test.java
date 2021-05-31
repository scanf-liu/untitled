package leetCode_other._61_旋转链表;

import leetCode.ListNode.Construction;
import leetCode.ListNode.ListNode;

/*82. 删除排序链表中的重复元素 II
存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。

返回同样按升序排列的结果链表。*/
public class test {
    public static void main(String[] args) {
        ListNode root = Construction.construct(new int[]{1,2,3,4,5,5,6,7,8,8,8});
        Construction.show(new Solution().rotateRight(root,234141
        ));
    }
}
