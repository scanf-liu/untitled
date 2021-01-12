package leetCode._105_二叉树恢复_前_中;
/*根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

对数组进行截取值记录下标， 使用hashmap

*/


import java.util.HashMap;
import leetCode.TreeNode.*;

public class test {
    public static void main(String[] args) {
        int[] a = {1,4,6,8,9};
        TreeNode ans = Solution.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        TreeOperation.show(ans);
    }
}

class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }
    public static TreeNode build(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, HashMap<Integer, Integer> map){

        if (p_start == p_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        int i_root_index = map.get(preorder[p_start]);
        int leftNum = i_root_index - i_start;
        root.left = build(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
        root.right = build(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);

        return root;
    }
}