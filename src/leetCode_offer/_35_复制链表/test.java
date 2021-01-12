package leetCode_offer._35_复制链表;


/*
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
        输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/


public class test {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.next = b;
        b.next = c;
        c.next = d;
        a.random = c;
        b.random = null;
        d.random = a;

        Node copy1 = new Solution().copyRandomList(a);
        Node copy2 = new Solution1().copyRandomList(a);

    }
}
