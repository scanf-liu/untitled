package leetCode_other._74_搜索二维矩阵;
/*74. 搜索二维矩阵
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。*/
public class test {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Solution().searchMatrix(a, 16));
        System.out.println(new Solution().searchMatrix(a, 11));
        System.out.println(new Solution().searchMatrix(a, 77));

    }
}
