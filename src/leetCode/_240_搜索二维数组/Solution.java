package leetCode._240_搜索二维数组;

public class Solution {


    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }


    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            if (matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            int col = binarySearch(matrix[i], target);
            if (col != -1) {
                return true;
            }
        }
        return false;
    }

    //二分查找
    private static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        return helper(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    public static boolean helper(int[][] matrix, int target, int up, int down, int left, int right) {
        if (up < 0 || left < 0 || down >= matrix.length || right >= matrix[0].length) return false;
        if (matrix[up][left] == target || matrix[down][right] == target) return true;

        if (matrix[up][left] > target || matrix[down][right] < target) return false;

        if (up == down) {
            if (right - left < 2) {
                return false;
            }
            return helper(matrix, target, up, up, left, (left + right) / 2) || helper(matrix, target, up, up, (left + right) / 2 + 1, right);
        }

        if (right == left) {
            if (down - up < 2) {
                return false;
            }
            return helper(matrix, target, up, (up + down) / 2, left, left) || helper(matrix, target, (up + down) / 2 + 1, down, right, right);
        }


        return helper(matrix, target, up, (up + down) / 2, left, (left + right) / 2) || helper(matrix, target, (up + down) / 2 + 1, down, (left + right) / 2 + 1, right) || helper(matrix, target, up, (up + down) / 2, (left + right) / 2 + 1, right) || helper(matrix, target, (up + down) / 2 + 1, down, left, (left + right) / 2);

    }

}
