package leetCode._1030_距离顺序排列矩阵单元格;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[][] a = Solution.allCellsDistOrder(2, 10, 0, 0);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
}
