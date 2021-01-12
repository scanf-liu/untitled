package leetCode._240_搜索二维数组;

public class test {
    public static void main(String[] args) {
        int[][] a = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(Solution.searchMatrix(a,15));
        System.out.println(Solution.searchMatrix1(a,15));
        System.out.println(Solution.searchMatrix2(a,15));
    }
}
