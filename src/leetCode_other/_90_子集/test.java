package leetCode_other._90_子集;
/*90. 子集 II
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。



示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
 */
public class test {
    public static void main(String[] args) {
        int[] a = new int[]{-1,3,5,6,2,3,6};
        System.out.println(new Solution().subsetsWithDup(a).toString());
        System.out.println(new Solution1().subsetsWithDup(a).toString());
    }
}
