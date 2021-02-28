package leetCode_offer._35_复制链表;

import java.util.HashMap;
import java.util.Map;


/*方法二：拼接 + 拆分
        考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，如此便可在访问原节点的 random 指向节点的同时找到新对应新节点的 random 指向节点。

        算法流程：
        复制各节点，构建拼接链表:

        设原链表为 node1 \rightarrow node2 \rightarrow \cdotsnode1→node2→⋯ ，构建的拼接链表如下所示：
        node1 \rightarrow node1_{new} \rightarrow node2 \rightarrow node2_{new} \rightarrow \cdots
        node1→node1
        new
        ​
        →node2→node2
        new
        ​
        →⋯

        构建新链表各节点的 random 指向：

        当访问原节点 cur 的随机指向节点 cur.random 时，对应新节点 cur.next 的随机指向节点为 cur.random.next 。
        拆分原 / 新链表：

        设置 pre / cur 分别指向原 / 新链表头节点，遍历执行 pre.next = pre.next.next 和 cur.next = cur.next.next 将两链表拆分开。
        返回新链表的头节点 res 即可。*/


public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node headCopy = new Node(head.val);
        Node tempCopy = headCopy;
        //Node now;
        map.put(head, headCopy);
        map.put(null, null);
        while (head != null) {
            if (map.containsKey(head.next)) {
                tempCopy.next = map.get(head.next);
            } else {
                Node now = new Node(head.next.val);
                map.put(head.next, now);
                tempCopy.next = now;
            }
            if (map.containsKey(head.random)) {
                tempCopy.random = map.get(head.random);
            } else {
                Node now = new Node(head.random.val);
                map.put(head.random, now);
                tempCopy.random = now;
            }
            head = head.next;
            tempCopy = tempCopy.next;
        }
        return headCopy;
    }
}