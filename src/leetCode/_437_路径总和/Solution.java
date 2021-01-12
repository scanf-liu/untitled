package leetCode._437_路径总和;

import leetCode.TreeNode.TreeNode;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        return helper(root, sum, new int[1000], 0); //0表示根
    }

    //array数组存储某一次递归时所遍历结点的结果值，p表示当前节点的位置
    public int helper(TreeNode root, int sum, int[] array, int p){
        if(root == null)    return 0;
        array[p] = root.val;
        int temp = 0;
        int n = 0;
        for(int i=p; i>=0; i--){
            temp += array[i];
            if(temp == sum){
                n ++;
            }
        }
        int left = helper(root.left, sum, array, p+1);
        int right = helper(root.right, sum, array, p+1);
        return n+left+right;
    }
}
