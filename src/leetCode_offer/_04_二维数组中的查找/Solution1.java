package leetCode_offer._04_二维数组中的查找;

public class Solution1 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, col = matrix[0].length;
        int row = rows - 1;
        int column = 0;
        while (row >= 0 && column < col) {
            int num = matrix[row][column];
            if (num == target) {
                //如果找到直接返回
                return true;
            } else if (num > target) {
                //往上面找
                row--;
            } else {
                //往右边找
                column++;
            }
        }
        return false;
    }
}
