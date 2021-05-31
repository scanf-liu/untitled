package leetCode_other._74_搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0]) return false;
        int start = 0;
        int end = matrix.length-1;
        int mid;
        while(start < end){
            mid = start + end;
            if(matrix[mid][0] > target) end = mid - 1;
            else start = mid + 1;
        }

        if(matrix[end][matrix[0].length-1] < target) return false;
        int startPlus = 0;
        int endPlus = matrix[0].length-1;
        if((matrix[end][0] == target)||(matrix[end][endPlus] == target)) return true;
        while(startPlus < endPlus){
            mid = endPlus + startPlus;
            if(matrix[end][mid] == target) return true;
            if(matrix[end][mid] > target) endPlus = mid - 1;
            else startPlus = mid + 1;
        }
        return false;

    }
}