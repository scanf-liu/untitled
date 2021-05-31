package leetCode_other._363_矩形区域不超过K的最大数值和;
/*363. 矩形区域不超过 K 的最大数值和
给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。

题目数据保证总会存在一个数值和不超过 k 的矩形区域。



示例 1：


输入：matrix = [[1,0,1],[0,-2,3]], k = 2
输出：2
解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
示例 2：

输入：matrix = [[2,2,-1]], k = 3
输出：3*/
public class test {
    public static void main(String[] args) {
        int[][] m = {{1,2,3,5,0,-4,-1,5,-2,8,-54,-4,-4},{1,2,-8,5,0,-4,-1,5,-2,8,-54,-4,-4},{1,-2,3,5,0,-4,-1,5,-2,8,-54,-4,-4}};
        System.out.println(new Solution().maxSumSubmatrix(m, 30));
        System.out.println(new Solution1().maxSumSubmatrix(m, 30));
        m =new int[][]{{1,2,3,5,0,-4,-1,5,-2,8,-54,-4,-4},{1,2,-8,5,0,-4,-1,5,-2,8,-54,-4,-4},{1,-2,3,5,0,-4,-1,5,-2,8,-54,-4,-4}};
        System.out.println(new Solution().maxSumSubmatrix(m, 300));
        System.out.println(new Solution1().maxSumSubmatrix(m, 300));
    }
}
