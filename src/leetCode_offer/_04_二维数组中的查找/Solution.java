package leetCode_offer._04_二维数组中的查找;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return helper(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    public boolean helper(int[][] matrix, int target, int start1, int start2, int end1, int end2) {
        //if(end1 == start1 && start2 == end1) return matrix[start1][start2] == target;
        if (end1 < start1 || end2 < start2) return false;
        if (matrix[start1][start2] > target || matrix[end1][end2] < target) return false;
        if (matrix[start1][start2] == target || matrix[end1][end2] == target) return true;
        int new_end1 = (start1 + end1) / 2;
        int new_end2 = (start2 + end2) / 2;
        return helper(matrix, target, start1, start2, new_end1, new_end2) || helper(matrix, target, start1, new_end2 + 1, new_end1, end2) || helper(matrix, target, new_end1 + 1, new_end2 + 1, end1, end2) || helper(matrix, target, new_end1 + 1, start2, end1, new_end2);
    }
}