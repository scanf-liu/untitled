package leetCode._56_合并区间;

import java.util.Arrays;

/*给出一个区间的集合，请合并所有重叠的区间。

 

示例 1:

输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class test {
    public static void main(String[] args) {
        int[][] a = {{1, 3}, {3, 9}, {4, 10}};
        int[][] b = Solution.merge(a);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println("");

        }
    }


}


class Solution {
    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] use = new int[intervals.length];
        int[][] ans1 = new int[intervals.length][2];

        int k = 0;

        for (int i = 0; i < intervals.length; i++) {

            if (use[i] == 1) continue;
            use[i] = 1;
            int[] now = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                if (use[j] == 1) continue;
                if (merge_judge(now, intervals[j])) {
                    now = merge_operate(now, intervals[j]);
                    use[j] = 1;
                }
            }
            ans1[k++] = now;
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) ans[i] = ans1[i];


        return ans;
    }


    public static boolean merge_judge(int[] a, int[] b) {
        if (b[0] <= a[1] && a[0] <= b[1]) return true;
        return false;
    }


    public static int[] merge_operate(int[] a, int[] b) {
        int[] ans = {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
        return ans;
    }

}
